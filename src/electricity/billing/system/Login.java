package electricity.billing.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {
	JButton login, cancel, signup;
	JTextField username, password;
	Choice signninas;

	Login() {
		super("Login Page");
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(300, 20, 100, 20);
		add(lblusername);

		username = new JTextField();
		username.setBounds(400, 20, 100, 20);
		add(username);

		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(300, 60, 100, 20);
		add(lblpassword);

		password = new JTextField();
		password.setBounds(400, 60, 100, 20);
		add(password);

		JLabel lblsignninas = new JLabel("Signnin as ");
		lblsignninas.setBounds(300, 100, 100, 20);
		add(lblsignninas);

		signninas = new Choice();
		signninas.add("Admin");
		signninas.add("Customer");
		signninas.setBounds(400, 100, 100, 20);
		add(signninas);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
		Image i2 = i1.getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT);
		login = new JButton("Login", new ImageIcon(i2));
		login.setBounds(300, 140, 100, 20);
		login.addActionListener(this);
		add(login);

		ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
		Image i4 = i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		cancel = new JButton("Cancel", new ImageIcon(i4));
		cancel.setBounds(450, 140, 100, 20);
		cancel.addActionListener(this);
		add(cancel);

		ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
		Image i6 = i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		signup = new JButton("Signup", new ImageIcon(i6));
		signup.setBounds(375, 180, 100, 20);
		signup.addActionListener(this);
		add(signup);

		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
		Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
		JLabel image = new JLabel(i9);
		image.setBounds(0, 0, 250, 250);
		add(image);

		setSize(640, 300);
		setLocation(400, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getSource() == login) {

			String susername = username.getText();
			String spassword = password.getText();
			String suser = signninas.getSelectedItem();

			try {
				Connect connect = new Connect();
				String queryString = "select * from login where username = '" + susername + "' and password = " + "'"
						+ spassword + "' and user = '" + suser + "' ; ";

				ResultSet resultSet = connect.statement.executeQuery(queryString);

				if (resultSet.next()) {
					setVisible(false);
					new Project(suser);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Login Credentials");
					username.setText("");
					password.setText("");

				}

			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Invalid Login Credentials");
				e.printStackTrace();
			}

		} else if (ae.getSource() == signup) {
			setVisible(false);
			new Signup();
		} else if (ae.getSource() == cancel) {
			setVisible(false);
		}
	}

}
