package labIV;
import javax.swing.*;
import java.awt.*;

public class ques3 extends JFrame {
    public ques3() {
        setTitle("Tabbed Pane Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("Welcome to the Home Tab!"));

        JPanel profilePanel = new JPanel(new GridLayout(2, 2));
        profilePanel.add(new JLabel("Name:"));
        profilePanel.add(new JTextField());
        profilePanel.add(new JLabel("Email:"));
        profilePanel.add(new JTextField());

        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new BorderLayout());
        settingsPanel.add(new JLabel("Settings Tab"), BorderLayout.NORTH);
        JButton button = new JButton("Click Me");
        settingsPanel.add(button, BorderLayout.CENTER);

        tabbedPane.addTab("Home", homePanel);
        tabbedPane.addTab("Profile", profilePanel);
        tabbedPane.addTab("Settings", settingsPanel);

        add(tabbedPane);
    }

    public static void main(String[] args) {
      
            ques3 tabbedPane = new ques3();
            tabbedPane.setVisible(true);
        
    }
}

