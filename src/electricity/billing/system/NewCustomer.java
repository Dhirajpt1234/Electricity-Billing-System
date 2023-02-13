package electricity.billing.system;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")
public class NewCustomer extends JFrame implements ActionListener {
	JTextField name, address, city, state, email, phoneno;
	JLabel meter;
	JButton next, back;

	public NewCustomer() {
		// TODO Auto-generated constructor stub
		super("New Customer");
		setSize(700, 500);
		setLocation(400, 200);

		JPanel p = new JPanel();
		p.setBackground(new Color(173, 216, 230));
		add(p);
		p.setLayout(null);

		JLabel heading = new JLabel("New Customer");
		heading.setBounds(180, 10, 200, 25);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
		p.add(heading);

		JLabel lblname = new JLabel("Customer Name ");
		lblname.setBounds(120, 50, 100, 20);
		p.add(lblname);

		name = new JTextField();
		name.setBounds(240, 50, 150, 20);
		p.add(name);

		JLabel lblmeter = new JLabel("Meter Number :");
		lblmeter.setBounds(120, 90, 100, 20);
		p.add(lblmeter);

		meter = new JLabel("");
		meter.setBounds(240, 90, 100, 20);
		p.add(meter);

		Random random = new Random();
		long no = random.nextLong() % 100000;
		meter.setText("" + Math.abs(no));

		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(120, 130, 100, 20);
		p.add(lbladdress);

		address = new JTextField();
		address.setBounds(240, 130, 150, 20);
		p.add(address);

		JLabel lblcity = new JLabel("City");
		lblcity.setBounds(120, 170, 100, 20);
		p.add(lblcity);

		city = new JTextField();
		city.setBounds(240, 170, 150, 20);
		p.add(city);

		JLabel lblstate = new JLabel("State");
		lblstate.setBounds(120, 210, 100, 20);
		p.add(lblstate);

		state = new JTextField();
		state.setBounds(240, 210, 150, 20);
		p.add(state);

		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(120, 250, 100, 20);
		p.add(lblemail);

		email = new JTextField();
		email.setBounds(240, 250, 150, 20);
		p.add(email);

		JLabel lblphoneno = new JLabel("Phone Number ");
		lblphoneno.setBounds(120, 290, 100, 20);
		p.add(lblphoneno);

		phoneno = new JTextField();
		phoneno.setBounds(240, 290, 150, 20);
		p.add(phoneno);

		next = new JButton("Next");
		next.setBounds(100, 330, 100, 25);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		p.add(next);

		back = new JButton("Back");
		back.setBounds(250, 330, 100, 25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		p.add(back);

		setLayout(new BorderLayout());
		add(p, "Center");

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);

		add(image, "West");

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == next) {
			String nameString = name.getText();
			String meterString = meter.getText();
			String addressString = address.getText();
			String cityString = city.getText();
			String stateString = state.getText();
			String emailString = email.getText();
			String phoneString = phoneno.getText();

			if (nameString.length() == 0 || addressString.length() == 0 || cityString.length() == 0
					|| stateString.length() == 0 || emailString.length() == 0 || phoneString.length() == 0) {
				JOptionPane.showMessageDialog(null, "All fields are Compulsory!");
			} else {

				try {

					Connect connect = new Connect();

					String query1 = "insert into customer values ('" + nameString + "' , '" + meterString + "' , '"
							+ addressString + "' , '" + cityString + "' , '" + stateString + "' , '" + emailString
							+ "' , '" + phoneString + "');";

					String query2 = "insert into login values('" + meterString + "' , '' , '" + nameString
							+ "' , '' , '');";
					
					System.out.println(query1);
					System.out.println(query2);

					connect.statement.executeUpdate(query1);
					connect.statement.executeUpdate(query2);

					JOptionPane.showMessageDialog(null, "Account Created Successfully!");
					setVisible(false);

					// next frame
					new MeterInfo(meterString);

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} else if (e.getSource() == back) {
			setVisible(false);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NewCustomer();

	}

};