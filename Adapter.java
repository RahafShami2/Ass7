package advcap;

import advcap.TFTPProtocol;
import advcap.Protocol;

public class Adapter implements Protocol {

	private TFTPProtocol tftpLegcy;
	private static Protocol instance;
	
	
	private Adapter() {
		System.out.println("Creating a new TFTPAdpter insatnce");
		tftpLegcy = TFTPProtocol.getTFTPInstance();
	}
	
	protected static Protocol getInsatnce() {
		if(instance == null) {
			instance = new Adapter();
		}
		return instance;
	}
	
	@Override
	public boolean release() {
		if(tftpLegcy != null) {
			tftpLegcy.releaseTFTP();
		}
		instance = null;
		return false;
	}

	@Override
	public void send(String message) {
		if(tftpLegcy != null) {
			tftpLegcy.sendMessage(message);
		}
	}

}
