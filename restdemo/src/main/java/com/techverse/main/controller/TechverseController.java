package com.techverse.main.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.techverse.main.objects.UserDetails;
import com.techverse.main.service.FirebaseService;

@RestController
public class TechverseController {
	
	
	@GetMapping("/index")
	public ResponseEntity<String> index(){
		System.out.println("BrokerAPIController - index() :: Start");
		String message = "Welcome to Azure deployment";
		System.out.println("BrokerAPIController - index() :: End");
		return ResponseEntity.ok().body(message);		
	}

}
