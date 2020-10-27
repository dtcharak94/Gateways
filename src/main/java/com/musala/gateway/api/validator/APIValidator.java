package com.musala.gateway.api.validator;

import java.util.*;
import java.util.regex.*; 

import com.musala.gateway.api.model.*;
import com.musala.gateway.exception.ResourceMissingGatewayException;

//Validates incoming Gateway API requests
public class APIValidator {
	
	public static final int C_MAX_DEVICES_PER_GATEWAY=10;
	
	public static final String C_MAX_DEVICES_ERROR_MESSAGE=new String("Gateway must have at most 10 peripheral devices.");
	public static final String C_NOT_VALID_IPV4_ADDRESS_ERROR_MESSAGE=new String("Gateway IPV4 address is not valid.");
	
	
	public APIValidator(){}
	
	/**
	 * Check gateway devices have not exceeded limit of 10!
	 * 
	 * @param list of PeripheralAPI devices
	 * @return true when limit reached, false otherwise
	 */
	public boolean checkGatewayPeripheralsLimit(List<PeripheralAPI> list) {
		
		return (list.size() > C_MAX_DEVICES_PER_GATEWAY) ? true : false;
		
	}
	
   /**
	* Validates Gateway ipv4 address is valid string
	* 
	* @param ipv4 String
	* return true upon success, false otherwise
	*/
	public boolean checkValidGatewayIPV4Address(String ipv4) {
		
		//Regular expression for digit from 0 to 255
        String zeroTo255 = "(\\d{1,2}|(0|1)\\"
              + "d{2}|2[0-4]\\d|25[0-5])"; 
  
        //Pattern for IP address - a digit from 0 to 255 followed by a dot, repeated 4 times
        String regex 
            = zeroTo255 + "\\."
              + zeroTo255 + "\\."
              + zeroTo255 + "\\."
              + zeroTo255; 
  
        Pattern p = Pattern.compile(regex); 
  
        //if IP address is empty, return false 
        if (ipv4 == null) { 
            return false; 
        } 
        
        Matcher m = p.matcher(ipv4); 
        
     
        return m.matches(); 
	}
	
	
	/**
	 * Combines all validations against Gateway API requests
	 * 
	 * @param devices List<PeripheralAPI>
	 * @param ipv4 String
	 * @return true upon success, Exception upon failure
	 */
	public boolean validationHandler(List<PeripheralAPI> devices, String ipv4 ) {
		

		if (!checkValidGatewayIPV4Address(ipv4))
			throw new ResourceMissingGatewayException(C_NOT_VALID_IPV4_ADDRESS_ERROR_MESSAGE);
		
		if (checkGatewayPeripheralsLimit(devices))
			throw new ResourceMissingGatewayException(C_MAX_DEVICES_ERROR_MESSAGE);
			
		return true;
	}
	

}
