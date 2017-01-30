package com.exception;

import java.net.URL;



import org.springframework.stereotype.Component;


@Component
public class AppException{
	
	private static final long serialVersionUID = 1L;
	private Integer status;
	private Integer code;
	private String message;
	private URL link;
	private String developerMessage;
	
	public AppException() {
		System.out.println("appexc created");
	}
	
	public AppException(Integer status, Integer code, String message, URL link, String developerMessage) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
		this.link = link;
		this.developerMessage = developerMessage;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public URL getLink() {
		return link;
	}
	public void setLink(URL link) {
		this.link = link;
	}
	public String getDeveloperMessage() {
		return developerMessage;
	}
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
	
}
