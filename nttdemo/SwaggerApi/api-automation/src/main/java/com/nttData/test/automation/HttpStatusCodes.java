package com.nttData.test.automation;

/* Defining HTTP Status code using enumeration */
public enum HttpStatusCodes {
	
	SUCCESS(200, "successful"),
	CREATED(201, "created"),
	NOTFOUND(404, "not found"),
	INVALID(400, "invalid status value"),
	EXCEPTION(405, "validation exception");
	
	private final int code;
	private final String description;
	
	HttpStatusCodes(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}

}
