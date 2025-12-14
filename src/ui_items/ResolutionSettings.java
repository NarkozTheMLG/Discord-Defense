package ui_items;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import GameSystem.Main;

public class ResolutionSettings extends JPanel{
	private static final long serialVersionUID = 1L;
	//
	private int y;
	private int height;
	//
	private int resTextX;
	private int resTextW;
	private int resTextH;
	JLabel resolutionText;
	ImageIcon resTextImgIcon = new ImageIcon("img/settings/resoulutionText.png");

//
	public int buttonWidth;
	public int buttonHeight;	
	Button res1920;
	Button res1280;
//
	public ResolutionSettings() {
		this.y = (int) (200 * Main.scalerY);
		this.height = (int) (500 * Main.scalerY);
		//
		this.resTextW = (int) (400 * Main.scalerX) ;
		this.resTextH = (int) (132 * Main.scalerY);
		this.resTextX = (int) (150 * Main.scalerX);
		//
		Image resImg = resTextImgIcon.getImage().getScaledInstance(resTextW, resTextH, Image.SCALE_REPLICATE);
		ImageIcon resImgIcon = new ImageIcon(resImg);
		this.resolutionText = new JLabel(resImgIcon);
		//
		this.buttonWidth = (int) (300 * Main.scalerX);
		this.buttonHeight = (int) (100 * Main.scalerY);	
		this.res1920 = new Button(resTextW+resTextX,(resTextH-buttonHeight)/2,buttonWidth,buttonHeight,"settings/1920off","1920",true);
		this.res1280 = new Button(resTextW+resTextX+buttonWidth,(resTextH-buttonHeight)/2,buttonWidth,buttonHeight,"settings/1280off","1280",true);
		//this.setLayout(new GridLayout(1,3,0,0));
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0,y,SettingsMenu.width,height);
		//
		resolutionText.setBounds(resTextX,0,resTextW,resTextH);
		//
		this.add(resolutionText);
		this.add(res1920);
		this.add(res1280);

	}
	
	public static void changeResolution(int w,int h) {
		Main.WIDTH = w;
		Main.HEIGHT = h;
		Main.updateScreen();
	}
	
	
}
