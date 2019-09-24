package com.nakun.employee.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nakun.employee.entities.User;
import com.nakun.employee.service.JwtService;
import com.nakun.employee.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(HttpServletRequest request, @RequestBody User user) {
		String result = "";
		HttpStatus httpStatus = null;
		try {
			if (userService.checkLogin(user)) {
				result = jwtService.generateTokenLogin(user.getUsername());
				httpStatus = HttpStatus.OK;
			} else {
				result = "Wrong userId and password";
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception ex) {
			result = "Server Error";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(result, httpStatus);
	}

}
