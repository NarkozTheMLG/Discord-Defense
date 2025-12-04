package ui_items;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import GameSystem.Main;

public class Button extends JButton {
	private static final long serialVersionUID = 1L;
	private int posScale;
	private int sizeScale;
	private int width; // 456 for main menu
	private int height;// 140 for main menu
	private int scaledW;
	private int scaledH;
	Button(int x, int y,int w,int h, String img, String type,boolean settingsItem) {
		this.width = w;
		this.height = h;
		if(width<400) {
			this.sizeScale = 4;			
			this.posScale = 2;
		}
		else {
			this.sizeScale = 8;
			this.posScale = 4;
		}
		int scaledX = x - posScale;
		int scaledY = y - posScale;
		this.scaledW = width + sizeScale;
		this.scaledH = height + sizeScale;
		//
		ImageIcon mainImgRaw = new ImageIcon("img/"+img+".png");
		Image mainImg = mainImgRaw.getImage().getScaledInstance(width, height, Image.SCALE_REPLICATE);
		ImageIcon mainImageIcon = new ImageIcon(mainImg);
		
		Image scaledImg = mainImg.getScaledInstance(scaledW, scaledH, Image.SCALE_REPLICATE);
		ImageIcon hoverImg = new ImageIcon(scaledImg);
		//
		this.setIcon(mainImageIcon);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBounds(x, y, width, height);
		this.setBorder(null); // this removes the border around button
		// event handlers //
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if(MainMenu.isSettingsMenuActive && !settingsItem) return; 
				setIcon(hoverImg);
				setBounds(scaledX, scaledY, scaledW, scaledH);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				if(MainMenu.isSettingsMenuActive && !settingsItem) return; 
				setIcon(mainImageIcon);
				setBounds(x, y, width, height);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				setBorder(null); // this removes the border around button
			}
		});
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MainMenu.isSettingsMenuActive && !settingsItem) return; 
				if (type.equalsIgnoreCase("Start"))
					Main.startGame();
				else if (type.equalsIgnoreCase("Quit"))
					Main.quitGame();
				else if (type.equalsIgnoreCase("Settings"))
					Main.settings();
			}
		});
	}
		
}
