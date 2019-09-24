package com.nakun.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nakun.employee.dao.UserDAO;
import com.nakun.employee.entities.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDAO userDAO;


	public User loadUserByUsername(final String username) {
		return userDAO.loadUserByUsername(username);
	}

	public boolean checkLogin(User userForm) {
		return userDAO.checkLogin(userForm);
	}
}

