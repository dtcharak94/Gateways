package com.musala.gateway.hibernate.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
import java.util.ListIterator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.musala.gateway.api.model.PeripheralAPI;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "gateway")
@EntityListeners(AuditingEntityListener.class)
public class Gateway implements Serializable {

	@Id
	String serialnum;
	 

	@NotNull	
	String name;
	
	@NotNull	
	String ipv4;
	

	@OneToMany(fetch = FetchType.EAGER,
	            cascade =  CascadeType.ALL,
	            mappedBy = "gateway")
	List<Peripheral> peripherals;


	public Gateway(){}
	
	
	public String getSerialnum() {
		return serialnum;
	}


	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
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
	
	public List<Peripheral> getPeripherals() {
		return peripherals;
	}

	public void setPeripherals(List<Peripheral> peripherals) {
		this.peripherals = peripherals;
	}
	
	
	/**
	 * Remove given peripheral device from gateway
	 * 
	 * @param id Long of device to be removed
	 * @return void
	 */
	public void removePeripheral(Long id) {

		//Iterate over list of PeripheralAPIs model and convert into Hibernate Peripheral model	
		ListIterator<Peripheral> litr = peripherals.listIterator();

		int counter=0;
		while(litr.hasNext()){

			Peripheral temp = litr.next();

			if (temp!=null && (temp.getId()).equals(id))
			{
				peripherals.remove(counter);
				break;
			}
			counter++;
		}
	}
	
}
