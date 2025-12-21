package ui_items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import GameSystem.Main;

public class GameOver extends JPanel implements ImageResizer{
	private static final long serialVersionUID = 1L;
	public int buttonWidth;
	public int buttonHeight;
	private int buttonX;
	private int buttonY;
	public int transitionAlpha;
	public GameOver() {
	setVisible(true);
	setLayout(null);
	//
	buttonWidth = (int) (456 * Main.scalerX);
	buttonHeight = (int) (140 * Main.scalerY);
	buttonY = (int) (Main.HEIGHT / 1.5);
	buttonX = (int) (Main.WIDTH);
	int bw = buttonWidth;
	int bh = buttonHeight;
	//
	JLabel gameOver = new JLabel(ImageResizer.imageResize("/img/gameOver.png", Main.WIDTH, Main.HEIGHT));
	gameOver.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
	//
	Button menuButton = new Button(0, buttonY, bw, bh, "buttons/MenuButton", "Menu", false);
	Button restartButton = new Button(buttonX-buttonWidth, buttonY, bw, bh, "buttons/RestartButton", "Restart",false);
	//
	add(restartButton);
	add(menuButton);
	add(gameOver);
	}
	@Override
	protected void paintChildren(Graphics g) {
		super.paintChildren(g);
		Graphics2D g2 = (Graphics2D) g;
		if(Main.isTransitioning) {
			g2.setColor(new Color(0, 0, 0, transitionAlpha));
			g2.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
			transitionAlpha = transitionAlpha +2;
			if(transitionAlpha>=255)
				transitionAlpha = 255;
	}
	}

}
