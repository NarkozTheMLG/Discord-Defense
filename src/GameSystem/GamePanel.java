package GameSystem;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui_items.EnergyBar;
import ui_items.Hotbar;
import ui_items.Lanes;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import Entity.*; 
import ui_items.Lanes;
import GameSystem.Main; // To access WIDTH

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
	public static boolean oneSecondPassed = false;
	private Piano piano;
	private BufferedImage imgA, imgB, imgC;
	//to have delay when  spawning enemies:
	private int spawnTick = 0;
    private int spawnRate = 120;

		// --- CONSTRUCTOR ---
	public GamePanel() {
		this.gameThread=null;
		hotbar = new Hotbar();
		energyBar = new EnergyBar();
		lanes = new Lanes();
		background = setUpBackground();
		piano = new Piano(100, 1000); //for now
		loadEnemyImages();
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
		ImageIcon backgroundImgRaw = new ImageIcon(getClass().getResource("/img/background.png"));
		Image backgroundImg= backgroundImgRaw.getImage().getScaledInstance(Main.WIDTH, Main.HEIGHT, Image.SCALE_REPLICATE);
		background.setIcon(new ImageIcon(backgroundImg));
		background.setBounds(0,0,Main.WIDTH,Main.HEIGHT);
		return background;
	}

	private void loadEnemyImages() { 
		// Prints where "/" actually points to on your computer
		System.out.println("Root Path: " + getClass().getResource("/"));

		// Prints where your current Java class is located
		System.out.println("Class Path: " + getClass().getResource("."));
        try { 
        	imgA = ImageIO.read(getClass().getResourceAsStream("/img/enemies/drum.png"));
            imgB = ImageIO.read(getClass().getResourceAsStream("/img/enemies/metronome.png"));
            imgC = ImageIO.read(getClass().getResourceAsStream("/img/enemies/greenSlime.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading enemy images!");
        }
    }
	
	public void spawnEnemy() {
		int laneIndex = (int)(Math.random() * Lanes.laneCount); //random lane
		double startY = laneIndex * Lanes.laneHeight; //find starting y coordinate
		double startX = Main.WIDTH + 50; // make sure the spawn is beyond screen by + 50
		
		//Find Enemy Type
		int type = (int)(Math.random() * 3);
		
		switch(type) {
		case 0: new TypeA(startX, startY, 2.0, "Low", laneIndex, imgA); //Enemy obj creation here
			break;
		case 1: new TypeB(startX, startY, 1.0, "Medium", laneIndex, imgB);
			break;
		case 2: new TypeC(startX, startY, 0.5, "High", laneIndex, imgC);
			break;
		}
		
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
	//UPDATE ENTITIES:
		//Update piano
			piano.update();
		//Update Enemy
			for (int i = 0; i < Enemy.enemyList.size(); i++) {
		        Enemy e = Enemy.enemyList.get(i);
		        if (e.isDead()) {
		            Enemy.enemyList.remove(i);
		            i--;
		        }else {
		        	e.update();
		        }
		        	
	//COLLISON HANDLING:
		//Piano hit by enemy
			if (piano.checkCollision(e)) {
	            System.out.println("Piano hit by enemy");
	            piano.setPianoHp(piano.getPianoHp() - 10); // reduce piano hp by 10 (10 hits later death)
	        }
		//Enemy hit by bullet
			for (int k = 0; k < Piano.shot.size(); k++) {
	            Bullet b = Piano.shot.get(k);
	            
	            if (b.checkCollision(e)) {
	                System.out.println("Enemy hit by bullet!");
	                e.setEnemyHp(e.getEnemyHp() - 1); // Enemy takes damage (3 hits till death)
	                b.setBulletHp(b.getBulletHp() - 1);  //Bullet lost its only hp (destroyed)
	            }
	        }
		}
	//ENEMY SPAWN:
		spawnTick++; //continues until spawnTick is 120 (2s passed)
        if (spawnTick >= spawnRate) { //spawns enemy after 2s
            spawnEnemy();
            spawnTick = 0; //resets so that it can respawn enemy
        }
	}//end of update()

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
		if (keyH.isPressedOnce(KeyEvent.VK_1)) piano.fire(0);
	    if (keyH.isPressedOnce(KeyEvent.VK_2)) piano.fire(1);
	    if (keyH.isPressedOnce(KeyEvent.VK_3)) piano.fire(2);
	    if (keyH.isPressedOnce(KeyEvent.VK_4)) piano.fire(3);
	    if (keyH.isPressedOnce(KeyEvent.VK_5)) piano.fire(4);
	    if (keyH.isPressedOnce(KeyEvent.VK_6)) piano.fire(5);
	    if (keyH.isPressedOnce(KeyEvent.VK_7)) piano.fire(6);

		
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
	    
	    //DRAW ENEMIES:
	    for(Enemy e: Enemy.enemyList) {
	    	if(e != null) {
	    		g2.drawImage(e.getCurrentFrame(), (int)e.getX(), (int)e.getY(), null);
	    		//null is observer updates for loads we already have it here so no need, it is null
	    	}
	    }
	 // DRAW BULLETS 
	    g2.setColor(Color.RED);
	    for (int i = 0; i < Piano.shot.size(); i++) {
	        Bullet b = Piano.shot.get(i);
	        if (b != null) {
	            g2.fillRect((int)b.getX(), (int)b.getY(), 20, 20);
	        }
	    }
	    
	    g2.setColor(Color.yellow);
	    g2.fillRect(Main.WIDTH-50-(time * 20), 0, 50, 50); 
	}
	
	
}