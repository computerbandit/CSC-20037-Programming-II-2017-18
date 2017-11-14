/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.queue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author w4f21
 */
public class StackQueue {

    //Borders
    private Border blackline = BorderFactory.createLineBorder(Color.gray);
    private JFrame frame;
    private JMenuBar menubar;
    private JMenu fileMenu, editMenu, aboutMenu;
    private JMenuItem newMenuItem, loadMenuItem, saveMenuItem, saveAsMenuItem;
    private static JTextArea msgBox;
    private JPanel toolPanel, dataPanel;

    private Canvas canvas;
    //Drawable stack and queue
    private final DStack userStack;

    public StackQueue() {
        int padding = 10;

        initGUI();
        userStack = new DStack(new Point(canvas.getWidth()/2, canvas.getHeight()/2));
        
    }

    private void initGUI() {

        //Making the main frame for the application simple layout
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 720));
        frame.setTitle("CSC-20037 Stacks and Queues || 0.1a");
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //Menu Bar Stuff
        menubar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        aboutMenu = new JMenu("About");

        newMenuItem = new JMenuItem("New");
        loadMenuItem = new JMenuItem("Load");
        saveMenuItem = new JMenuItem("Save");
        saveAsMenuItem = new JMenuItem("Save As");

        //Adding all menu bar Items into the menubar and then adding that to the frame.
        fileMenu.add(newMenuItem);
        fileMenu.add(loadMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);

        canvas = new Canvas(this);
        canvas.setBorder(new LineBorder(Color.gray));
        canvas.setPreferredSize(new Dimension(500, 500));
        canvas.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        canvas.addMouseListener(new CanvasMouseListener(this));
        canvas.setBackground(Color.white);

        toolPanel = new JPanel();
        toolPanel.setBorder(blackline);
        toolPanel.setPreferredSize(new Dimension(250, 400));

        dataPanel = new JPanel();
        dataPanel.setBorder(blackline);
        dataPanel.setPreferredSize(new Dimension(400, 200));

        //msgbox
        msgBox = new JTextArea();

        msgBox.setBackground(Color.white);
        msgBox.setEditable(false);
        msgBox.setAutoscrolls(true);
        msgBox.setRows(5);
        msgBox.setWrapStyleWord(true);
        msgBox.setPreferredSize(new Dimension(500, 120));
        msgBox.setText("Debug Console...");
        msgBox.setCaretPosition(msgBox.getDocument().getLength());
        JScrollPane scroll = new JScrollPane(msgBox);

        dataPanel = new JPanel();
        dataPanel.setBorder(blackline);

        dataPanel.setPreferredSize(new Dimension(600, 120));
        dataPanel.add(scroll, BorderLayout.EAST);

        menubar.add(fileMenu);
        menubar.add(editMenu);
        menubar.add(aboutMenu);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.3;

        c.ipady = 500;
        c.insets = new Insets(10, 10, 0, 10);

        mainPanel.add(toolPanel, c);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.7;

        c.ipady = 500;
        mainPanel.add(canvas, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 1.0;   //request any extra vertical space
        c.ipady = 100;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        mainPanel.add(dataPanel, c);

        frame.add(menubar, BorderLayout.PAGE_START);
        frame.add(mainPanel);

        //frame.pack();
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            // handle exception
        }

        StackQueue app = new StackQueue();
    }

    public static void log(String s) {
        msgBox.append("\n " + s);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public DStack getDStack() {
        return userStack;
    }

}
