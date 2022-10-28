package in.ac.adit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveRoom extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveRoom frame = new RemoveRoom();
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
	public RemoveRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove Room");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(289, 24, 117, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Room Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(172, 78, 117, 14);
		contentPane.add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.setBounds(289, 78, 57, 20);
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
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String room = choice.getSelectedItem();
				try {
					Conn c = new Conn();
					String query = "delete from rooms where roomNo = '"+room+"';";
					c.s.execute(query);
					JOptionPane.showMessageDialog(null,"Room is Removed");
					setVisible(false);
					AdminPage ad = new AdminPage();
					ad.setVisible(true);
				}
				catch(Exception e5) {
					e5.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(201, 234, 99, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminPage ad = new AdminPage();
				ad.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(368, 234, 89, 23);
		contentPane.add(btnNewButton_1);
		
	}
}
