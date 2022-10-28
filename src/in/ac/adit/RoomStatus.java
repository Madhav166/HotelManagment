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

public class RoomStatus extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomStatus frame = new RoomStatus();
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
	public RoomStatus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Room Status");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(351, 22, 108, 26);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 67, 626, 305);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ReceptionPage r =new ReceptionPage();
				r.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(356, 393, 89, 23);
		contentPane.add(btnNewButton);
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from rooms"); 
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
	}
}
