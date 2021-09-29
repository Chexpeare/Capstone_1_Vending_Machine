package com.techelevator.util;

/**
 * TELogException extends RuntimeException and reports TELog-specific exceptions. You'll implement TELog in this exercise.
 */

public class TELogException extends RuntimeException {

	public TELogException(String message) {
		super(message);
	}
}
