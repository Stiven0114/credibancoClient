package com.credibancoClient.credibancoClient.consumir;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.credibanco.Dependencias.dto.UsuarioDTORequest;
import com.credibanco.Dependencias.http.SHttpService;



public class HttpService {
	
	private static final Logger logger= LoggerFactory.getLogger(HttpService.class);
	public void createUser() {
		try {
		 UsuarioDTORequest userDto=new UsuarioDTORequest();
		userDto.setId(401);
		userDto.setUserName("Stiven");
		userDto.setPassword("09876");
		userDto.setCardNumber("2365478967354267");
		
		ResponseEntity<String>response=new RestTemplate().exchange("http://localhost:8080/users/create",HttpMethod.POST,SHttpService.getHttpEntity(userDto),String.class);
		if(response.getStatusCode()==HttpStatus.OK) {
			logger.info("usuario registrado: {}",response.getBody());
		}else {
			logger.info("usuario no registrado: {}",response.getBody());
			
		 }
		}catch(Exception e) {
			logger.error("Error en el http service al crear usuario: *",e);
		}
		
		
		
		}
		
	
	

}
