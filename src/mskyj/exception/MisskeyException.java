package mskyj.exception;

public class MisskeyException extends Exception {
	private String message;
	
	public MisskeyException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
