package serial_port_test_01;
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
				//if(true) {
					ISD.send("  some text ");
					Thread.sleep(2000);
					ISD.receive();
					Thread.sleep(2000);

				} else {
					System.out.println("irrigation device not found");
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// TODO meaningfull message in case program crash here
			}
		}

	}

}
