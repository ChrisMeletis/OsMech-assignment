package paradoxprograming.org;

import java.awt.EventQueue;











import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
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
	private JButton btnFind_package;
	private JLabel lblNewLabel;
	private JLabel lblSurename;
	private JLabel lblPosition;
	private JLabel lblPosition_1;
	private JLabel lblAddress;
	private JLabel lblCourier;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JList list = new JList(listModel);
	private JButton btnEdit;
	private String logicSurename="or";
	private String logicStatus="or";
	private String logicPosition="or";
	private String logicAddress="or";
	private String logicCourier="or";
	private String tempName = "";
	private String tempSurename = "";
	private String tempStatus = "";
	private String tempPosition = "";
	private String tempAddress = "";
	private String tempCourier = "";
	private JButton btnClear;

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
		frame.setBounds(100, 100, 700, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setToolTipText("Change client name");
		txtName.setBounds(128, 74, 86, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtSurename = new JTextField();
		txtSurename.setToolTipText("Change client Surename");
		txtSurename.setBounds(224, 74, 86, 20);
		frame.getContentPane().add(txtSurename);
		txtSurename.setColumns(10);
		
		txtPosition = new JTextField();
		txtPosition.setToolTipText("Shows current package position.");
		txtPosition.setBounds(416, 74, 86, 20);
		frame.getContentPane().add(txtPosition);
		txtPosition.setColumns(10);
		
		txtStatus = new JTextField();
		txtStatus.setToolTipText("Indicates packet's status. Can be one of the followings:Pending,Sent,Return,Recieved");
		txtStatus.setBounds(320, 74, 86, 20);
		frame.getContentPane().add(txtStatus);
		txtStatus.setColumns(10);
		
		txtClientAddress = new JTextField();
		txtClientAddress.setBounds(128, 119, 86, 20);
		frame.getContentPane().add(txtClientAddress);
		txtClientAddress.setColumns(10);
		
		txtCourierName = new JTextField();
		txtCourierName.setBounds(224, 119, 86, 20);
		frame.getContentPane().add(txtCourierName);
		txtCourierName.setColumns(10);
		
		JButton btnChange = new JButton("Change");
		btnChange.setBounds(10, 74, 98, 33);
		frame.getContentPane().add(btnChange);
		
		JLabel lblWelcomeUser = new JLabel("Welcome user:"+LoginForm.username);
		lblWelcomeUser.setBounds(10, 11, 140, 33);
		frame.getContentPane().add(lblWelcomeUser);
		
		btnLogOut = new JButton("Log Out");
		
		btnLogOut.setBounds(160, 16, 89, 23);
		frame.getContentPane().add(btnLogOut);
		
		label = new JLabel("Developed by Paradox.ae");
		label.setBounds(500, 378, 170, 14);
		frame.getContentPane().add(label);
		
		btnFind_package = new JButton("Find package");
		btnFind_package.setToolTipText("Use the above fields to find a package acordingly.");
		btnFind_package.setBounds(10, 150, 98, 33);
		frame.getContentPane().add(btnFind_package);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(128, 50, 63, 20);
		frame.getContentPane().add(lblNewLabel);
		
		lblSurename = new JLabel("Surename");
		lblSurename.setBounds(224, 50, 63, 20);
		frame.getContentPane().add(lblSurename);
		
		lblPosition = new JLabel("Status");
		lblPosition.setBounds(320, 50, 63, 20);
		frame.getContentPane().add(lblPosition);
		
		lblPosition_1 = new JLabel("Position");
		lblPosition_1.setBounds(416, 50, 63, 20);
		frame.getContentPane().add(lblPosition_1);
		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(128, 98, 63, 20);
		frame.getContentPane().add(lblAddress);
		
		lblCourier = new JLabel("Courier");
		lblCourier.setBounds(224, 98, 63, 20);
		frame.getContentPane().add(lblCourier);
		
		
		
		ArrayList<String> data = MainSystem.askDB("select * from parcels  ;",3,"Client_name","Client_Surename","Dest_Address","Pack_Status","Position","Courier");
		String[] results = data.toArray(new String[data.size()]);
		
		
		for (int i = 0; i<=(results.length)-1; i++)
		{
			listModel.addElement(results[i]);
		}
		
		list.setVisibleRowCount(-1);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setToolTipText("Select a package to edit from this list");
		list.setBounds(128, 150, 550, 217);
		frame.getContentPane().add(list);
		
		JButton btnCreate = new JButton("Create package");
		
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCreate.setBounds(10, 231, 108, 33);
		frame.getContentPane().add(btnCreate);
		
		JButton btnDeletePackage = new JButton("Delete package");
		
		btnDeletePackage.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDeletePackage.setBounds(10, 275, 108, 33);
		frame.getContentPane().add(btnDeletePackage);
		
		btnEdit = new JButton("Edit package");
		
		btnEdit.setToolTipText("Use the above fields to find a package acordingly.");
		btnEdit.setBounds(10, 191, 98, 33);
		frame.getContentPane().add(btnEdit);
		
		btnClear = new JButton("Clear all");
		btnClear.setBounds(320, 116, 89, 23);
		frame.getContentPane().add(btnClear);
		
		btnFind_package.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("".equals(txtCourierName.getText()) && "".equals(txtSurename.getText()) && "".equals(txtStatus.getText()) && "".equals(txtName.getText()) && "".equals(txtPosition.getText()) && "".equals(txtClientAddress.getText()))
				{
					listModel.clear();
					
					ArrayList<String> data = MainSystem.askDB("select * from parcels  ;",3,"Client_name","Client_Surename","Dest_Address","Pack_Status","Position","Courier");
					String[] results = data.toArray(new String[data.size()]);
								
					for (int j = 0; j<=(results.length)-1; j++)
					{
						listModel.addElement(results[j]);
						
					}
				}else
				{
				
					if (!"".equals(txtName.getText()) && !"".equals(txtSurename.getText()))
					{
						logicSurename="and";
					} 
					if (!"".equals(txtStatus.getText()) && (!"".equals(txtName.getText()) || !"".equals(txtSurename.getText())))
					{
						logicStatus="and";
					}
					if (!"".equals(txtPosition.getText()) && (!"".equals(txtSurename.getText()) || !"".equals(txtStatus.getText()) || !"".equals(txtName.getText())))
					{
						logicPosition="and";
					}
					if (!"".equals(txtClientAddress.getText()) && (!"".equals(txtSurename.getText()) || !"".equals(txtStatus.getText()) || !"".equals(txtName.getText()) || !"".equals(txtPosition.getText())))
					{
						logicAddress="and";
					}
					if (!"".equals(txtCourierName.getText()) && (!"".equals(txtSurename.getText()) || !"".equals(txtStatus.getText()) || !"".equals(txtName.getText()) || !"".equals(txtPosition.getText()) || !"".equals(txtClientAddress.getText())))
					{
						logicCourier="and";
					}
					ArrayList<String> data = MainSystem.askDB("select * from parcels where Client_Name ='" +txtName.getText()+"' " +logicSurename+" Client_Surename='"+txtSurename.getText()+"' "+logicStatus+ " Pack_Status ='" +txtStatus.getText()+"' " +logicPosition+" Position ='" +txtPosition.getText()+"' " +logicAddress+" Dest_Address ='" +txtClientAddress.getText()+"' " +logicCourier+" Courier ='" +txtCourierName.getText()+"' ;",3,"Client_name","Client_Surename","Dest_Address","Pack_Status","Position","Courier");
					String[] results = data.toArray(new String[data.size()]);
					listModel.clear();
					for (int i = 0; i<=(results.length)-1; i++)
					{
						listModel.addElement(results[i]);
					}
					list.setVisibleRowCount(-1);
			        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
					list.setToolTipText("Select a package to edit from this list");
					list.setBounds(128, 150, 550, 217);
					frame.getContentPane().add(list);
					if (listModel.isEmpty())
					{
						listModel.addElement("Δε βρέθηκαν καταχωρήσεις που να ταιριάζουν με τα στοιχεία που ζητήθηκαν");
					}
					//frame.getContentPane().add(new JScrollPane(list));
					
				}
				
			}
		});
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ("".equals(txtCourierName.getText()) || "".equals(txtSurename.getText()) || "".equals(txtStatus.getText()) || "".equals(txtName.getText()) || "".equals(txtPosition.getText()) || "".equals(txtClientAddress.getText()))
				{
					listModel.clear();
					listModel.addElement("Πρέπει να συμπληρώσετε όλα τα πεδία! προσπαθήστε ξανά!");
				}
				else
				{
					MainSystem.askDB("insert into parcels (Client_Name,Client_Surename,Dest_Address,Pack_Status,Position,Courier) values ('"+txtName.getText()+"','"+txtSurename.getText()+"','"+txtClientAddress.getText()+"','"+txtStatus.getText()+"','"+txtPosition.getText()+"','"+txtCourierName.getText()+"') ;",1,"","","","","","");
					listModel.clear();
					listModel.addElement("Η εγγραφή καταχωρήθηκε επιτυχώς!");
				}
			}
		});
		
		btnDeletePackage.addActionListener(new ActionListener() {
			byte count=-1;
			public void actionPerformed(ActionEvent e) {
				
				if ("".equals(txtCourierName.getText()) && "".equals(txtSurename.getText()) && "".equals(txtStatus.getText()) && "".equals(txtName.getText()) && "".equals(txtPosition.getText()) && "".equals(txtClientAddress.getText()))
				{
					listModel.clear();
					listModel.addElement("Πρέπει να συμπληρώσετε κάτι για να διαγραφεί. Παρακαλώ συμπληρώστε τουλάχιστον ένα πεδίο");
				}else
				{
					count++;
				
					if(count==0)
					{
						listModel.clear();
						listModel.addElement("<html>ΠΡΟΣΟΧΗ! ΘΑ ΔΙΑΓΡΑΦΟΥΝ ΟΛΕΣ ΟΙ ΚΑΤΑΧΩΡΗΣΕΙΣ ΠΟΥ <br> ΤΑΙΡΙΑΖΟΥΝ ΜΕ ΟΛΑ ΤΑ ΠΑΡΑΚΑΤΩ ΣΤΟΙΧΕΙΑ...</html>");
						if (!"".equals(txtName.getText()))
						{
							listModel.addElement("Όνομα:"+txtName.getText());
						}
						if (!"".equals(txtSurename.getText()))
						{
							listModel.addElement("Επώνυμο:"+txtSurename.getText());
						}
						if (!"".equals(txtClientAddress.getText()))
						{
							listModel.addElement("Διεύθυνση:"+txtClientAddress.getText());
						}
						if (!"".equals(txtStatus.getText()))
						{
							listModel.addElement("Κατάσταση:"+txtStatus.getText());
						}
						if (!"".equals(txtPosition.getText()))
						{
							listModel.addElement("Τοποθεσία:"+txtPosition.getText());
						}
						if (!"".equals(txtCourierName.getText()))
						{
							listModel.addElement("Όνομα Μεταφορέα:"+txtCourierName.getText());
						}
						
						listModel.addElement("ΕΑΝ ΘΕΛΕΤΕ ΟΝΤΩΣ ΝΑ ΣΥΝΕΧΙΣΕΤΕ ΠΑΤΗΣΤΕ ΞΑΝΑ ΤΟ ΚΟΥΜΠΙ delete package");
					}else if(count>0)
					{
						if (!"".equals(txtName.getText()) && !"".equals(txtSurename.getText()))
						{
							logicSurename="and";
						} 
						if (!"".equals(txtStatus.getText()) && (!"".equals(txtName.getText()) || !"".equals(txtSurename.getText())))
						{
							logicStatus="and";
						}
						if (!"".equals(txtPosition.getText()) && (!"".equals(txtSurename.getText()) || !"".equals(txtStatus.getText()) || !"".equals(txtName.getText())))
						{
							logicPosition="and";
						}
						if (!"".equals(txtClientAddress.getText()) && (!"".equals(txtSurename.getText()) || !"".equals(txtStatus.getText()) || !"".equals(txtName.getText()) || !"".equals(txtPosition.getText())))
						{
							logicAddress="and";
						}
						if (!"".equals(txtCourierName.getText()) && (!"".equals(txtSurename.getText()) || !"".equals(txtStatus.getText()) || !"".equals(txtName.getText()) || !"".equals(txtPosition.getText()) || !"".equals(txtClientAddress.getText())))
						{
							logicCourier="and";
						}
						MainSystem.askDB("Delete from parcels where Client_Name ='" +txtName.getText()+"' " +logicSurename+" Client_Surename='"+txtSurename.getText()+"' "+logicStatus+ " Pack_Status ='" +txtStatus.getText()+"' " +logicPosition+" Position ='" +txtPosition.getText()+"' " +logicAddress+" Dest_Address ='" +txtClientAddress.getText()+"' " +logicCourier+" Courier ='" +txtCourierName.getText()+"' ;",1,"","","","","","");
						
						listModel.clear();
						listModel.addElement("Η καταχώρηση/σεις διαγράφηκαν επιτυχώς! ");
					}	
				}
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("".equals(txtCourierName.getText()) && "".equals(txtSurename.getText()) && "".equals(txtStatus.getText()) && "".equals(txtName.getText()) && "".equals(txtPosition.getText()) && "".equals(txtClientAddress.getText()))
				{
					listModel.clear();
					listModel.addElement("<html>Εισάγετε τα δεδομένα της ήδη υπάρχουσας εγγραφής στο/α πεδίο/πεδία. <br> Αφού εισάγετε τα δεδομενα στα κατάλληλα πεδία πατήστε ξανά edit package και εισάγετε τις <br>νέες τιμές που θέλετε και πατήστε Change για να καταχωρηθούν.<br> ΠΡΟΣΟΧΗ! ΣΕ ΠΕΡΙΠΤΩΣΗ ΠΟΥ ΕΙΣΑΓΕΤΕ ΛΙΓΑ ΠΕΔΙΑ ΤΑ ΟΠΟΙΑ ΤΑΙΡΙΑΖΟΥΝ ΣΕ ΠΑΡΑΠΑΝΩ <br>ΑΠΟ ΜΙΑ ΕΓΓΡΑΦΕΣ ΘΑ ΑΛΛΑΧΤΟΥΝ ΟΛΕΣ ΟΙ ΕΓΓΡΑΦΕΣ ΣΤΑ ΠΕΔΙΑ ΠΟΥ ΖΗΤΗΣΑΤΕ</html>");
					
				}else
				{
					tempName = txtName.getText();
					tempSurename=txtSurename.getText();
					tempStatus = txtStatus.getText();
					tempPosition = txtPosition.getText();
					tempAddress = txtClientAddress.getText();
					tempCourier = txtCourierName.getText();
					listModel.clear();
					listModel.addElement("Τα στοιχεία του πακέτου αποθηκεύτηκαν επιτυχώς. Εισάγετε τώρα τα νέα στοιχεία και πατήστε Change για να καταχωρηθούν");
				}
				    	
			}
		});
		btnChange.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if ("".equals(txtCourierName.getText()) && "".equals(txtSurename.getText()) && "".equals(txtStatus.getText()) && "".equals(txtName.getText()) && "".equals(txtPosition.getText()) && "".equals(txtClientAddress.getText()))
				{
					listModel.clear();
					listModel.addElement("<html>Πρέπει να συμπληρώσετε όλα τα πεδία με τα νέα στοιχεία και να έχετε ενημερώσει <br>το edit package με τα παλιά στοιχεία ώστε να πραγματοποιηθεί η αλλαγή");
				}else{ 
					if ("".equals(tempName))
					{
						listModel.clear();
						listModel.addElement("Δεν αποθηκεύσαατε τα παλαιά στοιχεία με το Edit Package! ");
					}
					else
					{
						MainSystem.askDB("update parcels set Client_Name ='" +txtName.getText()+"' ,Client_Surename='"+txtSurename.getText()+"' ,Pack_Status ='" +txtStatus.getText()+"' ,Position ='" +txtPosition.getText()+"' ,Dest_Address ='" +txtClientAddress.getText()+"' ,Courier ='" +txtCourierName.getText()+"' where Client_Name ='" +tempName+"' and Client_Surename='"+tempSurename+"' and Pack_Status ='" +tempStatus+"' and Position ='" +tempPosition+"' and Dest_Address ='" +tempAddress+"' and Courier ='" +tempCourier+"'  ;", 1, "","","","","","");
						listModel.clear();
						listModel.addElement("Τα στοιχεία ενημερώθηκαν επιτυχώς! ");
					}
				}
			}
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtSurename.setText("");
				txtClientAddress.setText("");
				txtCourierName.setText("");
				txtStatus.setText("");
				txtPosition.setText("");
			}
		});
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee.frame.dispose();
		    	 try {
						LoginForm window = new LoginForm();
						window.frame.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
	}
}
