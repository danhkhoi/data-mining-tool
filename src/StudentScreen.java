import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JTextPane;

public class StudentScreen {

	public JFrame frmGiaoDinDnh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentScreen window = new StudentScreen();
					window.frmGiaoDinDnh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGiaoDinDnh = new JFrame();
		frmGiaoDinDnh.setTitle("Giao diện dành cho sinh viên");
		frmGiaoDinDnh.setBounds(100, 100, 450, 300);
		frmGiaoDinDnh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGiaoDinDnh.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Môn học");
		label.setBounds(26, 24, 61, 16);
		frmGiaoDinDnh.getContentPane().add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cấu trúc dữ liệu và giải thuật"}));
		comboBox.setBounds(99, 20, 264, 27);
		frmGiaoDinDnh.getContentPane().add(comboBox);
		
		JLabel lblKtQu = new JLabel("Kết quả");
		lblKtQu.setBounds(57, 77, 61, 16);
		frmGiaoDinDnh.getContentPane().add(lblKtQu);
		
		JLabel lblPassed = new JLabel("PASSED");
		lblPassed.setForeground(Color.RED);
		lblPassed.setBounds(152, 77, 61, 16);
		frmGiaoDinDnh.getContentPane().add(lblPassed);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(57, 109, 203, 139);
		frmGiaoDinDnh.getContentPane().add(textPane);
	}
}
