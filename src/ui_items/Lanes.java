package ui_items;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameSystem.Main;

public class Lanes extends JPanel{
	private static final long serialVersionUID = 1L;

	public int width = (int)(1536 * Main.scalerX);
	public int height = (int)(896 * Main.scalerY);
	final public int laneCount = 7; 
	public int laneHeight = (int)((height / laneCount)*Main.scalerY) ;
	public int x = (int)(400*Main.scalerX);
	public Lanes() {
		setLayout(new GridLayout(7,1,0,0));
		setOpaque(false);
		setBounds(x,0,width,height);
		for(int i = 0 ; i < 7; i++) {
		ImageIcon laneRaw = new ImageIcon("img/redLane.png");
		Image laneImg = laneRaw.getImage().getScaledInstance(width, laneHeight, Image.SCALE_SMOOTH);
		JLabel laneLabel = new JLabel(new ImageIcon(laneImg));
		add(laneLabel);}

	}
}
