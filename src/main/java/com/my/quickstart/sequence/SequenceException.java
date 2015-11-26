package com.my.quickstart.sequence;

/**
 * @author Alan
 *
 */
public class SequenceException extends RuntimeException {
	private static final long serialVersionUID = -3671433293220191179L;

	public SequenceException() {
		super();
	}

	public SequenceException(String message) {
		super(message);
	}

	public SequenceException(String message, Throwable cause) {
		super(message, cause);
	}

	public SequenceException(Throwable cause) {
		super(cause);
	}
}
