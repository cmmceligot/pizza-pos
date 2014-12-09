import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SodaFrame extends JFrame {
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
		
		JSpinner spinner = new JSpinner();
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
	}
}

