package com.musala.gateway.service;


import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.gateway.repository.*;
import com.musala.gateway.api.model.*;
import com.musala.gateway.api.validator.APIValidator;
import com.musala.gateway.hibernate.model.*;
import com.musala.gateway.hibernate.builder.*;
import com.musala.gateway.exception.*;
import com.musala.gateway.api.validator.APIValidator;


import com.musala.gateway.*;

/**
 *  Gateway service supports the following WS operations:
 *  
 * 1) Add new Gateway
 * 2) Get Getaway info
 * 3) Get all gateways info
 * 4) Add peripheral device to Gateway
 * 5) Remove peripheral device from Gateway
 * 
 */

@Service ("GatewayService")
public class GatewayService {
	
	@Autowired
	GatewayRepo gatewayRepository;
	
	@Autowired
	PeripheralRepo peripheralRepository;
	
	public static final Logger logger = LoggerFactory.getLogger(GatewaysApplication.class);
	
	
	/**
	 *  Retrieve given gateway info
	 *  
	 *  @param String serialNum of gateway
	 * 
	 * @return Gateway object, empty upon error or none
	 */
	 public com.musala.gateway.hibernate.model.Gateway getGateway(String serialNum) 
	 {		
		return gatewayRepository.findByserialnum(serialNum);
	 }    
	 
	 
	 /**
	  * Retrieve all gateways info
	  * 
	  * @return List of Gateway objects
	  */
	public List<com.musala.gateway.hibernate.model.Gateway> getAllGateways() {
			return gatewayRepository.findAll();
	}

		
	/** 
	* Create gateway with corresponding peripheral devices 
	*  
	* @param com.musala.gateway.api.model.Gateway  object
	* @return boolean true upon success, false otherwise result object
    */	
	 
	public com.musala.gateway.hibernate.model.Gateway createGateway(com.musala.gateway.api.model.GatewayAPI apigtway) 
	{	
		GatewayDAO gtwyBuilder = new GatewayDAO();
		
		List<PeripheralAPI> devices=apigtway.getDevices();
		
		APIValidator validator= new APIValidator();
		validator.validationHandler(devices, apigtway.getIpv4());
		
		//prepare to insert Gateway model into database
		Gateway gtwy=gtwyBuilder.buildGatewayDAO(apigtway);
		
		return gatewayRepository.save(gtwy);
	 }  
	
	
	/**
	 * Add peripheral device to Gateway by converting API model into Hibernate expected one
	 * 
	 * @param PeripheralAPI device object
	 * @return Peripheral Hibernate model
	 */
	public com.musala.gateway.hibernate.model.Peripheral createPeripheral(@Valid @RequestBody com.musala.gateway.api.model.PeripheralAPIUnit device) 
	{		
		PeripheralDAO buildDevice = new PeripheralDAO();
		
		Peripheral temp=null;
		Gateway gtway=gatewayRepository.findByserialnum(device.getSerialnum());
		
		//validate request
		if (gtway!=null)
		{
			validatePeripheralsInDB(gtway.getPeripherals());
			
		}
		
		PeripheralAPI unit= new PeripheralAPI();
		unit.setId(device.getId());
		unit.setVendor(device.getVendor());
		unit.setDatecreated(device.getDatecreated());
		unit.setStatus(device.getStatus());
		
		temp=buildDevice.buildPeripheralDAO(unit);
		if (gtway!=null)
		{
			temp.setGateway(gtway);
		}
		else 
			throw new ResourceMissingGatewayException();
		
		
		
		return peripheralRepository.save(temp);
	}  

	
	/**
	 * Delete given peripheral device
	 *
	 * @param id String
	 * @return true upon success, false upon failure
	 */
	public boolean deletePeripheral(Long id) {
		
		boolean result = true;
		try 
		{
			peripheralRepository.deleteById(id);
		}
		catch(Exception e)
		{
			result=false;
			logger.debug(e.getMessage());
		}
		
		return result;
	}
	
	
	
	/**
	 * Validates number of peripherals is not past maximum allowed
	 * 
	 * @param List of Peripheral objects 
	 * @return true upon successful validation, ResourceMissingGatewayException upon validation failure
	 */
	public boolean validatePeripheralsInDB(List<Peripheral> devices)
	{
		//Validate # of devices in request to maximum limit
			
		boolean result = (devices.size() == APIValidator.C_MAX_DEVICES_PER_GATEWAY) ? true : false;
		if (result)
			throw new ResourceMissingGatewayException(APIValidator.C_MAX_DEVICES_ERROR_MESSAGE);

		return true;
	}
	
	
}//end-class
