package GameSystem;

import javax.swing.ImageIcon;

public class Items {
	int id;
	static public int count = 0;
	private int width;
	private int height;
	ImageIcon img;

	public Items(int id, int order) {
		count++;
		this.id = id;
		switch (id) {
		case 0: {
			img = new ImageIcon("img/items/ice.png");
			width = (int)(68 * Main.scalerX);
			height = (int)(68 * Main.scalerY);
			break;
		}
		default:
			System.out.println("Invalid item id!");
			break;
		}
	}

	public void use() {
		count--;
	}

	public ImageIcon getImage() {
		return img;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
