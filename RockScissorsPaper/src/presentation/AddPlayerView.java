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
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPlayerView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIpAddressTwo;
	private JTextField textFieldIpAddressThree;
	private JTextField textFieldIpAddressFour;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label;
	private JTextField textFieldIpAddressOne;
	private JTextField textFieldPort;
	private JTextField textFieldUserName;
	private JButton buttonCancel;
	private JLabel lblPleaseEnterThe;
	private JLabel lblIfYouAdd;
	private JButton buttonAddPlayer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// addPlayerView frame = new addPlayerView();
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
	public AddPlayerView(ActionListener addFriendListener,
			ActionListener cancelListener) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 51, 2, 50, 0, 50,
				0, 50, 53, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		lblPleaseEnterThe = new JLabel(
				"Please enter the information about your friend.");
		GridBagConstraints gbc_lblPleaseEnterThe = new GridBagConstraints();
		gbc_lblPleaseEnterThe.anchor = GridBagConstraints.WEST;
		gbc_lblPleaseEnterThe.gridwidth = 10;
		gbc_lblPleaseEnterThe.insets = new Insets(0, 0, 5, 5);
		gbc_lblPleaseEnterThe.gridx = 1;
		gbc_lblPleaseEnterThe.gridy = 1;
		contentPane.add(lblPleaseEnterThe, gbc_lblPleaseEnterThe);

		lblIfYouAdd = new JLabel(
				"If you add a friend, the current game will be stopped.");
		GridBagConstraints gbc_lblIfYouAdd = new GridBagConstraints();
		gbc_lblIfYouAdd.gridwidth = 10;
		gbc_lblIfYouAdd.insets = new Insets(0, 0, 5, 5);
		gbc_lblIfYouAdd.gridx = 1;
		gbc_lblIfYouAdd.gridy = 2;
		contentPane.add(lblIfYouAdd, gbc_lblIfYouAdd);

		JLabel labelUserName = new JLabel("User name:");
		GridBagConstraints gbc_labelUserName = new GridBagConstraints();
		gbc_labelUserName.anchor = GridBagConstraints.WEST;
		gbc_labelUserName.insets = new Insets(0, 0, 5, 5);
		gbc_labelUserName.gridx = 1;
		gbc_labelUserName.gridy = 4;
		contentPane.add(labelUserName, gbc_labelUserName);

		textFieldUserName = new JTextField();
		textFieldUserName.setColumns(10);
		GridBagConstraints gbc_textFieldUserName = new GridBagConstraints();
		gbc_textFieldUserName.gridwidth = 7;
		gbc_textFieldUserName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUserName.gridx = 3;
		gbc_textFieldUserName.gridy = 4;
		contentPane.add(textFieldUserName, gbc_textFieldUserName);

		JLabel labelIpAddress = new JLabel("IP address");
		GridBagConstraints gbc_labelIpAddress = new GridBagConstraints();
		gbc_labelIpAddress.anchor = GridBagConstraints.WEST;
		gbc_labelIpAddress.insets = new Insets(0, 0, 5, 5);
		gbc_labelIpAddress.gridx = 1;
		gbc_labelIpAddress.gridy = 6;
		contentPane.add(labelIpAddress, gbc_labelIpAddress);

		textFieldIpAddressOne = new JTextField();
		textFieldIpAddressOne.setColumns(10);
		GridBagConstraints gbc_textFieldIpAddressOne = new GridBagConstraints();
		gbc_textFieldIpAddressOne.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIpAddressOne.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIpAddressOne.gridx = 3;
		gbc_textFieldIpAddressOne.gridy = 6;
		contentPane.add(textFieldIpAddressOne, gbc_textFieldIpAddressOne);

		label = new JLabel(".");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 4;
		gbc_label.gridy = 6;
		contentPane.add(label, gbc_label);

		textFieldIpAddressTwo = new JTextField();
		textFieldIpAddressTwo.setColumns(10);
		GridBagConstraints gbc_textFieldIpAddressTwo = new GridBagConstraints();
		gbc_textFieldIpAddressTwo.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIpAddressTwo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIpAddressTwo.gridx = 5;
		gbc_textFieldIpAddressTwo.gridy = 6;
		contentPane.add(textFieldIpAddressTwo, gbc_textFieldIpAddressTwo);

		label_1 = new JLabel(".");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.gridx = 6;
		gbc_label_1.gridy = 6;
		contentPane.add(label_1, gbc_label_1);

		textFieldIpAddressThree = new JTextField();
		textFieldIpAddressThree.setColumns(10);
		GridBagConstraints gbc_textFieldIpAddressThree = new GridBagConstraints();
		gbc_textFieldIpAddressThree.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIpAddressThree.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIpAddressThree.gridx = 7;
		gbc_textFieldIpAddressThree.gridy = 6;
		contentPane.add(textFieldIpAddressThree, gbc_textFieldIpAddressThree);

		label_2 = new JLabel(".");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.gridx = 8;
		gbc_label_2.gridy = 6;
		contentPane.add(label_2, gbc_label_2);

		textFieldIpAddressFour = new JTextField();
		textFieldIpAddressFour.setColumns(10);
		GridBagConstraints gbc_textFieldIpAddressFour = new GridBagConstraints();
		gbc_textFieldIpAddressFour.anchor = GridBagConstraints.BASELINE;
		gbc_textFieldIpAddressFour.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIpAddressFour.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIpAddressFour.gridx = 9;
		gbc_textFieldIpAddressFour.gridy = 6;
		contentPane.add(textFieldIpAddressFour, gbc_textFieldIpAddressFour);

		JLabel labelPort = new JLabel("Port:");
		GridBagConstraints gbc_labelPort = new GridBagConstraints();
		gbc_labelPort.anchor = GridBagConstraints.WEST;
		gbc_labelPort.insets = new Insets(0, 0, 5, 5);
		gbc_labelPort.gridx = 1;
		gbc_labelPort.gridy = 8;
		contentPane.add(labelPort, gbc_labelPort);

		textFieldPort = new JTextField();
		GridBagConstraints gbc_textFieldPort = new GridBagConstraints();
		gbc_textFieldPort.gridwidth = 7;
		gbc_textFieldPort.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPort.gridx = 3;
		gbc_textFieldPort.gridy = 8;
		contentPane.add(textFieldPort, gbc_textFieldPort);
		textFieldPort.setColumns(10);

		buttonCancel = new JButton("Cancel");
		buttonCancel.addActionListener(cancelListener);
		GridBagConstraints gbc_buttonCancel = new GridBagConstraints();
		gbc_buttonCancel.gridwidth = 3;
		gbc_buttonCancel.insets = new Insets(0, 0, 5, 5);
		gbc_buttonCancel.gridx = 3;
		gbc_buttonCancel.gridy = 10;
		contentPane.add(buttonCancel, gbc_buttonCancel);

		buttonAddPlayer = new JButton("Add Player");
		buttonAddPlayer.addActionListener(addFriendListener);
		GridBagConstraints gbc_buttonAddPlayer = new GridBagConstraints();
		gbc_buttonAddPlayer.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_buttonAddPlayer.gridwidth = 3;
		gbc_buttonAddPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_buttonAddPlayer.gridx = 7;
		gbc_buttonAddPlayer.gridy = 10;
		contentPane.add(buttonAddPlayer, gbc_buttonAddPlayer);
	}

	public String getUserName() {
		return textFieldUserName.getText();
	}

	public String getIpAddress() {
		return textFieldIpAddressOne.getText() + "." + textFieldIpAddressTwo.getText() + "." + textFieldIpAddressThree.getText() + "." + textFieldIpAddressFour.getText();
	}

	public String getPort() {
		return textFieldPort.getText();
	}
}
