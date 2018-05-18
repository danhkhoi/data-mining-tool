import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

import weka.classifiers.Evaluation;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.attribute.Remove;
import javax.swing.JScrollPane;

public class LectureScreen {

	public JFrame frmGiaoDinDnh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LectureScreen window = new LectureScreen();
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
	public LectureScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGiaoDinDnh = new JFrame();
		frmGiaoDinDnh.setTitle("Giao diện dành cho giảng viên");
		frmGiaoDinDnh.setBounds(100, 100, 495, 502);
		frmGiaoDinDnh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGiaoDinDnh.getContentPane().setLayout(null);
		
		JLabel lblMnHc = new JLabel("Môn học");
		lblMnHc.setBounds(33, 24, 61, 16);
		frmGiaoDinDnh.getContentPane().add(lblMnHc);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cấu trúc dữ liệu và giải thuật"}));
		comboBox.setBounds(106, 20, 264, 27);
		frmGiaoDinDnh.getContentPane().add(comboBox);
		
		JTextPane textTree = new JTextPane();
		textTree.setBounds(33, 69, 205, 306);
		frmGiaoDinDnh.getContentPane().add(textTree);
		
		JTextPane txtList = new JTextPane();
		txtList.setBounds(266, 69, 205, 306);
		frmGiaoDinDnh.getContentPane().add(txtList);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBackground(Color.DARK_GRAY);
		list.setBounds(300, 220, 115, -150);
		frmGiaoDinDnh.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("Nhập dữ liệu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(frmGiaoDinDnh);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				    
				    DataSource source;
				    
					try {
						source = new DataSource(selectedFile.getPath());
						 Instances data = source.getDataSet();
						 if (data.classIndex() == -1)
					    	   data.setClassIndex(9);
						 
						 
						 // classifier
						 String[] options = new String[1];
						 options[0] = "-U";            // unpruned tree
						 J48 tree = new J48();         // new instance of tree
						 tree.setOptions(options);     // set the options
						 tree.buildClassifier(data);   // build classifier
						 
						 System.out.println(tree);
						 textTree.setText(tree.toString());
						 Evaluation eval = new Evaluation(data);
						 eval.evaluateModel(tree, data);
						 
						 String evalString = (eval.toSummaryString("\nResults\n======\n", false));
						 
						 String resultText = "";
						 for (int i = 0; i < data.numInstances(); i++) {
							 resultText = resultText + data.instance(i).value(0) + " : " +data.classAttribute().value((int) data.instance(i).classValue())  + "\n";
						   System.out.println("ID: " + data.instance(i).value(0));
						   System.out.println(", actual: " + data.classAttribute().value((int) data.instance(i).classValue()));
						 }
						 
						 resultText = resultText + evalString;
						 txtList.setText(resultText);
					} catch (Exception e1) {
						
						System.out.println("Exception "+ e1);
						e1.printStackTrace();
					}
				   
				    
				    
				}
			}
		});
		btnNewButton.setBounds(6, 430, 117, 29);
		frmGiaoDinDnh.getContentPane().add(btnNewButton);
		
		JButton btnBuildModel = new JButton("Build model");
		btnBuildModel.setBounds(123, 430, 117, 29);
		frmGiaoDinDnh.getContentPane().add(btnBuildModel);
		
		JButton btnSaveModel = new JButton("Save model");
		btnSaveModel.setBounds(239, 430, 117, 29);
		frmGiaoDinDnh.getContentPane().add(btnSaveModel);
		
		JButton btnSendWarning = new JButton("Send warning");
		btnSendWarning.setBounds(362, 430, 117, 29);
		frmGiaoDinDnh.getContentPane().add(btnSendWarning);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(266, 344, 167, -281);
		frmGiaoDinDnh.getContentPane().add(scrollPane);
		
		
	}
}
