import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;

import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.CardLayout;

import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

//TODO display prices with two decimal places



public class POS extends JPanel{

	private JFrame frmDominosPizzaPoint;
	static HashMap<String, String> map = new HashMap<String, String>();
	static EmployeeList testmap = new EmployeeList();
	static PriceTaxConfig newPriceTax = new PriceTaxConfig();
	static HashMap<String, Double> priceTax = new HashMap<String, Double>();
	//priceTax = newPriceTax.setPriceTax(priceTax);
	JList listEmployeeTable = new JList();
	JLabel lblEmployee = new JLabel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		map = testmap.inputMap();
		priceTax = newPriceTax.inputMap();
		if(priceTax.isEmpty()){
			priceTax.put("Soda", 0.00);
			priceTax.put("Small Regular", 0.00);
			priceTax.put("Medium Regular", 0.00);
			priceTax.put("Large Regular", 0.00);
			priceTax.put("Small Specialty", 0.00);
			priceTax.put("Medium Specialty", 0.00);
			priceTax.put("Large Specialty", 0.00);
			priceTax.put("Toppings", 0.00);
			priceTax.put("Tax Rate", 0.00);
			
			newPriceTax.outputMap(priceTax);
			newPriceTax.inputMap();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POS window = new POS();
					window.frmDominosPizzaPoint.setVisible(true);
				} catch (Exception e) {
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
		final String SYSCARD = "System";
		final String POSCARD = "POS";
		final String CONFIGCARD = "Config";
		final String ADMINCARD = "Admin";
		Color Pink = new Color(251, 200, 202);
		Color Blue = new Color(0, 78, 150);
		Image image = null;
		try {
			image = ImageIO.read(getClass().getResource("/Domino'sIcon.png"));
		} catch (IOException e) {
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
		Dimension dimReceipt = new Dimension(391, 0);
		Dimension dimOrder = new Dimension(154, 50);
		Dimension dimItem = new Dimension(530, 100);
		Dimension dimAction = new Dimension(150, 30);
		
		frmDominosPizzaPoint = new JFrame();
		frmDominosPizzaPoint.setBackground(Pink);
		frmDominosPizzaPoint.setTitle("Domino's Pizza Point of Sales");
		frmDominosPizzaPoint.setIconImage(image);
		frmDominosPizzaPoint.setPreferredSize(new Dimension(1024, 768));  
		frmDominosPizzaPoint.setMinimumSize(frmDominosPizzaPoint.getPreferredSize());  
		frmDominosPizzaPoint.pack();  
		frmDominosPizzaPoint.setLocationRelativeTo(null); 
		frmDominosPizzaPoint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final CardLayout metaHand = new CardLayout();
		frmDominosPizzaPoint.getContentPane().setLayout(metaHand);
		
		final JPanel loginCard = new JPanel();
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
		
		final JFormattedTextField formattedPIN = new JFormattedTextField(createFormatter("####"));
		formattedPIN.setFocusLostBehavior(JFormattedTextField.PERSIST);
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
		frmDominosPizzaPoint.getContentPane().add(systemCard, SYSCARD);
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
		
		final JButton btnPOS = new JButton("Point of Sales");
		btnPOS.setSize(dimNav);
		btnPOS.setPreferredSize(dimNav);
		btnPOS.setMinimumSize(dimNav);
		btnPOS.setMaximumSize(dimNav);
		
		final JButton btnPrice = new JButton("Price & Rate Configuration");
		btnPrice.setSize(dimNav);
		btnPrice.setPreferredSize(dimNav);
		btnPrice.setMinimumSize(dimNav);
		btnPrice.setMaximumSize(dimNav);
		
		final JButton btnAdmin = new JButton("Account Administration");
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
		
		lblEmployee = new JLabel("Employee Name");
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
		
		final JPanel subsysPanel = new JPanel();
		subsysPanel.setBackground(Pink);
		subsysPanel.setPreferredSize(new Dimension(0, 650));
		systemCard.add(subsysPanel, BorderLayout.CENTER);
		final CardLayout subHand = new CardLayout();
		subsysPanel.setLayout(subHand);
		
		JPanel POScard = new JPanel();
		POScard.setBackground(Pink);
		subsysPanel.add(POScard, POSCARD);
		POScard.setLayout(new BorderLayout(0, 0));
		
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
		POScard.add(scrollReceipt, BorderLayout.EAST);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Pink);
		POScard.add(leftPanel, BorderLayout.CENTER);
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
		
		// BEGIN PRICE & RATE
		JPanel priceCard = new JPanel();
		priceCard.setBackground(Pink);
		subsysPanel.add(priceCard, CONFIGCARD);
		priceCard.setLayout(new BorderLayout(0, 0));
		
		JPanel configAreaPanel = new JPanel();
		configAreaPanel.setBackground(Pink);
		priceCard.add(configAreaPanel, BorderLayout.NORTH);
		configAreaPanel.setLayout(new BoxLayout(configAreaPanel, BoxLayout.Y_AXIS));
		
		configAreaPanel.add(Box.createRigidArea(new Dimension(0, 140)));
		
		JPanel sodaPanel = new JPanel();
		sodaPanel.setBackground(Pink);
		configAreaPanel.add(sodaPanel);
		sodaPanel.setLayout(new BoxLayout(sodaPanel, BoxLayout.X_AXIS));
		
		sodaPanel.add(Box.createRigidArea(new Dimension(22, 0)));
		
		JLabel lblSodaPrice = new JLabel("Soda Price $");
		sodaPanel.add(lblSodaPrice);
		
		final JTextField textSodaPrice = new JTextField();
		textSodaPrice.setMaximumSize(new Dimension(100, 20));
		textSodaPrice.setText(String.valueOf(priceTax.get("Soda")));
		textSodaPrice.setHorizontalAlignment(JTextField.RIGHT);
		sodaPanel.add(textSodaPrice);
		textSodaPrice.setColumns(5);
		
		configAreaPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		
		JPanel metaPizzaPanel = new JPanel();
		metaPizzaPanel.setBackground(Pink);
		configAreaPanel.add(metaPizzaPanel);
		
		// BEGIN REGULAR PIZZA PRICE PANEL
		JPanel regPizzaPanel = new JPanel();
		regPizzaPanel.setBackground(Pink);
		regPizzaPanel.setPreferredSize(new Dimension(225, 130));
		regPizzaPanel.setMaximumSize(new Dimension(225, 130));
		metaPizzaPanel.add(regPizzaPanel);
		GridBagLayout gbl_regPizzaPanel = new GridBagLayout();
		gbl_regPizzaPanel.columnWidths = new int[]{85, 0, 100, 40};
		gbl_regPizzaPanel.rowHeights = new int[]{32, 32, 32, 32};
		gbl_regPizzaPanel.columnWeights = new double[]{Double.MIN_VALUE, 1.0};
		gbl_regPizzaPanel.rowWeights = new double[]{Double.MIN_VALUE};
		regPizzaPanel.setLayout(gbl_regPizzaPanel);
		
		JLabel lblRegPizza = new JLabel("Regular Pizza Prices");
		lblRegPizza.setFont(helB18);
		GridBagConstraints gbc_lblRegPizza = new GridBagConstraints();
		gbc_lblRegPizza.gridwidth = 4;
		gbc_lblRegPizza.insets = new Insets(0, 0, 5, 0);
		gbc_lblRegPizza.gridx = 0;
		gbc_lblRegPizza.gridy = 0;
		regPizzaPanel.add(lblRegPizza, gbc_lblRegPizza);
		
		JLabel lblRegSmall = new JLabel("Small $");
		GridBagConstraints gbc_lblRegSmall = new GridBagConstraints();
		gbc_lblRegSmall.anchor = GridBagConstraints.EAST;
		gbc_lblRegSmall.insets = new Insets(0, 0, 5, 0);
		gbc_lblRegSmall.gridx = 0;
		gbc_lblRegSmall.gridy = 1;
		regPizzaPanel.add(lblRegSmall, gbc_lblRegSmall);
		
		final JTextField textRegSmall = new JTextField();
		textRegSmall.setHorizontalAlignment(SwingConstants.RIGHT);
		textRegSmall.setText(String.valueOf(priceTax.get("Small Regular")));
		GridBagConstraints gbc_textRegSmall = new GridBagConstraints();
		gbc_textRegSmall.gridwidth = 2;
		gbc_textRegSmall.insets = new Insets(0, 0, 5, 5);
		gbc_textRegSmall.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRegSmall.gridx = 1;
		gbc_textRegSmall.gridy = 1;
		regPizzaPanel.add(textRegSmall, gbc_textRegSmall);
		textRegSmall.setColumns(10);
		
		JLabel lblRegMedium = new JLabel("Medium $");
		GridBagConstraints gbc_lblRegMedium = new GridBagConstraints();
		gbc_lblRegMedium.anchor = GridBagConstraints.EAST;
		gbc_lblRegMedium.insets = new Insets(0, 0, 5, 0);
		gbc_lblRegMedium.gridx = 0;
		gbc_lblRegMedium.gridy = 2;
		regPizzaPanel.add(lblRegMedium, gbc_lblRegMedium);
		
		final JTextField textRegMedium = new JTextField();
		textRegMedium.setHorizontalAlignment(SwingConstants.RIGHT);
		textRegMedium.setText(String.valueOf(priceTax.get("Medium Regular")));
		GridBagConstraints gbc_textRegMedium = new GridBagConstraints();
		gbc_textRegMedium.gridwidth = 2;
		gbc_textRegMedium.insets = new Insets(0, 0, 5, 5);
		gbc_textRegMedium.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRegMedium.gridx = 1;
		gbc_textRegMedium.gridy = 2;
		regPizzaPanel.add(textRegMedium, gbc_textRegMedium);
		textRegMedium.setColumns(10);
		
		JLabel lblRegLarge = new JLabel("Large $");
		GridBagConstraints gbc_lblRegLarge = new GridBagConstraints();
		gbc_lblRegLarge.anchor = GridBagConstraints.EAST;
		gbc_lblRegLarge.gridx = 0;
		gbc_lblRegLarge.gridy = 3;
		regPizzaPanel.add(lblRegLarge, gbc_lblRegLarge);
		
		final JTextField textRegLarge = new JTextField();
		textRegLarge.setHorizontalAlignment(SwingConstants.RIGHT);
		textRegLarge.setText(String.valueOf(priceTax.get("Large Regular")));
		GridBagConstraints gbc_textRegLarge = new GridBagConstraints();
		gbc_textRegLarge.gridwidth = 2;
		gbc_textRegLarge.insets = new Insets(0, 0, 5, 5);
		gbc_textRegLarge.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRegLarge.gridx = 1;
		gbc_textRegLarge.gridy = 3;
		regPizzaPanel.add(textRegLarge, gbc_textRegLarge);
		textRegLarge.setColumns(10);
		// END REGULAR PIZZA PRICE PANEL
		
		// BEGIN SPECIALTY PIZZA PRICE PANEL
		JPanel specPizzaPanel = new JPanel();
		specPizzaPanel.setBackground(Pink);
		specPizzaPanel.setPreferredSize(new Dimension(225, 130));
		specPizzaPanel.setMaximumSize(new Dimension(225, 130));
		metaPizzaPanel.add(specPizzaPanel);
		GridBagLayout gbl_specPizzaPanel = new GridBagLayout();
		gbl_specPizzaPanel.columnWidths = new int[]{85, 0, 100, 40};
		gbl_specPizzaPanel.rowHeights = new int[]{32, 32, 32, 32};
		gbl_specPizzaPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_specPizzaPanel.rowWeights = new double[]{Double.MIN_VALUE};
		specPizzaPanel.setLayout(gbl_specPizzaPanel);
		
		JLabel lblSpecPizza = new JLabel("Specialty Pizza Prices");
		lblSpecPizza.setFont(helB18);
		GridBagConstraints gbc_lblSpecPizza = new GridBagConstraints();
		gbc_lblSpecPizza.gridwidth = 4;
		gbc_lblSpecPizza.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpecPizza.gridx = 0;
		gbc_lblSpecPizza.gridy = 0;
		specPizzaPanel.add(lblSpecPizza, gbc_lblSpecPizza);
		
		JLabel lblSpecSmall = new JLabel("Small $");
		GridBagConstraints gbc_lblSpecSmall = new GridBagConstraints();
		gbc_lblSpecSmall.gridwidth = 2;
		gbc_lblSpecSmall.anchor = GridBagConstraints.EAST;
		gbc_lblSpecSmall.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpecSmall.gridx = 0;
		gbc_lblSpecSmall.gridy = 1;
		specPizzaPanel.add(lblSpecSmall, gbc_lblSpecSmall);
		
		final JTextField textSpecSmall = new JTextField();
		textSpecSmall.setHorizontalAlignment(SwingConstants.RIGHT);
		textSpecSmall.setText(String.valueOf(priceTax.get("Small Specialty")));
		GridBagConstraints gbc_textSpecSmall = new GridBagConstraints();
		gbc_textSpecSmall.insets = new Insets(0, 0, 5, 5);
		gbc_textSpecSmall.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSpecSmall.gridx = 2;
		gbc_textSpecSmall.gridy = 1;
		specPizzaPanel.add(textSpecSmall, gbc_textSpecSmall);
		textSpecSmall.setColumns(10);
		
		JLabel lblSpecMedium = new JLabel("Medium $");
		GridBagConstraints gbc_lblSpecMedium = new GridBagConstraints();
		gbc_lblSpecMedium.gridwidth = 2;
		gbc_lblSpecMedium.anchor = GridBagConstraints.EAST;
		gbc_lblSpecMedium.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpecMedium.gridx = 0;
		gbc_lblSpecMedium.gridy = 2;
		specPizzaPanel.add(lblSpecMedium, gbc_lblSpecMedium);
		
		final JTextField textSpecMedium = new JTextField();
		textSpecMedium.setHorizontalAlignment(SwingConstants.RIGHT);
		textSpecMedium.setText(String.valueOf(priceTax.get("Medium Specialty")));
		GridBagConstraints gbc_textSpecMedium = new GridBagConstraints();
		gbc_textSpecMedium.insets = new Insets(0, 0, 5, 5);
		gbc_textSpecMedium.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSpecMedium.gridx = 2;
		gbc_textSpecMedium.gridy = 2;
		specPizzaPanel.add(textSpecMedium, gbc_textSpecMedium);
		textSpecMedium.setColumns(10);
		
		JLabel lblSpecLarge = new JLabel("Large $");
		GridBagConstraints gbc_lblSpecLarge = new GridBagConstraints();
		gbc_lblSpecLarge.gridwidth = 2;
		gbc_lblSpecLarge.anchor = GridBagConstraints.EAST;
		gbc_lblSpecLarge.gridx = 0;
		gbc_lblSpecLarge.gridy = 3;
		specPizzaPanel.add(lblSpecLarge, gbc_lblSpecLarge);
		
		final JTextField textSpecLarge = new JTextField();
		textSpecLarge.setHorizontalAlignment(SwingConstants.RIGHT);
		textSpecLarge.setText(String.valueOf(priceTax.get("Large Specialty")));
		GridBagConstraints gbc_textSpecLarge = new GridBagConstraints();
		gbc_textSpecLarge.insets = new Insets(0, 0, 5, 5);
		gbc_textSpecLarge.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSpecLarge.gridx = 2;
		gbc_textSpecLarge.gridy = 3;
		specPizzaPanel.add(textSpecLarge, gbc_textSpecLarge);
		textSpecLarge.setColumns(10);
		// END SPECIALTY PIZZA PRICE PANEL
		
		configAreaPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		
		JPanel toppingsPanel = new JPanel();
		toppingsPanel.setBackground(Pink);
		configAreaPanel.add(toppingsPanel);
		toppingsPanel.setLayout(new BoxLayout(toppingsPanel, BoxLayout.X_AXIS));
		
		JLabel lblToppingsPrice = new JLabel("Topping Price $");
		toppingsPanel.add(lblToppingsPrice);
		
		final JTextField textToppingsPrice = new JTextField();
		textToppingsPrice.setMaximumSize(new Dimension(100, 20));
		textToppingsPrice.setText(String.valueOf(priceTax.get("Toppings")));
		textToppingsPrice.setHorizontalAlignment(JTextField.RIGHT);
		toppingsPanel.add(textToppingsPrice);
		textToppingsPrice.setColumns(5);
		
		configAreaPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		
		JPanel taxPanel = new JPanel();
		taxPanel.setBackground(Pink);
		configAreaPanel.add(taxPanel);
		taxPanel.setLayout(new BoxLayout(taxPanel, BoxLayout.X_AXIS));
		
		taxPanel.add(Box.createRigidArea(new Dimension(48, 0)));
		
		JLabel lblTaxPrice = new JLabel("Tax Rate");
		taxPanel.add(lblTaxPrice);
		
		taxPanel.add(Box.createRigidArea(new Dimension(4, 0)));
		
		final JTextField textTax = new JTextField();
		textTax.setMaximumSize(new Dimension(100, 20));
		textTax.setText(String.valueOf(priceTax.get("Tax Rate")));
		textTax.setHorizontalAlignment(JTextField.RIGHT);
		taxPanel.add(textTax);
		textTax.setColumns(5);
		
		JLabel lblPercent = new JLabel("%");
		taxPanel.add(lblPercent);
		
		JPanel confirmAreaPanel = new JPanel();
		confirmAreaPanel.setBackground(Pink);
		confirmAreaPanel.setPreferredSize(dimHeadFoot);
		priceCard.add(confirmAreaPanel, BorderLayout.SOUTH);
		confirmAreaPanel.setLayout(new BoxLayout(confirmAreaPanel, BoxLayout.X_AXIS));
		
		confirmAreaPanel.add(Box.createHorizontalGlue());
		
		JButton btnSavePrice = new JButton("Save");
		btnSavePrice.setFont(helB18);
		btnSavePrice.setMaximumSize(dimOrder);
		btnSavePrice.setMinimumSize(dimOrder);
		btnSavePrice.setPreferredSize(dimOrder);
		confirmAreaPanel.add(btnSavePrice);
		
		confirmAreaPanel.add(Box.createRigidArea(new Dimension(12,0)));
		// END PRICE & RATE

		
		// BEGIN ADMIN
		JPanel adminCard = new JPanel();
		adminCard.setBackground(Pink);
		subsysPanel.add(adminCard, ADMINCARD);
		adminCard.setLayout(new BorderLayout(0, 0));
		
		JPanel tableHeaderPanel = new JPanel();
		tableHeaderPanel.setBackground(Pink);
		tableHeaderPanel.setPreferredSize(new Dimension(0, 40));
		adminCard.add(tableHeaderPanel, BorderLayout.NORTH);
		tableHeaderPanel.setLayout(new BoxLayout(tableHeaderPanel, BoxLayout.X_AXIS));
		
		tableHeaderPanel.add(Box.createRigidArea(new Dimension(92, 0)));
		
		JLabel lblTablePIN = new JLabel("PIN");
		lblTablePIN.setFont(helB24);
		tableHeaderPanel.add(lblTablePIN);
		
		tableHeaderPanel.add(Box.createRigidArea(new Dimension(78, 0)));
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setFont(helB24);
		tableHeaderPanel.add(lblEmployeeName);
		
		JPanel manageAreaPanel = new JPanel();
		manageAreaPanel.setBackground(Pink);
		manageAreaPanel.setPreferredSize(new Dimension(0, 90));
		adminCard.add(manageAreaPanel, BorderLayout.SOUTH);
		manageAreaPanel.setLayout(new BoxLayout(manageAreaPanel, BoxLayout.X_AXIS));
		
		manageAreaPanel.add(Box.createHorizontalGlue());
		
		JButton btnAdd = new JButton("Add Employee");
		btnAdd.setPreferredSize(dimAction);
		manageAreaPanel.add(btnAdd);
		
		manageAreaPanel.add(Box.createRigidArea(new Dimension(30, 0)));
		
		JButton btnEdit = new JButton("Edit Employee");
		btnEdit.setPreferredSize(dimAction);
		manageAreaPanel.add(btnEdit);
		
		manageAreaPanel.add(Box.createRigidArea(new Dimension(30, 0)));
		
		JButton btnDelete = new JButton("Delete Employee");
		btnDelete.setPreferredSize(dimAction);
		manageAreaPanel.add(btnDelete);
		
		manageAreaPanel.add(Box.createHorizontalGlue());
		
		JPanel middlePanel = new JPanel();
		middlePanel.setBackground(Pink);
		adminCard.add(middlePanel, BorderLayout.CENTER);
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.X_AXIS));
		
		middlePanel.add(Box.createRigidArea(new Dimension(40, 0)));
		
		JScrollPane scrollEmployeeTable = new JScrollPane();
		scrollEmployeeTable.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollEmployeeTable.setMaximumSize(new Dimension(1360, 770));
		scrollEmployeeTable.setMinimumSize(new Dimension(940, 500));
		scrollEmployeeTable.setPreferredSize(new Dimension(940, 500));
		middlePanel.add(scrollEmployeeTable);
		
		//String[] employees = {"0000 Admin", "1234 Dumpty"};
		final ArrayList<String> employees = new ArrayList<String>();
		employees.add("   0000     Administrator");
		
		Iterator<String> keySetIterator = map.keySet().iterator();
		while(keySetIterator.hasNext()){
			String key = keySetIterator.next();
			employees.add("   " + String.valueOf(key) + "     " + map.get(key));
        }

		listEmployeeTable = new JList(employees.toArray());
		listEmployeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEmployeeTable.setFont(new Font("Consolas", Font.PLAIN, 26));
		scrollEmployeeTable.add(listEmployeeTable);
		scrollEmployeeTable.setViewportView(listEmployeeTable);
		
		middlePanel.add(Box.createRigidArea(new Dimension(40, 0)));
		// END ADMIN
				
		btnSavePrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPriceTax.editToppings(priceTax, Double.valueOf(priceTax.get("Toppings")), Double.valueOf(textToppingsPrice.getText()));
				textToppingsPrice.setText(String.valueOf(priceTax.get("Toppings")));
				
				newPriceTax.editTaxRate(priceTax, Double.valueOf(priceTax.get("Tax Rate")), Double.valueOf(textTax.getText()));
				textTax.setText(String.valueOf(priceTax.get("Tax Rate")));
				
				newPriceTax.editSoda(priceTax, Double.valueOf(priceTax.get("Soda")), Double.valueOf(textSodaPrice.getText()));
				textSodaPrice.setText(String.valueOf(priceTax.get("Soda")));
				
				newPriceTax.editSmallRegular(priceTax, Double.valueOf(priceTax.get("Small Regular")), Double.valueOf(textRegSmall.getText()));
				textRegSmall.setText(String.valueOf(priceTax.get("Small Regular")));
				
				newPriceTax.editMediumRegular(priceTax, Double.valueOf(priceTax.get("Medium Regular")), Double.valueOf(textRegMedium.getText()));
				textRegMedium.setText(String.valueOf(priceTax.get("Medium Regular")));
				
				newPriceTax.editLargeRegular(priceTax, Double.valueOf(priceTax.get("Large Regular")), Double.valueOf(textRegLarge.getText()));
				textRegLarge.setText(String.valueOf(priceTax.get("Large Regular")));
				
				newPriceTax.editSmallSpecialty(priceTax, Double.valueOf(priceTax.get("Small Specialty")), Double.valueOf(textSpecSmall.getText()));
				textSpecSmall.setText(String.valueOf(priceTax.get("Small Specialty")));
				
				newPriceTax.editMediumSpecialty(priceTax, Double.valueOf(priceTax.get("Medium Specialty")), Double.valueOf(textSpecMedium.getText()));
				textSpecMedium.setText(String.valueOf(priceTax.get("Medium Specialty")));
				
				newPriceTax.editLargeSpecialty(priceTax, Double.valueOf(priceTax.get("Large Specialty")), Double.valueOf(textSpecLarge.getText()));
				textSpecLarge.setText(String.valueOf(priceTax.get("Large Specialty")));
				
				newPriceTax.outputMap(priceTax);
			}
		});
		// BEGIN NAVIGATION ACTIONS
		btnLogOn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				
				//TODO INDENTS
					if(isPasswordCorrect(formattedPIN.getText().trim())) {
						metaHand.next(frmDominosPizzaPoint.getContentPane());
						subHand.show(subsysPanel, POSCARD);
						btnPOS.setEnabled(false);
						btnPrice.setEnabled(true);
						btnAdmin.setEnabled(true);
					}else{
						JOptionPane.showMessageDialog(null,
					        "Invalid PIN. Try again.",
					        "Error Message",
					        JOptionPane.ERROR_MESSAGE);
					}

		    	
		        formattedPIN.setText(null);
			}
			
		    private boolean isPasswordCorrect(String input) {
		        boolean isCorrect = true;

		        
//	        	DEBUG
	        	System.out.println(input);
//	        	DEBUG
		        
	        	
		        if(input.equals("0000")){
		        	isCorrect = true;
		        	lblEmployee.setText("Administrator");
//		        	DEBUG
		        	System.out.println("admin");
//		        	DEBUG
//		        }else if(input < 1000){
//		        	isCorrect = false;
////		        	DEBUG
//		        	System.out.println("< 1000");
////		        	DEBUG
		        }else{
		            isCorrect = map.containsKey(input);
		            
		            if(isCorrect) {
			        	lblEmployee.setText(map.get(input).trim());
		            }
//		        	DEBUG
		        	System.out.println(map.containsKey(input) + " : " + input);
//		        	DEBUG
		        }

		        return isCorrect;
		   }
		});
		
		btnLogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				metaHand.previous(frmDominosPizzaPoint.getContentPane());
			}
		});
		
		btnPOS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				subHand.show(subsysPanel, POSCARD);
				btnPOS.setEnabled(false);
				btnPrice.setEnabled(true);
				btnAdmin.setEnabled(true);
			}
		});
		
		btnPrice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				subHand.show(subsysPanel, CONFIGCARD);
				btnPrice.setEnabled(false);
				btnPOS.setEnabled(true);
				btnAdmin.setEnabled(true);
			}
		});
		
		btnAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				subHand.show(subsysPanel, ADMINCARD);
				btnAdmin.setEnabled(false);
				btnPOS.setEnabled(true);
				btnPrice.setEnabled(true);
			}
		});
		// END NAVIGATION ACTIONS
		
		// BEGIN POS ACTIONS
		btnPizza.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		PizzaFrame pizza = new PizzaFrame();
		}
		});
		 
		btnSoda.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		SodaFrame soda = new SodaFrame();
		}
		});
		// END POS ACTIONS
		
		//Begin Admin Actions
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				EmployeeFrame addition = new EmployeeFrame(employees, "", "");
			}
		}); 
		
		btnEdit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String text = (String) listEmployeeTable.getSelectedValue();
				String stringPin = text.substring(3, 7);
				String stringName = text.substring(12, text.length());
				
				if(text.equals("   0000     Administrator")){
					JOptionPane.showMessageDialog(null,
			                "You cannot edit the Administrator pin.",
			                "Error Message",
			                JOptionPane.ERROR_MESSAGE);
				}else{
					EmployeeFrame edits = new EmployeeFrame(employees, stringPin, stringName);
					
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int index = listEmployeeTable.getSelectedIndex();
				String text = (String) listEmployeeTable.getSelectedValue();
				if(text.equals("   0000     Administrator")){
					JOptionPane.showMessageDialog(null,
			                "You cannot delete the Administrator account.",
			                "Error Message",
			                JOptionPane.ERROR_MESSAGE);
				}else{
					String stringPin = text.substring(3, 7);
					String stringName = text.substring(12, text.length()).trim();
					employees.remove(index);
					if(stringName.equals(lblEmployee.getText())){
					    listEmployeeTable.setListData(employees.toArray());
						testmap.deleteEmployee(map, stringPin);
						testmap.outputMap(map);
						metaHand.previous(frmDominosPizzaPoint.getContentPane());
					}else{
						listEmployeeTable.setListData(employees.toArray());
						testmap.deleteEmployee(map, stringPin);
						testmap.outputMap(map);
					}		
				}
			}
		});
	}
	
	private class EmployeeFrame extends JFrame {

		private JPanel contentPane;
		private String PIN;
		private String EmployeeName;

		public EmployeeFrame(final ArrayList<String> employees, String pin, String name) {
			this.PIN = pin;
			this.EmployeeName = name.trim();
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			this.setTitle("Employee");
			this.setPreferredSize(new Dimension(450, 300));  
			this.setResizable(false);
			this.pack();  
			this.setLocationRelativeTo(null); 
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			
			JPanel confirmPanel = new JPanel();
			confirmPanel.setPreferredSize(new Dimension(0, 60));
			contentPane.add(confirmPanel, BorderLayout.SOUTH);
			confirmPanel.setLayout(new BoxLayout(confirmPanel, BoxLayout.X_AXIS));
			
			Component horizontalGlue = Box.createHorizontalGlue();
			confirmPanel.add(horizontalGlue);
			
			final JButton btnOk = new JButton("Ok");
			btnOk.setPreferredSize(new Dimension(75, 30));
			confirmPanel.add(btnOk);
			
			Component rigidArea_2 = Box.createRigidArea(new Dimension(15, 0));
			confirmPanel.add(rigidArea_2);
			
			final JButton btnCancel = new JButton("Cancel");
			btnCancel.setPreferredSize(new Dimension(75, 30));
			confirmPanel.add(btnCancel);
			
			Component rigidArea_3 = Box.createRigidArea(new Dimension(25, 0));
			confirmPanel.add(rigidArea_3);
			
			JPanel formPanel = new JPanel();
			contentPane.add(formPanel, BorderLayout.CENTER);
			formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
			
			Component rigidArea = Box.createRigidArea(new Dimension(0, 30));
			formPanel.add(rigidArea);
			
			JLabel labelPIN = new JLabel("PIN");
			labelPIN.setAlignmentX(Component.CENTER_ALIGNMENT);
			labelPIN.setMaximumSize(new Dimension(216, 20));
			formPanel.add(labelPIN);
			
			final JFormattedTextField textPIN = new JFormattedTextField(createFormatter("####"));
			textPIN.setFocusLostBehavior(JFormattedTextField.COMMIT);
			textPIN.setText(PIN);
			textPIN.setMaximumSize(new Dimension(220, 20));
			textPIN.setToolTipText("four-digit employee number");
			formPanel.add(textPIN);
			textPIN.setColumns(10);
			
			Component rigidArea_1 = Box.createRigidArea(new Dimension(0, 25));
			formPanel.add(rigidArea_1);
			
			JLabel lblName = new JLabel("Employee Name");
			lblName.setMaximumSize(new Dimension(216, 20));
			lblName.setAlignmentX(Component.CENTER_ALIGNMENT);
			formPanel.add(lblName);
			
			final JTextField textName = new JTextField();
			textName.setText(EmployeeName);
			textName.setMaximumSize(new Dimension(220, 20));
			formPanel.add(textName);
			textName.setColumns(10);
			
			btnOk.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String replacePIN, replaceName;
					String newName = textName.getText().trim();
					boolean add;
//					int checkPin = Integer.parseInt(textPIN.getText().trim());
					
					if(PIN == ""){
						replacePIN = "";
						replaceName = "";
						add = true;
					} else {
						replacePIN = PIN;
						replaceName = EmployeeName;
						add = false;
					}
					
						if(map.containsKey(textPIN.getText().trim()) 
								&& PIN.equals(textPIN.getText().trim()) == false){
							textPIN.setText(replacePIN);
							JOptionPane.showMessageDialog(null,
									"PIN already exists. Enter antoher four-digit PIN.",
					                "Error Message",
					                JOptionPane.ERROR_MESSAGE);
						}else if((textPIN.getText()).equals("")){
							JOptionPane.showMessageDialog(null,
									"PIN field empty. Enter a four-digit PIN.",
					                "Error Message",
					                JOptionPane.ERROR_MESSAGE);
						}else if((textPIN.getText()).equals("0000")){
							textPIN.setText(replacePIN);
							JOptionPane.showMessageDialog(null,
									"Cannot use Administrative PIN. Enter another four-digit PIN.",
					                "Error Message",
					                JOptionPane.ERROR_MESSAGE);
						}else if(textPIN.getText().trim().indexOf(" ") > -1){
							textPIN.setText(replacePIN);
							JOptionPane.showMessageDialog(null,
									"Invalid PIN. Enter a four-digit PIN.",
					                "Error Message",
					                JOptionPane.ERROR_MESSAGE);
						}else if(textPIN.getText().trim().length() < 4){
							textPIN.setText(replacePIN);
							JOptionPane.showMessageDialog(null,
									"Invalid PIN. Enter a four-digit PIN.",
					                "Error Message",
					                JOptionPane.ERROR_MESSAGE);
						}else if((textName.getText()).trim().equals("")){
							textName.setText(replaceName);
							JOptionPane.showMessageDialog(null,
									"Employee name field empty. Enter the name of the employee.",
					                "Error Message",
					                JOptionPane.ERROR_MESSAGE);
						}else{
							if (add) {
								testmap.addEmployee(map, textPIN.getText().trim(), newName);
								employees.add("   " + textPIN.getText().trim() + "     " + newName);
							} else {
								if(lblEmployee.getText().equals(map.get(PIN))) {
									lblEmployee.setText(newName);
								}
								
								employees.set(employees.indexOf("   " + PIN + "     " + map.get(PIN)),
										"   " + textPIN.getText().trim() + "     " + newName);
								testmap.editEmployee(map, PIN, textPIN.getText().trim(), newName);
							}
							
							testmap.outputMap(map);
							listEmployeeTable.setListData(employees.toArray());
							((JFrame) btnOk.getTopLevelAncestor()).dispose();
						}	
				}
			});
			
			btnCancel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					((JFrame) btnCancel.getTopLevelAncestor()).dispose();
				}
			});
			
			this.setVisible(true);
		}

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
	
//	private void ActionLogin(final String pass, JButton btn, final JPanel next) {
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
