package paradoxprograming.org;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class Admin {

	static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
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
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 370, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblCourier = new JLabel("Courier:");
		lblCourier.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourier.setBounds(10, 46, 54, 22);
		frame.getContentPane().add(lblCourier);
		
		JLabel lblStatus = new JLabel("Package Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(10, 87, 99, 22);
		frame.getContentPane().add(lblStatus);
		
		JLabel lblWelcomeAdministrator = new JLabel("Welcome Administrator: "+LoginForm.username);
		lblWelcomeAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWelcomeAdministrator.setBounds(10, 11, 231, 22);
		frame.getContentPane().add(lblWelcomeAdministrator);
		
		JLabel lblStatistics = new JLabel("Statistics");
		lblStatistics.setBackground(Color.WHITE);
		lblStatistics.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatistics.setVerticalAlignment(SwingConstants.TOP);
		lblStatistics.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistics.setBounds(10, 138, 312, 155);
		frame.getContentPane().add(lblStatistics);
		
		JLabel lblDevelopedByParadoxae = new JLabel("Developed by Paradox.ae");
		lblDevelopedByParadoxae.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDevelopedByParadoxae.setBounds(227, 308, 127, 14);
		frame.getContentPane().add(lblDevelopedByParadoxae);
		
		//Logout button--------------------------------------------------------------------------------------------------------------------
		JButton btnLogout = new JButton("Log Out");
		btnLogout.addActionListener(
			    new ActionListener(){
			     public void actionPerformed(ActionEvent e){
			    	 Admin.frame.dispose();
			    	 try {
							LoginForm window = new LoginForm();
							window.frame.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
			    	 
			     }
			    });
		btnLogout.setBounds(251, 13, 93, 23);
		frame.getContentPane().add(btnLogout);
		//Logout button end----------------------------------------------------------------------------------------------------------------
		
		//Status combobox------------------------------------------------------------------------------------------------------------------
		String[] statusinfo = {"Pending","Sent","Recieved","Return","All"};
		JComboBox cbstatus = new JComboBox(statusinfo);
		cbstatus.setBounds(122, 85, 200, 30);
		frame.getContentPane().add(cbstatus);
		
		cbstatus.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						StringBuilder sb = new StringBuilder(64);
						if(cbstatus.getSelectedItem().equals("All")){
							ArrayList<String> numofpacks = MainSystem.askDB("select count(Pack_Status) from parcels;",2,"count(Pack_Status)","","","","","");
							ArrayList<String> deliverpacks = MainSystem.askDB("select count(Pack_Status) from parcels where Pack_Status='Received';",2,"count(Pack_Status)","","","","","");
							ArrayList<String> returnpacks = MainSystem.askDB("select count(Pack_Status) from parcels where Pack_Status='Return';",2,"count(Pack_Status)","","","","","");
							ArrayList<String> remainpacks = MainSystem.askDB("select count(Pack_Status) from parcels where Pack_Status='Pending';",2,"count(Pack_Status)","","","","","");
							ArrayList<String> sentpacks = MainSystem.askDB("select count(Pack_Status) from parcels where Pack_Status='Sent';",2,"count(Pack_Status)","","","","","");
							
							sb.append("<html>All Packages: "+numofpacks+".<br>").
							append("Total Packages sent:"+sentpacks+".<br>").
					    	append("Packages delivered:"+deliverpacks+".<br>").
					    	append("Packages returned:"+returnpacks+".<br>").
					    	append("Packages to be delivered:"+remainpacks+".</html>");
						}
						else{
							ArrayList<String> numofpacks = MainSystem.askDB("select count(Pack_Status) from parcels where Pack_Status='"+cbstatus.getSelectedItem()+"';",2,"count(Pack_Status)","","","","","");
							sb.append(cbstatus.getSelectedItem()+" Packages: "+numofpacks+".");
							
						}						
						lblStatistics.setText(sb.toString());
					}
				});
		//Status combobox end -------------------------------------------------------------------------------------------------------------
		
		//courier combobox ----------------------------------------------------------------------------------------------------------------
		ArrayList<String> couriername = MainSystem.askDB("select username from employees where property='courier';",2,"username","","","","","");
		String[] courierInfo = couriername.toArray(new String[couriername.size()]);
		JComboBox cbcourier = new JComboBox(courierInfo);

		cbcourier.setBounds(122, 44, 200, 30);
		frame.getContentPane().add(cbcourier);
		
		cbcourier.addActionListener(
			    new ActionListener(){
			     public void actionPerformed(ActionEvent e){
			    	 ArrayList<String> numofpacks = MainSystem.askDB("select count(*) from parcels where courier='"+cbcourier.getSelectedItem()+"';",2,"count(*)","","","","","");
			    	 ArrayList<String> deliverpacks = MainSystem.askDB("select count(*) from parcels where courier='"+cbcourier.getSelectedItem()+"' and Pack_Status='delivered';",2,"count(*)","","","","","");
			    	 ArrayList<String> returnpacks = MainSystem.askDB("select count(*) from parcels where courier='"+cbcourier.getSelectedItem()+"' and Pack_Status='return';",2,"count(*)","","","","","");
			    	 ArrayList<String> remainpacks = MainSystem.askDB("select count(*) from parcels where courier='"+cbcourier.getSelectedItem()+"' and Pack_Status='pending';",2,"count(*)","","","","","");

			    	 
			    	 StringBuilder sb = new StringBuilder(64);
			    	 
			    	 sb.append("<html>Packets handled by: "+cbcourier.getSelectedItem()+".<br>").
			    	 append("All Packages: "+numofpacks+".<br>").
			    	 append("Packages delivered:"+deliverpacks+".<br>").
			    	 append("Packages returned:"+returnpacks+".<br>").
			    	 append("Packages to be delivered:"+remainpacks+".</html>");
			    	 lblStatistics.setText(sb.toString());
			      
			     }
			    });
		//courier combobox end ------------------------------------------------------------------------------------------------------------
	}
}
