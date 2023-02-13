package electricity.billing.system;


import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class Signup extends JFrame implements ActionListener {
	JButton create, back;
	Choice accounttype;
	JTextField meternumber, username, name, password;

	Signup() {
		super("Sign-Up Page");
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(20, 20, 645, 325);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(135, 206, 235), 2), "Create Account",
				TitledBorder.LEADING, TitledBorder.TOP, null));

		panel.setLayout(null);

		//components
		JLabel lblaccounttype = new JLabel("Create Account As");
		lblaccounttype.setBounds(90, 40, 150, 20);
		lblaccounttype.setForeground(Color.GRAY);
		lblaccounttype.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblaccounttype);

		accounttype = new Choice();
		accounttype.add("Admin");
		accounttype.add("Customer");
		accounttype.setBounds(270, 40, 100, 20);
		panel.add(accounttype);

		JLabel lblmeternumber = new JLabel("Meter Number");
		lblmeternumber.setBounds(90, 80, 150, 20);
		lblmeternumber.setForeground(Color.GRAY);
		lblmeternumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblmeternumber);

		meternumber = new JTextField();
		meternumber.setBounds(270, 80, 100, 20);
		panel.add(meternumber);

		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(90, 120, 150, 20);
		lblusername.setForeground(Color.GRAY);
		lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblusername);

		username = new JTextField();
		username.setBounds(270, 120, 100, 20);
		panel.add(username);

		JLabel lblname = new JLabel("Name");
		lblname.setBounds(90, 160, 150, 20);
		lblname.setForeground(Color.GRAY);
		lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblname);

		name = new JTextField();
		name.setBounds(270, 160, 100, 20);
		panel.add(name);

		meternumber.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				try {
					Connect connect = new Connect();
					String queryString = "select * from login where meter_no = '" + meternumber.getText() + "';";
					System.out.println(queryString);
					ResultSet rs = connect.statement.executeQuery(queryString);
//					System.out.println(rs.getString("name"));
					while (rs.next()) {
						name.setText(rs.getString("name"));
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});

		JLabel lblpassword = new JLabel("Password ");
		lblpassword.setBounds(90, 200, 150, 20);
		lblpassword.setForeground(Color.GRAY);
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblpassword);

		password = new JTextField();
		password.setBounds(270, 200, 100, 20);
		panel.add(password);

		accounttype.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (accounttype.getSelectedItem().equals("Admin")) {
					meternumber.setVisible(false);
					lblmeternumber.setVisible(false);
					name.setEditable(true);
				} else {
					meternumber.setVisible(true);
					lblmeternumber.setVisible(true);
					name.setEditable(false);
				}
			}
		});

		create = new JButton("Create");
		create.setBounds(120, 240, 100, 24);
		create.setBackground(Color.BLACK);
		create.setForeground(Color.WHITE);
		create.setFont(new Font("Tahoma", Font.BOLD, 14));
		create.addActionListener(this);
		panel.add(create);

		back = new JButton("Back");
		back.setBounds(250, 240, 100, 24);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Tahoma", Font.BOLD, 14));
		back.addActionListener(this);
		panel.add(back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
		Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		JLabel lblimage = new JLabel(new ImageIcon(i2));
		lblimage.setBounds(400, 40, 200, 250);
		panel.add(lblimage);

		add(panel);
		setLocation(450, 150);
		setSize(700, 400);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == create) {
			String satype = accounttype.getSelectedItem();
			String smeter = meternumber.getText();
			String susername = username.getText();
			String sname = name.getText();
			String spassword = password.getText();

			try {

				Connect connect = new Connect();
				String query = null;
				
				if (satype.equals("Admin")) {
					query = "insert into login values('" + smeter + "','" + susername + "' , '" + sname + "','"
							+ spassword + "' , '" + satype + "');";
				} else {
					query = "update login set username = '" + susername + "' , password = '" + spassword
							+ "' , user = '" + satype + "' where meter_no = '" + smeter + "';";
				}

				connect.statement.executeUpdate(query);
				System.out.println("Account created !");

				JOptionPane.showMessageDialog(null, "Account Created Successfully!");
				setVisible(false);
				new Login();

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		} else if (ae.getSource() == back) {

			setVisible(false);
			new Login();

		}

	}

	public static void main(String[] args) {
		JFrame s = new Signup();
	}

}
