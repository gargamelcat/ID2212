package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.UIManager;

public class MainController {

	private MainController mainController = null;
	LoginView loginView = null;

	/**
	 * Main method for MainController.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println("Look and feel could not be set.");
		}

		MainController mainController = new MainController();
	}

	/**
	 * New MainView and LoginController.
	 */
	public MainController() {
		mainController = this;
		loginView = new LoginView(new connectListener());
		loginView.setVisible(true);

	}

	class connectListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			loginView.setVisible(false);
		}
	}
}
