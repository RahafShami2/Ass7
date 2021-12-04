package advcap;

public class BusyConnectionException extends Exception {
	public BusyConnectionException(String massage){
		super(massage);
		
	}
	@Override
	public String getMessage() {
		
		return "[BusyConnectionException :: ] " + super.getMessage();
	}
}
