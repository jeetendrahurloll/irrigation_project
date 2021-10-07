package serial_port_test_01;

public interface IrrigationSerialDevice {

	void init();

	void send(String message);

	void receive();

	void close();

}