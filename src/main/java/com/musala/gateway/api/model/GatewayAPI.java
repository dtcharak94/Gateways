package com.musala.gateway.api.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import javax.xml.bind.annotation.*;  
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public class GatewayAPI {
	
	@NotBlank
	String serialnum;
	
	@NotBlank
	String name;
	
	@NotBlank
	String ipv4;
	
	@NotNull
	List<PeripheralAPI> devices;
	
	GatewayAPI(){}
	
	
	public String getSerialnum() {
		return serialnum;
	}

	public void setSerialnum(String serualNum) {
		this.serialnum = serualNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpv4() {
		return ipv4;
	}

	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
	}

	public List<PeripheralAPI> getDevices() {
		return devices;
	}

	public void setDevices(List<PeripheralAPI> devices) {
		this.devices = devices;
	}
	
	
}
