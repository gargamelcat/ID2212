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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WaitingView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//WaitingView frame = new WaitingView();
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
	public WaitingView(ActionListener leaveGameListener, WaitingForPlayerModel waitingForPlayerModel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 202, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEllapsedTime = new JLabel("Time left for this round:");
		GridBagConstraints gbc_lblEllapsedTime = new GridBagConstraints();
		gbc_lblEllapsedTime.anchor = GridBagConstraints.WEST;
		gbc_lblEllapsedTime.gridwidth = 3;
		gbc_lblEllapsedTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblEllapsedTime.gridx = 2;
		gbc_lblEllapsedTime.gridy = 1;
		contentPane.add(lblEllapsedTime, gbc_lblEllapsedTime);
		
		JLabel labelTime = new JLabel("time");
		GridBagConstraints gbc_labelTime = new GridBagConstraints();
		gbc_labelTime.anchor = GridBagConstraints.NORTHWEST;
		gbc_labelTime.insets = new Insets(0, 0, 5, 5);
		gbc_labelTime.gridx = 6;
		gbc_labelTime.gridy = 1;
		contentPane.add(labelTime, gbc_labelTime);
		
		JLabel lblYouAreWaiting = new JLabel("You are waiting for following players:");
		GridBagConstraints gbc_lblYouAreWaiting = new GridBagConstraints();
		gbc_lblYouAreWaiting.anchor = GridBagConstraints.WEST;
		gbc_lblYouAreWaiting.gridwidth = 5;
		gbc_lblYouAreWaiting.insets = new Insets(0, 0, 5, 5);
		gbc_lblYouAreWaiting.gridx = 2;
		gbc_lblYouAreWaiting.gridy = 3;
		contentPane.add(lblYouAreWaiting, gbc_lblYouAreWaiting);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 5;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable(waitingForPlayerModel);
		scrollPane.setViewportView(table);
		
		JButton btnLeaveGame = new JButton("Leave game");
		btnLeaveGame.addActionListener(leaveGameListener);
		GridBagConstraints gbc_btnLeaveGame = new GridBagConstraints();
		gbc_btnLeaveGame.insets = new Insets(0, 0, 5, 5);
		gbc_btnLeaveGame.gridx = 8;
		gbc_btnLeaveGame.gridy = 6;
		contentPane.add(btnLeaveGame, gbc_btnLeaveGame);
	}

}
