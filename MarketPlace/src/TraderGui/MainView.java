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
import javax.swing.JTextArea;

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
	private JButton buttonUpdate;
	private JTextArea messageLog;
	private JLabel lblBankName;
	private JLabel lblMoney;
	private JLabel labelBalance;
	private JButton Deposit;
	private JLabel labelBankName;
	private JLabel lblDepositMoney;
	private JTextField textFieldDeposit;

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
			ActionListener sellItemListener, ActionListener exitListener, ActionListener updateListener, ActionListener depositMoneyListener, ProductModel productModel) {
		this.productModel = productModel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 227, 163, 93, 0, 0, 3 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, -9, 0, 0, 0, 0, 0, 0, 38, 33, 0, 66, 133, 0, 3 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0,
				0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0,
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
						
						lblBankName = new JLabel("Bank name:");
						GridBagConstraints gbc_lblBankName = new GridBagConstraints();
						gbc_lblBankName.anchor = GridBagConstraints.WEST;
						gbc_lblBankName.insets = new Insets(0, 0, 5, 5);
						gbc_lblBankName.gridx = 2;
						gbc_lblBankName.gridy = 2;
						contentPane.add(lblBankName, gbc_lblBankName);
						
						labelBankName = new JLabel("none");
						GridBagConstraints gbc_labelBankName = new GridBagConstraints();
						gbc_labelBankName.insets = new Insets(0, 0, 5, 5);
						gbc_labelBankName.gridx = 3;
						gbc_labelBankName.gridy = 2;
						contentPane.add(labelBankName, gbc_labelBankName);
				
				lblMoney = new JLabel("Balance:");
				GridBagConstraints gbc_lblMoney = new GridBagConstraints();
				gbc_lblMoney.anchor = GridBagConstraints.WEST;
				gbc_lblMoney.insets = new Insets(0, 0, 5, 5);
				gbc_lblMoney.gridx = 2;
				gbc_lblMoney.gridy = 3;
				contentPane.add(lblMoney, gbc_lblMoney);
				
				labelBalance = new JLabel("0");
				GridBagConstraints gbc_labelMoney = new GridBagConstraints();
				gbc_labelMoney.insets = new Insets(0, 0, 5, 5);
				gbc_labelMoney.gridx = 3;
				gbc_labelMoney.gridy = 3;
				contentPane.add(labelBalance, gbc_labelMoney);
				
				lblDepositMoney = new JLabel("Deposit money:");
				GridBagConstraints gbc_lblDepositMoney = new GridBagConstraints();
				gbc_lblDepositMoney.anchor = GridBagConstraints.WEST;
				gbc_lblDepositMoney.insets = new Insets(0, 0, 5, 5);
				gbc_lblDepositMoney.gridx = 2;
				gbc_lblDepositMoney.gridy = 4;
				contentPane.add(lblDepositMoney, gbc_lblDepositMoney);
				
				textFieldDeposit = new JTextField();
				textFieldDeposit.setColumns(10);
				GridBagConstraints gbc_textFieldDeposit = new GridBagConstraints();
				gbc_textFieldDeposit.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldDeposit.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldDeposit.gridx = 3;
				gbc_textFieldDeposit.gridy = 4;
				contentPane.add(textFieldDeposit, gbc_textFieldDeposit);
				
				Deposit = new JButton("Deposit!");
				Deposit.addActionListener(depositMoneyListener);
				GridBagConstraints gbc_Deposit = new GridBagConstraints();
				gbc_Deposit.insets = new Insets(0, 0, 5, 5);
				gbc_Deposit.gridx = 4;
				gbc_Deposit.gridy = 4;
				contentPane.add(Deposit, gbc_Deposit);
				
				label = new JLabel("");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 1;
				gbc_label.gridy = 5;
				contentPane.add(label, gbc_label);
		
		lblNewLabel = new JLabel("Item to sell:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 8;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Name:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 9;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textFieldItemName = new JTextField();
		textFieldItemName.setColumns(10);
		GridBagConstraints gbc_textFieldItemName = new GridBagConstraints();
		gbc_textFieldItemName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldItemName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldItemName.gridx = 2;
		gbc_textFieldItemName.gridy = 9;
		contentPane.add(textFieldItemName, gbc_textFieldItemName);
		
		lblPrice = new JLabel("Price:");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.anchor = GridBagConstraints.WEST;
		gbc_lblPrice.gridx = 1;
		gbc_lblPrice.gridy = 10;
		contentPane.add(lblPrice, gbc_lblPrice);
		
		textFieldItemPrice = new JTextField();
		GridBagConstraints gbc_textFieldItemPrice = new GridBagConstraints();
		gbc_textFieldItemPrice.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldItemPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldItemPrice.gridx = 2;
		gbc_textFieldItemPrice.gridy = 10;
		contentPane.add(textFieldItemPrice, gbc_textFieldItemPrice);
		textFieldItemPrice.setColumns(10);
		
				JButton buttonSellItem = new JButton("Sell item");
				buttonSellItem.addActionListener(sellItemListener);
				GridBagConstraints gbc_buttonSellItem = new GridBagConstraints();
				gbc_buttonSellItem.insets = new Insets(0, 0, 5, 5);
				gbc_buttonSellItem.gridx = 4;
				gbc_buttonSellItem.gridy = 10;
				contentPane.add(buttonSellItem, gbc_buttonSellItem);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 12;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		tableProduct = new JTable(productModel);
		scrollPane.setViewportView(tableProduct);

		JButton buttonBuyItem = new JButton("Buy selected item");
		buttonBuyItem.addActionListener(buyItemListener);
		GridBagConstraints gbc_buttonBuyItem = new GridBagConstraints();
		gbc_buttonBuyItem.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBuyItem.gridx = 4;
		gbc_buttonBuyItem.gridy = 12;
		contentPane.add(buttonBuyItem, gbc_buttonBuyItem);
										
										buttonUpdate = new JButton("Update");
										buttonUpdate.addActionListener(updateListener);
										GridBagConstraints gbc_buttonUpdate = new GridBagConstraints();
										gbc_buttonUpdate.insets = new Insets(0, 0, 5, 5);
										gbc_buttonUpdate.gridx = 4;
										gbc_buttonUpdate.gridy = 13;
										contentPane.add(buttonUpdate, gbc_buttonUpdate);
												
												messageLog = new JTextArea();
												GridBagConstraints gbc_messageLog = new GridBagConstraints();
												gbc_messageLog.gridwidth = 3;
												gbc_messageLog.insets = new Insets(0, 0, 5, 5);
												gbc_messageLog.fill = GridBagConstraints.BOTH;
												gbc_messageLog.gridx = 1;
												gbc_messageLog.gridy = 16;
												contentPane.add(messageLog, gbc_messageLog);
												
														JButton buttonExit = new JButton("Exit");
														buttonExit.addActionListener(exitListener);
														GridBagConstraints gbc_buttonExit = new GridBagConstraints();
														gbc_buttonExit.insets = new Insets(0, 0, 5, 5);
														gbc_buttonExit.gridx = 4;
														gbc_buttonExit.gridy = 16;
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
	
	public void addMessageToLog(String message){
		messageLog.setText(message + "\n" + messageLog.getText());
		//messageLog.repaint();
	}
	
	public void setBankName(String bankName){
		labelBankName.setText(bankName);
	}
	
	public void setBalance(int balance){
		labelBalance.setText(Integer.toString(balance));
	}	
	
	public int getDeposit(){
		int deposit = Integer.parseInt(textFieldDeposit.getText());
		return deposit;
	}
	
	public void clearDepositField(){
		textFieldDeposit.setText("");
	}
	
	public void clearProductFields(){
		textFieldItemName.setText("");
		textFieldItemPrice.setText("");
	}
}
