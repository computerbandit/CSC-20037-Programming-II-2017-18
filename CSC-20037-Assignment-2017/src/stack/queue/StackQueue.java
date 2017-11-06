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
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author w4f21
 */
public class StackQueue {

    //Borders
    private Border blackline = BorderFactory.createLineBorder(Color.gray);
    private Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    private JFrame frame;
    private JMenuBar menubar;
    private JMenu fileMenu, editMenu, aboutMenu;
    private JMenuItem newMenuItem, loadMenuItem, saveMenuItem, saveAsMenuItem;

    private JPanel toolPanel, dataPanel;

    private Canvas canvas;
    //Drawable stack and queue
    private final DStack userStack;
    private final Rect rect1 = new Rect(100, 100, 100, 100);

    public StackQueue() {
        userStack = new DStack();
        userStack.push(rect1);
        userStack.push(rect1);
        userStack.push(rect1);
        userStack.push(rect1);
        initGUI();

    }

    private void initGUI() {

        //Making the main frame for the application simple layout
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800, 640));
        frame.setTitle("CSC-20037 Stacks and Queues || 0.1a");

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

        menubar.add(fileMenu);
        menubar.add(editMenu);
        menubar.add(aboutMenu);

        frame.add(menubar, BorderLayout.PAGE_START);
        frame.add(canvas, BorderLayout.CENTER);
        frame.add(dataPanel, BorderLayout.SOUTH);
        frame.add(toolPanel, BorderLayout.LINE_START);

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

    public Canvas getCanvas() {
        return canvas;
    }

    public DStack getDStack() {
        return userStack;
    }
    
    public Rect getRect(){
        return rect1;
    }
}
