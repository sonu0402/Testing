package org.ggsl.ew_shared.exception;

public class GenericCustomException extends Exception {
	
	/**
	 * Generic Exception class for all custom exceptions
	 */
	private static final long serialVersionUID = 1L;

	public GenericCustomException(String messageId){
		super(messageId);
		
	}

    
}