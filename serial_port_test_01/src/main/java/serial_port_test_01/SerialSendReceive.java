package serial_port_test_01;

import java.io.InputStream;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

/*
 * do send and receive around same class with same com port object 
 * as other wise the serial port buffer is closed after each com port open
 */
public class SerialSendReceive implements IrrigationSerialDevice {
	// TODO maybe autocloseable interface should be implemented to clear usage of
	// serial port

	SerialPort comPort;
	OutputStream out;
	InputStream in;

	SerialSendReceive() {

		init();
	}

	public void init() {
		System.out.println("serialsend receive init");
		comPort = SerialPort.getCommPort("/dev/ttyACM0");
		comPort.openPort();
		comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		out = comPort.getOutputStream();
		in = comPort.getInputStream();
		
		
	

	}

	public void send(String message) {
		try {
			System.out.println(">>" + message);
			out.write(message.getBytes());
			out.flush();
			// out.close();

		} catch (Exception e) {
			//e.printStackTrace();

			// todo error handler in case serial port permission not set
			System.out.println("send error");
		}

	}

	public void receive() {
		try {
			//TODO message sanity check


			byte[] buffer = new byte[in.available()];
			int v = in.read(buffer);		
			String string = new String(buffer);
			System.out.println("from arduinoz .. " + string + " nnn  " + in.available());
			//System.out.println("available" + in.available());
			//System.out.println("available" + in.available());


		} catch (Exception e) {
			//e.printStackTrace();
			// todo error handler in case serial port permission not set
			System.out.println("receive error");

		}

	}

	public void close() {
		comPort.closePort();

	}

}
