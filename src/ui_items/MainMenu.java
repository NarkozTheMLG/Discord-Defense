package ui_items;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JPanel;

import GameSystem.Main;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MainMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	static SettingsMenu settingsMenu = new SettingsMenu();
	static public boolean isSettingsMenuActive = false;
	
	final public static int buttonWidth = (int) (456 * Main.scalerX);
	final public static int buttonHeight = (int) (140 * Main.scalerY);

	private int difference = (int) (-150 * Main.scalerY);
	private int buttonX = (int) ((float) (Main.WIDTH - buttonWidth) / 2);
	private int buttonY = (int) (Main.HEIGHT);


	public MainMenu() {
		setPreferredSize(new Dimension(Main.WIDTH, Main.HEIGHT));
		ImageIcon splashScreenRaw = new ImageIcon("img/splashscreen.png");
		Image splashScreenImg = splashScreenRaw.getImage().getScaledInstance(Main.WIDTH, Main.HEIGHT,Image.SCALE_SMOOTH);
		JLabel splashScreen = new JLabel(new ImageIcon(splashScreenImg));
		splashScreen.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
		//

		// ImageIcon titleImgIcon = new ImageIcon(titleImg);
		// JLabel title = new JLabel(titleImgIcon);
		// title.setBounds((Main.WIDTH-titleWidth)/2, -20, titleWidth, titleHeight);
		TitlePanel title = new TitlePanel();
		//
		setDoubleBuffered(true);

		
		// Button creation
		int bw = buttonWidth;
		int bh = buttonHeight;
		Button startButton = new Button(buttonX, buttonY + 3*difference,bw,bh,"buttons/StartButton", "Start",false);
		Button settingsButton = new Button(buttonX, buttonY +2* difference,bw,bh, "buttons/SettingsButton", "Settings",false);
		Button quitButton = new Button(buttonX, buttonY + difference,bw,bh, "buttons/QuitButton", "Quit",false);

		/////////////////////////////////////
		setLayout(null);
		add(startButton);
		add(settingsButton);
		add(quitButton);
		add(title);
		add(splashScreen);
	}
	public void settingsMenu() {
		isSettingsMenuActive = true;
		add(settingsMenu);
		setComponentZOrder(settingsMenu, 0);

	}
}
