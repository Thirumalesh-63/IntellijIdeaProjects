package com.zapcom.gmail.controller.exceptions;

public class InvalidEmailException extends RuntimeException{
	
	public InvalidEmailException(String msg) {
		super(msg);
	}

}
