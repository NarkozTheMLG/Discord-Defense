package GameSystem;
import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L;
	// --- 1. SCREEN SETTINGS ---
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; // 48x48 tile
    public final int maxScreenCol = 24;
    public final int maxScreenRow = 16;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // --- 2. SYSTEM ---
    int FPS = 60;
    KeyInput keyH = new KeyInput();
    Thread gameThread;
    int time =0;

    //--- Hotbar ---

    // --- CONSTRUCTOR ---
    public GamePanel() {
        Hotbar hotbar = new Hotbar();
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true); // Improves rendering performance
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.setLayout(null);
        
        hotbar.setBounds(screenWidth/2, screenHeight-hotbar.height, hotbar.width, hotbar.height);;   
    	add(hotbar);
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
            	System.out.println("FPS: "+drawCount);
            	timer = 0;
            	drawCount= 0;
            	time++;
            }
        }
    }

    // --- UPDATE (Logic) ---
    public void update() {
  
    }

    // --- DRAW (Rendering) ---
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.yellow);
        g2.fillRect(time*20,0, 50, 50);

    }
}