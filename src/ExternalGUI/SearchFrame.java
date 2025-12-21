package ExternalGUI;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchFrame extends JFrame{
	private JTextField textField;
	private JTextField descTF;

	public SearchFrame(){
		getContentPane().setLayout(null);
		
		JComboBox ItemCB = new JComboBox();
		ItemCB.setBounds(68, 25, 112, 21);
		getContentPane().add(ItemCB);
		ItemCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		textField = new JTextField();
		textField.setBounds(271, 26, 130, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(32, 29, 23, 13);
		getContentPane().add(idLabel);
		
		JLabel itemNameLabel = new JLabel("Item Name:");
		itemNameLabel.setBounds(214, 29, 61, 13);
		getContentPane().add(itemNameLabel);
		
		descTF = new JTextField();
		descTF.setBounds(269, 109, 160, 131);
		getContentPane().add(descTF);
		descTF.setColumns(10);
		
		JLabel PhotoLabel = new JLabel(" ");
		PhotoLabel.setBounds(57, 109, 145, 131);
		getContentPane().add(PhotoLabel);
		
		JLabel itemPhotoLabel = new JLabel("Item Photo:");
		itemPhotoLabel.setBounds(57, 86, 61, 13);
		getContentPane().add(itemPhotoLabel);
		
		JLabel descLabel = new JLabel("Description:");
		descLabel.setBounds(271, 86, 61, 13);
		getContentPane().add(descLabel);
		
	}
}
