package admin;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;

public class AdminMenuScreen2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenuScreen2 window = new AdminMenuScreen2();
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
	public AdminMenuScreen2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		frame = new JFrame();
		frame.setTitle("KollyTalk");
		frame.setBounds(100, 100, 500, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 77, 96));
		panel.setBounds(0, 0, 484, 661);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel mainLogo = new JLabel(
				new ImageIcon("C:\\images\\kollytalk_logo.jpg"));
		mainLogo.setBounds(0, 10, 476, 165);
		panel.add(mainLogo);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(135, 244, 173, 69);
		panel.add(btnNewButton);
		
	}

}
