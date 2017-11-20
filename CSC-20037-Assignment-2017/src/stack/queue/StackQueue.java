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
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
    private JButton stackButton, queueButton, addButton, removeButton;
    
    private Canvas canvas;
    //Drawable stack and queue
    private final Stack stack;
    private final Queue queue;
    private boolean appState;
    
    public StackQueue() {
        initGUI();
        /*stack stuff*/
        stack = new Stack();
        queue = new Queue();
        
        appState = true;
    }
    
    private void initGUI() {

        //Making the main frame for the application simple layout
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 720));
        frame.setTitle("CSC-20037 Stacks and Queues || 0.2sa");
        frame.addComponentListener(new onResizeListener());

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
        
        toolPanel = new JPanel(new GridLayout(10, 1));
        toolPanel.setBorder(blackline);
        toolPanel.setPreferredSize(new Dimension(250, 400));
        
        stackButton = new JButton("Stack");
        stackButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        stackButton.setBackground(new Color(0, 51, 204));
        stackButton.setForeground(new Color(0, 51, 204));
        stackButton.setFocusPainted(false);
        stackButton.setBorderPainted(false);
        toolPanel.add(stackButton);
        
        queueButton = new JButton("Queue");
        toolPanel.add(queueButton);
        toolPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        
        addButton = new JButton("Add");
        addButton.addActionListener(new addButtonListener(this));
        toolPanel.add(addButton);
        
        removeButton = new JButton("Remove");
        removeButton.addActionListener(new removeButtonListener(this));
        toolPanel.add(removeButton);
        
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
        
        frame.add(menubar, BorderLayout.PAGE_START);
        frame.add(toolPanel, BorderLayout.WEST);
        frame.add(canvas, BorderLayout.CENTER);
        frame.add(dataPanel, BorderLayout.PAGE_END);

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
    
    public Stack getStack() {
        return stack;
    }

    private static class onResizeListener implements ComponentListener {

        public onResizeListener() {
        }

        @Override
        public void componentResized(ComponentEvent e) {
        }

        @Override
        public void componentMoved(ComponentEvent e) {
        }

        @Override
        public void componentShown(ComponentEvent e) {
        }

        @Override
        public void componentHidden(ComponentEvent e) {
        }
    }
}
