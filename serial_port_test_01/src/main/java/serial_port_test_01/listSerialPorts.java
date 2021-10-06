package serial_port_test_01;

import java.util.ArrayList;

import com.fazecast.jSerialComm.SerialPort;

public class listSerialPorts {
	public static void listSerialPorts() {
	    ArrayList<String> portList = new ArrayList<String>();
	    for (SerialPort port : SerialPort.getCommPorts()) {
	        portList.add(port.getSystemPortName());
	    }
	    
	    	for (String temp : portList) {
	            System.out.println(temp);
	        }
	}
}
