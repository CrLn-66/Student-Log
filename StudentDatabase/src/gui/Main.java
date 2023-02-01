package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import com.github.lgooddatepicker.components.DatePicker;

public class Main {

	private JFrame frame;
	private JTextField sid;
	private JTextField nme;
	private JTextField age;
	private JTextField addr;
	private static Connection con = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String path = System.getProperty("user.dir") +"\\data.db";
					 // Step 1: Register the SQLite JDBC Driver
		            Class.forName("org.sqlite.JDBC");

		            // Step 2: Open a connection to the database file
		            con = DriverManager.getConnection("jdbc:sqlite:"+path);
		            con.setAutoCommit(false);
		            System.out.println("Connection to SQLite database established.");
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Model model = new Model();
		model.addColumn("Student ID");
	    model.addColumn("Name");
	    model.addColumn("Age");
	    model.addColumn("Birthday");
	    model.addColumn("Gender");
	    model.addColumn("Address");
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 51));
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 50, 472, 370);
		frame.getContentPane().add(scrollPane);
		JTable table = new JTable(model);
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		JLabel lblNewLabel = new JLabel("STUDENTS LOG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(204, 204, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(28, 11, 183, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 90, 230, 330);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		DatePicker bday = new DatePicker();
		bday.setBounds(72, 119, 148, 22);
		panel.add(bday);
		
		JLabel lblNewLabel_1_1 = new JLabel("Student ID : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(0, 39, 75, 14);
		panel.add(lblNewLabel_1_1);
		
		sid = new JTextField();
		sid.setBounds(72, 37, 148, 20);
		panel.add(sid);
		sid.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Name : ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(0, 64, 75, 14);
		panel.add(lblNewLabel_1_1_1);
		
		nme = new JTextField();
		nme.setColumns(10);
		nme.setBounds(72, 64, 148, 20);
		panel.add(nme);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Age : ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(0, 91, 75, 20);
		panel.add(lblNewLabel_1_1_1_1);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(72, 92, 148, 20);
		panel.add(age);
		((AbstractDocument)age.getDocument()).setDocumentFilter(new DocumentFilter() {
		      public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
		        fb.insertString(offset, string.replaceAll("[^0-9]", ""), attr);
		      }
		      
		      public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attr) throws BadLocationException {
		        fb.replace(offset, length, string.replaceAll("[^0-9]", ""), attr);
		      }
		    });
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Birthday : ");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1.setBounds(0, 121, 75, 20);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Gender : ");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_1.setBounds(0, 149, 75, 20);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JComboBox gnder = new JComboBox();
		gnder.setModel(new DefaultComboBoxModel(new String[] {"MALE", "FEMALE", "PREFER NOT TO SAY"}));
		gnder.setBounds(72, 150, 148, 22);
		panel.add(gnder);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Address : ");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(0, 177, 75, 20);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		addr = new JTextField();
		addr.setColumns(10);
		addr.setBounds(72, 178, 148, 20);
		panel.add(addr);
        try {
			Statement st = con.createStatement();
			ResultSet set = st.executeQuery("SELECT * FROM Student");
			while(set.next()) {
				String name = set.getString("name");
				String sd = set.getString("student_id");
				String address = set.getString("address");
				String gender = set.getString("gender");
				String bdday = set.getString("birthday");
				String age = set.getString("age");
				model.addRow(new Object[] {sd, name, age, bdday, gender, address});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = nme.getText();
				String sd = sid.getText();
				String address = addr.getText();
				String gender = gnder.getSelectedItem().toString();
				String bdday = bday.getDateStringOrEmptyString();
				String ag = age.getText();
				try {
					String checkKey = "SELECT * FROM Student WHERE student_id = ?";
					PreparedStatement stat = con.prepareStatement(checkKey);
					stat.setString(1, sd);
					ResultSet res = stat.executeQuery();

					if (res.next()) {
					    // key exists
						JOptionPane.showMessageDialog(null, "Student id is already on database!", "ERROR", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String sql = "INSERT INTO Student (student_id, name, address, gender, birthday, age) VALUES (?,?,?,?,?,?)";
				      PreparedStatement statement = con.prepareStatement(sql);
				      statement.setString(2, name);
				      statement.setString(1, sd);
				      statement.setString(3, address);
				      statement.setString(4, gender);
				      statement.setString(5, bdday);
				      statement.setString(6, ag);
				      statement.executeUpdate();
				      con.commit();
				      Statement as = con.createStatement();
				      ResultSet set = as.executeQuery("SELECT * FROM Student");
				      model.setRowCount(0);
						while(set.next()) {
							String names = set.getString("name");
							String sds = set.getString("student_id");
							String addresss = set.getString("address");
							String genders = set.getString("gender");
							String bddays = set.getString("birthday");
							String ages = set.getString("age");
							model.addRow(new Object[] {sds, names, ages, bddays, genders, addresss});
						}
						as.close();
						statement.close();
				}catch(Exception es) {
					es.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(10, 225, 105, 31);
		panel.add(btnNewButton);
		frame.setResizable(false);
		frame.setBounds(100, 100, 748, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
