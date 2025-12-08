package GameSystem;

import java.awt.Dimension;

import javax.swing.JFrame;
import ui_items.MainMenu;

public class Main {
	MainSys mainSys = new MainSys();
	// 1. THIS IS THE SCREEN SIZE (What the user sees)
	static public int WIDTH = 1920;
	static public int HEIGHT = 1080;
	// final static int WIDTH = 1280;
	// final static int HEIGHT = 720;
	static public float scalerX = WIDTH / 1920f;
	static public float scalerY = HEIGHT / 1080f;
	static JFrame window = new JFrame();
	static MainMenu mainMenu = new MainMenu();
	static GamePanel gamePanel;

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
		gamePanel = new GamePanel();
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
	
	public static void updateScreen(int w, int h) {
		scalerX = WIDTH / 1920f;
		scalerY = HEIGHT / 1080f;
		Dimension newSize = new Dimension(w, h);
		window.setSize(newSize);
	    
		mainMenu.setPreferredSize(newSize);
	    gamePanel.setPreferredSize(newSize);
		window.pack();
		window.revalidate(); 
	    window.repaint();
	    window.setLocationRelativeTo(null);
	}
	public static void updateScreen() {
		System.out.println(WIDTH);
		scalerX = WIDTH / 1920f;
		scalerY = HEIGHT / 1080f;
	    window.remove(mainMenu);
	    mainMenu = new MainMenu(); 
	    gamePanel = new GamePanel();
	    window.add(mainMenu);
	    settings();
	    window.pack();
	    window.setLocationRelativeTo(null);
	    window.revalidate();
	    window.repaint();
	}
}