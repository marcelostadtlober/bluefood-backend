package br.com.mstadtlober.bluefood.application;

@SuppressWarnings("serial")
public class ValidationException extends Exception {
	
	public ValidationException(String message) {
		super(message);
	}

}
