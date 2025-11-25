package GameSystem;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class Hotbar extends JPanel {
	private static final long serialVersionUID = 1L;
	public final int WIDTH = 480;
	public final int HEIGHT = 96;
	public final int BOXSIZE = 96;

	public Items[] inventory = new Items[5];
	public JLabel[] myLabels = new JLabel[5];

	public void addItem(int id) {
		if (Items.count < 5) {
			System.out.println("Added item: " + id);
			for (int i = 0; i < myLabels.length; i++) {
				if (myLabels[i].getComponentCount() == 0) {
					inventory[i] = new Items(id, i);
					int itemW = inventory[i].getWidth();
					int itemH = inventory[i].getHeight();
					ImageIcon iceImg = inventory[i].getImage();
					Image scaledImg = iceImg.getImage().getScaledInstance(itemW * 3, itemH * 3, Image.SCALE_SMOOTH);
					JLabel itemLabel = new JLabel();
					itemLabel.setBounds(((BOXSIZE - itemW * 3)) / 2, 8, itemW * 3, itemH * 3);
					itemLabel.setIcon(new ImageIcon(scaledImg));
					itemLabel.setOpaque(false);
					itemLabel.setBackground(Color.GRAY);
					itemLabel.setHorizontalAlignment(SwingConstants.CENTER);
					myLabels[i].add(itemLabel);
					break;
				}
			}
		}
	}
	

	public void useItem(int slot) {
		if (inventory[slot] == null)
			return;

		inventory[slot].use();
		myLabels[slot].removeAll();
	}

	public Hotbar() {
		try {
			BufferedImage backgroundImg = ImageIO.read(new File("hotbar.png"));
			setBounds(0, 0, WIDTH, HEIGHT);
			setLayout(new GridLayout(1, 5, 0, 0));
			for (int i = 0; i < myLabels.length; i++) {
				BufferedImage subImage = backgroundImg.getSubimage(i * BOXSIZE, 0, BOXSIZE, BOXSIZE);
				myLabels[i] = new JLabel();
				myLabels[i].setIcon(new ImageIcon(subImage));
				myLabels[i].setOpaque(true);
				myLabels[i].setBackground(Color.GRAY);
				myLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
				myLabels[i].setBorder(new EmptyBorder(0, 0, 0, 0));
				add(myLabels[i]);
				myLabels[i].setLayout(null);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
