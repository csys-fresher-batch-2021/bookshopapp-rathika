package in.rathika.exception;

public class InvalidBookException extends Exception {
	/**
	 * This method is used to raise product invalid message
	 */
	private static final long serialVersionUID = 1L;

		public InvalidBookException(String message) {
			super(message);
	}
}
