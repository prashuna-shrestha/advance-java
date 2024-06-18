package labIV;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class ques1 extends JFrame{
	private JTextField txtcel, txtfah;
	public ques1() {
		setTitle("temperature converter");
		setSize(300,150);
		setLayout(new GridLayout(2,2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exit when the window is closed
		
		JLabel cel= new JLabel("Celsius number:");
		txtcel= new JTextField(10);
		JLabel fah = new JLabel("Fahrenheit:");
		txtfah= new JTextField(10);
		txtfah.setEditable(false);
		
		add(cel);
		add(txtcel);
		add(fah);
		add(txtfah);
		
		txtcel.addKeyListener(new KeyAdapter() {// keylistener class extends keyAdapter
			public void keyTyped(KeyEvent e) {// keyTyped method is overridden to call the convertTem method when the key is typed.
				convertTemperature();
			}
		});
		setVisible(true);
	}
	public void convertTemperature() {// method
		try {
			double celsius= Double.parseDouble(txtcel.getText());
			double fahrenheit=(celsius *9 / 5)+32;
			txtfah.setText(String.format("%.2f",fahrenheit));//convert the fahrenheit double value into a string with two decimal places.
			
		}catch(NumberFormatException e) {
			txtfah.setText("invalid input");
		}
	}
	public static void main(String[] args) {
		new ques1();
	}
}

