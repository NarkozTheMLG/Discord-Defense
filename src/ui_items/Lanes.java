package ui_items;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lanes extends JPanel{
	public Lanes() {
		setLayout(new GridLayout(7,1,0,0));
		setOpaque(false);
		setBounds(400,0,1536,896);
		for(int i = 0 ; i < 7; i++) {
		ImageIcon laneRaw = new ImageIcon("img/redLane.png");
		Image laneImg = laneRaw.getImage().getScaledInstance(1536, 128, Image.SCALE_SMOOTH);
		JLabel laneLabel = new JLabel(new ImageIcon(laneImg));
		add(laneLabel);}

	}
}
