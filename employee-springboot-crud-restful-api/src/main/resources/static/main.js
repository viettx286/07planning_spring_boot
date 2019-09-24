var app = angular.module("EmployeeManagement", []);

//send tokenAuthentication
app.run(function($http) {
    $http.defaults.headers.common.Authorization = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1Njk4MjAxMDAsInVzZXJuYW1lIjoiYWRtaW4ifQ.s_7UB33hR7MKUc-0gDFwWwsjR3aSmCHdW4HNq2na18M";
});

// Controller Part
app.controller("EmployeeController", function($scope, $http) {
	
    $scope.employees = [];
    $scope.employeeForm = {
        empId: 1,
        empNo: "",
        empName: ""
    };
 
    // Now load the data from server
    _refreshEmployeeData();
 
    // HTTP POST/PUT methods for add/edit employee  
    // Call: http://localhost:8080/rest/employees
    $scope.submitEmployee = function() {
 
        var method = "";
        var url = "";
 
        if ($scope.employeeForm.empId == -1) {
            method = "POST";
            url = '/rest/employees';
        } else {
            method = "PUT";
            url = '/rest/employees';
        }
 
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.employeeForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
    $scope.createEmployee = function() {
        _clearFormData();
    }
 
    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/rest/employee/{empId}
    $scope.deleteEmployee = function(employee) {
        $http({
            method: 'DELETE',
            url: '/rest/employees/' + employee.empId
        }).then(_success, _error);
    };
 
    // In case of edit
    $scope.editEmployee = function(employee) {
        $scope.employeeForm.empId = employee.empId;
        $scope.employeeForm.empNo = employee.empNo;
        $scope.employeeForm.empName = employee.empName;
    };
 
    // Private Method  
    // HTTP GET- get all employees collection
    // Call: http://localhost:8080/rest/employees
    function _refreshEmployeeData() {
        $http({
            method: 'GET',
            url: '/rest/employees'
        }).then(
            function(res) { // success
                $scope.employees = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function _success(res) {
        _refreshEmployeeData();
        _clearFormData();
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    // Clear the form
    function _clearFormData() {
        $scope.employeeForm.empId = -1;
        $scope.employeeForm.empNo = "";
        $scope.employeeForm.empName = ""
    };
});