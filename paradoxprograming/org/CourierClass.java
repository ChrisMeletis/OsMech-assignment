package paradoxprograming.org;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.util.ArrayList;

import javax.swing.SwingConstants;

public class CourierClass {
	String choice = null;	
	String choice2 = null;
	StringBuilder sb = new StringBuilder(64);
	ArrayList <String> nam = null;
	String[] name = null;
	ArrayList <String> surenam = null;
	String[] surename = null;
	ArrayList <String> statu = null;
	String[] status = null;
	static JFrame frame;

	/**
	 * Launch the application.
	 */public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						CourierClass window = new CourierClass();
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
	public CourierClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	*/
	private void initialize() {
		
	
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 650, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Information = new JLabel("");
		Information.setBounds(450, 11, 174, 239);
		frame.getContentPane().add(Information);
		frame.getContentPane().add(Information);
		
		
		JButton deliveredButton = new JButton("\u03A0\u03B1\u03C1\u03B1\u03B4\u03CC\u03B8\u03B7\u03BA\u03B5");
		Image images = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		deliveredButton.setIcon(new ImageIcon(images));
		deliveredButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		deliveredButton.setBounds(220, 73, 147, 83);
		frame.getContentPane().add(deliveredButton);
				
		JLabel deliveryLabel = new JLabel("");
		Image images1 = new ImageIcon(this.getClass().getResource("/delivery.jpg")).getImage();
		deliveryLabel.setIcon(new ImageIcon(images1));
		deliveryLabel.setBounds(10, 21, 200, 200);
		frame.getContentPane().add(deliveryLabel);
		
		JButton returnedButton = new JButton("\u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE");
		Image images2 = new ImageIcon(this.getClass().getResource("/Sign-Error-icon.png")).getImage();
		returnedButton.setIcon(new ImageIcon(images2));
		returnedButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		returnedButton.setBounds(220, 167, 147, 83);
		frame.getContentPane().add(returnedButton);
		
		
		ArrayList<String> addresses = MainSystem.askDB("select Dest_Address from parcels where parcels.Courier='Markos';",2,"Dest_Address","","","","","");
		String[] AddrInfo = addresses.toArray(new String[addresses.size()]);
		JComboBox AddrInfoList = new JComboBox(AddrInfo);
		AddrInfoList.setBounds(220, 12, 200, 50);
		frame.getContentPane().add(AddrInfoList);
		
		JButton btn = new JButton("Log\r\nOut");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourierClass.frame.dispose();
		    	 try {
						LoginForm window = new LoginForm();
						window.frame.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btn.setHorizontalAlignment(SwingConstants.LEFT);
		btn.setBounds(377, 73, 67, 182);
		frame.getContentPane().add(btn);
		
		
		AddrInfoList.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
					
						choice = (String) AddrInfoList.getSelectedItem();	
						choice2 = LoginForm.username;
						sb = new StringBuilder(64);
					
						nam = MainSystem.askDB("select Client_Name from parcels where parcels.Courier='" +choice2+"'and parcels.Dest_Address='" +choice+"';" ,2,"Client_Name","","","","","");
						name = nam.toArray(new String[nam.size()]);
						surenam = MainSystem.askDB("select Client_Surename from parcels where parcels.Courier='" +choice2+"'and parcels.Dest_Address='" +choice+"';" ,2, "Client_Surename","","","","","");
						surename = surenam.toArray(new String[surenam.size()]);
						statu = MainSystem.askDB("select Pack_Status from parcels where parcels.Courier='" +choice2+"'and parcels.Dest_Address='" +choice+"';" ,2, "Pack_Status","","","","","");
						status = statu.toArray(new String[statu.size()]);
						
						
						sb.append("<html>Όνομα: " +name[0]+"<br> Επώνυμο: " +surename[0]+"<br> Kατάσταση: " +status[0]+"<br> Διεύθυνση: " +choice+ " <br> </html>" );
						Information.setText(sb.toString());
						
						
					}
				});
		deliveredButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						MainSystem.askDB("update parcels set Pack_Status='Delivered' where Client_Name='"+name[0]+"'and Dest_Address='"+choice+"';",1, "update","","","","","");
						nam = MainSystem.askDB("select Client_Name from parcels where parcels.Courier='" +choice2+"'and parcels.Dest_Address='" +choice+"';" ,2, "Client_Name","","","","","");
						name = nam.toArray(new String[nam.size()]);
						surenam = MainSystem.askDB("select Client_Surename from parcels where parcels.Courier='" +choice2+"'and parcels.Dest_Address='" +choice+"';" ,2, "Client_Surename","","","","","");
						surename = surenam.toArray(new String[surenam.size()]);
						statu = MainSystem.askDB("select Pack_Status from parcels where parcels.Courier='" +choice2+"'and parcels.Dest_Address='" +choice+"';" ,2, "Pack_Status","","","","","");
						status = statu.toArray(new String[statu.size()]);
						sb.append("<html>Όνομα: " +name[0]+"<br>" ).
						append(" Επώνυμο: " +surename[0]+"<br>" ).
						append(" Kατάσταση: " +status[0]+"<br>").
						append(" Διεύθυνση: " +choice+ " <br> </html>" );
						Information.setText(sb.toString());
					}
				});
		returnedButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						MainSystem.askDB("update parcels set Pack_Status='Return' where Client_Name='"+name[0]+"'and Dest_Address='"+choice+"';",1, "update","","","","","");
						nam = MainSystem.askDB("select Client_Name from parcels where parcels.Courier='" +choice2+"'and parcels.Dest_Address='" +choice+"';" ,2, "Client_Name","","","","","");
						name = nam.toArray(new String[nam.size()]);
						surenam = MainSystem.askDB("select Client_Surename from parcels where parcels.Courier='" +choice2+"'and parcels.Dest_Address='" +choice+"';" ,2, "Client_Surename","","","","","");
						surename = surenam.toArray(new String[surenam.size()]);
						statu = MainSystem.askDB("select Pack_Status from parcels where parcels.Courier='" +choice2+"'and parcels.Dest_Address='" +choice+"';" ,2, "Pack_Status","","","","","");
						status = statu.toArray(new String[statu.size()]);
						sb.append("<html>Όνομα: " +name[0]+"<br>" ).
						append(" Επώνυμο: " +surename[0]+"<br>" ).
						append(" Kατάσταση: " +status[0]+"<br>").
						append(" Διεύθυνση: " +choice+ " <br> </html>" );
						
						Information.setText(sb.toString());
					}
				});
		 
		
		
		
		
		
		
	
	}
}
	
	

	
	

