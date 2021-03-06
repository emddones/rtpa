package com.rtpa.service.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.http.HttpStatus;

/**
 * @author raidentrance
 *
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessage(ex.getMessage());
		errorMessage.setDeveloperMessage(ex.toString());
		return Response.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).entity(errorMessage)
				.type(MediaType.APPLICATION_JSON).build();
	}

}