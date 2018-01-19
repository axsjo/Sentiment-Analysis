package com.analysis.common;

import com.analysis.entity.Role;

public class GlobalResponse {
	private RequestStatus status;
	private String statusDesc;
	private Role loginUserRole;

	private Object response;

	public GlobalResponse() {
		super();
	}

	public Role getLoginUserRole() {
		return loginUserRole;
	}

	public void setLoginUserRole(Role loginUserRole) {
		this.loginUserRole = loginUserRole;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String errorDesc) {
		this.statusDesc = errorDesc;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

}
