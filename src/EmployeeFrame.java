//import java.awt.BorderLayout;
//import java.awt.Dimension;
//import java.awt.EventQueue;
//import java.awt.Window;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import java.awt.Color;
//import java.awt.GridLayout;
//
//import javax.swing.JLabel;
//
//import java.awt.GridBagLayout;
//import java.awt.GridBagConstraints;
//
//import javax.swing.BoxLayout;
//
//import java.awt.Component;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.Box;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//
//
//public class EmployeeFrame extends JFrame {
//
//	private JPanel contentPane;
//	private String PIN;
//	private String EmployeeName;
//	private JTextField textPIN;
//	private JTextField textName;
//}
//
////	/**
////	 * Launch the application.
////	 */
////	public static void main(String[] args) {
////		EventQueue.invokeLater(new Runnable() {
////			public void run() {
////				try {
////					EmployeeFrame frame = new EmployeeFrame(null, "","");
////					frame.setVisible(true);
////				} catch (Exception e) {
////					e.printStackTrace();
////				}
////			}
////		});
////	}
//
////	public EmployeeFrame(EmployeeList employees, String pin, String name) {
////		this.PIN = pin;
////		this.EmployeeName = name;
////		
////		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		setBounds(100, 100, 450, 300);
////		contentPane = new JPanel();
////		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
////		this.setTitle("Domino's Pizza Point of Sales");
////		this.setPreferredSize(new Dimension(450, 300));  
//////	this.setMinimumSize(this.getPreferredSize());
//////	this.setMaximumSize(this.getPreferredSize());
////		setResizable(false);
////		this.setAlwaysOnTop(true);
////		this.pack();  
////		this.setLocationRelativeTo(null); 
////		setContentPane(contentPane);
////		contentPane.setLayout(new BorderLayout(0, 0));
////		
////		JPanel confirmPanel = new JPanel();
////		confirmPanel.setPreferredSize(new Dimension(0, 60));
////		contentPane.add(confirmPanel, BorderLayout.SOUTH);
////		confirmPanel.setLayout(new BoxLayout(confirmPanel, BoxLayout.X_AXIS));
////		
////		Component horizontalGlue = Box.createHorizontalGlue();
////		confirmPanel.add(horizontalGlue);
////		
////		final JButton btnOk = new JButton("Ok");
////		btnOk.setPreferredSize(new Dimension(75, 30));
////		confirmPanel.add(btnOk);
////		
////		Component rigidArea_2 = Box.createRigidArea(new Dimension(15, 0));
////		confirmPanel.add(rigidArea_2);
////		
////		final JButton btnCancel = new JButton("Cancel");
////		btnCancel.setPreferredSize(new Dimension(75, 30));
////		confirmPanel.add(btnCancel);
////		
////		Component rigidArea_3 = Box.createRigidArea(new Dimension(25, 0));
////		confirmPanel.add(rigidArea_3);
////		
////		JPanel formPanel = new JPanel();
////		contentPane.add(formPanel, BorderLayout.CENTER);
////		formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
////		
////		Component rigidArea = Box.createRigidArea(new Dimension(0, 30));
////		formPanel.add(rigidArea);
////		
////		JLabel labelPIN = new JLabel("PIN");
////		labelPIN.setAlignmentX(Component.CENTER_ALIGNMENT);
////		labelPIN.setMaximumSize(new Dimension(216, 20));
////		formPanel.add(labelPIN);
////		
////		textPIN = new JTextField();
////		textPIN.setText(PIN);
////		textPIN.setMaximumSize(new Dimension(220, 20));
////		formPanel.add(textPIN);
////		textPIN.setColumns(10);
////		
////		Component rigidArea_1 = Box.createRigidArea(new Dimension(0, 25));
////		formPanel.add(rigidArea_1);
////		
////		JLabel lblName = new JLabel("Employee Name");
////		lblName.setMaximumSize(new Dimension(216, 20));
////		lblName.setAlignmentX(Component.CENTER_ALIGNMENT);
////		formPanel.add(lblName);
////		
////		textName = new JTextField();
////		textName.setText(EmployeeName);
////		textName.setMaximumSize(new Dimension(220, 20));
////		formPanel.add(textName);
////		textName.setColumns(10);
////		
////		btnOk.addActionListener(new ActionListener() {
////			@Override
////			public void actionPerformed(ActionEvent e) {
////				// TODO
////			}
////		});
////		
////		btnCancel.addActionListener(new ActionListener() {
////			@Override
////			public void actionPerformed(ActionEvent e) {
////				((JFrame) btnCancel.getTopLevelAncestor()).dispose();
////			}
////		});
////	}
////}
