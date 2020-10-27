package com.musala.gateway.repository;


import com.musala.gateway.hibernate.model.Gateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface GatewayRepo extends JpaRepository<Gateway, String> {

	//save(), findOne(), findAll(), count(), delete()
	
	 Gateway findByserialnum(String serialnum);

}

