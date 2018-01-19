package com.analysis.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.analysis.entity.Role;

public class ValidationUtil {
	

//	public static boolean isValidSession(GlobalResponse response, HttpServletRequest request, String requestFromRole) {
	public static boolean isValidSession(GlobalResponse response, HttpServletRequest request) {		
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.setStatus(RequestStatus.STATUS_FAILURE);
			response.setStatusDesc("Session Expired; please login again");
		} else {
//			Role loggedInRole = (Role) session.getAttribute(Constants.SESSION_USER_ROLE);
//			if (!loggedInRole.getName().equalsIgnoreCase(requestFromRole)) {
//				response.setStatus(RequestStatus.STATUS_FAILURE);
//				response.setStatusDesc("You are not authorized user for this operation");
//			}else{
				response.setStatus(RequestStatus.STATUS_SUCCESS);
				response.setLoginUserRole((Role) session.getAttribute(Constants.SESSION_USER_ROLE));
				return true;
//			}
		}
		return false;
	}
	
	
}
