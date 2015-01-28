package paradoxprograming.org;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;


public class LoginForm {
	public static String username;

	//it was private JFrame frame;
	static JFrame frame;
	private JTextField txtUsername;
	private JTextField txtEnterPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
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
	public LoginForm() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 280, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToParcel = new JLabel("Welcome to P.M.S.");
		lblWelcomeToParcel.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToParcel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcomeToParcel.setBounds(10, 11, 230, 41);
		frame.getContentPane().add(lblWelcomeToParcel);
		
		JLabel lblParcelManagementSystem = new JLabel("Parcel Management System");
		lblParcelManagementSystem.setBounds(108, 44, 132, 14);
		frame.getContentPane().add(lblParcelManagementSystem);
		
		txtUsername = new JTextField();
		txtUsername.setText("Enter Username");
		txtUsername.setBounds(103, 69, 122, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(35, 72, 58, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(35, 103, 58, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblDevelopedByParadoxae = new JLabel("Developed by Paradox.ae ");
		lblDevelopedByParadoxae.setBounds(132, 168, 132, 14);
		frame.getContentPane().add(lblDevelopedByParadoxae);
		
		txtEnterPassword = new JTextField();
		txtEnterPassword.setText("Enter Password");
		txtEnterPassword.setBounds(102, 100, 123, 20);
		frame.getContentPane().add(txtEnterPassword);
		txtEnterPassword.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		frame.add(btnEnter);
		btnEnter.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						System.out.println("Listener anabled");

						
						ArrayList<String> propertxt = MainSystem.askDB("SELECT property FROM employees WHERE username = '" + txtUsername.getText() + "' and password = '" + txtEnterPassword.getText() + "';",2,"property","","","","","");
						username = txtUsername.getText();
						
						System.out.println("Query succeded");
						String[] propinfo = propertxt.toArray(new String[propertxt.size()]);
						
						if(propertxt.isEmpty()){
							JOptionPane.showMessageDialog(null, "Invalid credentials", "Warning", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						else if (propinfo[0].equals("employee")){
							LoginForm.frame.dispose();
							try {
								Employee window = new Employee();
								window.frame.setVisible(true);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
						else if(propinfo[0].equals("administrator")){
							LoginForm.frame.dispose();
							try {
								Admin window = new Admin();
								window.frame.setVisible(true);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
						else if(propinfo[0].equals("courier")){
							System.out.println("you are a courier");
							System.out.println("Courier class is missing please find another job");
						}							
						

						System.out.println(propinfo[0]);
					}
				});
		btnEnter.setBounds(84, 134, 89, 23);
		frame.getContentPane().add(btnEnter);
	}
}
