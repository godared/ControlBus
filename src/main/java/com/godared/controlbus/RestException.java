package com.godared.controlbus;

public class RestException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private int code;
	private String message;
	private String detailedMessage;
	public RestException(int code, String message, String detailedMessage) {
		this.code = code;
		this.message = message;
		this.detailedMessage = detailedMessage;
	}
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public String getDetailedMessage() {
		return detailedMessage;
	}

}
