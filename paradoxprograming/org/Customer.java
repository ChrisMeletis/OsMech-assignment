package paradoxprograming.org;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;



public class Customer {

	private JFrame frame;
	private JTextField txtTrackingNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer window = new Customer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Customer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 290, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Welcome to P.M.S.");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(10, 11, 230, 41);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Parcel Management System");
		label_1.setBounds(100, 44, 170, 14);
		frame.getContentPane().add(label_1);
		
		JLabel lblEnterYourTrack = new JLabel("Enter your track ID to track your package");
		lblEnterYourTrack.setBounds(30, 97, 250, 14);
		frame.getContentPane().add(lblEnterYourTrack);
		
		txtTrackingNumber = new JTextField();
		txtTrackingNumber.setToolTipText("Type your tracking number and we will automaticaly give you its location");
		txtTrackingNumber.setBounds(40, 122, 86, 20);
		frame.getContentPane().add(txtTrackingNumber);
		txtTrackingNumber.setColumns(10);
		
		JLabel lblInfo = new JLabel("Your package information will appear here.");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(22, 165, 230, 31);
		frame.getContentPane().add(lblInfo);
		
		JButton btntrack = new JButton("Track");
		btntrack.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){

						ArrayList<String> text = MainSystem.askDB("SELECT Position FROM parcels WHERE PackID='" + txtTrackingNumber.getText() + "';",2,"Position","","","","","");
						String[] posinfo = text.toArray(new String[text.size()]);
						if(text.isEmpty())
						{
							JOptionPane.showMessageDialog(null, "Invalid PackID", "Warning", JOptionPane.INFORMATION_MESSAGE);
							return;
						}else
						{
							lblInfo.setText("<html>Your package position is: <br>" + posinfo[0] + "</html>");
						}
						
						
					}
				});
		
		btntrack.setBounds(136, 120, 86, 25);
		frame.getContentPane().add(btntrack);
	}
}
