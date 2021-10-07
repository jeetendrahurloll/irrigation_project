package serial_port_test_01;

import java.util.ArrayList;

import com.fazecast.jSerialComm.SerialPort;

public class listSerialPorts {
	public static String listAllSerialPorts() {
		String portPath="";
		//System.out.println("listing serial port");
	    ArrayList<String> portList = new ArrayList<String>();
	    for (SerialPort port : SerialPort.getCommPorts()) {
	        portList.add("/dev/"+port.getSystemPortName());
	        //System.out.println(port.toString());
	        //System.out.println(port.getDescriptivePortName());
	    }
	    
	    	for (String temp : portList) {
	    		//todo refactor tty to be modular for linux and windows
	    		if(temp.contains("tty")) {
	            //System.out.println(temp);
	            portPath=temp;
	            
	            
	    		}
	        }
	    	return portPath;
	}
}
