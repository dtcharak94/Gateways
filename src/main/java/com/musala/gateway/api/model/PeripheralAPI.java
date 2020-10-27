package com.musala.gateway.api.model;

//import java.time.LocalDate;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//import com.musala.gateway.api.model.deserializer.DateHandler;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.musala.gateway.api.model.deserializer.LongHandler;


public class PeripheralAPI {

	@JsonDeserialize(using = LongHandler.class)
	Long id;

	@NotBlank
	String vendor;

	//@JsonFormat(pattern = "yyyy-MM-dd")
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	//LocalDate dateCreated;

	//@JsonDeserialize(using = DateHandler.class)
	//Date dateCreated;

	@NotBlank
	String datecreated;

	@NotBlank
	String status;


	public PeripheralAPI(){}

	
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

	/*
		public Date getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(Date dateCreated) {
			this.dateCreated = dateCreated;
		}*/


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

	public String printPeripheral()
	{	
		String s="UID:"+this.id +"\n";
		s=s+"Vendor:"+this.datecreated +"\n";
		s=s+"Date created:"+this.datecreated +"\n";
		s=s+"Status:"+this.status +"\n";

		return s;
	}


}
