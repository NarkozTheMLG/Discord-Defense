package GameSystem;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {
	public static int titleWidth = (int) (1050 * Main.scalerX); // 700
	public static int titleHeight = (int) (600 * Main.scalerY); // 400
	//
	final private float titleStartWidth = titleWidth;
	final private  float titleEndWidth = titleWidth + 70;;
	final private  float titleStartHeight = titleHeight;
	final private float titleEndHeight = titleHeight + 40;;
	private float acc = 0.008f;
	private float t = 0.00f;
	private boolean growing = true;

	ImageIcon titleRaw = new ImageIcon("img/title.png");
	Image titleImg = titleRaw.getImage().getScaledInstance(titleWidth, titleHeight, Image.SCALE_SMOOTH);

	public TitlePanel() {
		setOpaque(false);
		System.out.println("Size: " + titleEndWidth);

		setBounds(0, -30, (int) titleEndWidth + 500, (int) titleEndHeight);
		new javax.swing.Timer(16, e -> {
			updateAnimation();
			repaint();
		}).start();
	}

	public void updateAnimation() {
		titleWidth = (int) lerp(titleStartWidth, titleEndWidth, findT(t));
		titleHeight = (int) lerp(titleStartHeight, titleEndHeight, findT(t));
		if (growing) {
			t += acc;
			if (t >= 1.0f) {
				t = 1.0f;
				growing = false; // REVERSE DIRECTION
			}
		} else {
			t -= acc;
			if (t <= 0.0f) {
				t = 0.0f;
				growing = true; // REVERSE DIRECTION
			}
		}
	}

	private float lerp(float n1, float n2, float t) {
		return n1 + t * (n2 - n1);
	}

	private float findT(float t) {
		return 4 * t * (1 - t);
		// return 1 - Math.abs(2*t-1);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int x = (int) ((Main.WIDTH - titleWidth) / 2);
		int y = 0;
		if (titleImg == null)
			System.out.print("error");
		g2.drawImage(titleImg, x, y, titleWidth, titleHeight, null);
	}

}