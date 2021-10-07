package serial_port_test_01;

import java.io.InputStream;


import com.fazecast.jSerialComm.SerialPort;

public class hub {

	public static void main(String[] args) {
		/*
		 * constinuously scan for connected irrigation device
		 */

		//IrrigationSerialDevice S=new SerialSendReceive();
		continuousPortScanner cPs=new continuousPortScanner();
		cPs.start();
		
		//serialSend.send("some text", "/dev/ttyACM0");
		//serialSend.send();
	 
	}

}
