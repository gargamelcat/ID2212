package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingConstants;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private JTextField textFieldIpAddressOne;
	private JTextField textFieldIpAddressTwo;
	private JTextField textFieldIpAddressThree;
	private JTextField textFieldIpAddressFour;
	private JTextField textFieldUserName;
	private JTextField textFieldPort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//LoginView frame = new LoginView();
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
	public LoginView(ActionListener connectListener) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 50, 0, 50, 0, 50, 0, 50, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Rock, Paper and Scissors P2P !");
		GridBagConstraints gbc_lblWelcomeToThe = new GridBagConstraints();
		gbc_lblWelcomeToThe.anchor = GridBagConstraints.WEST;
		gbc_lblWelcomeToThe.gridwidth = 9;
		gbc_lblWelcomeToThe.gridheight = 2;
		gbc_lblWelcomeToThe.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcomeToThe.gridx = 2;
		gbc_lblWelcomeToThe.gridy = 0;
		contentPane.add(lblWelcomeToThe, gbc_lblWelcomeToThe);
		
		JLabel lblName = new JLabel("UserName:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 2;
		gbc_lblName.gridy = 2;
		contentPane.add(lblName, gbc_lblName);
	
		textFieldUserName = new JTextField();
		GridBagConstraints gbc_textFieldUserName = new GridBagConstraints();
		gbc_textFieldUserName.gridwidth = 7;
		gbc_textFieldUserName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUserName.gridx = 3;
		gbc_textFieldUserName.gridy = 2;
		contentPane.add(textFieldUserName, gbc_textFieldUserName);
		textFieldUserName.setColumns(10);
		textFieldUserName.setDocument(new JTextFieldLimit(10));
		
		JLabel lblIp = new JLabel("IP address:");
		GridBagConstraints gbc_lblIp = new GridBagConstraints();
		gbc_lblIp.anchor = GridBagConstraints.WEST;
		gbc_lblIp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIp.gridx = 2;
		gbc_lblIp.gridy = 4;
		contentPane.add(lblIp, gbc_lblIp);
		
		textFieldIpAddressOne = new JTextField();
		GridBagConstraints gbc_textFieldIpAddressOne = new GridBagConstraints();
		gbc_textFieldIpAddressOne.anchor = GridBagConstraints.NORTH;
		gbc_textFieldIpAddressOne.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIpAddressOne.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIpAddressOne.gridx = 3;
		gbc_textFieldIpAddressOne.gridy = 4;
		contentPane.add(textFieldIpAddressOne, gbc_textFieldIpAddressOne);
		textFieldIpAddressOne.setColumns(10);
		
		JLabel label = new JLabel(".");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 4;
		gbc_label.gridy = 4;
		contentPane.add(label, gbc_label);
		
		textFieldIpAddressTwo = new JTextField();
		textFieldIpAddressTwo.setColumns(10);
		GridBagConstraints gbc_textFieldIpAddressTwo = new GridBagConstraints();
		gbc_textFieldIpAddressTwo.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIpAddressTwo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIpAddressTwo.gridx = 5;
		gbc_textFieldIpAddressTwo.gridy = 4;
		contentPane.add(textFieldIpAddressTwo, gbc_textFieldIpAddressTwo);
		
		JLabel label_1 = new JLabel(".");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.gridx = 6;
		gbc_label_1.gridy = 4;
		contentPane.add(label_1, gbc_label_1);
		
		textFieldIpAddressThree = new JTextField();
		textFieldIpAddressThree.setColumns(10);
		GridBagConstraints gbc_textFieldIpAddressThree = new GridBagConstraints();
		gbc_textFieldIpAddressThree.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIpAddressThree.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIpAddressThree.gridx = 7;
		gbc_textFieldIpAddressThree.gridy = 4;
		contentPane.add(textFieldIpAddressThree, gbc_textFieldIpAddressThree);
		
		JLabel label_2 = new JLabel(".");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.gridx = 8;
		gbc_label_2.gridy = 4;
		contentPane.add(label_2, gbc_label_2);
		
		textFieldIpAddressFour = new JTextField();
		textFieldIpAddressFour.setColumns(10);
		GridBagConstraints gbc_textFieldIpAddressFour = new GridBagConstraints();
		gbc_textFieldIpAddressFour.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIpAddressFour.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIpAddressFour.gridx = 9;
		gbc_textFieldIpAddressFour.gridy = 4;
		contentPane.add(textFieldIpAddressFour, gbc_textFieldIpAddressFour);
		
		JLabel lblPort = new JLabel("Port:");
		GridBagConstraints gbc_lblPort = new GridBagConstraints();
		gbc_lblPort.anchor = GridBagConstraints.WEST;
		gbc_lblPort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPort.gridx = 2;
		gbc_lblPort.gridy = 6;
		contentPane.add(lblPort, gbc_lblPort);
	
		textFieldPort = new JTextField();
		textFieldPort.setColumns(10);
		GridBagConstraints gbc_textFieldPort = new GridBagConstraints();
		gbc_textFieldPort.anchor = GridBagConstraints.NORTH;
		gbc_textFieldPort.gridwidth = 7;
		gbc_textFieldPort.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPort.gridx = 3;
		gbc_textFieldPort.gridy = 6;
		contentPane.add(textFieldPort, gbc_textFieldPort);
		
		JButton buttonConnect = new JButton("Connect");
		buttonConnect.addActionListener(connectListener);
		GridBagConstraints gbc_buttonConnect = new GridBagConstraints();
		gbc_buttonConnect.anchor = GridBagConstraints.EAST;
		gbc_buttonConnect.gridwidth = 3;
		gbc_buttonConnect.insets = new Insets(0, 0, 5, 5);
		gbc_buttonConnect.gridx = 7;
		gbc_buttonConnect.gridy = 8;
		contentPane.add(buttonConnect, gbc_buttonConnect);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	public String getUserName(){
		return textFieldUserName.getText();
	}
	
	public String getIpAddress(){
		String ipAddress = textFieldIpAddressOne.getText() + "." + textFieldIpAddressTwo.getText() + "." + textFieldIpAddressThree.getText() + "." + textFieldIpAddressFour.getText();
		return ipAddress;
	}
	
	public String getPort(){
		return textFieldPort.getText();
	}
}
