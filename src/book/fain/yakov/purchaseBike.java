package book.fain.yakov;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;


public class purchaseBike extends JFrame implements ActionListener{
	
	JPanel windowContent;
	JTextField countBike;
	JButton enterThePurchase;
	JLabel text;
	JComboBox modelBike1;
	
	public purchaseBike() {
		
		Font font = new Font("Consolas", Font.BOLD, 20);
		
		windowContent = new JPanel();
		windowContent.setLayout(new FlowLayout());
		
		JPanel bottomPanel = new JPanel();
		
		text = new JLabel("");
		text.setFont(font);
		
		enterThePurchase = new JButton("Замовити");
		enterThePurchase.addActionListener(this);
		enterThePurchase.setFont(font);
		
		windowContent.add("South", bottomPanel);
		bottomPanel.add("Center", enterThePurchase);
		bottomPanel.add(text);
		text.setText("Виберіть модель та кількість шт.");
		
		
		JPanel p1 = new JPanel();
		windowContent.add("South", p1);
		
		String[] bikes = {"Bike1", "Bike2", "Bike3", "Bike4", "Bike5"};
		modelBike1 = new JComboBox(bikes);
		modelBike1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {		
				
			}
		});
		modelBike1.setFont(font);
		
		JLabel lab1 = new JLabel("Model Bike: ");
		lab1.setFont(font);
		p1.add(lab1);
		p1.add(modelBike1);
		
		
		JPanel p2 = new JPanel();
		windowContent.add(p2);
		
		countBike = new JFormattedTextField(0);
		countBike.setColumns(10);
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


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String selectedModel = (String) modelBike1.getSelectedItem();
		String selectedQuantity = countBike.getText();
		
		int quantity = Integer.parseInt(selectedQuantity);
		
		
		try {
			checkOrder(selectedModel, quantity);
			text.setText("Ваше замовлення прийнято!");
		} catch (TooManyBikesException e1) {
		}
		
	}
	
	
	void checkOrder (String modelBike, int quantity) throws TooManyBikesException{
		
		if (modelBike.equals("Bike1") && quantity >= 3) {
			throw new TooManyBikesException("Неможливо доставити " + quantity 
					+ " велосипедів моделі " + modelBike + " за одну доставку.");
		} else if (modelBike.equals("Bike2") && quantity >= 5) {
			throw new TooManyBikesException("Неможливо доставити " + quantity 
					+ " велосипедів моделі " + modelBike + " за одну доставку.");
		} else if (modelBike.equals("Bike3") && quantity >= 10) {
			throw new TooManyBikesException("Неможливо доставити " + quantity 
					+ " велосипедів моделі " + modelBike + " за одну доставку.");
		} else if (modelBike.equals("Bike4") && quantity >= 2) {
			throw new TooManyBikesException("Неможливо доставити " + quantity 
					+ " велосипедів моделі " + modelBike + " за одну доставку.");
		}  else if (modelBike.equals("Bike5") && quantity >= 7) {
			throw new TooManyBikesException("Неможливо доставити " + quantity 
					+ " велосипедів моделі " + modelBike + " за одну доставку.");
		} else if (modelBike.equals("")) {
			throw new TooManyBikesException("Заповніть поле моделі");
		} else if (quantity == 0) {
			throw new TooManyBikesException("Заповніть поле кількості велосипедів.");
		}	
		
	}
	
	
	public static void main(String[] args) {		
		new purchaseBike();
	}
	
	
}


class TooManyBikesException extends Exception {
	
	public TooManyBikesException(String newExc) {
		
		JOptionPane.showMessageDialog(null, newExc, "Error", JOptionPane.INFORMATION_MESSAGE);
	}
}
