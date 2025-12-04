package ui_items;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import GameSystem.Main;
public class SettingsMenu extends JPanel{
	private static final long serialVersionUID = 1L;
	public static int width = (int)(Main.WIDTH * 0.8);
	public int height = (int)(Main.HEIGHT * 0.8);
	ResolutionSettings resSettings = new ResolutionSettings();
	
	ImageIcon settingsUIRaw = new ImageIcon("img/settingsUI2.png");
	Image settingsUIImg = settingsUIRaw.getImage().getScaledInstance(width, height,Image.SCALE_SMOOTH);
	
	JLabel settingsUILabel = new JLabel(new ImageIcon(settingsUIImg));

	public SettingsMenu(){
		this.setLayout(null);
		this.setBounds((Main.WIDTH-width)/2,(Main.HEIGHT-height)/2,width,height);
		this.add(settingsUILabel);
		settingsUILabel.setBounds(0,0,width,height);
		settingsUILabel.setVisible(true);
		settingsUILabel.setOpaque(true);
		this.add(resSettings);
		this.setComponentZOrder(settingsUILabel, 1);
		this.setComponentZOrder(resSettings, 0);

		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	}
	

}
