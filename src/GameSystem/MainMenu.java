package GameSystem;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class MainMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	final static int buttonWidth = 228;
	final static int buttonHeight = 70;
	final static int posScale = 4;
	final static int sizeScale = 8;

	int difference = -75;

	int x = (Main.WIDTH - buttonWidth) / 2;
	int y = (Main.HEIGHT - buttonHeight) / 2;

	float minFontSize = 20;
	float maxFontSize = 30;

	public MainMenu() {
		setPreferredSize(new Dimension(1024, 768));
		setBackground(Color.white);
		setDoubleBuffered(true);

		// Image Icons initialization
		ImageIcon startImg = new ImageIcon("StartButton.png");
		ImageIcon quitImg = new ImageIcon("QuitButton.png");
		// Button creation
		Button startButton = new Button(x, y + difference, startImg, "Start");
		Button quitButton = new Button(x, y, quitImg, "Quit");

		/////////////////////////////////////
		setLayout(null);
		add(startButton);
		add(quitButton);
	}
}
