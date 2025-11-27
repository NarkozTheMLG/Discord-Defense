package GameSystem;

import javax.swing.JFrame;
import java.awt.BorderLayout; // Import this

public class Main {

	static JFrame window = new JFrame();
	static MainMenu mainMenu = new MainMenu();
	static GamePanel gamePanel = new GamePanel();

	// 1. THIS IS THE SCREEN SIZE (What the user sees)
	final static int WIDTH = 1920;
	final static int HEIGHT = 1080;
	// final static int WIDTH = 1280;
	// final static int HEIGHT = 720;
	final static float scalerX = WIDTH / 1920f;
	final static float scalerY = HEIGHT / 1080f;

	public static void main(String[] args) {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Discord Defense");
		window.setLayout(new BorderLayout());

		// Set the window size
		window.setSize(WIDTH, HEIGHT);
		window.setLocationRelativeTo(null);

		// Add MainMenu
		window.add(mainMenu);

		window.setVisible(true);
	}

	public static void startGame() {
		window.remove(mainMenu);
		window.add(gamePanel);

		window.revalidate();
		window.repaint();
		gamePanel.requestFocusInWindow();
		gamePanel.startGameThread();
	}

	public static void quitGame() {
		System.exit(0);
	}
}