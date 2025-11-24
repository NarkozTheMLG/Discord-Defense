package GameSystem;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	int w = 200;
	int h = 70;
	
	int x = (Main.WIDTH-w)/2;
	int y = (Main.HEIGHT-h)/2;
	
	float minFontSize = 20;
	float maxFontSize = 30;
	
	public MainMenu() {
		this.setPreferredSize(new Dimension(1024,768));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		
		JButton playButton = new JButton("PLAY");
		playButton.setBounds(x, y, w, h);
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playButton.setBounds(x-10, y-10, w+20, h+20);
				playButton.setFont(playButton.getFont().deriveFont(maxFontSize));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				playButton.setBounds(x, y, w, h);
				playButton.setFont(playButton.getFont().deriveFont(minFontSize));
			}
		});
		playButton.setBackground(SystemColor.menuText);
		playButton.setForeground(new Color(255, 21, 21));
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.startGame();
				
			}
		});
		setLayout(null);
		add(playButton);
	}
}
