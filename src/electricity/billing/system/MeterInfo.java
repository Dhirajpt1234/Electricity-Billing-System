package electricity.billing.system;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MeterInfo extends JFrame implements ActionListener {
	JTextField name, address, city, state, email, phoneno;
	JButton submit;
	JLabel meterno;
	Choice metertype, meterlocation, phasecode, billtype;
	String smeterno;

	public MeterInfo(String smeterno) {
		super("Meter Information");

		this.smeterno = smeterno;
		setSize(700, 500);
		setLocation(400, 200);

		JPanel p = new JPanel();
		p.setBackground(new Color(173, 216, 230));
		add(p);
		p.setLayout(null);

		JLabel heading = new JLabel("Meter Information");
		heading.setBounds(180, 10, 200, 25);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
		p.add(heading);

		JLabel lblmeterno = new JLabel("Meter Number");
		lblmeterno.setBounds(120, 50, 100, 20);
		p.add(lblmeterno);

		meterno = new JLabel(smeterno);
		meterno.setBounds(240, 50, 100, 20);
		p.add(meterno);

		JLabel lblmeterlocation = new JLabel("Meter Location");
		lblmeterlocation.setBounds(120, 90, 100, 20);
		p.add(lblmeterlocation);

		meterlocation = new Choice();
		meterlocation.setBounds(240, 90, 150, 20);
		meterlocation.add("Outside");
		meterlocation.add("Inside");
		p.add(meterlocation);

		JLabel lblmetertype = new JLabel("Meter Type");
		lblmetertype.setBounds(120, 130, 100, 20);
		p.add(lblmetertype);

		metertype = new Choice();
		metertype.setBounds(240, 130, 150, 20);
		metertype.add("Electric Meter");
		metertype.add("Solar Meter");
		metertype.add("Smart Meter");
		p.add(metertype);

		JLabel lblphasecode = new JLabel("Phase Code");
		lblphasecode.setBounds(120, 170, 100, 20);
		p.add(lblphasecode);

		phasecode = new Choice();
		phasecode.setBounds(240, 170, 150, 20);
		phasecode.add("011");
		phasecode.add("022");
		phasecode.add("033");
		phasecode.add("044");
		phasecode.add("055");
		phasecode.add("066");
		phasecode.add("077");
		phasecode.add("088");
		phasecode.add("099");
		p.add(phasecode);

		JLabel lblbilltype = new JLabel("Bill Type");
		lblbilltype.setBounds(120, 210, 100, 20);
		p.add(lblbilltype);

		billtype = new Choice();
		billtype.setBounds(240, 210, 150, 20);
		billtype.add("Normal");
		billtype.add("Industrial");
		p.add(billtype);

		JLabel lblDays = new JLabel("Days");
		lblDays.setBounds(120, 250, 100, 20);
		p.add(lblDays);

		JLabel Days = new JLabel("30 Days");
		Days.setBounds(240, 250, 150, 20);
		p.add(Days);

		JLabel lblnote = new JLabel("Note");
		lblnote.setBounds(120, 290, 100, 20);
		p.add(lblnote);

		JLabel note = new JLabel("By defalut bill will be calculated for 30 Days");
		note.setBounds(240, 290, 300, 20);
		p.add(note);

		submit = new JButton("Submit");
		submit.setBounds(150, 330, 100, 25);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		p.add(submit);

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
			String meternoString = smeterno;
			String meterlocationString = meterlocation.getSelectedItem();
			String metertypeString = metertype.getSelectedItem();
			String phasecodeString = phasecode.getSelectedItem();
			String billtypeString = billtype.getSelectedItem();
			String dayString = "30";

			try {

				Connect connect = new Connect();

				String query = "insert into meter_info values ( '" + meternoString + "' , '" + meterlocationString
						+ "' , '" + metertypeString + "' , '" + phasecodeString + "' , '" + billtypeString + "' , '"
						+ dayString + "');";

				connect.statement.executeUpdate(query);

				JOptionPane.showMessageDialog(null, "Meter information updated Successfully!");
				setVisible(false);

				new NewCustomer();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MeterInfo("");

	}

}
