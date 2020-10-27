package com.musala.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musala.gateway.hibernate.model.Peripheral;

@Repository
public interface PeripheralRepo extends JpaRepository<Peripheral, Long> {

	//save(), findOne(), findAll(), count(), delete()

}