package serial_port_test_01;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;

import com.fazecast.jSerialComm.SerialPort;

public class serial_receive {
	public static void receive() {

		SerialPort comPort = SerialPort.getCommPort("/dev/ttyACM0");
		comPort.openPort();
		comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		InputStream in = comPort.getInputStream();

		try {

			
			while (true) {

				// System.out.println("available "+ in.available());
				// System.out.println((char)in.read());
				byte[] buffer = new byte[1024];
				int v = in.read(buffer);
				// in.close();
				String string = new String(buffer);
				System.out.println("from arduino <<" + string);
				Thread.sleep(4000);

			}

		
		} catch (Exception e) {
			e.printStackTrace();
		}

		comPort.closePort();
	}
}