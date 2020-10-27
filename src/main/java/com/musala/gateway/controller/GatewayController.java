package com.musala.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Other Beans to auto create and import
import org.springframework.context.annotation.Bean;

import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.List;

import com.musala.gateway.GatewaysApplication;
import com.musala.gateway.service.GatewayService;
import com.musala.gateway.hibernate.model.*;
import com.musala.gateway.api.model.GatewayAPI;
import com.musala.gateway.exception.*;


/**
 *  Gateway controller supports the following WS operations:
 *  
 * 1) Add new Gateway
 * 2) Get Getaway info
 * 3) Get all Gateways info
 * 4) Add peripheral device to Gateway
 * 5) Remove peripheral device from Gateway
 * 
 */

@RestController
@RequestMapping("/api/v1")
public class GatewayController {
	
	@Autowired
	private GatewayService gatewaySvc;
	
	
	/**
	*  Create Gateway with corresponding peripheral devices
	*  
	* @param  GatewayAPI - API gateway model object plus list of peripheral devices 
	* @return WS result object
    */	
	@PostMapping(path="/gateways",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Gateway createGateway(@Valid @RequestBody com.musala.gateway.api.model.GatewayAPI gtway) 
	{		
		return gatewaySvc.createGateway(gtway);
	}  
	
	
   /**
	* Retrieves all gateways info
	* 
	* @return List of Gateways objects, empty if none found
	*/
	@GetMapping(path = "/gateways"
				,produces = {MediaType.APPLICATION_JSON_VALUE}
		)
	 public List<Gateway> getAllGateways() 
	 {		
		return gatewaySvc.getAllGateways();
	 } 
	
	
   /**
	* Retrieves gateway info for specified id
	* 
	* @param  id  a gateway unique identifier
	* @return List of Gateways objects, empty if none found
	*/
	@GetMapping(path = "/gateways/{id}"
				,produces = {MediaType.APPLICATION_JSON_VALUE}
		)
	 public Gateway getGatewayInfo(@Valid @PathVariable("id") String serialNum) 
	 {		
		  return gatewaySvc.getGateway(serialNum);
	 }  
	  
	
   /**
	* Add peripheral device to Gateway
	* 
	* @param PeripheralAPI object model
	* @return Peripheral Hibernate object model
	*/
	@PostMapping(path = "/gateways/peripheral",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public com.musala.gateway.hibernate.model.Peripheral createPeripheral(@Valid @RequestBody com.musala.gateway.api.model.PeripheralAPIUnit device) 
	{		
		return gatewaySvc.createPeripheral(device);
	} 
	  
	/**
	* Delete peripheral device from Gateway
	* 
	* @param String peripheral id
	* @return true, false upon error
	*/
	@DeleteMapping(path = "/gateways/peripheral/{id}")
	public boolean deletePeripheral(@Valid @PathVariable("id") Long id) 
	{		
		boolean result = gatewaySvc.deletePeripheral(id);
		
		if(!result) 
			throw new ResourceOperationFailedException("Deleting device id="+id+" failed!");
		
		return result;
	} 
}
