package paradoxprograming.org;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class Employee {

	static JFrame frame;
	private JTextField txtName;
	private JTextField txtSurename;
	private JTextField txtPosition;
	private JTextField txtStatus;
	private JTextField txtClientAddress;
	private JTextField txtCourierName;
	private JButton btnLogOut;
	private JLabel label;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee window = new Employee();
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
	public Employee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 670, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList<?> list = new JList<Object>();
		list.setToolTipText("Select a package to edit from this list");
		list.setBounds(128, 150, 511, 217);
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("Edit package");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(10, 194, 98, 33);
		frame.getContentPane().add(btnNewButton);
		
		txtName = new JTextField();
		txtName.setToolTipText("Change client name");
		txtName.setText("Name");
		txtName.setBounds(128, 74, 86, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtSurename = new JTextField();
		txtSurename.setToolTipText("Change client Surename");
		txtSurename.setText("Surename");
		txtSurename.setBounds(224, 74, 86, 20);
		frame.getContentPane().add(txtSurename);
		txtSurename.setColumns(10);
		
		txtPosition = new JTextField();
		txtPosition.setToolTipText("Shows current package position.");
		txtPosition.setText("Position");
		txtPosition.setBounds(416, 74, 86, 20);
		frame.getContentPane().add(txtPosition);
		txtPosition.setColumns(10);
		
		txtStatus = new JTextField();
		txtStatus.setToolTipText("Indicates packet's status. Can be one of the followings:Pending,Sent,Return,Recieved");
		txtStatus.setText("Status");
		txtStatus.setBounds(320, 74, 86, 20);
		frame.getContentPane().add(txtStatus);
		txtStatus.setColumns(10);
		
		txtClientAddress = new JTextField();
		txtClientAddress.setText("Client Address");
		txtClientAddress.setBounds(128, 105, 86, 20);
		frame.getContentPane().add(txtClientAddress);
		txtClientAddress.setColumns(10);
		
		txtCourierName = new JTextField();
		txtCourierName.setText("Courier name");
		txtCourierName.setBounds(320, 105, 86, 20);
		frame.getContentPane().add(txtCourierName);
		txtCourierName.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Change");
		btnNewButton_1.setBounds(10, 74, 98, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblWelcomeUser = new JLabel("Welcome user: "+LoginForm.username);
		lblWelcomeUser.setBounds(10, 11, 172, 33);
		frame.getContentPane().add(lblWelcomeUser);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(
			    new ActionListener(){
			     public void actionPerformed(ActionEvent e){
			    	 Employee.frame.dispose();
			    	 try {
							LoginForm window = new LoginForm();
							window.frame.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
			    	 
			     }
			    });
		btnLogOut.setBounds(555, 16, 89, 23);
		frame.getContentPane().add(btnLogOut);
		
		label = new JLabel("Developed by Paradox.ae");
		label.setBounds(519, 378, 125, 14);
		frame.getContentPane().add(label);
		
		btnNewButton_2 = new JButton("Find package");
		btnNewButton_2.setToolTipText("Use the above fields to find a package acordingly.");
		btnNewButton_2.setBounds(10, 150, 98, 33);
		frame.getContentPane().add(btnNewButton_2);
	}
}
