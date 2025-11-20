import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
    	final int WIDTH = 1470;
    	 final int HEIGHT = 920;
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Discord Defense");
        
        // 1. Create the "Mother Board" (The Main Menu)
        MainMenu mainMenu = new MainMenu();
        mainMenu.setLayout(null); 
        
        // 2. Create the Game Panel
        GamePanel gamePanel = new GamePanel();
        gamePanel.setBounds((WIDTH - gamePanel.screenWidth)/2, (HEIGHT- gamePanel.screenHeight)/2, gamePanel.screenWidth, gamePanel.screenHeight); 
        
        // 3. Add the Game Panel INSIDE the Main Menu
        mainMenu.add(gamePanel);
        
        // 4. Add the Main Menu to the Window
        window.add(mainMenu);
        
        // 5. Final Setup
        window.setSize(WIDTH, HEIGHT);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        // Start the game loop
        gamePanel.startGameThread();
    }
}