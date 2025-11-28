package GameSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MainMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	final public static int buttonWidth = (int) (456 * Main.scalerX);
	final public static int buttonHeight = (int) (140 * Main.scalerY);

	private int difference = (int) (-150 * Main.scalerY);
	private int buttonX = (int) ((float) (Main.WIDTH - buttonWidth) / 2);
	private int buttonY = (int) (((float) (Main.HEIGHT - buttonHeight + TitlePanel.titleHeight - 20)) / 2);


	public MainMenu() {
		//
		ImageIcon splashScreenRaw = new ImageIcon("img/splashscreen.png");
		Image splashScreenImg = splashScreenRaw.getImage().getScaledInstance(Main.WIDTH, Main.HEIGHT,
				Image.SCALE_SMOOTH);
		JLabel splashScreen = new JLabel(new ImageIcon(splashScreenImg));
		splashScreen.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
		//

		// ImageIcon titleImgIcon = new ImageIcon(titleImg);
		// JLabel title = new JLabel(titleImgIcon);
		// title.setBounds((Main.WIDTH-titleWidth)/2, -20, titleWidth, titleHeight);
		TitlePanel title = new TitlePanel();
		//
		setDoubleBuffered(true);
		// Image Icons initialization
		ImageIcon startImgRaw = new ImageIcon("img/StartButton.png");
		Image startImg = startImgRaw.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_REPLICATE);
		ImageIcon quitImgRaw = new ImageIcon("img/QuitButton.png");
		Image quitImg = quitImgRaw.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_REPLICATE);

		// Button creation
		Button startButton = new Button(buttonX, buttonY + difference, new ImageIcon(startImg), "Start");
		Button quitButton = new Button(buttonX, buttonY, new ImageIcon(quitImg), "Quit");

		/////////////////////////////////////
		setLayout(null);
		add(startButton);
		add(quitButton);
		add(title);
		add(splashScreen);
	}

}
