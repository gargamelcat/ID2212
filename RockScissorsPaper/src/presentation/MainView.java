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
import javax.swing.JScrollPane;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JLabel labelUserName;
	private JLabel labelIpAddress;
	private JLabel labelPort;
	private JRadioButton radioButtonRock;
	private JRadioButton radioButtonScissors;
	private JRadioButton radioButtonPaper;
	private PlayerListModel playerListModel;
	private JScrollPane scrollPane;
	private JTable tableResult;

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
		this.playerListModel = playerListModel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 205, 68, 0, 3 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel labelTitle = new JLabel("Let's play!");
		GridBagConstraints gbc_labelTitle = new GridBagConstraints();
		gbc_labelTitle.insets = new Insets(0, 0, 5, 5);
		gbc_labelTitle.gridx = 0;
		gbc_labelTitle.gridy = 0;
		contentPane.add(labelTitle, gbc_labelTitle);

		labelUserName = new JLabel("User name:");
		GridBagConstraints gbc_labelUserName = new GridBagConstraints();
		gbc_labelUserName.anchor = GridBagConstraints.WEST;
		gbc_labelUserName.insets = new Insets(0, 0, 5, 5);
		gbc_labelUserName.gridx = 0;
		gbc_labelUserName.gridy = 1;
		contentPane.add(labelUserName, gbc_labelUserName);

		labelIpAddress = new JLabel("IP address:");
		GridBagConstraints gbc_labelIpAddress = new GridBagConstraints();
		gbc_labelIpAddress.anchor = GridBagConstraints.WEST;
		gbc_labelIpAddress.insets = new Insets(0, 0, 5, 5);
		gbc_labelIpAddress.gridx = 0;
		gbc_labelIpAddress.gridy = 2;
		contentPane.add(labelIpAddress, gbc_labelIpAddress);

		labelPort = new JLabel("Port:");
		GridBagConstraints gbc_labelPort = new GridBagConstraints();
		gbc_labelPort.anchor = GridBagConstraints.WEST;
		gbc_labelPort.insets = new Insets(0, 0, 5, 5);
		gbc_labelPort.gridx = 0;
		gbc_labelPort.gridy = 3;
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
		gbc_radioButtonRock.gridx = 0;
		gbc_radioButtonRock.gridy = 4;
		contentPane.add(radioButtonRock, gbc_radioButtonRock);

		JButton buttonPlayMove = new JButton("Play Move!!");
		buttonPlayMove.addActionListener(playMoveListener);
		GridBagConstraints gbc_buttonPlayMove = new GridBagConstraints();
		gbc_buttonPlayMove.insets = new Insets(0, 0, 5, 5);
		gbc_buttonPlayMove.gridx = 1;
		gbc_buttonPlayMove.gridy = 4;
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
		gbc_radioButtonScissors.gridx = 0;
		gbc_radioButtonScissors.gridy = 5;
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
		gbc_radioButtonPaper.gridx = 0;
		gbc_radioButtonPaper.gridy = 6;
		contentPane.add(radioButtonPaper, gbc_radioButtonPaper);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 7;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		tableResult = new JTable(playerListModel);
		scrollPane.setViewportView(tableResult);

		JButton buttonAddPlayer = new JButton("Add Player");
		buttonAddPlayer.addActionListener(addPlayerListener);
		GridBagConstraints gbc_buttonAddPlayer = new GridBagConstraints();
		gbc_buttonAddPlayer.insets = new Insets(0, 0, 5, 0);
		gbc_buttonAddPlayer.gridx = 2;
		gbc_buttonAddPlayer.gridy = 7;
		contentPane.add(buttonAddPlayer, gbc_buttonAddPlayer);
								
										JButton buttonExit = new JButton("Exit");
										buttonExit.addActionListener(exitListener);
										GridBagConstraints gbc_buttonExit = new GridBagConstraints();
										gbc_buttonExit.insets = new Insets(0, 0, 5, 0);
										gbc_buttonExit.gridx = 2;
										gbc_buttonExit.gridy = 9;
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
	
	public void updateTable(){
		tableResult.updateUI();
	}
}
