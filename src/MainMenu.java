import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class MainMenu extends JPanel{

	public MainMenu() {
		this.setPreferredSize(new Dimension(1024,768));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}
}
