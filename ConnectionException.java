package advcap;

public class ConnectionException extends Exception {
	public ConnectionException(String massage1) {
		super(massage1);

		
	}
	@Override
	public String getMessage() {
		
		return "[ConnectionException :: ] " + super.getMessage();
	}

}
