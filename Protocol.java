package advcap;

import advcap.ProtocolException;
import advcap.NoConnectionException;


public interface Protocol {
	
	public static boolean release() throws ProtocolException {
		return false;
	}
	
	public static int send(String message) throws NoConnectionException, BusyConnectionException, ConnectionException, ProtocolException {
		int status = MyConstraints.BUSY_STATUS;
		//no connection 
		if(message == null) {
			Logger.getInstance().logInfo("sending..");
			throw new NoConnectionException ("No connection...you can creat a connection");
		}
		//connection is busy 
		if(status == MyConstraints.BUSY_STATUS ) {
			Logger.getInstance().logError("Bug in creat of new connection");
			throw new BusyConnectionException("Connection is busy...you can try again later");
		}
		if(status == MyConstraints.READY_STATUS )
		{
			Connection.getInstance(ConnectionType.SSH);
		}
		try{
		if(status== MyConstraints.DONE_RESULT) {
			Logger.getInstance().logInfo("Succesfull of Release :) !!");
			Connection.release("ssh");
			return MyConstraints.DONE_RESULT;
		}
		else {
			Connection.release(message);
			Logger.getInstance().logError("Bug in release");
			throw new ConnectionException("Connection failed ");	
		}
	 catch(Exception e) {
		Logger.getInstance().logError("Unexpected Error :: " + e.getMessage());
		throw new ConnectionException("Failed to connection" + e.getMessage());
	} finally {
		System.out.println("Releasing the connecter");
		Processor.release();
	}	
}
throw new ConnectionException("The connection was not connect ");	
	}
}