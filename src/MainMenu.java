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
	
	public MainMenu() {
		this.setPreferredSize(new Dimension(1024,768));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		setLayout(null);
		
		JButton btnNewButton = new JButton("PLAY");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBounds(400-10, 197-10, w+20, h+20);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBounds(400, 197, w, h);

			}
		});
		btnNewButton.setBackground(SystemColor.menuText);
		btnNewButton.setForeground(new Color(255, 21, 21));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(400, 197, w, h);
		add(btnNewButton);
	}
}
