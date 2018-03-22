package com.rtpa.service.exceptions;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

 
/**
 * @author raidentrance
 *
 */
 
@Provider
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {
 
    @Override
    public Response toResponse(ServiceException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(ex.getCode());
        errorMessage.setMessage(ex.getMessage());
        errorMessage.setDeveloperMessage(ex.toString());
        return Response.status(ex.getHttpStatus()).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
    }
 
}