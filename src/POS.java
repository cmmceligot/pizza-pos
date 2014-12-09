import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.EventQueue;
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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

//TODO numbers and decimal only

public class POS extends JPanel{

	private JFrame frmDominosPizzaPoint;
	static HashMap<String, String> map = new HashMap<String, String>();
	static EmployeeList testmap = new EmployeeList();
	static PriceTaxConfig newPriceTax = new PriceTaxConfig();
	static HashMap<String, String> priceTax = new HashMap<String, String>();
	JList listEmployeeTable = new JList();
	JLabel lblEmployee = new JLabel();
	Order currentOrder = new Order();
	static NumberFormat formatter = new DecimalFormat("#0.00"); 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		map = testmap.inputMap();
		priceTax = newPriceTax.inputMap();
		if(priceTax.isEmpty()){
			priceTax.put("Soda", (formatter.format(0.00)));
			priceTax.put("Small Regular", (formatter.format(0.00)));
			priceTax.put("Medium Regular", (formatter.format(0.00)));
			priceTax.put("Large Regular", (formatter.format(0.00)));
			priceTax.put("Small Specialty", (formatter.format(0.00)));
			priceTax.put("Medium Specialty", (formatter.format(0.00)));
			priceTax.put("Large Specialty", (formatter.format(0.00)));
			priceTax.put("Toppings", (formatter.format(0.00)));
			priceTax.put("Tax Rate", "0");
			
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
	
		final JTextArea textReceipt = new JTextArea();
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
		textTax.setText(String.valueOf(Double.valueOf(priceTax.get("Tax Rate"))));
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
				try {
					newPriceTax.editToppings(priceTax,(priceTax.get("Toppings")), Double.valueOf(textToppingsPrice.getText()));
					textToppingsPrice.setText(String.valueOf(priceTax.get("Toppings")));
					
					newPriceTax.editTaxRate(priceTax, (priceTax.get("Tax Rate")), Double.valueOf(textTax.getText()));
					textTax.setText(String.valueOf(String.valueOf(Double.valueOf(priceTax.get("Tax Rate")))));
					
					newPriceTax.editSoda(priceTax, (priceTax.get("Soda")), Double.valueOf(textSodaPrice.getText()));
					textSodaPrice.setText(String.valueOf(priceTax.get("Soda")));
					
					newPriceTax.editSmallRegular(priceTax, (priceTax.get("Small Regular")), Double.valueOf(textRegSmall.getText()));
					textRegSmall.setText(String.valueOf(priceTax.get("Small Regular")));
					
					newPriceTax.editMediumRegular(priceTax, (priceTax.get("Medium Regular")), Double.valueOf(textRegMedium.getText()));
					textRegMedium.setText(String.valueOf(priceTax.get("Medium Regular")));
					
					newPriceTax.editLargeRegular(priceTax, (priceTax.get("Large Regular")), Double.valueOf(textRegLarge.getText()));
					textRegLarge.setText(String.valueOf(priceTax.get("Large Regular")));
					
					newPriceTax.editSmallSpecialty(priceTax, (priceTax.get("Small Specialty")), Double.valueOf(textSpecSmall.getText()));
					textSpecSmall.setText(String.valueOf(priceTax.get("Small Specialty")));
					
					newPriceTax.editMediumSpecialty(priceTax, (priceTax.get("Medium Specialty")), Double.valueOf(textSpecMedium.getText()));
					textSpecMedium.setText(String.valueOf(priceTax.get("Medium Specialty")));
					
					newPriceTax.editLargeSpecialty(priceTax, (priceTax.get("Large Specialty")), Double.valueOf(textSpecLarge.getText()));
					textSpecLarge.setText(String.valueOf(priceTax.get("Large Specialty")));
					
					newPriceTax.outputMap(priceTax);
				} catch (NumberFormatException e1) {
					
					textToppingsPrice.setText(String.valueOf(priceTax.get("Toppings")));
					textTax.setText(String.valueOf(String.valueOf(Double.valueOf(priceTax.get("Tax Rate")))));
					textSodaPrice.setText(String.valueOf(priceTax.get("Soda")));
					textRegSmall.setText(String.valueOf(priceTax.get("Small Regular")));
					textRegMedium.setText(String.valueOf(priceTax.get("Medium Regular")));
					textRegLarge.setText(String.valueOf(priceTax.get("Large Regular")));
					textSpecSmall.setText(String.valueOf(priceTax.get("Small Specialty")));
					textSpecMedium.setText(String.valueOf(priceTax.get("Medium Specialty")));
					textSpecLarge.setText(String.valueOf(priceTax.get("Large Specialty")));
					
					JOptionPane.showMessageDialog(null,
					        "Prices should contain only numbers with an option decimal point.",
					        "Error Message",
					        JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		// BEGIN NAVIGATION ACTIONS
		btnLogOn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

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

		        if(input.equals("0000")){
		        	isCorrect = true;
		        	lblEmployee.setText("Administrator");
		        }else{
		            isCorrect = map.containsKey(input);
		            
		            if(isCorrect) {
			        	lblEmployee.setText(map.get(input).trim());
		            }
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
		
		//Begin Ordering Actions
		btnComplete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				textReceipt.setText(currentOrder.makeReceipt());
			}
		});
		
		btnComplete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				currentOrder.cancelOrder();
			}
		});
		
		//End Ordering Actions
		
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
						}else if((textPIN.getText()).trim().length() < 4){
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

	private class SodaFrame extends JFrame {
	
		private JPanel contentPane;

		public SodaFrame() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			this.setTitle("Add Soda");
			this.setPreferredSize(new Dimension(280, 180)); 
			this.setResizable(false);
			this.pack();  
			this.setLocationRelativeTo(null); 
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			this.setVisible(true);
			
			JPanel qtyPanel = new JPanel();
			contentPane.add(qtyPanel, BorderLayout.CENTER);
			qtyPanel.setLayout(new BoxLayout(qtyPanel, BoxLayout.X_AXIS));
			
			Component horizontalGlue_3 = Box.createHorizontalGlue();
			qtyPanel.add(horizontalGlue_3);
			
			JLabel lblQty = new JLabel("Quantity");
			lblQty.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			qtyPanel.add(lblQty);
			
			Component rigidArea_1 = Box.createRigidArea(new Dimension(4, 36));
			qtyPanel.add(rigidArea_1);
			
			SpinnerNumberModel qtys = new SpinnerNumberModel(1, 1, 100, 1);
			
			final JSpinner spinner = new JSpinner(qtys);
			spinner.setPreferredSize(new Dimension(55, 28));
			spinner.setMaximumSize(new Dimension(55, 28));
			qtyPanel.add(spinner);
			
			Component horizontalGlue_2 = Box.createHorizontalGlue();
			qtyPanel.add(horizontalGlue_2);
			
			JPanel confirmPanel = new JPanel();
			confirmPanel.setPreferredSize(new Dimension(0, 60));
			contentPane.add(confirmPanel, BorderLayout.SOUTH);
			confirmPanel.setLayout(new BoxLayout(confirmPanel, BoxLayout.X_AXIS));
			
			Component horizontalGlue = Box.createHorizontalGlue();
			confirmPanel.add(horizontalGlue);
			
			JButton btnOk = new JButton("Ok");
			btnOk.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			btnOk.setPreferredSize(new Dimension(100, 30));
			confirmPanel.add(btnOk);
			
			Component rigidArea = Box.createRigidArea(new Dimension(18, 0));
			confirmPanel.add(rigidArea);
			
			final JButton btnCancel = new JButton("Cancel");
			btnCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			btnCancel.setPreferredSize(new Dimension(100, 30));
			confirmPanel.add(btnCancel);
			
			Component horizontalGlue_1 = Box.createHorizontalGlue();
			confirmPanel.add(horizontalGlue_1);
			
			// BEGIN ACTIONS
			btnOk.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO fix this (move things outside; up there)
					Soda bottles = new Soda();
					bottles.setPrice(Double.valueOf(textSodaPrice.getText()));
					currentOrder.setTaxRate(Double.valueOf(texttax.getText()));
					bottles.setQuantity((Integer) spinner.getValue());
					currentOrder.addItem(bottles);
					textReceipt.setText(currentOrder.makeReceipt());
					
					((JFrame) btnOk.getTopLevelAncestor()).dispose();
				}
			});
			
			btnCancel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					((JFrame) btnCancel.getTopLevelAncestor()).dispose();
				}
			});
			// END ACTIONS
		}

	}
	
	private class PizzaFrame extends JFrame {
		
		private JPanel contentPane;

		public PizzaFrame() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			this.setTitle("Create Pizza");
			this.setPreferredSize(new Dimension(800, 425));  
			this.setResizable(false);
			this.pack();  
			this.setLocationRelativeTo(null); 
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			
			JPanel panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(10, 25));
			contentPane.add(panel_1, BorderLayout.NORTH);
			
			JPanel panel_2 = new JPanel();
			contentPane.add(panel_2, BorderLayout.CENTER);
			panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
			
			Component horizontalGlue_1 = Box.createHorizontalGlue();
			panel_2.add(horizontalGlue_1);
			
			JLabel lblQty = new JLabel("Quantity");
			lblQty.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			lblQty.setMaximumSize(new Dimension(54, 26));
			lblQty.setAlignmentY(Component.TOP_ALIGNMENT);
			panel_2.add(lblQty);
			
			SpinnerNumberModel qtys = new SpinnerNumberModel(1, 1, 100, 1);
			
			Component rigidArea_6 = Box.createRigidArea(new Dimension(4, 0));
			panel_2.add(rigidArea_6);
			JSpinner spinnerQty = new JSpinner(qtys);
			spinnerQty.setPreferredSize(new Dimension(55, 28));
			spinnerQty.setAlignmentY(Component.TOP_ALIGNMENT);
			spinnerQty.setMaximumSize(new Dimension(55, 28));
			panel_2.add(spinnerQty);
			
			Component rigidArea = Box.createRigidArea(new Dimension(45, 0));
			panel_2.add(rigidArea);
			
			JComboBox comboSize = new JComboBox();
			comboSize.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			comboSize.setModel(new DefaultComboBoxModel(new String[] {"Size", "Small", "Medium", "Large"}));
			comboSize.setPreferredSize(new Dimension(110, 27));
			comboSize.setAlignmentY(Component.TOP_ALIGNMENT);
			comboSize.setMaximumSize(new Dimension(110, 27));
			panel_2.add(comboSize);
			
			Component rigidArea_1 = Box.createRigidArea(new Dimension(40, 0));
			panel_2.add(rigidArea_1);
			
			JPanel regularPanel = new JPanel();
			regularPanel.setAlignmentY(Component.TOP_ALIGNMENT);
			regularPanel.setPreferredSize(new Dimension(180, 10));
			regularPanel.setMaximumSize(new Dimension(180, 32767));
			panel_2.add(regularPanel);
			regularPanel.setLayout(new BoxLayout(regularPanel, BoxLayout.Y_AXIS));
			
			JRadioButton rdbtnRegularPizza = new JRadioButton("Regular Pizza");
			rdbtnRegularPizza.setSelected(true);
			rdbtnRegularPizza.setPreferredSize(new Dimension(180, 23));
			rdbtnRegularPizza.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			rdbtnRegularPizza.setMaximumSize(new Dimension(180, 23));
			rdbtnRegularPizza.setAlignmentX(Component.CENTER_ALIGNMENT);
			regularPanel.add(rdbtnRegularPizza);
			
			Component rigidArea_3 = Box.createRigidArea(new Dimension(0, 8));
			regularPanel.add(rigidArea_3);
			
			JLabel lblToppings = new JLabel("Toppings");
			lblToppings.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblToppings.setAlignmentX(Component.CENTER_ALIGNMENT);
			regularPanel.add(lblToppings);
			
			final JCheckBox chckbxBacon = new JCheckBox("Bacon");
			chckbxBacon.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			chckbxBacon.setMaximumSize(new Dimension(150, 23));
			chckbxBacon.setAlignmentX(Component.CENTER_ALIGNMENT);
			regularPanel.add(chckbxBacon);
			
			final JCheckBox chckbxOlives = new JCheckBox("Black Olives");
			chckbxOlives.setPreferredSize(new Dimension(150, 23));
			chckbxOlives.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			chckbxOlives.setMaximumSize(new Dimension(150, 23));
			chckbxOlives.setAlignmentX(Component.CENTER_ALIGNMENT);
			regularPanel.add(chckbxOlives);
			
			final JCheckBox chckbxXtraCheese = new JCheckBox("Extra Cheese");
			chckbxXtraCheese.setMaximumSize(new Dimension(150, 23));
			chckbxXtraCheese.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			chckbxXtraCheese.setAlignmentX(Component.CENTER_ALIGNMENT);
			regularPanel.add(chckbxXtraCheese);
			
			final JCheckBox chckbxChicken = new JCheckBox("Chicken");
			chckbxChicken.setMaximumSize(new Dimension(150, 23));
			chckbxChicken.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			chckbxChicken.setAlignmentX(Component.CENTER_ALIGNMENT);
			regularPanel.add(chckbxChicken);
			
			final JCheckBox chckbxPeppers = new JCheckBox("Green Peppers");
			chckbxPeppers.setMaximumSize(new Dimension(150, 23));
			chckbxPeppers.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			chckbxPeppers.setAlignmentX(Component.CENTER_ALIGNMENT);
			regularPanel.add(chckbxPeppers);
			
			final JCheckBox chckbxHam = new JCheckBox("Ham");
			chckbxHam.setMaximumSize(new Dimension(150, 23));
			chckbxHam.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			chckbxHam.setAlignmentX(Component.CENTER_ALIGNMENT);
			regularPanel.add(chckbxHam);
			
			final JCheckBox chckbxShrooms = new JCheckBox("Mushrooms");
			chckbxShrooms.setMaximumSize(new Dimension(150, 23));
			chckbxShrooms.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			chckbxShrooms.setAlignmentX(Component.CENTER_ALIGNMENT);
			regularPanel.add(chckbxShrooms);
			
			final JCheckBox chckbxOnions = new JCheckBox("Onions");
			chckbxOnions.setMaximumSize(new Dimension(150, 23));
			chckbxOnions.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			chckbxOnions.setAlignmentX(Component.CENTER_ALIGNMENT);
			regularPanel.add(chckbxOnions);
			
			final JCheckBox chckbxPepperoni = new JCheckBox("Pepperoni");
			chckbxPepperoni.setMaximumSize(new Dimension(150, 23));
			chckbxPepperoni.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			chckbxPepperoni.setAlignmentX(Component.CENTER_ALIGNMENT);
			regularPanel.add(chckbxPepperoni);
			
			final JCheckBox chckbxPineapple = new JCheckBox("Pineapple");
			chckbxPineapple.setMaximumSize(new Dimension(150, 23));
			chckbxPineapple.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			chckbxPineapple.setAlignmentX(Component.CENTER_ALIGNMENT);
			regularPanel.add(chckbxPineapple);
			
			final JCheckBox chckbxSausage = new JCheckBox("Sausage");
			chckbxSausage.setMaximumSize(new Dimension(150, 23));
			chckbxSausage.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			chckbxSausage.setAlignmentX(Component.CENTER_ALIGNMENT);
			regularPanel.add(chckbxSausage);
			
			JPanel specPanel = new JPanel();
			specPanel.setAlignmentY(Component.TOP_ALIGNMENT);
			specPanel.setPreferredSize(new Dimension(215, 10));
			specPanel.setMaximumSize(new Dimension(215, 32767));
			panel_2.add(specPanel);
			specPanel.setLayout(new BoxLayout(specPanel, BoxLayout.Y_AXIS));
			
			JRadioButton rdbtnSpec = new JRadioButton("Specialty Pizza");
			rdbtnSpec.setPreferredSize(new Dimension(215, 23));
			rdbtnSpec.setMaximumSize(new Dimension(215, 23));
			rdbtnSpec.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			rdbtnSpec.setAlignmentX(Component.CENTER_ALIGNMENT);
			specPanel.add(rdbtnSpec);
			
			Component rigidArea_4 = Box.createRigidArea(new Dimension(0, 5));
			specPanel.add(rigidArea_4);
			
			final JComboBox comboSpec = new JComboBox();
			comboSpec.setEnabled(false);
			comboSpec.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			comboSpec.setModel(new DefaultComboBoxModel(new String[] {"Specialty Type", "Hawaiian", "Meat Lovers'"}));
			comboSpec.setMaximumSize(new Dimension(175, 27));
			specPanel.add(comboSpec);
			
			Component rigidArea_7 = Box.createRigidArea(new Dimension(30, 0));
			panel_2.add(rigidArea_7);
			
			ButtonGroup pizzaType = new ButtonGroup();
			pizzaType.add(rdbtnRegularPizza);
			pizzaType.add(rdbtnSpec);
			
			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 50));
			contentPane.add(panel, BorderLayout.SOUTH);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			
			Component horizontalGlue_2 = Box.createHorizontalGlue();
			panel.add(horizontalGlue_2);
			
			JButton btnOk = new JButton("Ok");
			btnOk.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			btnOk.setPreferredSize(new Dimension(100, 30));
			panel.add(btnOk);
			
			Component rigidArea_5 = Box.createRigidArea(new Dimension(16, 0));
			panel.add(rigidArea_5);
			
			final JButton btnCancel = new JButton("Cancel");
			btnCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			btnCancel.setPreferredSize(new Dimension(100, 30));
			panel.add(btnCancel);
			
			Component rigidArea_2 = Box.createRigidArea(new Dimension(25, 0));
			panel.add(rigidArea_2);
			
			// BEGIN ACTIONS
			rdbtnRegularPizza.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					chckbxBacon.setEnabled(true);
					chckbxOlives.setEnabled(true);
					chckbxXtraCheese.setEnabled(true);
					chckbxChicken.setEnabled(true);
					chckbxPeppers.setEnabled(true);
					chckbxHam.setEnabled(true);
					chckbxShrooms.setEnabled(true);
					chckbxOnions.setEnabled(true);
					chckbxPepperoni.setEnabled(true);
					chckbxPineapple.setEnabled(true);
					chckbxSausage.setEnabled(true);

					comboSpec.setEnabled(false);
				}
			});
			
			rdbtnSpec.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					chckbxBacon.setEnabled(false);
					chckbxOlives.setEnabled(false);
					chckbxXtraCheese.setEnabled(false);
					chckbxChicken.setEnabled(false);
					chckbxPeppers.setEnabled(false);
					chckbxHam.setEnabled(false);
					chckbxShrooms.setEnabled(false);
					chckbxOnions.setEnabled(false);
					chckbxPepperoni.setEnabled(false);
					chckbxPineapple.setEnabled(false);
					chckbxSausage.setEnabled(false);

					comboSpec.setEnabled(true);
				}
			});
			
			btnOk.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Implement adding a pizza
					Pizza pie;
					Size pieSize;
					
					if (comboSize.getSelectedItem().toString().equals("Small")) {
						pieSize = Size.Small;
					} else if (comboSize.getSelectedItem().toString().equals("Medium")) {
						pieSize = Size.Medium;
					} else if (comboSize.getSelectedItem().toString().equals("Large")) {
						pieSize = Size.Large;
					} else {
						JOptionPane.showMessageDialog(null,
								"Please select a valid pizza size.",
				                "Error Message",
				                JOptionPane.ERROR_MESSAGE);
					}
					
					if (rdbtnSpec.isSelected()) {
						String type = comboSpec.getSelectedItem().toString();
						
						if (type.equals("Specialty Type") == false) {
							pie = new SpecialtyPizza(pieSize, type);
							switch(pieSize) {
							case Small: pie.setPrice(Double.valueOf(textSmallSpec.getText()));
							case Medium: pie.setPrice(Double.valueOf(textMedSpec.getText()));
							case Large: pie.setPrice(Double.valueOf(textLargeSpec.getText()));
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Please select a valid specialty type.",
					                "Error Message",
					                JOptionPane.ERROR_MESSAGE);
						}
					} else {
						EnumSet<Topping> tops;
						
						if (chckbxBacon.isSelected()) {
							tops.add(Topping.Bacon);
						}
						if (chckbxOlives.isSelected()) {
							tops.add(Topping.BlackOlives);
						}
						if (chckbxXtraCheese.isSelected()) {
							tops.add(Topping.ExtraCheese);
						}
						if (chckbxChicken.isSelected()) {
							tops.add(Topping.Chicken);
						}
						if (chckbxPeppers.isSelected()) {
							tops.add(Topping.GreenPeppers);
						}
						if (chckbxHam.isSelected()) {
							tops.add(Topping.Ham);
						}
						if (chckbxShrooms.isSelected()) {
							tops.add(Topping.Mushrooms);
						}
						if (chckbxPepperoni.isSelected()) {
							tops.add(Topping.Pepperoni);
						}
						if (chckbxPineapple.isSelected()) {
							tops.add(Topping.Pineapple);
						}
						if (chckbxSausage.isSelected()) {
							tops.add(Topping.Sausage);
						}
						
						pie = new Pizza(pieSize, tops);
						pie.setToppingsPrice(Double.valueOf(textToppings.getText()));
						
						switch(pieSize) {
						case Small: pie.setPrice(Double.valueOf(textSmallReg.getText()));
						case Medium: pie.setPrice(Double.valueOf(textMedReg.getText()));
						case Large: pie.setPrice(Double.valueOf(textLargeReg.getText()));
						}
					}
					currentOrder.setTaxRate(Double.valueOf(textTax.getText()));
					pie.setQuantity((Integer) spinner.getValue());
					currentOrder.addItem(pie);
					textReceipt.setText(currentOrder.makeReceipt());
					
					((JFrame) btnOk.getTopLevelAncestor()).dispose();
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
}
