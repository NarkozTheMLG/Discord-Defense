package GameSystem;

import javax.swing.ImageIcon;

public class Items {
	int id;
	static int count = 0;
	private int width;
	private int height;
	ImageIcon img;

	Items(int id, int order) {
		count++;
		this.id = id;
		switch (id) {
		case 0: {
			img = new ImageIcon("ice.png");
			width = 17;
			height = 17;
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

	ImageIcon getImage() {
		return img;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
