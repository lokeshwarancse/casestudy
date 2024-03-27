package com.hexaware.myexceptions;

/**
 * The IncidentNumberNotFoundException class represents an exception that is thrown when an incident number is not found.
 */
import java.util.Scanner;


	public class IncidentNumberNotFoundException extends Exception {

		private static final long serialVersionUID = 1L;
		private String message;
		 /**
	     * Constructs a new IncidentNumberNotFoundException with the specified detail message.
	     * 
	     * @param message the detail message
	     */
		public IncidentNumberNotFoundException(String message) {
			this.message = message;
		}
		  /**
	     * Returns the detail message of this exception.
	     * 
	     * @return the detail message
	     */
		public String getMessage() {
			return message;
		}

	}


