package com.cts.spring.boot.rest.api.demo.exception;

public class InvalidTxnException extends Exception{

	public InvalidTxnException() {
		super();
	}

	public InvalidTxnException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidTxnException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidTxnException(String message) {
		super(message);
	}

	public InvalidTxnException(Throwable cause) {
		super(cause);
	}

}
