package advcap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import advcap.Adapter;
import advcap.ConnectionType;
import advcap.Ftp;
import advcap.ProtocolFactory;
import advcap.Scp;
import advcap.Ssh;
import advcap.Telnet;
import advcap.Protocol;
import advcap.ProtocolException;

public class Connection {
	
	public static Map connections = new HashMap<String, Protocol>();
	//getInstance, createConnection , getConnection 
	public static Protocol getInstance(String connectionType) throws ProtocolException{
		if(connections.containsKey(connectionType)) {
			System.out.println("Connection is already created!.");
			return (Protocol) connections.get(connectionType);
		} else {
			if(connections.size() >= 3 ) {
				//do not create connection
				System.out.println("Can't create more than 3 connection!!");
				return null;
			}
			Protocol instance = ProtocolFactory.createProcol(connectionType);
			connections.put(connectionType, instance);
			return instance;
			
		}
	}
	
	public static boolean release(String connectionType) {
		if(connections.containsKey(connectionType)) {
			connections.remove(connectionType);
			
		//	ProtocolFactory.createProcol(connectionType).release();
			
			return true;
		}
		
		return false;
		
	}
	public static ArrayList<String> getCurrentConnections() {
		Set<String> keys = connections.keySet();
		
		ArrayList<String> myConnection =  new ArrayList<String>();
		for (String key : keys) {
			myConnection.add(key);
		}
		return myConnection;
		
		
	}

}