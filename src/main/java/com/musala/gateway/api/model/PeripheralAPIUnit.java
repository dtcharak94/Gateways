package com.musala.gateway.api.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.musala.gateway.api.model.deserializer.LongHandler;

//Models single addition of one peripheral device 
public class PeripheralAPIUnit {
	
	@JsonDeserialize(using = LongHandler.class)
	Long id;

	@NotBlank
	String vendor;

	@NotBlank
	String datecreated;

	@NotBlank
	String status;

	@NotBlank
	String serialnum;


	PeripheralAPIUnit(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(String datecreated) {
		this.datecreated = datecreated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

   
	public String getSerialnum() {
		return serialnum;
	}

	public void setGatewaySerialNum(String serialNum) {
		this.serialnum = serialNum;
	}


	public String printPeripheral()
	{	
		String s="UID:"+this.id +"\n";
		s=s+"Vendor:"+this.datecreated +"\n";
		s=s+"Date created:"+this.datecreated +"\n";
		s=s+"Status:"+this.status +"\n";

		return s;
	}

}
