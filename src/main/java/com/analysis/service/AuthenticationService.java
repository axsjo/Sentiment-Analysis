package com.analysis.service;

import com.analysis.entity.User;

public interface AuthenticationService {

	public User authenticateOperator(String userId, String password);

}
