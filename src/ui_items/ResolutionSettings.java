package ui_items;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import GameSystem.Main;

public class ResolutionSettings extends JPanel{
	private static final long serialVersionUID = 1L;
//
	final private int resTextW = (int) (400 * Main.scalerX) ;
	final private int resTextH = (int) (132 * Main.scalerY);
	JLabel resolutionText = new JLabel(new ImageIcon("img/settings/resoulutionText.png"));
//
	final public static int buttonWidth = (int) (300 * Main.scalerX);
	final public static int buttonHeight = (int) (100 * Main.scalerY);	
	Button res1920 = new Button(resTextW+150,(resTextH-buttonHeight)/2,buttonWidth,buttonHeight,"settings/1920off","1920",true);
	Button res1280 = new Button(resTextW+150+buttonWidth,(resTextH-buttonHeight)/2,buttonWidth,buttonHeight,"settings/1280off","1280",true);
//
	public ResolutionSettings() {
		//this.setLayout(new GridLayout(1,3,0,0));
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0,200,SettingsMenu.width,500);
		//
		resolutionText.setBounds(150,0,resTextW,resTextH);
		//
		this.add(resolutionText);
		this.add(res1920);
		this.add(res1280);

	}
}
