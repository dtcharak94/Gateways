package com.musala.gateway.hibernate.builder;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.musala.gateway.api.model.PeripheralAPI;
import com.musala.gateway.hibernate.model.Peripheral;


public class PeripheralDAO {

	public PeripheralDAO(){}
	
	/**
	 *  Translate API Peripheral model into one Hibernate understands
	 *  
	 * @param  Peripheral API model
	 * 
	 * @return Hibernate Peripheral model object
     */	
	public Peripheral buildPeripheralDAO(PeripheralAPI o)
	{
		Peripheral device=new Peripheral();
		Date tempDate=null;
		
		device.setId(o.getId());
		device.setVendor(o.getVendor());
		
		//convert LocalDate to java.util.date understood by Hibernate mapper
		//device.setDateCreated(java.sql.Date.valueOf(o.getDateCreated()));
		
		 try    
		 {
			 String date = o.getDatecreated();
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 tempDate=sdf.parse(date);
	    } catch (Exception e) {}
		
		device.setDateCreated(tempDate);
		device.setStatus(o.getStatus());
		
	
		return device;
	}
}
