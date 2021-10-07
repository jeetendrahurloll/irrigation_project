package serial_port_test_01;
import java.io.OutputStream;
import com.fazecast.jSerialComm.SerialPort;

public class serialSend {
public static void send(String outstr,String comPortPath) {

	SerialPort comPort = SerialPort.getCommPort("/dev/ttyACM0");
	comPort.openPort();
	comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
	OutputStream out=comPort.getOutputStream();

	try {
		
			//String outstr=UUID.randomUUID().toString();
			//String outstr=UUID.randomUUID().toString();

			System.out.println(">>"+outstr);
			out.write(outstr.getBytes());
			out.flush();
			out.close();


	} catch (Exception e) {
		e.printStackTrace();
	}

	comPort.closePort();
}
}
