package presentation;

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

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTable tableResult;
	private JLabel labelUserName;
	private JLabel labelIpAddress;
	private JLabel labelPort;
	private JRadioButton radioButtonRock;
	private JRadioButton radioButtonScissors;
	private JRadioButton radioButtonPaper;

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
	public MainView(ActionListener playMoveListener,
			ActionListener addPlayerListener, ActionListener exitListener, PlayerListModel playerListModel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 83, 205, 68, 0, 0, 0, 0, 3 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				50, 0, 0, 0, 0, 0, 3 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel labelTitle = new JLabel("Let's play!");
		GridBagConstraints gbc_labelTitle = new GridBagConstraints();
		gbc_labelTitle.insets = new Insets(0, 0, 5, 5);
		gbc_labelTitle.gridx = 1;
		gbc_labelTitle.gridy = 1;
		contentPane.add(labelTitle, gbc_labelTitle);

		labelUserName = new JLabel("User name:");
		GridBagConstraints gbc_labelUserName = new GridBagConstraints();
		gbc_labelUserName.anchor = GridBagConstraints.WEST;
		gbc_labelUserName.insets = new Insets(0, 0, 5, 5);
		gbc_labelUserName.gridx = 1;
		gbc_labelUserName.gridy = 3;
		contentPane.add(labelUserName, gbc_labelUserName);

		labelIpAddress = new JLabel("IP address:");
		GridBagConstraints gbc_labelIpAddress = new GridBagConstraints();
		gbc_labelIpAddress.anchor = GridBagConstraints.WEST;
		gbc_labelIpAddress.insets = new Insets(0, 0, 5, 5);
		gbc_labelIpAddress.gridx = 1;
		gbc_labelIpAddress.gridy = 4;
		contentPane.add(labelIpAddress, gbc_labelIpAddress);

		labelPort = new JLabel("Port:");
		GridBagConstraints gbc_labelPort = new GridBagConstraints();
		gbc_labelPort.anchor = GridBagConstraints.WEST;
		gbc_labelPort.insets = new Insets(0, 0, 5, 5);
		gbc_labelPort.gridx = 1;
		gbc_labelPort.gridy = 5;
		contentPane.add(labelPort, gbc_labelPort);

		radioButtonRock = new JRadioButton("Rock");
		radioButtonRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				radioButtonScissors.setSelected(false);
				radioButtonPaper.setSelected(false);
			}
		});
		radioButtonRock.setSelected(true);
		GridBagConstraints gbc_radioButtonRock = new GridBagConstraints();
		gbc_radioButtonRock.anchor = GridBagConstraints.WEST;
		gbc_radioButtonRock.insets = new Insets(0, 0, 5, 5);
		gbc_radioButtonRock.gridx = 1;
		gbc_radioButtonRock.gridy = 7;
		contentPane.add(radioButtonRock, gbc_radioButtonRock);

		JButton buttonPlayMove = new JButton("Play Move!!");
		buttonPlayMove.addActionListener(playMoveListener);
		GridBagConstraints gbc_buttonPlayMove = new GridBagConstraints();
		gbc_buttonPlayMove.insets = new Insets(0, 0, 5, 5);
		gbc_buttonPlayMove.gridx = 2;
		gbc_buttonPlayMove.gridy = 7;
		contentPane.add(buttonPlayMove, gbc_buttonPlayMove);

		radioButtonScissors = new JRadioButton("Scissors");
		radioButtonScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButtonRock.setSelected(false);
				radioButtonPaper.setSelected(false);
			}
		});
		GridBagConstraints gbc_radioButtonScissors = new GridBagConstraints();
		gbc_radioButtonScissors.anchor = GridBagConstraints.WEST;
		gbc_radioButtonScissors.insets = new Insets(0, 0, 5, 5);
		gbc_radioButtonScissors.gridx = 1;
		gbc_radioButtonScissors.gridy = 8;
		contentPane.add(radioButtonScissors, gbc_radioButtonScissors);

		radioButtonPaper = new JRadioButton("Paper");
		radioButtonPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButtonRock.setSelected(false);
				radioButtonScissors.setSelected(false);
			}
		});
		GridBagConstraints gbc_radioButtonPaper = new GridBagConstraints();
		gbc_radioButtonPaper.anchor = GridBagConstraints.WEST;
		gbc_radioButtonPaper.insets = new Insets(0, 0, 5, 5);
		gbc_radioButtonPaper.gridx = 1;
		gbc_radioButtonPaper.gridy = 9;
		contentPane.add(radioButtonPaper, gbc_radioButtonPaper);

		tableResult = new JTable(playerListModel);
		GridBagConstraints gbc_tableResult = new GridBagConstraints();
		gbc_tableResult.gridwidth = 3;
		gbc_tableResult.insets = new Insets(0, 0, 5, 5);
		gbc_tableResult.fill = GridBagConstraints.BOTH;
		gbc_tableResult.gridx = 1;
		gbc_tableResult.gridy = 11;
		contentPane.add(tableResult, gbc_tableResult);

		JButton buttonAddPlayer = new JButton("Add Player");
		buttonAddPlayer.addActionListener(addPlayerListener);
		GridBagConstraints gbc_buttonAddPlayer = new GridBagConstraints();
		gbc_buttonAddPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_buttonAddPlayer.gridx = 5;
		gbc_buttonAddPlayer.gridy = 11;
		contentPane.add(buttonAddPlayer, gbc_buttonAddPlayer);

		JButton buttonExit = new JButton("Exit");
		buttonExit.addActionListener(exitListener);
		GridBagConstraints gbc_buttonExit = new GridBagConstraints();
		gbc_buttonExit.insets = new Insets(0, 0, 5, 5);
		gbc_buttonExit.gridx = 5;
		gbc_buttonExit.gridy = 13;
		contentPane.add(buttonExit, gbc_buttonExit);
	}

	public void setUserName(String userName) {

		labelUserName.setText("UserName: " + userName);
	}

	public void setIpAddress(String ipAddress) {
		labelIpAddress.setText("IP address: " + ipAddress);

	}

	public void setPort(String port) {
		labelPort.setText("Port: " + port);

	}

	public boolean isRockSelected() {
		return radioButtonRock.isSelected();
	}

	public boolean isScissorsSelected() {
		return radioButtonScissors.isSelected();
	}

	public boolean isPaperSelected() {
		return radioButtonPaper.isSelected();
	}
}
