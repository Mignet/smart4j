package com.v5ent.core.datatable;

public class ErrorField {
	/**
	 * field name
	 */
	private String name;
	/**
	 * which is the error message for the field to be displayed
	 */
	private String status;

	public ErrorField(String name, String status) {
		this.name = name;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
