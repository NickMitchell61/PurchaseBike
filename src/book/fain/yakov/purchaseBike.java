package book.fain.yakov;


import java.awt.Button;
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
	JLabel text;
	
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
		
		countBike = new JFormattedTextField(0);
		countBike.setColumns(30);
		countBike.setFont(font);
		
		JLabel lab2 = new JLabel("Count Bike: ");
		lab2.setFont(font);
		p2.add(lab2);
		p2.add(countBike);
		
		
		setContentPane(windowContent);
		setSize(800, 200);
		setLocation(600, 200);
		setTitle("Purchase Bike");
		setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String selectedModel = modelBike.getText();
		String selectedQuantity = countBike.getText();
		
		int quantity = Integer.parseInt(selectedQuantity);
		
		
		try {
			checkOrder(selectedModel, quantity);
			text.setText("Ваше замовлення прийнято!");
		} catch (TooManyBikesException e1) {
			text.setText(e1.getMessage());
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
		
		super(newExc);
		
	}
}
