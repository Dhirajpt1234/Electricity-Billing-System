package electricity.billing.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
class Project extends JFrame implements ActionListener {
	String usertype;

	Project(String usertype) {

		super("Home page");
		this.usertype = usertype;

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1530, 1000, Image.SCALE_DEFAULT);
		JLabel image = new JLabel(new ImageIcon(i2));
		add(image);

		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);

		JMenu master = new JMenu("Master");

		JMenuItem newcoustumer = new JMenuItem("New Costumer");
		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
		Image image1 = icon1.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		newcoustumer.setFont(new Font("monospaced", Font.PLAIN, 12));
		newcoustumer.setIcon(new ImageIcon(image1));
		newcoustumer.setMnemonic('N');
		newcoustumer.addActionListener(this);
		newcoustumer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		master.add(newcoustumer);

		JMenuItem costumerdetails = new JMenuItem("Customer Details");
		ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
		Image image2 = icon2.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		costumerdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
		costumerdetails.setIcon(new ImageIcon(image2));
		costumerdetails.setMnemonic('C');
		costumerdetails.addActionListener(this);
		costumerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		master.add(costumerdetails);

		JMenuItem depositdetails = new JMenuItem("Deposit Details");
		ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
		Image image3 = icon3.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		depositdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
		depositdetails.setIcon(new ImageIcon(image3));
		depositdetails.setMnemonic('D');
		depositdetails.addActionListener(this);
		depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		master.add(depositdetails);

		JMenuItem calculatebill = new JMenuItem("Calculate Bill");
		ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
		Image image4 = icon4.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		calculatebill.setFont(new Font("monospaced", Font.PLAIN, 12));
		calculatebill.setIcon(new ImageIcon(image4));
		calculatebill.setMnemonic('B');
		calculatebill.addActionListener(this);
		calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		master.add(calculatebill);

		JMenu info = new JMenu("Information");

		JMenuItem updateinformation = new JMenuItem("Update Information");
		ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
		Image image5 = icon5.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		updateinformation.setIcon(new ImageIcon(image5));
		updateinformation.setFont(new Font("monospaced", Font.PLAIN, 12));
		updateinformation.setMnemonic('U');
		updateinformation.addActionListener(this);
		updateinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		info.add(updateinformation);

		JMenuItem viweinformation = new JMenuItem("View Information");
		ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
		Image image6 = icon6.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		viweinformation.setIcon(new ImageIcon(image6));
		viweinformation.setFont(new Font("monospaced", Font.PLAIN, 12));
		viweinformation.setMnemonic('V');
		viweinformation.addActionListener(this);
		viweinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		info.add(viweinformation);

		JMenu user = new JMenu("User");

		JMenuItem paybill = new JMenuItem("Paybills");
		ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
		Image image7 = icon7.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		paybill.setIcon(new ImageIcon(image7));
		paybill.setFont(new Font("monospaced", Font.PLAIN, 12));
		paybill.setMnemonic('P');
		paybill.addActionListener(this);
		paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		user.add(paybill);

		JMenuItem billdetails = new JMenuItem("Bill Details");
		ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
		Image image8 = icon8.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		billdetails.setIcon(new ImageIcon(image8));
		billdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
		billdetails.setMnemonic('D');
		billdetails.addActionListener(this);
		billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		user.add(billdetails);

		JMenu report = new JMenu("Report");

		JMenuItem generatebill = new JMenuItem("Generate Bill");
		ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
		Image image9 = icon9.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		generatebill.setIcon(new ImageIcon(image9));
		generatebill.setFont(new Font("monospaced", Font.PLAIN, 12));
		generatebill.setMnemonic('G');
		generatebill.addActionListener(this);
		generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		report.add(generatebill);

		JMenu utility = new JMenu("Utilities");

		JMenuItem notepad = new JMenuItem("Notepad");
		ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
		Image image10 = icon10.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		notepad.setIcon(new ImageIcon(image10));
		notepad.setFont(new Font("monospaced", Font.PLAIN, 12));
		notepad.setMnemonic('R');
		notepad.addActionListener(this);
		notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		utility.add(notepad);

		JMenuItem calci = new JMenuItem("Calculator");
		ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
		Image image11 = icon11.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		calci.setIcon(new ImageIcon(image11));
		calci.setFont(new Font("monospaced", Font.PLAIN, 12));
		calci.setMnemonic('H');
		calci.addActionListener(this);
		calci.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		utility.add(calci);

		JMenu exit = new JMenu("Exit");

		JMenuItem exitItem = new JMenuItem("Exit");
		ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
		Image image12 = icon12.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		exitItem.setIcon(new ImageIcon(image12));
		exitItem.setFont(new Font("monospaced", Font.PLAIN, 12));
		exitItem.setMnemonic('W');
		exitItem.addActionListener(this);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		exit.add(exitItem);

		if (usertype.equals("Admin")) {
			mb.add(master);
		} else {

			mb.add(info);
			mb.add(user);
			mb.add(report);
		}

		mb.add(utility);
		mb.add(exit);

		setLayout(new FlowLayout());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String sourceString = e.getActionCommand();

		if (sourceString.equals("New Costumer")) {
//			setVisible(false);
			new NewCustomer();
		} else if (sourceString.equals("Customer Details")) {
			new CustomerDetails();
		} else if (sourceString.equals("Deposit Details")) {
			new DepositDetails();
		} else if (sourceString.equals("Calculate Bill")) {
			new CalculateBill();
		}
	}

	public static void main(String[] args) {
		new Project("");
	}

}
