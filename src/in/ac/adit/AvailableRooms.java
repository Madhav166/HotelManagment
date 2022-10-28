package in.ac.adit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AvailableRooms extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvailableRooms frame = new AvailableRooms();
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
	public AvailableRooms() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Check");
		lblNewLabel.setBounds(284, 29, 46, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 86, 498, 285);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from rooms where status = 'Available'"); 
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model =(DefaultTableModel) table.getModel();
			
			int cols = rsmd.getColumnCount();
			String [] colName = new String[cols];
			for(int i = 0; i<cols;i++) {
				colName[i] = rsmd.getColumnName(i+1);
			}
			model.setColumnIdentifiers(colName);
			String roomNo ,type,dailyRent,hasSeaView ,status;
			while(rs.next()) {
				roomNo =rs.getString(1);
				type =rs.getString(2);
				dailyRent =rs.getString(3);
				hasSeaView =rs.getString(4);
				status =rs.getString(5);
				String [] row = {roomNo ,type,dailyRent,hasSeaView,status};
				model.addRow(row);
			}
			
			
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CheckIn ci = new CheckIn();
				ci.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(299, 377, 89, 23);
		contentPane.add(btnNewButton);
	}
}
