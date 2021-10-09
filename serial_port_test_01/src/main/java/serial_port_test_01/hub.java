package serial_port_test_01;

import java.io.InputStream;


import com.fazecast.jSerialComm.SerialPort;

import dataFilters.headTailRemover;

public class hub {

	public static void main(String[] args) {
		/*
		 * constinuously scan for connected irrigation device
		 */

		//continuousPortScanner cPs=new continuousPortScanner();
		//cPs.start();

		headTailRemover htr=new headTailRemover();
		String S="sdfasdfHEAD559lsjfljsldfj"
				+ "TAIL559asdfasfa";
		htr.arduinoData(S);
		
	 
	}

}
