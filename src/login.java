import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login {

	private JFrame frmHThngH;
	private JTextField tFUserName;
	private static login window;
	private JPasswordField tFPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new login();
					window.frmHThngH.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHThngH = new JFrame();
		frmHThngH.setTitle("Hệ thống hỗ trợ ra quyết định");
		frmHThngH.setBounds(100, 100, 450, 382);
		frmHThngH.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHThngH.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hệ thống hỗ trợ ra quyết định");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(57, 73, 322, 16);
		frmHThngH.getContentPane().add(lblNewLabel);
		
		tFUserName = new JTextField();
		tFUserName.setBounds(191, 125, 130, 26);
		frmHThngH.getContentPane().add(tFUserName);
		tFUserName.setColumns(10);
		
		JLabel lblTnngNhp = new JLabel("Tên đăng nhập");
		lblTnngNhp.setBounds(42, 130, 106, 16);
		frmHThngH.getContentPane().add(lblTnngNhp);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setBounds(42, 189, 61, 16);
		frmHThngH.getContentPane().add(lblMtKhu);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = tFUserName.getText();
				if(userName.equals("admin")) {
					LectureScreen screen = new LectureScreen();
					screen.frmGiaoDinDnh.setVisible(true);
				} else 
				{
					StudentScreen screen = new StudentScreen();
					screen.frmGiaoDinDnh.setVisible(true);
				}
				
				window.frmHThngH.setVisible(false);
			}
		});
		btnLogin.setBounds(129, 255, 117, 29);
		frmHThngH.getContentPane().add(btnLogin);
		
		tFPassword = new JPasswordField();
		tFPassword.setBounds(191, 184, 130, 26);
		frmHThngH.getContentPane().add(tFPassword);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(117, 28, 61, 16);
		frmHThngH.getContentPane().add(lblNewLabel_1);
	}
}

