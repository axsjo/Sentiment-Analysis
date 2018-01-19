package com.analysis.common;

public enum RequestStatus {
	STATUS_SUCCESS("success"), STATUS_FAILURE("failure");

	private String status;

	private RequestStatus(final String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return status;
	}

}
