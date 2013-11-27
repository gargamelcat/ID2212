package TraderGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import TraderGui.MainController.SellItemListener;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JLabel labelUserName;
	private ProductModel productModel;
	private JScrollPane scrollPane;
	private JTable tableProduct;
	private JLabel label;
	private JTextField textFieldItemPrice;
	private JTextField textFieldItemName;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// MainView frame = new MainView();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView(ActionListener buyItemListener,
			ActionListener sellItemListener, ActionListener exitListener, ProductModel productModel) {
		this.productModel = productModel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 205, 0, 68, 0, 0, 3 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, -9, 0, 0, 0, 0, 38, 0, 0, 0, 0, 0, 0, 0, 3 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel labelTitle = new JLabel("Marketplace");
		GridBagConstraints gbc_labelTitle = new GridBagConstraints();
		gbc_labelTitle.anchor = GridBagConstraints.WEST;
		gbc_labelTitle.insets = new Insets(0, 0, 5, 5);
		gbc_labelTitle.gridx = 1;
		gbc_labelTitle.gridy = 0;
		contentPane.add(labelTitle, gbc_labelTitle);
				
						labelUserName = new JLabel("User name:");
						GridBagConstraints gbc_labelUserName = new GridBagConstraints();
						gbc_labelUserName.anchor = GridBagConstraints.WEST;
						gbc_labelUserName.insets = new Insets(0, 0, 5, 5);
						gbc_labelUserName.gridx = 1;
						gbc_labelUserName.gridy = 2;
						contentPane.add(labelUserName, gbc_labelUserName);
				
				label = new JLabel("");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 1;
				gbc_label.gridy = 4;
				contentPane.add(label, gbc_label);
		
		lblNewLabel = new JLabel("Item to sell:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 5;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Name:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 6;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textFieldItemName = new JTextField();
		textFieldItemName.setColumns(10);
		GridBagConstraints gbc_textFieldItemName = new GridBagConstraints();
		gbc_textFieldItemName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldItemName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldItemName.gridx = 2;
		gbc_textFieldItemName.gridy = 6;
		contentPane.add(textFieldItemName, gbc_textFieldItemName);
		
		lblPrice = new JLabel("Price:");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.anchor = GridBagConstraints.WEST;
		gbc_lblPrice.gridx = 1;
		gbc_lblPrice.gridy = 7;
		contentPane.add(lblPrice, gbc_lblPrice);
		
		textFieldItemPrice = new JTextField();
		GridBagConstraints gbc_textFieldItemPrice = new GridBagConstraints();
		gbc_textFieldItemPrice.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldItemPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldItemPrice.gridx = 2;
		gbc_textFieldItemPrice.gridy = 7;
		contentPane.add(textFieldItemPrice, gbc_textFieldItemPrice);
		textFieldItemPrice.setColumns(10);
		
				JButton buttonSellItem = new JButton("Sell item");
				buttonSellItem.addActionListener(sellItemListener);
				GridBagConstraints gbc_buttonSellItem = new GridBagConstraints();
				gbc_buttonSellItem.insets = new Insets(0, 0, 5, 5);
				gbc_buttonSellItem.gridx = 4;
				gbc_buttonSellItem.gridy = 7;
				contentPane.add(buttonSellItem, gbc_buttonSellItem);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 9;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		tableProduct = new JTable(productModel);
		scrollPane.setViewportView(tableProduct);

		JButton buttonBuyItem = new JButton("Buy selected item");
		buttonBuyItem.addActionListener(buyItemListener);
		GridBagConstraints gbc_buttonBuyItem = new GridBagConstraints();
		gbc_buttonBuyItem.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBuyItem.gridx = 4;
		gbc_buttonBuyItem.gridy = 9;
		contentPane.add(buttonBuyItem, gbc_buttonBuyItem);
								
										JButton buttonExit = new JButton("Exit");
										buttonExit.addActionListener(exitListener);
										GridBagConstraints gbc_buttonExit = new GridBagConstraints();
										gbc_buttonExit.insets = new Insets(0, 0, 5, 5);
										gbc_buttonExit.gridx = 4;
										gbc_buttonExit.gridy = 11;
										contentPane.add(buttonExit, gbc_buttonExit);
	}

	public void setUserName(String userName) {

		labelUserName.setText("UserName: " + userName);
	}
	
	public String getProductName(){
		return textFieldItemName.getText();
	}
	
	public int getProductPrice(){
		return Integer.parseInt(textFieldItemPrice.getText());
	}
	
	public int getSelectedRow(){
		return tableProduct.getSelectedRow();
	}
}
