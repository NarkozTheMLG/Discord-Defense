package GameSystem;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton {
	private int posScale = 4;
	private int sizeScale = 8;
	private int width = (int)(456 * Main.scalerX);
	private int height = (int)(140 * Main.scalerY);
	int scaledW = width + sizeScale;
	int scaledH = height + sizeScale;
	
	Button(int x, int y, ImageIcon img, String type) {
		int scaledX = x - posScale;
		int scaledY = y - posScale;
		//

		Image quitScaledImg = img.getImage().getScaledInstance(scaledW, scaledH, Image.SCALE_SMOOTH);
		ImageIcon hoverImg = new ImageIcon(quitScaledImg);
		//
		this.setIcon(img);
		this.setBounds(x, y, width, height);
		this.setBorder(null); // this removes the border around button
		// event handlers //
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setIcon(hoverImg);
				setBounds(scaledX, scaledY, scaledW, scaledH);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				setIcon(img);
				setBounds(x, y, width, height);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				setBorder(null); // this removes the border around button
			}
		});
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (type.equalsIgnoreCase("Start"))
					Main.startGame();
				else if (type.equalsIgnoreCase("Quit"))
					Main.quitGame();

			}
		});
	}
}
