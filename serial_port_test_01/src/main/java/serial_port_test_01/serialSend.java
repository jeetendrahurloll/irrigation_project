package serial_port_test_01;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;

import com.fazecast.jSerialComm.SerialPort;

public class serialSend {
	public static void send(String outstr, String comPortPath) {

		SerialPort comPort = SerialPort.getCommPort("/dev/ttyACM0");
		comPort.openPort();
		comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		OutputStream out = comPort.getOutputStream();

		try {

			// String outstr=UUID.randomUUID().toString();
			// String outstr=UUID.randomUUID().toString();

			System.out.println(">>" + outstr);
			out.write(outstr.getBytes());
			out.flush();
			// out.close();

		} catch (Exception e) {
			e.printStackTrace();
			
			//todo error handler in case serial port permission not set
		}

		comPort.closePort();
	}
	
	/*
	 * obsolete testing function, verified to work assuming port permissions are set
	 */
	
	public static void send3() {
		/*very rough testing of serial port*/
		// TODO Auto-generated method stub
		// SerialPort comPort = SerialPort.getCommPorts("/dev/ttyACM0");
		SerialPort comPort = SerialPort.getCommPort("/dev/ttyACM0");
		comPort.openPort();
		comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		InputStream in = comPort.getInputStream();
		OutputStream out=comPort.getOutputStream();

		try {
//			for (int j = 0; j < 50; ++j) {
//				System.out.print((char)in.read());

				// System.out.print(in.readAllBytes());
//			   String S=new String(in.readAllBytes());
//			   System.out.println(S);
//			   System.out.println("XXX");
			int i;
			while(true) {
				
			    ArrayList<String> portList = new ArrayList<String>();
			    for (SerialPort port : SerialPort.getCommPorts()) {
			        portList.add(port.getSystemPortName());
			    }
			    
			    	for (String temp : portList) {
			            System.out.println(temp);
			        }
				
				
				
				System.out.println("available "+ in.available());
				//System.out.println((char)in.read());
				byte[] buffer = new byte[1024];
				int v= in.read(buffer);
				//in.close();
				String string = new String(buffer);
				System.out.println("from arduino <<"+string);
				Thread.sleep(4000);
				
				String outstr=UUID.randomUUID().toString();
				System.out.println(">>"+outstr);
				//outstr.getBytes();
				out.write(outstr.getBytes());
				out.flush();
		        
			}
			
			
			
			
			

			//System.out.println("End");
			//in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		comPort.closePort();
		
		
	}
	
	
}
