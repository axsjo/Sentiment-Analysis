package com.analysis.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analysis.common.Status;
import com.analysis.dao.UserDao;
import com.analysis.entity.User;

@Service
public class AuthenticationServiceImplementation implements
		AuthenticationService {

	private Logger logger = Logger
			.getLogger(AuthenticationServiceImplementation.class);

	@Autowired
	private UserDao userDao;

	@Override
	public User authenticateOperator(String userId, String password) {
		try {
			User user = userDao.findByUserIdAndStatus(userId, Status.Active);
			if (user != null && password.equals(user.getPassword())) {
				return user;
			}
		} catch (Exception e) {
			logger.error("Exception while authenticating the User:", e);

		}
		return null;
	}
}
