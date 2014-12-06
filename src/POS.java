import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.Font;
import java.io.IOException;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;

import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.CardLayout;


public class POS {

	private JFrame frmDominosPizzaPoint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POS window = new POS();
					window.frmDominosPizzaPoint.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public POS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		final String LOGINCARD = "Login";
		final String SYSTEMCARD = "System";
		Color Pink = new Color(251, 200, 202);
		Color Blue = new Color(0, 78, 150);
		Image image = null;
		try {
			image = ImageIO.read(getClass().getResource("/Domino'sIcon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(image);
		Font hel28 = new Font("Helvetica", Font.PLAIN, 28);
		Font helB24 = new Font("Helvetica", Font.BOLD, 24);
		Font helB18 = new Font("Helvetica", Font.BOLD, 18);
		Dimension dimHeadFoot = new Dimension(0, 80);
		Dimension dimMargin = new Dimension(8, 0);
		Dimension dimBalance = new Dimension(68, 0);
		Dimension dimPIN = new Dimension(200, 45);
		Dimension dimLogin = new Dimension(150, 50);
		Dimension dimNav = new Dimension(186, 40);
		Dimension dimLogoutPad = new Dimension(15, 0);
		Dimension dimReceipt = new Dimension(391, 0);
		Dimension dimOrder = new Dimension(154, 50);
		Dimension dimItem = new Dimension(530, 100);
		
		frmDominosPizzaPoint = new JFrame();
		frmDominosPizzaPoint.setBackground(Pink);
		frmDominosPizzaPoint.setTitle("Domino's Pizza Point of Sales");
		frmDominosPizzaPoint.setIconImage(image);
		frmDominosPizzaPoint.setPreferredSize(new Dimension(1024, 768));  
		frmDominosPizzaPoint.setMinimumSize(frmDominosPizzaPoint.getPreferredSize());  
		frmDominosPizzaPoint.pack();  
		frmDominosPizzaPoint.setLocationRelativeTo(null); 
		frmDominosPizzaPoint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardLayout metaHand = new CardLayout();
		frmDominosPizzaPoint.getContentPane().setLayout(metaHand);
		
		JPanel loginCard = new JPanel();
		loginCard.setBackground(Pink);
		frmDominosPizzaPoint.getContentPane().add(loginCard, LOGINCARD);
		BorderLayout divLayout = new BorderLayout(0, 0);
		loginCard.setLayout(divLayout);
		
		JPanel headerLogin = new JPanel();
		headerLogin.setBackground(Blue);
		headerLogin.setPreferredSize(dimHeadFoot);
		loginCard.add(headerLogin, BorderLayout.NORTH);
		headerLogin.setLayout(new BoxLayout(headerLogin, BoxLayout.X_AXIS));
		
		headerLogin.add(Box.createRigidArea(dimMargin));
		
		JLabel lblDominosIcon = new JLabel();
		lblDominosIcon.setToolTipText("Domino's Logo");
		lblDominosIcon.setIcon(icon);
		headerLogin.add(lblDominosIcon);
		
		// BEGIN
		headerLogin.add(Box.createHorizontalGlue());
		
		JLabel lblTitle = new JLabel("Domino's Pizza POS System");
		lblTitle.setFont(new Font("Helvetica", Font.BOLD, 64));
		lblTitle.setForeground(Color.WHITE);
		headerLogin.add(lblTitle);
		
		Component glueRight = Box.createHorizontalGlue();
		headerLogin.add(glueRight);

		headerLogin.add(Box.createRigidArea(dimBalance));
		// END
		
//		BEGIN LOGIN PANEL CODE	//
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(Pink);
		loginPanel.setPreferredSize(new Dimension(0, 650));
		loginCard.add(loginPanel, BorderLayout.CENTER);
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		
		loginPanel.add(Box.createVerticalGlue());
		
		JLabel lblPin = new JLabel("PIN");
		lblPin.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPin.setFont(new Font("Helvetica", Font.BOLD, 36));
		loginPanel.add(lblPin);
		
		JFormattedTextField formattedPIN = new JFormattedTextField(createFormatter("####"));
		formattedPIN.setColumns(4);
		formattedPIN.setToolTipText("Four-digit employee number");
		formattedPIN.setHorizontalAlignment(SwingConstants.CENTER);
		formattedPIN.setFont(hel28);
		formattedPIN.setMinimumSize(dimPIN);
		formattedPIN.setPreferredSize(dimPIN);
		formattedPIN.setMaximumSize(dimPIN);
		loginPanel.add(formattedPIN);
		
		JButton btnLogOn = new JButton("Log In");
		btnLogOn.setFont(hel28);
		btnLogOn.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLogOn.setMinimumSize(dimLogin);
		btnLogOn.setMaximumSize(dimLogin);
		btnLogOn.setPreferredSize(dimLogin);
		loginPanel.add(btnLogOn);
		
		loginPanel.add(Box.createVerticalGlue());
		
//		END LOGIN PANEL CODE	//
		
		JPanel systemCard = new JPanel();
		systemCard.setBackground(Pink);
		frmDominosPizzaPoint.getContentPane().add(systemCard, SYSTEMCARD);
		BorderLayout divBorder = new BorderLayout(0, 0);
		systemCard.setLayout(divBorder);
		
//		BEGIN NAV HEADER		//
		JPanel headerNav = new JPanel();
		headerNav.setBackground(Blue);
		headerNav.setPreferredSize(dimHeadFoot);
		systemCard.add(headerNav, BorderLayout.NORTH);
		headerNav.setLayout(new BoxLayout(headerNav, BoxLayout.X_AXIS));
		
		headerNav.add(Box.createRigidArea(dimMargin));
		
		
		JLabel lblDominosIcon1 = new JLabel();
		lblDominosIcon1.setToolTipText("Domino's Logo");
		lblDominosIcon1.setIcon(icon);
		headerNav.add(lblDominosIcon1);
		
		JButton btnPOS = new JButton("Point of Sales");
		btnPOS.setSize(dimNav);
		btnPOS.setPreferredSize(dimNav);
		btnPOS.setMinimumSize(dimNav);
		btnPOS.setMaximumSize(dimNav);
		
		JButton btnPrice = new JButton("Price & Rate Configuration");
		btnPrice.setSize(dimNav);
		btnPrice.setPreferredSize(dimNav);
		btnPrice.setMinimumSize(dimNav);
		btnPrice.setMaximumSize(dimNav);
		
		JButton btnAdmin = new JButton("Account Administration");
		btnAdmin.setSize(dimNav);
		btnAdmin.setPreferredSize(dimNav);
		btnAdmin.setMinimumSize(dimNav);
		btnAdmin.setMaximumSize(dimNav);
		
		headerNav.add(Box.createRigidArea(dimMargin));
		headerNav.add(btnPOS);
		headerNav.add(btnPrice);
		headerNav.add(btnAdmin);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		headerNav.add(horizontalGlue);
		
		headerNav.add(Box.createRigidArea(dimMargin));
		
		JLabel lblEmployee = new JLabel("Emanuel Jimenez Marquez Filipe Rosito");
		lblEmployee.setMaximumSize(new Dimension(1440, 60));
		lblEmployee.setMinimumSize(new Dimension(180, 16));
		lblEmployee.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblEmployee.setFont(new Font("Helvetica", Font.BOLD, 36));
		lblEmployee.setForeground(Color.WHITE);
		headerNav.add(lblEmployee);
		
		headerNav.add(Box.createRigidArea(dimMargin));
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setSize(dimNav);
		btnLogOut.setPreferredSize(dimNav);
		btnLogOut.setMinimumSize(dimNav);
		btnLogOut.setMaximumSize(dimNav);
		headerNav.add(btnLogOut);
		
		headerNav.add(Box.createRigidArea(dimMargin));
//		END NAV HEADER		//
		
		JPanel POSpanel = new JPanel();
		POSpanel.setBackground(Pink);
		POSpanel.setPreferredSize(new Dimension(0, 650));
		systemCard.add(POSpanel, BorderLayout.CENTER);
		
//		ActionLogin(formattedPIN.getText().trim(), btnLogOn, POSpanel);
		POSpanel.setLayout(new BorderLayout(0, 0));
		
//		JScrollPane scrollReceipt = new JScrollPane();
//		scrollReceipt.setPreferredSize(dimReceipt);
//		scrollReceipt.setSize(dimReceipt);
//		scrollReceipt.setMinimumSize(dimReceipt);
//		scrollReceipt.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		frmDominosPizzaPoint.getContentPane().add(scrollReceipt, BorderLayout.EAST);
		
		JTextArea textReceipt = new JTextArea();
		textReceipt.setColumns(30);
		textReceipt.setEditable(true);
		textReceipt.setText("\n"
				+ "           ORDER #999\n"
				+ "            Jean Doe\n\n"
				+ " QTY  ITEM                PRICE\n"
				+ " 100  Medium Pizza      $100.00\n"
				+ "       + Pepperoni\n"
				+ "       + Extra Cheese\n"
				+ "       + Green Peppers\n\n"
				+ "   2  2-Liter Soda      $100.00\n\n\n"
				+ "            Subtotal $10,200.00\n"
				+ "           Tax (20%) $Something\n"
				+ "         Grand Total $10,200.01\n"
				+ "\n\n\n\n\n\n\n\n\n\n\ntest");
		textReceipt.setCaretPosition(0);
		textReceipt.setToolTipText("Order Receipt");
		textReceipt.setFont(new Font("Consolas", Font.PLAIN, 22));
//		scrollReceipt.add(textReceipt);
		
		JScrollPane scrollReceipt = new JScrollPane (textReceipt, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollReceipt.setMinimumSize(dimReceipt);
		scrollReceipt.setMaximumSize(dimReceipt);
		scrollReceipt.setPreferredSize(dimReceipt);
		systemCard.add(scrollReceipt, BorderLayout.EAST);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Pink);
		POSpanel.add(leftPanel, BorderLayout.CENTER);
		leftPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel orderPanel = new JPanel();
		orderPanel.setPreferredSize(dimHeadFoot);
		orderPanel.setBackground(Pink);
		leftPanel.add(orderPanel, BorderLayout.SOUTH);
		orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.X_AXIS));
		
		orderPanel.add(Box.createHorizontalGlue());
		
		JButton btnComplete = new JButton("Complete Order");
		btnComplete.setFont(helB18);
		btnComplete.setMaximumSize(dimOrder);
		btnComplete.setMinimumSize(dimOrder);
		btnComplete.setPreferredSize(dimOrder);
		orderPanel.add(btnComplete);
		
		orderPanel.add(Box.createRigidArea(new Dimension(15,0)));
		
		JButton btnCancel = new JButton("Cancel Order");
		btnCancel.setFont(helB18);
		btnCancel.setPreferredSize(dimOrder);
		btnCancel.setMinimumSize(dimOrder);
		btnCancel.setMaximumSize(dimOrder);
		orderPanel.add(btnCancel);
		
		orderPanel.add(Box.createRigidArea(new Dimension(12,0)));
		
		JPanel ItemPanel = new JPanel();
		ItemPanel.setBackground(Pink);
		leftPanel.add(ItemPanel, BorderLayout.CENTER);
		ItemPanel.setLayout(new BoxLayout(ItemPanel, BoxLayout.Y_AXIS));
		
		ItemPanel.add(Box.createRigidArea(new Dimension(0, 50)));
		
		JButton btnPizza = new JButton("Add Pizza");
		btnPizza.setFont(helB24);
		btnPizza.setMaximumSize(dimItem);
		btnPizza.setAlignmentX(Component.CENTER_ALIGNMENT);
		ItemPanel.add(btnPizza);
		
		ItemPanel.add(Box.createRigidArea(new Dimension(0, 28)));
		
		JButton btnSoda = new JButton("Add Soda");
		btnSoda.setFont(helB24);
		btnSoda.setMaximumSize(dimItem);
		btnSoda.setAlignmentX(Component.CENTER_ALIGNMENT);
		ItemPanel.add(btnSoda);
	}
	
