package GameSystem;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton {
	Button(int x, int y, ImageIcon img, String type) {
		int scaledX = x - MainMenu.posScale;
		int scaledY = y - MainMenu.posScale;

		int width = MainMenu.buttonWidth;
		int height = MainMenu.buttonHeight;

		int scaledW = width + MainMenu.sizeScale;
		int scaledH = height + MainMenu.sizeScale;
		//
		Image quitScaledImg = img.getImage().getScaledInstance(scaledW, scaledH, Image.SCALE_SMOOTH);
		ImageIcon hoverImg = new ImageIcon(quitScaledImg);
		//
		this.setIcon(img);
		this.setBounds(x, y, width, height);
		this.setContentAreaFilled(false);// this removes buttons paint
		this.setBorder(null); // this removes the border around button
		this.setFocusPainted(false); // this removes the border around the text
		// event handlers //////////////////////////
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
