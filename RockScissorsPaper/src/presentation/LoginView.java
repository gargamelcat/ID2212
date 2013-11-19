package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPort;
	private JTextField textFieldIpAddress;
	private JTextField textFieldUserName;
	private final Action action = new SwingAction();

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
		setBounds(100, 100, 434, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Rock, Paper and Scissors P2P !");
		GridBagConstraints gbc_lblWelcomeToThe = new GridBagConstraints();
		gbc_lblWelcomeToThe.gridwidth = 3;
		gbc_lblWelcomeToThe.gridheight = 2;
		gbc_lblWelcomeToThe.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcomeToThe.gridx = 2;
		gbc_lblWelcomeToThe.gridy = 0;
		contentPane.add(lblWelcomeToThe, gbc_lblWelcomeToThe);
		
		JLabel lblName = new JLabel("UserName");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 2;
		gbc_lblName.gridy = 2;
		contentPane.add(lblName, gbc_lblName);
		
		textFieldUserName = new JTextField();
		GridBagConstraints gbc_textFieldUserName = new GridBagConstraints();
		gbc_textFieldUserName.anchor = GridBagConstraints.WEST;
		gbc_textFieldUserName.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUserName.gridx = 4;
		gbc_textFieldUserName.gridy = 2;
		contentPane.add(textFieldUserName, gbc_textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JLabel lblIp = new JLabel("IP");
		GridBagConstraints gbc_lblIp = new GridBagConstraints();
		gbc_lblIp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIp.gridx = 2;
		gbc_lblIp.gridy = 4;
		contentPane.add(lblIp, gbc_lblIp);
		
		textFieldIpAddress = new JTextField();
		GridBagConstraints gbc_textFieldIpAddress = new GridBagConstraints();
		gbc_textFieldIpAddress.anchor = GridBagConstraints.WEST;
		gbc_textFieldIpAddress.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldIpAddress.gridx = 4;
		gbc_textFieldIpAddress.gridy = 4;
		contentPane.add(textFieldIpAddress, gbc_textFieldIpAddress);
		textFieldIpAddress.setColumns(10);
		
		JLabel lblPort = new JLabel("Port");
		GridBagConstraints gbc_lblPort = new GridBagConstraints();
		gbc_lblPort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPort.gridx = 2;
		gbc_lblPort.gridy = 6;
		contentPane.add(lblPort, gbc_lblPort);
		
		textFieldPort = new JTextField();
		GridBagConstraints gbc_textFieldPort = new GridBagConstraints();
		gbc_textFieldPort.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPort.anchor = GridBagConstraints.WEST;
		gbc_textFieldPort.gridx = 4;
		gbc_textFieldPort.gridy = 6;
		contentPane.add(textFieldPort, gbc_textFieldPort);
		textFieldPort.setColumns(10);
		
		JButton btnConnect = new JButton("CONNECT");
		btnConnect.addActionListener(connectListener);
		
		JButton btnPlayAgainsIa = new JButton("Play Agains IA");
		btnPlayAgainsIa.addActionListener(connectListener);
		btnPlayAgainsIa.setFont(new Font("Dialog", Font.BOLD, 10));
		GridBagConstraints gbc_btnPlayAgainsIa = new GridBagConstraints();
		gbc_btnPlayAgainsIa.insets = new Insets(0, 0, 5, 5);
		gbc_btnPlayAgainsIa.anchor = GridBagConstraints.WEST;
		gbc_btnPlayAgainsIa.gridx = 2;
		gbc_btnPlayAgainsIa.gridy = 8;
		contentPane.add(btnPlayAgainsIa, gbc_btnPlayAgainsIa);
		GridBagConstraints gbc_btnConnect = new GridBagConstraints();
		gbc_btnConnect.insets = new Insets(0, 0, 5, 0);
		gbc_btnConnect.anchor = GridBagConstraints.WEST;
		gbc_btnConnect.gridx = 4;
		gbc_btnConnect.gridy = 8;
		contentPane.add(btnConnect, gbc_btnConnect);
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
		return textFieldIpAddress.getText();
	}
	
	public String getPort(){
		return textFieldPort.getText();
	}
}
