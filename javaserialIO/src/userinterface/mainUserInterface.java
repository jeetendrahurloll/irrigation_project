package userinterface;

import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class mainUserInterface {
	public mainUserInterface() {
		// Create and set up a frame window
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("BoxLayout Example X_AXIS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
		// panel.setBorder(new EmptyBorder(new Insets(50, 80, 50, 80)));

		// Define new buttons
		JButton jb1 = new JButton("Button 1");
		JButton jb2 = new JButton("Button 2");
		JButton jb3 = new JButton("Button 3");

		JTextArea ta = new JTextArea("", 5, 50);
		ta.setLineWrap(true);
		JScrollPane sbrText = new JScrollPane(ta);
		sbrText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// Add buttons to the frame (and spaces between buttons)
		panel.add(jb1);
		// panel.add(Box.createRigidArea(new Dimension(0, 60)));
		panel.add(jb2);
		// panel.add(Box.createRigidArea(new Dimension(0, 60)));
		panel.add(jb3);
		
		panel.add(sbrText);

		// Set size for the frame
		frame.setSize(1000, 1000);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
