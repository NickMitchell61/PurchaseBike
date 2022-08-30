package book.fain.yakov;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class purchaseBike extends JFrame implements ActionListener{
	
	JPanel windowContent;
	JTextField modelBike;
	JTextField countBike;
	JButton enterThePurchase;
	
	public purchaseBike() {
		
		Font font = new Font("Consolas", Font.BOLD, 20);
		
		windowContent = new JPanel();
		windowContent.setLayout(new FlowLayout());
		
		JPanel bottomPanel = new JPanel();
		
		JTextArea text = new JTextArea("");
		text.setFont(font);
		
		enterThePurchase = new JButton("Замовити");
		enterThePurchase.addActionListener(this);
		enterThePurchase.setFont(font);
		
		windowContent.add("South", bottomPanel);
		bottomPanel.add("Center", enterThePurchase);
		bottomPanel.add(text);
		text.setText("Виберіть модель та кількість шт.");
		
		JPanel p1 = new JPanel();
		windowContent.add(p1);
		
		modelBike = new JFormattedTextField("");
		modelBike.setColumns(30);
		modelBike.setFont(font);
		
		JLabel lab1 = new JLabel("Model Bike: ");
		lab1.setFont(font);
		p1.add(lab1);
		p1.add(modelBike);
		
		
		JPanel p2 = new JPanel();
		windowContent.add(p2);
		
		countBike = new JFormattedTextField("");
		countBike.setColumns(30);
		countBike.setFont(font);
		
		JLabel lab2 = new JLabel("Count Bike: ");
		lab2.setFont(font);
		p2.add(lab2);
		p2.add(countBike);
		
	
		
		setContentPane(windowContent);
		setSize(600, 200);
		setLocation(600, 200);
		setTitle("Purchase Bike");
		setVisible(true);
		
	}
	

	public static void main(String[] args) {		
		new purchaseBike();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
