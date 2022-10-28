package in.ac.adit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckOut extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private int total ;
	private String roomNo;
	private String days,deposit,dailyRent;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut frame = new CheckOut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckOut() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 451);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Check Out");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(293, 27, 109, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Aadhar Number:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(132, 76, 125, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(282, 76, 163, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setBounds(269, 250, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 120, 573, 78);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText();
				if(number == null) {
					JOptionPane.showMessageDialog(null,"Please Write Aadhar Number");
				}
				else {
					try {
						Conn c = new Conn();
						ResultSet rs = c.s.executeQuery("Select * from booking where aadharNo = '"+number+"'");  
						ResultSetMetaData rsmd = rs.getMetaData();
						DefaultTableModel model =(DefaultTableModel) table.getModel();
						
						int cols = rsmd.getColumnCount();
						String [] colName = new String[cols];
						for(int i = 0; i<cols;i++) {
							colName[i] = rsmd.getColumnName(i+1);
						}
						model.setColumnIdentifiers(colName);
						String name ,aadharNo,email,date ,gender,age,phoneNo;
						while(rs.next()) {
							name =rs.getString(1);
							aadharNo =rs.getString(2);
							email =rs.getString(3);
							date =rs.getString(4);
							days =rs.getString(5);
							roomNo =rs.getString(6);
							gender =rs.getString(7);
							age =rs.getString(8);
							phoneNo =rs.getString(9);
							dailyRent =rs.getString(10);
							deposit = rs.getString(11);
							String [] row = {name ,aadharNo,email,date,days,roomNo,gender,age,phoneNo,dailyRent,deposit};
							model.addRow(row);
							
						}
						total = (Integer.parseInt(days) *Integer.parseInt(dailyRent)) - (Integer.parseInt(deposit)); 
						
						textField_1.setText(""+total);
						
						
						
						
					}catch(Exception e2) {
						//e2.printStackTrace();
					}
				
				
				}
			}
		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(501, 75, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Your Payable Amount is:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(73, 240, 197, 34);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Check Out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query1 = "delete from booking where roomNo = '" +roomNo+"'";
					String query2 = "update rooms set status = 'Available' where roomNo = '"+roomNo+"'";
					Conn conn = new Conn();
					conn.s.execute(query1);
					conn.s.execute(query2);
					JOptionPane.showMessageDialog(null,"Check Out Successfully");
				}catch(Exception e3) {
					//e3.printStackTrace();
				}
				
				setVisible(false);
				
				ReceptionPage re = new ReceptionPage();
				re.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(207, 356, 125, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				ReceptionPage re = new ReceptionPage();
				re.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_2.setBounds(436, 356, 89, 26);
		contentPane.add(btnNewButton_2);
		
		
		
		
		
		
	}

}
