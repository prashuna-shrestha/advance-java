package labIV;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ques2  extends JFrame{
 private JTextField num1,num2;
 private JTextField result;
 
 public ques2(){
	setTitle("sum and differences:");
	setSize(300,150);
	setLayout(new GridLayout(3,2));
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 JLabel number1= new JLabel("number one:");
	 num1= new JTextField(10);
	 JLabel number2= new JLabel("number two:");
	num2= new JTextField(10);
	JLabel results=new JLabel("result:");
	result= new JTextField(10);
	result.setEditable(false);
	add(number1);
	add(num1);
	add(number2);
	add(num2);
	add(results);
	add(result);
	// adding mouseadapter to handle the mousevent
	addMouseListener(new MouseAdapter(){
		public void mousePressed(MouseEvent e) {
			calculateSum();
		}
		
		public void mouseReleased(MouseEvent e) {
			calculateDifference();
		}
	});
	setVisible(true);
	 
 }
 public void calculateSum() {
	 try {
		 double number1= Double.parseDouble(num1.getText());
		 double number2= Double.parseDouble(num2.getText());
		 double sum= number1 +number2;
		 result.setText("sum:"+sum);
		 
	 }catch(NumberFormatException ex) {
		 result.setText("invalid input");
	 }
 }
 
 public void calculateDifference() {
	 try {
		 double number1= Double.parseDouble(num1.getText());
		 double number2= Double.parseDouble(num2.getText());
		 double diff= number1 - number2;
		 result.setText("Difference:"+diff);
		 
	 }catch(NumberFormatException ex) {
		 result.setText("invalid input");
	 }
 }
 public static void main(String[]args) {
	 new ques2();
 }
 
 
}
