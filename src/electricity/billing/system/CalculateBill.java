package electricity.billing.system;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.*;

@SuppressWarnings("serial")
public class CalculateBill extends JFrame implements ActionListener {
	JTextField units;
	JLabel meter, name, address;
	JButton submit, cancel;
	Choice meterno, month;

	public CalculateBill() {
		// TODO Auto-generated constructor stub
		super("");
		setSize(700, 500);
		setLocation(400, 200);
		getContentPane().setBackground(Color.WHITE);

		JPanel p = new JPanel();
		p.setBackground(new Color(173, 216, 230));
		add(p);
		p.setLayout(null);

		JLabel heading = new JLabel("Calculate Electricity Bill");
		heading.setBounds(180, 10, 400, 25);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
		p.add(heading);

		JLabel lblmeterno = new JLabel("Meter No");
		lblmeterno.setBounds(120, 50, 100, 20);
		p.add(lblmeterno);

		meterno = new Choice();
		meterno.setBounds(240, 50, 150, 20);
		p.add(meterno);

		try {
			Connect connect = new Connect();
			String queryString = "select * from customer;";

			ResultSet resultSet = connect.statement.executeQuery(queryString);

			while (resultSet.next()) {
				meterno.add(resultSet.getString("meterno"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error in fetching value of meter no:");
			e.printStackTrace();
		}

		JLabel lblname = new JLabel("Name ");
		lblname.setBounds(120, 90, 100, 20);
		p.add(lblname);

		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(120, 130, 100, 20);
		p.add(lbladdress);

		name = new JLabel();
		address = new JLabel();

		name.setBounds(240, 90, 100, 20);
		p.add(name);

		address.setBounds(240, 130, 150, 20);
		p.add(address);

		meterno.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				try {
					Connect connect = new Connect();

					String meternoString = meterno.getSelectedItem();
					String queryString = "select * from customer where meterno = '" + meternoString + "';";

					ResultSet resultSet = connect.statement.executeQuery(queryString);

					while (resultSet.next()) {
						name.setText(resultSet.getString("name"));
						address.setText(resultSet.getString("address"));
					}

				} catch (Exception ee) {
					// TODO: handle exception
					System.out.println("error in getting values of name and address");
					ee.printStackTrace();
				}
			}
		});

		JLabel lblunits = new JLabel("Units Consumed");
		lblunits.setBounds(120, 170, 100, 20);
		p.add(lblunits);

		units = new JTextField();
		units.setBounds(240, 170, 150, 20);
		p.add(units);

		JLabel lblmonth = new JLabel("Month");
		lblmonth.setBounds(120, 210, 100, 20);
		p.add(lblmonth);

		month = new Choice();
		month.add("January");
		month.add("February");
		month.add("March");
		month.add("April");
		month.add("May");
		month.add("June");
		month.add("July");
		month.add("August");
		month.add("September");
		month.add("Octomber");
		month.add("November");
		month.add("December");
		month.setBounds(240, 210, 150, 20);
		p.add(month);

		submit = new JButton("Submit");
		submit.setBounds(100, 330, 100, 25);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		p.add(submit);

		cancel = new JButton("Cancel");
		cancel.setBounds(250, 330, 100, 25);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		p.add(cancel);

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
		if (e.getSource() == submit) {
			String meternoString = meterno.getSelectedItem();
			String unitString = units.getText();
			String monthString = month.getSelectedItem();

			int totalbill = 0;

			String queryString = "select * from tax;";
			try {
				Connect connect = new Connect();
				ResultSet resultSet = connect.statement.executeQuery(queryString);

				while (resultSet.next()) {

					totalbill += (Integer.parseInt(unitString)
							* Integer.parseInt(resultSet.getString("cost_per_unit")));
					totalbill += (Integer.parseInt(resultSet.getString("meter_rent")));
					totalbill += (Integer.parseInt(resultSet.getString("service_charge")));
					totalbill += (Integer.parseInt(resultSet.getString("service_tax")));
					totalbill += (Integer.parseInt(resultSet.getString("swacch_bharat_cess")));
					totalbill += (Integer.parseInt(resultSet.getString("fixed_tax")));
				}

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

			String queryString2 = "insert into bill values('" + meternoString + "' , '" + monthString + "' , '"
					+ unitString + "' , '" + totalbill + "' , '' );";

			try {

				Connect connect = new Connect();
				connect.statement.executeUpdate(queryString2);

				JOptionPane.showMessageDialog(null, "Bill details added successfully!");

				setVisible(false);

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} else if (e.getSource() == cancel) {
			setVisible(false);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalculateBill();

	}

};