package lab2;
import java.awt.*;
import java.awt.event.*;

public class ques1c extends Frame implements MouseListener {
	
    Label label;

    public ques1c() {
    	super("Java MouseEvent Examples");
        label = new Label("");
        label.setBounds(50, 100, 200, 30);
        label.addMouseListener(this);

        add(label);

        setSize(300, 200);
        setLayout(null);
        setVisible(true);

        // Adding window listener inside the constructor
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose(); // Closing the frame
            }
        });
    }

    public void mouseClicked(MouseEvent e) {
  
    }

    public void mouseEntered(MouseEvent e) {
       
    }

    public void mouseExited(MouseEvent e) {
    	label.setText("Mouse exited");
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
   
    }

    public static void main(String[] args) {
        new ques1c();
    }
}
