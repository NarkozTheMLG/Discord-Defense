package ExternalGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GameSystem.Items;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ExternalFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField itemIDTF;
	private JTextField slotTF;

	public ExternalFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addB = new JButton("Add");

		addB.setBounds(10, 11, 89, 23);
		contentPane.add(addB);
		
		JButton displayB = new JButton("Display");

		displayB.setBounds(217, 11, 89, 23);
		contentPane.add(displayB);
		
		JButton deleteB = new JButton("Delete");

		deleteB.setBounds(109, 11, 89, 23);
		contentPane.add(deleteB);
		
		JButton searchB = new JButton("Search");
		searchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		searchB.setBounds(316, 11, 89, 23);
		contentPane.add(searchB);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 161, 557, 126);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 5, 0, 0));
		
		JLabel[] itemLabels = new JLabel[5];
		for(JLabel i : itemLabels) {
			i = new JLabel();
			panel.add(i);
		}
		itemIDTF = new JTextField();
		itemIDTF.setBounds(128, 67, 86, 20);
		contentPane.add(itemIDTF);
		itemIDTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Item ID");
		lblNewLabel.setBounds(28, 70, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel statusL = new JLabel("StatusLabel");
		statusL.setBounds(30, 136, 410, 14);
		contentPane.add(statusL);
		
		JLabel lblSlotNumber = new JLabel("Slot number");
		lblSlotNumber.setBounds(28, 96, 90, 14);
		contentPane.add(lblSlotNumber);
		
		slotTF = new JTextField();
		slotTF.setColumns(10);
		slotTF.setBounds(128, 98, 86, 20);
		contentPane.add(slotTF);
		
		
		addB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SystemClass.add(Integer.parseInt(itemIDTF.getText()))) {
					statusL.setText("Item has been successfully added!");
				}
				else
					statusL.setText("Item could not be added!");

			}
		});
		
		displayB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Items[] items = SystemClass.display();
				int count  = 0 ;
				for(Items i :items) {
					itemLabels[count++].setIcon(i.getImage());
}
			}
		});
		deleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SystemClass.delete(Integer.parseInt(itemIDTF.getText())))
					statusL.setText("Item has been successfully deleted!");
				else
					statusL.setText("Item could not be deleted!");
			}
		});
	}
}
