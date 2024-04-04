import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import admin.AdminLoginScreen;
import user.RegisterScreen;

import javax.swing.JButton;

public class LoginScreen extends JFrame {

	private JFrame frame;
	private JTextField idField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
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
	public LoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:/Users/BIT/git/KollyTalkv5/kollytalkv5/images/background2.jpg").getImage());
		frame.setSize(welcomePanel.getWidth(),welcomePanel.getHeight());
		frame.getContentPane().add(welcomePanel, BorderLayout.WEST);
		welcomePanel.setLayout(null);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setForeground(new Color(255, 255, 255));
		idLabel.setFont(new Font("Cafe24 Ssurround Bold", Font.PLAIN, 22));
		idLabel.setBounds(83, 338, 69, 36);
		welcomePanel.add(idLabel);
		
		JLabel  passwordLabel = new JLabel("비밀번호");
		 passwordLabel.setForeground(new Color(255, 255, 255));
		 passwordLabel.setFont(new Font("Cafe24 Ssurround Bold", Font.PLAIN, 22));
		 passwordLabel.setBounds(75, 378, 90, 36);
		welcomePanel.add( passwordLabel);
		
		idField = new JTextField();
		idField.setBounds(177, 338, 200, 30);
		welcomePanel.add(idField);
		idField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(177, 378, 200, 30);
		welcomePanel.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel mainLogo = new JLabel(new ImageIcon("C:/Users/BIT/git/KollyTalkv5/kollytalkv5/images/collytalk_logo.jpg"));
		mainLogo.setBounds(12, 40, 476, 166);
		welcomePanel.add(mainLogo);
		
		JButton signinBtn = new JButton(new ImageIcon("C:/Users/BIT/git/KollyTalkv5/kollytalkv5/images/signin64.png"));
		signinBtn.setBackground(new Color(34, 77, 96));
		signinBtn.setBounds(117, 522, 111, 97);
		welcomePanel.add(signinBtn);
		frame.setLocationRelativeTo(welcomePanel);
		
		JButton adminBtn = new JButton(new ImageIcon("C:/Users/BIT/git/KollyTalkv5/kollytalkv5/images/admin64.png"));
		adminBtn.setBackground(new Color(34, 77, 96));
		adminBtn.setBounds(261, 525, 98, 94);
		welcomePanel.add(adminBtn);
		
		JButton loginBtn = new JButton("");
		loginBtn.setIcon(new ImageIcon("C:\\Users\\BIT\\OneDrive\\바탕 화면\\프로젝트\\회원가입\\login_un.jpg"));
		loginBtn.setPressedIcon(new ImageIcon("C:\\Users\\BIT\\OneDrive\\바탕 화면\\프로젝트\\회원가입\\login_click.jpg"));
		loginBtn.setBounds(100, 424, 265, 57);
		welcomePanel.add(loginBtn);
		
		JLabel siginInLabel = new JLabel("회원가입");
		siginInLabel.setFont(new Font("Cafe24 Ssurround Bold", Font.PLAIN, 20));
		siginInLabel.setBounds(135, 619, 90, 36);
		welcomePanel.add(siginInLabel);
		
		JLabel adminLabel = new JLabel("관리자로그인");
		adminLabel.setFont(new Font("Cafe24 Ssurround Bold", Font.PLAIN, 20));
		adminLabel.setBounds(250, 619, 129, 36);
		welcomePanel.add(adminLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 로그인 버튼 리스너
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 아이디와 비밀번호 입력 받기
				String username = idField.getText();
				String password = new String(passwordField.getPassword());

				// 여기에 로그인 처리 코드를 작성하세요
				try {
					// JDBC 연결
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collytalk", "root",
							"qwe123!@#");
					Statement stmt = conn.createStatement();

					// 입력된 아이디와 비밀번호를 이용하여 데이터베이스에서 정보를 조회
					String query = "SELECT * FROM user WHERE user_id='" + username + "' AND user_pw='" + password + "'";
					ResultSet rs = stmt.executeQuery(query);

					if (rs.next()) {
						// 로그인 성공
						dispose(); // 현재 창 닫기
						new UserMenuScreen(username); // 사용자 메뉴 화면 열기 (사용자 ID 전달)
					} else {
						// 로그인 실패
						JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 일치하지 않습니다.");
					}

					// 자원 해제
					rs.close();
					stmt.close();
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "데이터베이스 오류: " + ex.getMessage());
				}
			}
		});

		// 회원가입 버튼 리스너
		signinBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 회원가입 버튼 눌렀을 때의 동작
				dispose(); // 현재 창 닫기
				new RegisterScreen(); // 회원가입 화면 열기
			}
		});

		// 관리자 로그인 버튼 리스너
		adminBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 관리자 로그인 버튼 눌렀을 때의 동작
				new AdminLoginScreen();
				// 여기에 관리자 로그인 처리 코드를 작성하세요
			}
		});
		
	}
}
class ImagePanel extends JPanel {
	private Image img;

	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);

	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
	
	public int getWidth() {
		return img.getWidth(null);
	}
	public int getHeight() {
		return img.getHeight(null);
	}
}
