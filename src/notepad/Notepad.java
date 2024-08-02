package notepad;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Notepad extends Frame implements ActionListener {
    TextArea textArea;
    File file;
    Label statusBar;
    int zoomLevel = 100; // Default zoom level

    public Notepad() {
        setTitle("Simple Notepad");
        setSize(500, 500);

        textArea = new TextArea();
        textArea.setPreferredSize(new Dimension(400, 400)); // Set preferred size to enable word wrap
        add(textArea, BorderLayout.CENTER);

        statusBar = new Label("Ready");
        add(statusBar, BorderLayout.SOUTH);

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");

        newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);

        Menu viewMenu = new Menu("View");
        MenuItem zoomInMenuItem = new MenuItem("Zoom In");
        MenuItem zoomOutMenuItem = new MenuItem("Zoom Out");

        zoomInMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                zoomIn();
            }
        });

        zoomOutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                zoomOut();
            }
        });

        viewMenu.add(zoomInMenuItem);
        viewMenu.add(zoomOutMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);

        setMenuBar(menuBar);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New":
                textArea.setText("");
                file = null;
                statusBar.setText("New File Created");
                break;
            case "Open":
                FileDialog fileDialog = new FileDialog(this, "Open File", FileDialog.LOAD);
                fileDialog.setVisible(true);
                String filename = fileDialog.getFile();
                if (filename != null) {
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileDialog.getDirectory() + filename));
                        textArea.setText("");
                        String line;
                        while ((line = reader.readLine()) != null) {
                            textArea.append(line + "\n");
                        }
                        reader.close();
                        file = new File(fileDialog.getDirectory() + filename);
                        statusBar.setText("File Opened: " + filename);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                break;
            case "Save":
                if (file == null) {
                    FileDialog saveDialog = new FileDialog(this, "Save File", FileDialog.SAVE);
                    saveDialog.setVisible(true);
                    String saveFilename = saveDialog.getFile();
                    if (saveFilename != null) {
                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter(saveDialog.getDirectory() + saveFilename));
                            writer.write(textArea.getText());
                            writer.close();
                            file = new File(saveDialog.getDirectory() + saveFilename);
                            statusBar.setText("File Saved: " + saveFilename);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        writer.write(textArea.getText());
                        writer.close();
                        statusBar.setText("File Saved: " + file.getName());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }

    public void zoomIn() {
        if (zoomLevel < 200) { // Limit zoom level to 200%
            zoomLevel += 10;
            Font font = new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), zoomLevel);
            textArea.setFont(font);
            statusBar.setText("Zoom Level: " + zoomLevel + "%");
        }
    }

    public void zoomOut() {
        if (zoomLevel > 50) { // Limit zoom level to 50%
            zoomLevel -= 10;
            Font font = new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), zoomLevel);
            textArea.setFont(font);
            statusBar.setText("Zoom Level: " + zoomLevel + "%");
        }
    }

    public static void main(String[] args) {
        new Notepad();
    }
}



