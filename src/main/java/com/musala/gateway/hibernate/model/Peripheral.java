package com.musala.gateway.hibernate.model;

import java.io.Serializable;
import java.util.Date;
//import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "peripheral")
public class Peripheral implements Serializable {
	
	@Id
	Long id;
	
	@NotBlank 
	String vendor;
	
	@Temporal(TemporalType.DATE)
	Date dateCreated;
	 
	@NotBlank 
	String status;
    
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "serialnum", nullable = false)
	public Gateway gateway;
	

	public Peripheral(){}
	
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	@JsonIgnore //to ignore infinite recursion due to bidirectional links?
	public Gateway getGateway() {
		return gateway;
	}

	public void setGateway(Gateway gtwy) {
		this.gateway = gtwy;
	}


	/**
	 * Update parent Gateway Hibernate model when device is removed
	 * 
	 * @param none
	 * @return void
	 */
	@PreRemove
	private void removePeripheralFromGateway() {
		
	   gateway.removePeripheral(this.id);
	}

}
