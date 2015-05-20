package it.appaid.rest.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>
{
	static final Logger logger = LogManager.getLogger(GenericExceptionMapper.class);

    @Override
    public Response toResponse(Throwable exception)
    {
    	logger.error("toResponse() caught exception", exception);

        return Response.status(getStatusCode(exception))
                .entity(getEntity(exception))
                .build();
    }

    /*
     * Get appropriate HTTP status code for an exception.
     */
    private int getStatusCode(Throwable exception)
    {
        if (exception instanceof WebApplicationException)
        {
            return ((WebApplicationException)exception).getResponse().getStatus();
        }

        return Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
    }

    /*
     * Get response body for an exception.
     */
    private Object getEntity(Throwable exception)
    {
        // return stack trace for debugging (probably don't want this in prod...)
        StringWriter errorMsg = new StringWriter();
        exception.printStackTrace(new PrintWriter(errorMsg));
        return errorMsg.toString();            
    }
}