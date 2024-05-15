package assignmentawt;
import java.awt.*;
import java.awt.event.*;

public class ques2 extends Frame {
    private TextField celsiusField, fahrenheitField;

    public ques2() {
        setTitle("Temperature Converter");
        setSize(300, 150);
        setLayout(new GridLayout(3, 2));
        
        Label celsiusLabel = new Label("Celsius:");
        celsiusField = new TextField();
        Label fahrenheitLabel = new Label("Fahrenheit:");
        fahrenheitField = new TextField();

        celsiusField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                convertTemperature();
            }
        });

        add(celsiusLabel);
        add(celsiusField);
        add(fahrenheitLabel);
        add(fahrenheitField);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });
        
        setVisible(true);
    }

    private void convertTemperature() {
        try {
            double celsius = Double.parseDouble(celsiusField.getText());
            double fahrenheit = celsius * 9 / 5 + 32;
            fahrenheitField.setText(String.format("%.2f", fahrenheit));
        } catch (NumberFormatException e) {
            fahrenheitField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new ques2();
    }
}
