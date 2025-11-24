package GameSystem;
import javax.swing.JFrame;

public class Main {

	static JFrame window = new JFrame();
	static MainMenu mainMenu = new MainMenu();
	static GamePanel gamePanel = new GamePanel();
	final static int WIDTH = 1470;
	final static int HEIGHT = 920;
    public static void main(String[] args) {
    	 // frame properties
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Discord Defense");
        window.setSize(WIDTH, HEIGHT);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        
        // we will need to adjust this 
    	

    	window.add(mainMenu);
    	mainMenu.setBounds(0, 0, WIDTH,HEIGHT);
        
        // Adjusting game panel
        gamePanel.setBounds((WIDTH - gamePanel.screenWidth)/2, (HEIGHT- gamePanel.screenHeight)/2, gamePanel.screenWidth, gamePanel.screenHeight); 
        // Start the game loop
        gamePanel.startGameThread();
        window.setVisible(true);
    }
    public static void startGame() {
    	// Remove main menu then add game panel
    	window.remove(mainMenu);
    	window.add(gamePanel);
    	window.revalidate();
    	window.repaint();

    	}
}