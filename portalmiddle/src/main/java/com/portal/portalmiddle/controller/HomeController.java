package com.portal.portalmiddle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.portalbackend.Client;
import com.portal.portalbackend.dao.ClientDao;

@RestController
public class HomeController {

	@Autowired
	ClientDao clientDao;

	@PostMapping("/SignUp")
	public ResponseEntity<?> SignUp(@RequestBody Client client) {
		try {
			clientDao.addClient(client);
		} catch (Exception e) {
			return new ResponseEntity<String>("Unable to create Client", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Client>(client, HttpStatus.CREATED);
	}

}
