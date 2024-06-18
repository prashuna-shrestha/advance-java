package lab2;

import javax.swing.*;
import java.awt.*;

public class ques2 extends JFrame {
    public ques2() {
        // Set up the JFrame
        setTitle("Personal Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200); // Increased size for better display
        setLayout(new GridLayout(2, 3)); // Adjusted layout for better spacing

        // Create labels
        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");

        // Create text fields
        JTextField nameField = new JTextField(20);
        JTextField emailField = new JTextField(20);

        // Load and scale the image icon
        ImageIcon icon = new ImageIcon("D:\\prabha\\Pictures\\Messenger\\received_289864258523620.jpeg");
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Create label for the image icon
        JLabel iconLabel = new JLabel(scaledIcon);

        // Add components to the JFrame
        add(nameLabel);
        add(nameField);
        // Add a blank JLabel for spacing
        add(new JLabel());
        add(emailLabel);
        add(emailField);
        // Add icon label with its own cell
        add(iconLabel);

        // Set JFrame visibility
        setVisible(true);
    }

    public static void main(String[] args) {
        new ques2();
    }
}



