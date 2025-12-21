package GameSystem;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import ui_items.GameOver;
import ui_items.MainMenu;
import ui_items.PauseMenu;
import ui_items.TitlePanel;

public class Main {
	// 1. THIS IS THE SCREEN SIZE (What the user sees)
	static public int WIDTH = 1280;
	static public int HEIGHT = 720;
	// final static int WIDTH = 1280;
	// final static int HEIGHT = 720;
	static public float scalerX = WIDTH / 1920f;
	static public float scalerY = HEIGHT / 1080f;
	//
	static public boolean isFullScreen = false;
	//
	public static JFrame window = new JFrame();
	public static MainMenu mainMenu = new MainMenu();
	public static PauseMenu pauseMenu = new PauseMenu();
	//
	public static boolean isTransitioning;

	
	static GamePanel gamePanel;
	public static MouseAdapter mouseListener;

	public static void main(String[] args) {
		//
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

	public static void startGameCode() {
		window.repaint(); 
            window.remove(mainMenu);
		            gamePanel = null;
		            gamePanel = new GamePanel();
		            window.add(gamePanel);
		            window.revalidate();
		            window.repaint();
		            gamePanel.requestFocusInWindow();
		            gamePanel.startGameThread();
		            pauseMenu = new PauseMenu();
		            pauseMenu.setOpaque(false);
		            window.setGlassPane(pauseMenu);
	}
	
	public static void reStartGameCode() {
        gamePanel.stopGameThread();
        window.remove(gamePanel); 
        gamePanel = null;
        gamePanel = new GamePanel();
        window.add(gamePanel);

		window.revalidate();
		window.repaint();
		gamePanel.requestFocusInWindow();
		gamePanel.startGameThread();
		
		pauseMenu = new PauseMenu();
		pauseMenu.setOpaque(false);
		window.setGlassPane(pauseMenu);
		
		openPauseMenu();
	}
	
	public static void gameOverCode() {
		GameOver gameOver = new GameOver();
		gameOver.setVisible(true);
		window.add(gameOver);

		
		window.revalidate(); 
	    window.repaint();
	}

	public static void quitGame() {
		System.exit(0);
	}
	public static void settings() {
		mouseListener = new MouseAdapter(){ // I NAMED HIM SO THAT I CAN REMOVE THIS LISTENER IN CASE SCREEN REFRESHES (for example when you click on windowed it used to open up new listeners but now it removes the previous one)
		    @Override
		    public void mousePressed(MouseEvent e) {
		    	//System.out.println("\n\n"+MainMenu.settingsMenu.getBounds()+"");
		    	//System.out.println(""+e.getPoint()+"\n\n");
		        if (MainMenu.isSettingsMenuActive) {
		            if (!MainMenu.settingsMenu.getBounds().contains(e.getPoint())) { // contains checks if mouse x is inside panelx+w and returns bool
		            	mainMenu.removeSettingsMenu();
		            }
		        }
		    }
		};
		Main.window.addMouseListener(mouseListener);
		mainMenu.settingsMenu();
		window.revalidate(); 
	    window.repaint();
	}
	public static void openPauseMenu() {
		System.out.println("Pasue key evet");
		GamePanel.isPaused = !GamePanel.isPaused;
		window.getGlassPane().setVisible(GamePanel.isPaused); 
		if (!GamePanel.isPaused) {
            gamePanel.setFocusable(true); // Ensure component is focusable
            gamePanel.requestFocusInWindow(); // Request focus back to this panel
        }
	    if (!GamePanel.isPaused) {
	        gamePanel.requestFocusInWindow(); 
	    }
		window.revalidate(); 
	    window.repaint();
	}
	public static void goBackToMainMenuCode() {
		gamePanel.stopGameThread();
		window.remove(gamePanel);
		window.add(mainMenu);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		openPauseMenu();
	}

	/*
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
	}*/
	public static void updateScreen() {
		System.out.println(WIDTH);
		scalerX = WIDTH / 1920f;
		scalerY = HEIGHT / 1080f;
		mainMenu.removeSettingsMenu();
	    window.remove(mainMenu);
	    mainMenu = new MainMenu(); 
	    window.add(mainMenu);
	    settings();
	    window.pack();
	    window.setLocationRelativeTo(null);
	    window.revalidate();
	    window.repaint();
		window.setVisible(true);
	}
	public static void updateToFullscreen() {
		System.out.println("FULLSCREEN");
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        WIDTH = (int) size.getWidth();
        HEIGHT = (int) size.getHeight();
		scalerX = WIDTH / 1920f;
		scalerY = HEIGHT / 1080f;
		mainMenu.removeSettingsMenu();
	    window.remove(mainMenu);
	    mainMenu = new MainMenu(); 
	    window.add(mainMenu);
	    settings();
	    window.setLocationRelativeTo(null);
	    window.revalidate();
	    window.repaint();
		window.setVisible(true);
	}
	
	public static void startGame() {
		if(isTransitioning) return;
		isTransitioning = true;
		javax.swing.Timer timer = new javax.swing.Timer(16, null);
		timer.addActionListener(new java.awt.event.ActionListener() {
		    long startTime = -1;
		    @Override
		    public void actionPerformed(java.awt.event.ActionEvent e) {
		        if (startTime == -1) startTime = System.currentTimeMillis();
		        window.repaint(); 
		        if (System.currentTimeMillis() - startTime >= 2000) {
		            timer.stop(); // Stop the animation timer
		            startGameCode();
		            mainMenu.transitionAlpha = 0;
		            isTransitioning = false;
		        }
		    }
		});
		timer.start();
	}

	public static void reStartGame() {
		if(isTransitioning) return;
		isTransitioning = true;
		javax.swing.Timer timer = new javax.swing.Timer(16, null);
		timer.addActionListener(new java.awt.event.ActionListener() {
		    long startTime = -1;
		    @Override
		    public void actionPerformed(java.awt.event.ActionEvent e) {
		        if (startTime == -1) startTime = System.currentTimeMillis();
		        window.repaint(); 
		        if (System.currentTimeMillis() - startTime >= 1500) {
		            timer.stop(); // Stop the animation timer
		            reStartGameCode();
		            pauseMenu.transitionAlpha = 0;
		            isTransitioning = false;
		        }
		    }
		});
		timer.start();
	}
	
	public static void goBackToMainMenu() {
		if(isTransitioning) return;
		isTransitioning = true;
		javax.swing.Timer timer = new javax.swing.Timer(16, null);
		timer.addActionListener(new java.awt.event.ActionListener() {
		    long startTime = -1;
		    @Override
		    public void actionPerformed(java.awt.event.ActionEvent e) {
		        if (startTime == -1) startTime = System.currentTimeMillis();
		        window.repaint(); 
		        if (System.currentTimeMillis() - startTime >= 1200) {
		            timer.stop(); // Stop the animation timer
		            goBackToMainMenuCode();
		            pauseMenu.transitionAlpha = 0;
		            isTransitioning = false;
		        }
		    }
		});
		timer.start();
	}
	
	public static void gameOver() {
		if(isTransitioning) return;
		isTransitioning = true;
		javax.swing.Timer timer = new javax.swing.Timer(16, null);
		timer.addActionListener(new java.awt.event.ActionListener() {
		    long startTime = -1;
		    @Override
		    public void actionPerformed(java.awt.event.ActionEvent e) {
		        if (startTime == -1) startTime = System.currentTimeMillis();
		        gameOverCode();
		        window.repaint(); 
		        if (System.currentTimeMillis() - startTime >= 1500) {
		            timer.stop(); // Stop the animation timer
		            pauseMenu.transitionAlpha = 255;
		            isTransitioning = false;
		        }
		    }
		});
		timer.start();
	}
	
	
	

}