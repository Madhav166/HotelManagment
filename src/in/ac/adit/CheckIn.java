package in.ac.adit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Choice;
import javax.swing.JRadioButton;

public class CheckIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_7;
	private String room;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckIn frame = new CheckIn();
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
	public CheckIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 464);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Check-In Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(343, 24, 143, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(146, 110, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(227, 109, 165, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Aadhar Number:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(73, 144, 122, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setBounds(227, 143, 165, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(146, 186, 59, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setBounds(227, 185, 165, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CheckIn Date:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(87, 227, 106, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Room No:");
		lblNewLabel_5.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(121, 65, 74, 22);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phone Number:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(71, 313, 122, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_5.setBounds(227, 312, 143, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Number Of Days:");
		lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(58, 271, 135, 30);
		contentPane.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_6.setBounds(227, 271, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		
		
		Choice choice = new Choice();
		choice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		choice.setBounds(227, 65, 86, 20);
		contentPane.add(choice);
		try {
			Conn conn = new Conn();
			String query = "select * from rooms where status = 'Available';";
			ResultSet rs = conn.s.executeQuery(query);
			while(rs.next()) {
				choice.add(rs.getString("roomNo"));
				
				
			}
			
			
		}catch(Exception e){
			//e.printStackTrace();
		}
		Date date = new Date();
		JLabel lblNewLabel_8 = new JLabel(""+ date);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(226, 229, 177, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Gender:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_9.setBounds(471, 144, 59, 14);
		contentPane.add(lblNewLabel_9);
		
		rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					rdbtnNewRadioButton_1.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(560, 142, 65, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_1.setBounds(636, 142, 74, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_10 = new JLabel("Age:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_10.setBounds(495, 104, 35, 26);
		contentPane.add(lblNewLabel_10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_3.setBounds(560, 109, 59, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Check");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AvailableRooms c = new AvailableRooms();
				c.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(330, 65, 89, 23);
		contentPane.add(btnNewButton_1);
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String number = textField_1.getText();
				String email = textField_2.getText();
				String date = lblNewLabel_8.getText();
				room = choice.getSelectedItem();
				String phoneNo = textField_5.getText();
				String days = textField_6.getText();
				String age = textField_3.getText();
				String deposit = textField_7.getText();
				String dailyRent = textField_4.getText();
				String gender = null;
				if(rdbtnNewRadioButton.isSelected()) {
					gender = "Male";
				}
				else {
					gender = "Female";
				}
				if((name.isEmpty()) || (number==null) || (email==null) || (phoneNo==null) || (days==null) || (age==null) || (gender==null) || (deposit==null) ||(dailyRent == null)) {
					JOptionPane.showMessageDialog(null,"Enter complete information");
				}
				else {
					try {
					
						String query1 = "insert into booking values('"+name+"','"+number+"', '"+email+"','"+date+"','"+days+"','"+room+"','"+gender+"','"+age+"','"+phoneNo+"','"+dailyRent+"','"+deposit+"' ) ";
						String query2 = "update rooms set status = 'Occupied' where roomNo = '"+room+"'";
					
						Conn conn = new Conn();
						conn.s.execute(query1);
						conn.s.execute(query2);
					
						JOptionPane.showMessageDialog(null,"New Customer is Added");
						setVisible(false);
						ReceptionPage reception = new ReceptionPage();
						reception.setVisible(true);
					
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(305, 370, 98, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ReceptionPage reception = new ReceptionPage();
				reception.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_2.setBounds(479, 370, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_11 = new JLabel("Daily Rent:");
		lblNewLabel_11.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_11.setBounds(447, 186, 86, 23);
		contentPane.add(lblNewLabel_11);
		
		textField_4 = new JTextField();
		 
				
				
			
		
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_4.setBounds(560, 186, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Deposit:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_12.setBounds(457, 227, 73, 23);
		contentPane.add(lblNewLabel_12);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_7.setBounds(560, 227, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("<--");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					room = choice.getSelectedItem();
					Conn c = new Conn();
					String query = "select dailyRent from rooms where roomNo = '"+room+"';";
					ResultSet rs = c.s.executeQuery(query);
					while(rs.next()) {
						textField_4.setText(rs.getString("dailyRent"));
					}
					
				}
				catch(Exception e9) {
					e9.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_3.setBounds(665, 185, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}
