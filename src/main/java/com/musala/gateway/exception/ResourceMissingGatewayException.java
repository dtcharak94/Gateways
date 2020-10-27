package com.musala.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
public class ResourceMissingGatewayException extends RuntimeException  {
	
	
	public static final String C_MISSING_GATEWAY_ERR_MSG= new String("Gateway for new device has not been setup! Transaction rejected.");
	
	public ResourceMissingGatewayException() {
        super(C_MISSING_GATEWAY_ERR_MSG);
    }

    public ResourceMissingGatewayException(String message) {
        super(message);
    }

    public ResourceMissingGatewayException(String message, Throwable cause) {
        super(message, cause);
    }

}
