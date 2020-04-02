package com.spring.restapi.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String detail;
	private String httpCodeMessage;

	public ExceptionResponse(Date timestamp, String message, String detail, String httpCodeMessage) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detail = detail;
		this.httpCodeMessage = httpCodeMessage;
	}
}
