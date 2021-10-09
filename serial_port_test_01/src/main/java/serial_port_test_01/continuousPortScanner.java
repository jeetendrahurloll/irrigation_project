package serial_port_test_01;

import java.util.Random;

/*
 * This class continuously scans for serial usb ports, if found,
 * updates the port variable on main
 * */

public class continuousPortScanner extends Thread {
	
	IrrigationSerialDevice ISD;
	continuousPortScanner() {
		ISD=new SerialSendReceive();
	}

	public void run() {
		String portPath="";
		
		while (true) {
			
			try {
				portPath=listSerialPorts.listAllSerialPorts();
				if (!portPath.isEmpty()) {
					System.out.println("Irrigation Device present  "+portPath );
					Random rand = new Random();
					// Generating random integers in range 0 to 99
					int int1 = rand.nextInt(100);
			
					ISD.send("  some text "+int1+ " ");
					Thread.sleep(2000);
					ISD.receive();
					Thread.sleep(2000);

				} else {
					System.out.println("irrigation device not found");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				// TODO meaningfull message in case program crash here
			}
		}

	}

}
