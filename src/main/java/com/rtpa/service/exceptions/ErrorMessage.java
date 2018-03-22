package com.rtpa.service.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author donese
 * 
 *         The error class will be used to represent the errors in JSON format
 *         and it contains the following attributes:
 *
 *         <ul>
 * 
 *         <li>httpStatus: Will contain the http status that will be
 *         returned</li>
 * 
 *         <li>message: It is used to show a small error message that describes
 *         the problem</li>
 * 
 *         <li>code: It is used to show a small error code that can be
 *         representative for an application</li>
 * 
 *         <li>developerMessage: You can specify the generated exception in
 *         order to make easier than the developer find the problem</li>
 * 
 *         </ul>
 * 
 *         The annotation @JsonInclude(Include.NON_NULL) specify that if an
 *         attribute is null it won’t be in the response.
 *
 */
@JsonInclude(Include.NON_NULL)
public class ErrorMessage implements Serializable {
	private Integer httpStatus;
	private String message;
	private Integer code;
	private String developerMessage;

	private static final long serialVersionUID = 5318063708359922770L;

	public ErrorMessage() {
	}

	public ErrorMessage(ServiceException ex) {
		this.httpStatus = ex.getHttpStatus();
		this.message = ex.getMessage();
		this.code = ex.getCode();
	}

	public ErrorMessage(Integer httpStatus, String message, Integer code) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.code = code;
	}

	public Integer getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

}