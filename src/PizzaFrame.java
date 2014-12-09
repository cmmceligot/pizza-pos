import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;


public class PizzaFrame extends JFrame {
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
		
		JCheckBox chckbxBacon = new JCheckBox("Bacon");
		chckbxBacon.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		chckbxBacon.setMaximumSize(new Dimension(150, 23));
		chckbxBacon.setAlignmentX(Component.CENTER_ALIGNMENT);
		regularPanel.add(chckbxBacon);
		
		JCheckBox chckbxOlives = new JCheckBox("Black Olives");
		chckbxOlives.setPreferredSize(new Dimension(150, 23));
		chckbxOlives.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		chckbxOlives.setMaximumSize(new Dimension(150, 23));
		chckbxOlives.setAlignmentX(Component.CENTER_ALIGNMENT);
		regularPanel.add(chckbxOlives);
		
		JCheckBox chckbxXtraCheese = new JCheckBox("Extra Cheese");
		chckbxXtraCheese.setMaximumSize(new Dimension(150, 23));
		chckbxXtraCheese.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		chckbxXtraCheese.setAlignmentX(Component.CENTER_ALIGNMENT);
		regularPanel.add(chckbxXtraCheese);
		
		JCheckBox chckbxChicken = new JCheckBox("Chicken");
		chckbxChicken.setMaximumSize(new Dimension(150, 23));
		chckbxChicken.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		chckbxChicken.setAlignmentX(Component.CENTER_ALIGNMENT);
		regularPanel.add(chckbxChicken);
		
		JCheckBox chckbxPeppers = new JCheckBox("Green Peppers");
		chckbxPeppers.setMaximumSize(new Dimension(150, 23));
		chckbxPeppers.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		chckbxPeppers.setAlignmentX(Component.CENTER_ALIGNMENT);
		regularPanel.add(chckbxPeppers);
		
		JCheckBox chckbxHam = new JCheckBox("Ham");
		chckbxHam.setMaximumSize(new Dimension(150, 23));
		chckbxHam.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		chckbxHam.setAlignmentX(Component.CENTER_ALIGNMENT);
		regularPanel.add(chckbxHam);
		
		JCheckBox chckbxShrooms = new JCheckBox("Mushrooms");
		chckbxShrooms.setMaximumSize(new Dimension(150, 23));
		chckbxShrooms.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		chckbxShrooms.setAlignmentX(Component.CENTER_ALIGNMENT);
		regularPanel.add(chckbxShrooms);
		
		JCheckBox chckbxOnions = new JCheckBox("Onions");
		chckbxOnions.setMaximumSize(new Dimension(150, 23));
		chckbxOnions.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		chckbxOnions.setAlignmentX(Component.CENTER_ALIGNMENT);
		regularPanel.add(chckbxOnions);
		
		JCheckBox chckbxPepperoni = new JCheckBox("Pepperoni");
		chckbxPepperoni.setMaximumSize(new Dimension(150, 23));
		chckbxPepperoni.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		chckbxPepperoni.setAlignmentX(Component.CENTER_ALIGNMENT);
		regularPanel.add(chckbxPepperoni);
		
		JCheckBox chckbxPineapple = new JCheckBox("Pineapple");
		chckbxPineapple.setMaximumSize(new Dimension(150, 23));
		chckbxPineapple.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		chckbxPineapple.setAlignmentX(Component.CENTER_ALIGNMENT);
		regularPanel.add(chckbxPineapple);
		
		JCheckBox chckbxSausage = new JCheckBox("Sausage");
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
		
		JComboBox comboSpec = new JComboBox();
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
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Implement adding a pizza
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((JFrame) btnCancel.getTopLevelAncestor()).dispose();
			}
		});
		// END ACTIONS
		
		this.setVisible(true);
	}
}
