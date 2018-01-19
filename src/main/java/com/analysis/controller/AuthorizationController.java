package com.analysis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.analysis.common.Constants;
import com.analysis.common.GlobalResponse;
import com.analysis.common.RequestStatus;
import com.analysis.entity.Role;

@RestController
public class AuthorizationController {
	Logger logger = Logger.getLogger(AuthorizationController.class);

	@RequestMapping("/getUserRole")
	public GlobalResponse getUserRole(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		GlobalResponse response = new GlobalResponse();
		try {
			if (session == null) {
				response.setStatus(RequestStatus.STATUS_FAILURE);
				response.setStatusDesc("Session Expired; please login again");
			} else {
				Role role = (Role) session.getAttribute(Constants.SESSION_USER_ROLE);
				response.setStatus(RequestStatus.STATUS_SUCCESS);
				response.setResponse(role.getName());
			}
		} catch (Exception e) {
			logger.error("", e);
			response.setStatus(RequestStatus.STATUS_FAILURE);
			response.setStatusDesc("Error while getting user role.");
		}
		return response;
	}

}
