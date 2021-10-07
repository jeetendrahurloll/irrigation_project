package serial_port_test_01;
/*
 * This class continuously scans for serial usb ports, if found,
 * updates the port variable on main
 * */

public class continuousPortScanner extends Thread {
	continuousPortScanner() {

	}

	public void run() {
		String portPath="";
		
		while (true) {
			
			try {
				portPath=listSerialPorts.listAllSerialPorts();
				if (!portPath.isEmpty()) {
					System.out.println("Irrigation Device present  "+portPath );
					serialSend.send("some text", portPath);
				} else {
					System.out.println("irrigation device not found");
				}

				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// TODO meaningfull message in case program crash here
			}
		}

	}

}
