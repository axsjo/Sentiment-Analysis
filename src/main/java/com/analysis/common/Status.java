package com.analysis.common;

public enum Status {

	//Maintain the order. Always add in end
	InActive(0), Active(1);

	private int status;

	private Status(int status) {
		this.status = status;
	}

	public String toString() {
		return String.valueOf(status);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
