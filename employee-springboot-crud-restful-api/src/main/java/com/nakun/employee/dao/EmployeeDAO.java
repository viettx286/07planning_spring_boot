package com.nakun.employee.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nakun.employee.entities.Employee;
  
@Repository
public class EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
  
    public Employee getEmployee(Long empId) {
        Session session = sessionFactory.getCurrentSession();
        Employee emp=(Employee) session.get(Employee.class,empId);
        return emp;
    }
  
    public Employee addEmployee(Employee empForm) {
    	Session session = sessionFactory.getCurrentSession();
        session.save(empForm);
        return empForm;
    }
  
    public Employee updateEmployee(Employee form) {
        Session session = sessionFactory.getCurrentSession();
        Employee emp =(Employee)session.get(Employee.class, form.getEmpId());
        emp.setEmpName(form.getEmpName());
        emp.setEmpNo(form.getEmpNo());
        session.update(emp);
        return emp;
    }
    
  
    public void deleteEmployee(Long empId) {
    	  Session session = sessionFactory.getCurrentSession();
    	  Employee emp=(Employee) session.get(Employee.class,empId);
          session.delete(emp);
    }
   
    public List<Employee> getAllEmployees() {
    	 Session session = sessionFactory.getCurrentSession();
         @SuppressWarnings("unchecked")
         List<Employee> listEmployee  = (List<Employee>) session.createQuery(" FROM  " + Employee.class.getName() ).list();
         return listEmployee;
    }
  
}