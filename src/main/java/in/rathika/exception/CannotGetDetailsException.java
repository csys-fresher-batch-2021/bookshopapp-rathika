package in.rathika.exception;


public class CannotGetDetailsException extends Exception {

public class CannotGetDetailsException extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * This exception will be raise when the details cannot be accessed by the
	 * method
	 * 
	 * @param message
	 */
	public CannotGetDetailsException(String message) {
		super(message);

	}

	

}

}