	private MaskFormatter createFormatter(String s) {
	    MaskFormatter formatter = null;
	    try {
	        formatter = new MaskFormatter(s);
	    } catch (java.text.ParseException exc) {
	        System.err.println("formatter is bad: " + exc.getMessage());
	        System.exit(-1);
	    }
	    return formatter;
	}
	
	private void ActionLogin(final String pass, JButton btn, final JPanel next) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if(pass.equals("0000")) {
					frmDominosPizzaPoint.getContentPane().remove(1);
					frmDominosPizzaPoint.getContentPane().add(next, BorderLayout.CENTER);
					frmDominosPizzaPoint.validate();
//				}
			}
		});
	}
	
//	private void ActionTestHead(JButton btn, final JPanel target) {
//		btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////				if(pass.equals("0000")) {
//					frmDominosPizzaPoint.getContentPane().remove(1);
//					frmDominosPizzaPoint.getContentPane().add(next, BorderLayout.CENTER);
//					frmDominosPizzaPoint.validate();
////				}
//			}
//		});
//	}
	
//	private FocusListener selectAll = new FocusListener() {
//
//	    @Override
//	    public void focusGained(FocusEvent e) {
//	        dumpInfo(e);
//	    }
//
//	    @Override
//	    public void focusLost(FocusEvent e) {
//	    }
//
//	    private void dumpInfo(FocusEvent e) {
//	        //System.out.println("Source  : " + name(e.getComponent()));
//	        //System.out.println("Opposite : " + name(e.getOppositeComponent()));
//	        //System.out.println("Temporary: " + e.isTemporary());
//	        Component c = e.getComponent();
//	        if (c instanceof JFormattedTextField) {
//	            ((JFormattedTextField) c).requestFocus();
//	            ((JFormattedTextField) c).setText(((JFormattedTextField) c).getText());
//	            ((JFormattedTextField) c).selectAll();
//	        } else if (c instanceof JTextField) {
//	            ((JTextField) c).requestFocus();
//	            ((JTextField) c).setText(((JTextField) c).getText());
//	            ((JTextField) c).selectAll();
//	        }
//	    }
//
////	    private String name(Component c) {
////	        return (c == null) ? null : c.getName();
////	    }
//	};
}
