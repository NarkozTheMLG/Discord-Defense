package ExternalGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

	public ExternalFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addB = new JButton("Add");
		addB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addB.setBounds(10, 11, 89, 23);
		contentPane.add(addB);
		
		JButton displayB = new JButton("Display");
		displayB.setBounds(217, 11, 89, 23);
		contentPane.add(displayB);
		
		JButton deleteB = new JButton("Delete");
		deleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteB.setBounds(109, 11, 89, 23);
		contentPane.add(deleteB);
		
		JButton searchB = new JButton("Search");
		searchB.setBounds(316, 11, 89, 23);
		contentPane.add(searchB);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 337, 910, 359);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 5, 0, 0));
		
		itemIDTF = new JTextField();
		itemIDTF.setBounds(131, 97, 86, 20);
		contentPane.add(itemIDTF);
		itemIDTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Item ID");
		lblNewLabel.setBounds(35, 100, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel statusL = new JLabel("StatusLabel");
		statusL.setBounds(30, 136, 410, 14);
		contentPane.add(statusL);
	}
}
