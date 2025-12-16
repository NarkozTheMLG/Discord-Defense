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
			this.width = (int)(70 * Main.scalerX);
			this.height = (int)(70 * Main.scalerY);
			img = new ImageIcon(getClass().getResource("/img/items/ice.png"));
			break;
		}
		case 1:{
			img = new ImageIcon(getClass().getResource("/img/items/damage.png"));
			this.width = (int)(128 * Main.scalerX);
			this.height = (int)(128 * Main.scalerY);
			break;
		}
		case 2:{
			img = new ImageIcon(getClass().getResource("/img/items/energy.png"));
			this.width = (int)(113 *0.6* Main.scalerX);
			this.height = (int)(174 *0.6* Main.scalerY);
			break;
		}
		default:
			System.out.println("Invalid item id!");
			break;
		}
	}

	public void use() {
		switch (id) {
		case 0: {

			break;
		}
		case 1:{

			break;
		}
		case 2:{

			break;
		}
		default:
			System.out.println("Invalid item id!");
			break;
		}
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
