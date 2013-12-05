package TraderGui;

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
	private JTextField textFieldUserName;
	private JTextField textFieldPassword;

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
	public LoginView(ActionListener loginListener, ActionListener registerListener) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 50, 50, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblWelcomeToThe = new JLabel("Add your name to login into the market place.");
		GridBagConstraints gbc_lblWelcomeToThe = new GridBagConstraints();
		gbc_lblWelcomeToThe.anchor = GridBagConstraints.WEST;
		gbc_lblWelcomeToThe.gridwidth = 3;
		gbc_lblWelcomeToThe.gridheight = 3;
		gbc_lblWelcomeToThe.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcomeToThe.gridx = 2;
		gbc_lblWelcomeToThe.gridy = 0;
		contentPane.add(lblWelcomeToThe, gbc_lblWelcomeToThe);
			
			JLabel lblName = new JLabel("UserName:");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.WEST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 2;
			gbc_lblName.gridy = 3;
			contentPane.add(lblName, gbc_lblName);
		
			textFieldUserName = new JTextField();
			GridBagConstraints gbc_textFieldUserName = new GridBagConstraints();
			gbc_textFieldUserName.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldUserName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldUserName.gridx = 3;
			gbc_textFieldUserName.gridy = 3;
			contentPane.add(textFieldUserName, gbc_textFieldUserName);
			textFieldUserName.setColumns(10);
		
		JButton buttonConnect = new JButton("Connect");
		buttonConnect.addActionListener(loginListener);
		
		JLabel labelPassword = new JLabel("Password:");
		GridBagConstraints gbc_labelPassword = new GridBagConstraints();
		gbc_labelPassword.anchor = GridBagConstraints.EAST;
		gbc_labelPassword.insets = new Insets(0, 0, 5, 5);
		gbc_labelPassword.gridx = 2;
		gbc_labelPassword.gridy = 5;
		contentPane.add(labelPassword, gbc_labelPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		GridBagConstraints gbc_textFieldPassword = new GridBagConstraints();
		gbc_textFieldPassword.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPassword.gridx = 3;
		gbc_textFieldPassword.gridy = 5;
		contentPane.add(textFieldPassword, gbc_textFieldPassword);
		
		JButton buttonRegister = new JButton("Register");
		buttonRegister.addActionListener(registerListener);
		GridBagConstraints gbc_buttonRegister = new GridBagConstraints();
		gbc_buttonRegister.insets = new Insets(0, 0, 5, 5);
		gbc_buttonRegister.gridx = 2;
		gbc_buttonRegister.gridy = 7;
		contentPane.add(buttonRegister, gbc_buttonRegister);
		GridBagConstraints gbc_buttonConnect = new GridBagConstraints();
		gbc_buttonConnect.anchor = GridBagConstraints.EAST;
		gbc_buttonConnect.insets = new Insets(0, 0, 5, 5);
		gbc_buttonConnect.gridx = 3;
		gbc_buttonConnect.gridy = 7;
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
	
	public String getPassword(){
		return textFieldPassword.getText();
	}

	public void deleteTextFields() {
		textFieldUserName.setText("");
		textFieldPassword.setText("");
	}
}
