package GameSystem;

import javax.swing.JPanel;
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
	Thread gameThread;
	int time = 0;

	// --- Hotbar ---
	// --- CONSTRUCTOR ---
	public GamePanel() {
		hotbar = new Hotbar();
		energyBar = new EnergyBar();
		this.setBackground(Color.red);
		this.setDoubleBuffered(true); // Improves rendering performance
		this.addKeyListener(keyH);
		this.setFocusable(true);
		this.setLayout(null);

		hotbar.setBounds((Main.WIDTH - hotbar.WIDTH), Main.HEIGHT - hotbar.HEIGHT-28, hotbar.WIDTH, hotbar.HEIGHT);
		add(hotbar);
		add(energyBar);
		this.setVisible(true);
	}

	// --- START METHOD ---
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	// --- GAME LOOP (The "Heart") ---
	@Override
	public void run() {
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		while (gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			if (delta >= 1) {
				drawCount++;
				update();
				repaint();
				delta--;
			}
			if (timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				timer = 0;
				drawCount = 0;
				time++;
			}
		}
	}

	// --- UPDATE (Logic) ---
	public void update() {
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
			hotbar.addItem(0);
		}
	}

	// --- DRAW (Rendering) ---
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.yellow);
		g2.fillRect(time * 20, 0, 50, 50);

	}
}