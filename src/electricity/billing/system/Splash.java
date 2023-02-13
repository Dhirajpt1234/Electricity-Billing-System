package electricity.billing.system;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Splash extends JFrame {

	Splash() {
		super("WELCOME");
		getContentPane().setBackground(Color.BLACK);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
		Image i2 = i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);

		setVisible(true);

		int x = 1;
		for (int i = 2; i < 600; i += 4, x += 1) {
			setSize(i + x, i);
			setLocation(700 - ((i + x) / 2), 400 - (i / 2));
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			Thread.sleep(7000);

		} catch (Exception e) {
			e.printStackTrace();
		}

		setVisible(false);
		// login page
		new Login();
	}

	public static void main(String[] args) {
		new Splash();

	}

}
