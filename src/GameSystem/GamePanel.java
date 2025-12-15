package GameSystem;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui_items.EnergyBar;
import ui_items.Hotbar;
import ui_items.Lanes;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	// --- 1. SCREEN SETTINGS ---
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 1;
	public final int tileSize = originalTileSize * scale; // 48x48 tile

	// --- 2. SYSTEM ---
	int FPS = 60;
	KeyInput keyH = new KeyInput();
	
	Hotbar hotbar;
	EnergyBar energyBar;
	Lanes lanes;
	JLabel background;
	Thread gameThread=null;
	public static boolean isPaused = false;
	int time = 0;
	boolean oneSecondPassed = false;

		// --- CONSTRUCTOR ---
	public GamePanel() {
		this.gameThread=null;
		hotbar = new Hotbar();
		energyBar = new EnergyBar();
		lanes = new Lanes();
		background = setUpBackground();
		this.setBackground(Color.gray);
		this.setPreferredSize(new Dimension(Main.WIDTH, Main.HEIGHT));
		this.setDoubleBuffered(true); // Improves rendering performance
		this.addKeyListener(keyH);
		this.setFocusable(true);
		this.setLayout(null);

		hotbar.setBounds((Main.WIDTH - hotbar.WIDTH), Main.HEIGHT - hotbar.HEIGHT, hotbar.WIDTH, hotbar.HEIGHT);
		add(hotbar);
		add(energyBar);
		add(lanes);
		add(background);
		this.setVisible(true);
	}

	// --- START METHOD ---
	public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
	public void stopGameThread() {
		if (gameThread!=null)
        gameThread = null;
    }
	private JLabel setUpBackground() {
		JLabel background = new JLabel();
		ImageIcon backgroundImgRaw = new ImageIcon("img/background.png");
		Image backgroundImg= backgroundImgRaw.getImage().getScaledInstance(Main.WIDTH, Main.HEIGHT, Image.SCALE_REPLICATE);
		background.setIcon(new ImageIcon(backgroundImg));
		background.setBounds(0,0,Main.WIDTH,Main.HEIGHT);
		return background;
	}
	// --- GAME LOOP (The "Heart") ---
	@Override
	public void run() {
		Thread thisThread = Thread.currentThread();
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		while (gameThread != null) {
			pauseKey();
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			if (delta >= 1) {
				drawCount++;	
				if(!isPaused) 
					update();
				repaint();
				delta--;
			}
			if (timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				timer = 0;
				drawCount = 0;
				if (!isPaused) {
			        time++;
			        oneSecondPassed = true;
			    }
			}
		}
	}
	
	// --- UPDATE (Logic) ---
	public void update() {
		energyBar.updateBars();
		keyBinds();
		if(oneSecondPassed) {
			EnergyBar.curEnergy++;
			oneSecondPassed = false;
		}
	}

	

	
	private void pauseKey() {
		if (keyH.isPressedOnce(KeyEvent.VK_ESCAPE)) {
			Main.openPauseMenu();
		}
	}
	private void keyBinds() {
		if (keyH.isPressedOnce(KeyEvent.VK_Q)) {
			EnergyBar.curEnergy--;
		}
		if (keyH.isPressedOnce(KeyEvent.VK_C)) {
			hotbar.useItem(0);
		}
		if (keyH.isPressedOnce(KeyEvent.VK_V)) {
			hotbar.useItem(1);
		}
		if (keyH.isPressedOnce(KeyEvent.VK_B)) {
			hotbar.useItem(2);
		}
		if (keyH.isPressedOnce(KeyEvent.VK_N)) {
			hotbar.useItem(3);
		}
		if (keyH.isPressedOnce(KeyEvent.VK_M)) {
			hotbar.useItem(4);
		}
		if (keyH.isPressedOnce(KeyEvent.VK_SPACE)) {
			hotbar.addItem((int)(Math.random()*3));
		}

	}
	// --- DRAW (Rendering) ---
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g); 
	}
	@Override
	public void paintChildren(Graphics g) { //This draws AFTER the labels dont forget 
	    super.paintChildren(g); 
	    
	    Graphics2D g2 = (Graphics2D) g;
	    
	    g2.setColor(Color.yellow);
	    g2.fillRect(Main.WIDTH-50-(time * 20), 0, 50, 50); 
	}
}