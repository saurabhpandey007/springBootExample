package com.exception;

import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	public GlobalExceptionHandler() {
		System.out.println("gexc created");
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)  
    @ExceptionHandler(value={Exception.class})  
    public AppException handleBaseException(Exception e) throws MalformedURLException{ 
		System.out.println("i am called");
        return new AppException(500, 5000, "Employee with id "+1+" is not present in database",new URL("http://localhost:8090/create"),"Verify the existence of the podcast with the id "+1+" in the database");
    }  
  
   
	
}
