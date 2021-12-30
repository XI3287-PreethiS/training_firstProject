package com.simpleapp.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class SimpleappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleappApplication.class, args);
	}
	@GetMapping("/{Number1}/{Number2}")
    public long greeting(@PathVariable("Number1") long n1,@PathVariable("Number2") long n2) {
		return (n1*n2);
		
	    
    }
}




