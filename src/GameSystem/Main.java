package GameSystem;

import javax.swing.JFrame;
import ui_items.MainMenu;

public class Main {

	static JFrame window = new JFrame();
	static MainMenu mainMenu = new MainMenu();
	static GamePanel gamePanel = new GamePanel();
	// 1. THIS IS THE SCREEN SIZE (What the user sees)
	final static public int WIDTH = 1920;
	final static public int HEIGHT = 1080;
	// final static int WIDTH = 1280;
	// final static int HEIGHT = 720;
	final static public float scalerX = WIDTH / 1920f;
	final static public float scalerY = HEIGHT / 1080f;

	public static void main(String[] args) {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Discord Defense");

		// Set the window size
		window.setLocationRelativeTo(null);
		// Add MainMenu
		window.add(mainMenu);
		window.pack();
		window.setLocationRelativeTo(null);
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
	public static void settings() {
		mainMenu.settingsMenu();
		window.revalidate(); 
	    window.repaint();
	}
}