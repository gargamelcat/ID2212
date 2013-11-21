package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddFriendView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAddrOne;
	private JTextField textFieldaddrTwo;
	private JTextField textFieldAddrThree;
	private JTextField textFieldAddrFour;
	private JTextField textFieldName;
	private JTextField textFieldPort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AddFriendView frame = new AddFriendView();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddFriendView(ActionListener addFriendListener, ActionListener cancelListener) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblInfo = new JLabel("Pleas enter information about your friend:");
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.gridwidth = 10;
		gbc_lblInfo.anchor = GridBagConstraints.WEST;
		gbc_lblInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblInfo.gridx = 1;
		gbc_lblInfo.gridy = 1;
		contentPane.add(lblInfo, gbc_lblInfo);
		
		JLabel lblRunningGameWill = new JLabel("Running game will be stopped if you add a friend.");
		GridBagConstraints gbc_lblRunningGameWill = new GridBagConstraints();
		gbc_lblRunningGameWill.gridwidth = 10;
		gbc_lblRunningGameWill.insets = new Insets(0, 0, 5, 5);
		gbc_lblRunningGameWill.gridx = 1;
		gbc_lblRunningGameWill.gridy = 2;
		contentPane.add(lblRunningGameWill, gbc_lblRunningGameWill);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 4;
		contentPane.add(lblName, gbc_lblName);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.gridwidth = 7;
		gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldName.gridx = 3;
		gbc_textFieldName.gridy = 4;
		contentPane.add(textFieldName, gbc_textFieldName);
		
		JLabel lblIpAddress = new JLabel("Ip address:");
		GridBagConstraints gbc_lblIpAddress = new GridBagConstraints();
		gbc_lblIpAddress.anchor = GridBagConstraints.WEST;
		gbc_lblIpAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblIpAddress.gridx = 1;
		gbc_lblIpAddress.gridy = 6;
		contentPane.add(lblIpAddress, gbc_lblIpAddress);
		
		textFieldAddrOne = new JTextField();
		GridBagConstraints gbc_textFieldAddrOne = new GridBagConstraints();
		gbc_textFieldAddrOne.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAddrOne.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAddrOne.gridx = 3;
		gbc_textFieldAddrOne.gridy = 6;
		contentPane.add(textFieldAddrOne, gbc_textFieldAddrOne);
		textFieldAddrOne.setColumns(10);
		
		JLabel label = new JLabel(".");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 4;
		gbc_label.gridy = 6;
		contentPane.add(label, gbc_label);
		
		textFieldaddrTwo = new JTextField();
		textFieldaddrTwo.setColumns(10);
		GridBagConstraints gbc_textFieldaddrTwo = new GridBagConstraints();
		gbc_textFieldaddrTwo.anchor = GridBagConstraints.NORTH;
		gbc_textFieldaddrTwo.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldaddrTwo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldaddrTwo.gridx = 5;
		gbc_textFieldaddrTwo.gridy = 6;
		contentPane.add(textFieldaddrTwo, gbc_textFieldaddrTwo);
		
		JLabel label_1 = new JLabel(".");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.gridx = 6;
		gbc_label_1.gridy = 6;
		contentPane.add(label_1, gbc_label_1);
		
		textFieldAddrThree = new JTextField();
		textFieldAddrThree.setColumns(10);
		GridBagConstraints gbc_textFieldAddrThree = new GridBagConstraints();
		gbc_textFieldAddrThree.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAddrThree.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAddrThree.gridx = 7;
		gbc_textFieldAddrThree.gridy = 6;
		contentPane.add(textFieldAddrThree, gbc_textFieldAddrThree);
		
		JLabel label_2 = new JLabel(".");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.gridx = 8;
		gbc_label_2.gridy = 6;
		contentPane.add(label_2, gbc_label_2);
		
		textFieldAddrFour = new JTextField();
		textFieldAddrFour.setColumns(10);
		GridBagConstraints gbc_textFieldAddrFour = new GridBagConstraints();
		gbc_textFieldAddrFour.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAddrFour.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAddrFour.gridx = 9;
		gbc_textFieldAddrFour.gridy = 6;
		contentPane.add(textFieldAddrFour, gbc_textFieldAddrFour);
		
		JLabel lblPort = new JLabel("Port: ");
		GridBagConstraints gbc_lblPort = new GridBagConstraints();
		gbc_lblPort.anchor = GridBagConstraints.WEST;
		gbc_lblPort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPort.gridx = 1;
		gbc_lblPort.gridy = 8;
		contentPane.add(lblPort, gbc_lblPort);
		
		textFieldPort = new JTextField();
		textFieldPort.setColumns(10);
		GridBagConstraints gbc_textFieldPort = new GridBagConstraints();
		gbc_textFieldPort.gridwidth = 7;
		gbc_textFieldPort.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPort.gridx = 3;
		gbc_textFieldPort.gridy = 8;
		contentPane.add(textFieldPort, gbc_textFieldPort);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(cancelListener);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 4;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 10;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton = new JButton("Add friend");
		btnNewButton.addActionListener(addFriendListener);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 7;
		gbc_btnNewButton.gridy = 10;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

	public String getName(){
		return textFieldName.getText();
	}
	
	public String getIpAddress(){
		return textFieldAddrOne.getText() + "." + textFieldaddrTwo.getText() + "." + textFieldAddrThree.getText() + "." + textFieldAddrFour.getText();
	}

	public String getPort(){
		return textFieldPort.getText();
	}
}
