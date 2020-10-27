package com.musala.gateway.hibernate.builder;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

import com.musala.gateway.api.model.*;
import com.musala.gateway.hibernate.model.*;


public class GatewayDAO {
	
	public GatewayDAO(){}
	
	
	/**
	 *  Translate API Gateway model into one Hibernate understands
	 *  
	 * @param  Gateway API model object
	 * 
	 * @return Hibernate Peripheral model object
     */	
	public Gateway buildGatewayDAO(GatewayAPI g)
	{
		Gateway gHibernate = new Gateway(); 
		
		PeripheralDAO peripheralBuilder = new PeripheralDAO();
		List<Peripheral> newDeviceList=new ArrayList();
			
		//create Gateway object model for Hibernate
		gHibernate.setSerialnum(g.getSerialnum());
		gHibernate.setName(g.getName());
		gHibernate.setIpv4(g.getIpv4());
		
		//Iterate over list of PeripheralAPIs model and convert into Hibernate Peripheral model
		List<PeripheralAPI> devices=g.getDevices();	
		ListIterator<PeripheralAPI> litr = devices.listIterator();
		
		while(litr.hasNext()){
			
			Peripheral temp = peripheralBuilder.buildPeripheralDAO(litr.next());
			if (temp!=null)
			{
				temp.setGateway(gHibernate);
				newDeviceList.add(temp);
			}
		}
		
		//save list of Devices into Gateway model
		gHibernate.setPeripherals(newDeviceList);

		return gHibernate;
	}
	
	
	
	

}
