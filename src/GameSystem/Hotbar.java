package GameSystem;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;

public class Hotbar extends JPanel {
	private static final long serialVersionUID = 1L;
	public int height = 96;
	public int width = 480;
	public int itemRatio = 96;
	

	
	public Hotbar() {
		try {
			System.out.println("Current Directory: " + new File(".").getAbsolutePath());
			BufferedImage backgroundImg = ImageIO.read(new File("hotbar.png"));
		System.out.print("Entered hotbar");
		setBounds(0,0,width,height);
		setLayout(new GridLayout(1, 5, 0, 0));	
		for (int i = 0; i < 5; i++) {
			BufferedImage subImage = backgroundImg.getSubimage(i*itemRatio, 0, itemRatio, itemRatio);
		    JLabel myLabel = new JLabel();
		    
		    myLabel.setIcon(new ImageIcon(subImage));
		    myLabel.setOpaque(true);
		    myLabel.setBackground(Color.GRAY);
		    myLabel.setHorizontalAlignment(SwingConstants.CENTER);

		    myLabel.setBorder(new EmptyBorder(0,0,0,0));
		    add(myLabel);
		}
		
		}catch (IOException e) {
		    e.printStackTrace();
		}
	}
}
