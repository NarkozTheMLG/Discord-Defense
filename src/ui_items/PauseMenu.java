package ui_items;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameSystem.Main;

public class PauseMenu extends JPanel{

	private static final long serialVersionUID = 1L;


	public int buttonWidth;
	public int buttonHeight;

	private int difference;
	private int buttonX;
	private int buttonY;
	
	public PauseMenu() {
		ImageIcon pauseScreenRaw = new ImageIcon(getClass().getResource("/img/pauseScreen.png"));
		Image pauseScreenImg = pauseScreenRaw.getImage().getScaledInstance(Main.WIDTH, Main.HEIGHT,Image.SCALE_SMOOTH);
		JLabel pauseScreen = new JLabel(new ImageIcon(pauseScreenImg));
		setLayout(null);
		buttonWidth = (int) (456 * Main.scalerX);
		buttonHeight = (int) (140 * Main.scalerY);
		difference = (int) (-150 * Main.scalerY);
		buttonY = (int) (Main.HEIGHT/1.5);
		buttonX = (int) ((float) (Main.WIDTH - buttonWidth) / 2);
		int bw = buttonWidth;
		int bh = buttonHeight;
		
	pauseScreen.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
	
	Button resumeButton = new Button(buttonX, buttonY + 3*difference,bw,bh,"buttons/ResumeButton", "Resume",false);
	Button restartButton = new Button(buttonX, buttonY +2* difference,bw,bh, "buttons/RestartButton", "Restart",false);
	Button menuButton = new Button(buttonX, buttonY + difference,bw,bh, "buttons/MenuButton", "Menu",false);

	add(resumeButton);
	add(restartButton);
	add(menuButton);
	
	add(pauseScreen);

	}
}
