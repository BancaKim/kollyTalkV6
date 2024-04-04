import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import user.EditProfileScreen;

public class UserMenuScreen extends JFrame {
	private String userId;
	private JFrame frame;

	/**
	 * Create the application.
	 */
	public UserMenuScreen(String userId) {
		this.userId = userId;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 700);
		frame.setTitle("KollyTalk");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 77, 96));
		panel.setBounds(0, 0, 484, 661);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel mainLogo = new JLabel(new ImageIcon("C:\\images\\kollytalk_logo.jpg"));
		mainLogo.setBounds(0, 20, 472, 159);
		panel.add(mainLogo);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(34, 77, 96));
		panel_1.setBounds(0, 466, 484, 95);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JButton infoBtn = new JButton("");
		infoBtn.setIcon(new ImageIcon("C:\\images\\infochange_un.jpg"));
		infoBtn.setPressedIcon(new ImageIcon("C:\\images\\infochange_click.jpg"));
		infoBtn.setBounds(259, 10, 213, 69);
		infoBtn.setBorderPainted(false);
		infoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 내 정보 변경 버튼 눌렀을 때의 동작
				new EditProfileScreen(userId);

				// 여기에 내 정보 변경 화면으로 이동하는 코드를 작성하세요
			}
		});
		panel_1.add(infoBtn);

		JButton chatBtn = new JButton("");
		chatBtn.setIcon(new ImageIcon("C:\\images\\chatenter_un.jpg"));
		chatBtn.setPressedIcon(new ImageIcon("C:\\images\\chatenter_cilck.jpg"));
		chatBtn.setBackground(new Color(34, 77, 96));
		chatBtn.setBorderPainted(false);
		chatBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 채팅방 입장 버튼 눌렀을 때의 동작
				ChatClient chatClient = new ChatClient(userId);
				chatClient.setVisible(true); // ChatClient 객체 표시
			}
		});
		chatBtn.setBounds(12, 10, 213, 69);
		panel_1.add(chatBtn);
		frame.setVisible(true);
	}
}
