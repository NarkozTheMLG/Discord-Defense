package GameSystem;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EnergyBar extends JPanel {

	private static final long serialVersionUID = 1L;
	public static int width = 1280; //1920
	public static int height = 120; //329
	public static int x;
	public static int y;
	public EnergyBar() {
		width =(int)(width * Main.scalerX);
		height =(int)(height* Main.scalerY);

		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, width, height); //2175,365
		ImageIcon energyBarRaw = new ImageIcon("img/energyBar.png");
		Image energyBarScaled = energyBarRaw.getImage().getScaledInstance(width, height,Image.SCALE_SMOOTH);
		JLabel energyBarLabel = new JLabel(new ImageIcon(energyBarScaled));
		energyBarLabel.setBounds(0,0,width,height);
		add(energyBarLabel);
	}

}
