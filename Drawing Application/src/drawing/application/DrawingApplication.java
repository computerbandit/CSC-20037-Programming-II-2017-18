/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.application;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author w4f21
 */
public class DrawingApplication {

    /**
     * @param args the command line arguments
     */
    private JFrame frame;
    private JPanel controlPanel, messageArea, mousePosPanel, drawingToolsPanel, gridPanel, colorPickerPanel, colorMainDisplay;
    private JScrollPane sidebar;
    private JMenuBar menuBar;
    private JMenu fileMenu, toolsMenu, toolsMenuMsgBoxMenu;
    private JMenuItem fileSaveMenuItem, fileNewMenuItem, fileLoadMenuItem, fileOptionsMenuItem, toolsClearMenuItem;
    private JLabel mousePosLabel;
    private JCheckBox fineCheckBox, coarseCheckBox;
    private JButton colorPickerButton;
    private JRadioButton freehand, line, shape;
    private JSlider freehandSizeSlider;
    private static JTextArea msgBox;

    private Canvas canvas;

    public DrawingApplication() {
        initGUI();
    }

    private void initGUI() {

        //Main Frame
        frame = new JFrame("Paint 0.1");
        //Frame Settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1000, 1000));
        frame.setResizable(true);
        frame.setLayout(new BorderLayout(0, 0));
        frame.setLocationRelativeTo(null);

        //JPanels Initalization
        controlPanel = new JPanel(new FlowLayout());
        messageArea = new JPanel(new BorderLayout());
        mousePosPanel = new JPanel(new BorderLayout());
        drawingToolsPanel = new JPanel(new BorderLayout());
        gridPanel = new JPanel(new BorderLayout());
        colorPickerPanel = new JPanel(new BorderLayout());
        colorMainDisplay = new JPanel(new BorderLayout());
        canvas = new Canvas(this);

        //msgbox
        msgBox = new JTextArea();

        msgBox.setBackground(Color.white);
        msgBox.setEditable(false);
        msgBox.setRows(5);
        msgBox.setWrapStyleWord(true);
        msgBox.setText("Debug Console...");
        msgBox.setCaretPosition(msgBox.getDocument().getLength());
        JScrollPane scroll = new JScrollPane(msgBox);

        //MenuBar
        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        fileOptionsMenuItem = new JMenuItem("Options");
        fileSaveMenuItem = new JMenuItem("Save");
        fileLoadMenuItem = new JMenuItem("Load");
        fileNewMenuItem = new JMenuItem("New");

        toolsMenu = new JMenu("Tools");
        toolsMenuMsgBoxMenu = new JMenu("Message Box");
        toolsClearMenuItem = new JMenuItem("Clear");
        toolsClearMenuItem.addActionListener(new ClearMenuItemListener(this));

        //Labels
        mousePosLabel = new JLabel();
        mousePosLabel.setPreferredSize(new Dimension(100, 20));

        //Checkboxes
        fineCheckBox = new JCheckBox("Fine", true);
        coarseCheckBox = new JCheckBox("Coarse", false);
        coarseCheckBox.addChangeListener(new CheckBoxChangeListener(canvas));
        fineCheckBox.addChangeListener(new CheckBoxChangeListener(canvas));

        fileMenu.add(fileLoadMenuItem);
        fileMenu.add(fileNewMenuItem);
        fileMenu.add(fileSaveMenuItem);
        fileMenu.add(fileOptionsMenuItem);
        menuBar.add(fileMenu);
        toolsMenuMsgBoxMenu.add(toolsClearMenuItem);
        toolsMenu.add(toolsMenuMsgBoxMenu);
        menuBar.add(toolsMenu);

        //Buttons
        colorPickerButton = new JButton("Pick color");
        colorPickerButton.addActionListener(new ButtonActionListener(this));

        //Panel Settings
        controlPanel.setBorder(new TitledBorder(new EtchedBorder(), "Control Panel"));
        controlPanel.setPreferredSize(new Dimension(220, 1000));

        colorPickerPanel.setBorder(new TitledBorder(new EtchedBorder(), "Color Picker"));
        colorPickerPanel.setPreferredSize(new Dimension(210, 90));
        colorMainDisplay.setBackground(canvas.getColorMain());
        colorMainDisplay.setPreferredSize(new Dimension(50, 50));

        colorPickerPanel.add(colorPickerButton, BorderLayout.LINE_START);
        colorPickerPanel.add(colorMainDisplay, BorderLayout.CENTER);

        gridPanel.setBorder(new TitledBorder(new EtchedBorder(), "Grid"));
        gridPanel.setPreferredSize(new Dimension(210, 55));

        gridPanel.add(fineCheckBox, BorderLayout.LINE_START);
        gridPanel.add(coarseCheckBox, BorderLayout.LINE_END);

        drawingToolsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Drawing Tools"));
        drawingToolsPanel.setPreferredSize(new Dimension(210, 150));

        freehand = new JRadioButton("Freehand");
        freehandSizeSlider = new JSlider(SwingConstants.HORIZONTAL, 1, 20, 5);
        freehandSizeSlider.setMajorTickSpacing(19);
        freehandSizeSlider.setMinorTickSpacing(1);
        freehandSizeSlider.setPaintTicks(true);
        freehandSizeSlider.setPaintLabels(true);
        freehandSizeSlider.setPaintTrack(true);
        freehandSizeSlider.addChangeListener(new FreehandSliderListener(this));

        shape = new JRadioButton("Shape");
        line = new JRadioButton("Line");

        ButtonGroup tools = new ButtonGroup();
        tools.add(freehand);
        tools.add(line);
        tools.add(shape);

        drawingToolsPanel.add(freehand, BorderLayout.PAGE_START);
        drawingToolsPanel.add(freehandSizeSlider, BorderLayout.LINE_END);
        drawingToolsPanel.add(line, BorderLayout.LINE_START);
        drawingToolsPanel.add(shape, BorderLayout.AFTER_LAST_LINE);

        mousePosPanel.setBorder(new TitledBorder(new EtchedBorder(), "Mouse Postion"));
        mousePosPanel.setPreferredSize(new Dimension(210, 50));
        mousePosPanel.add(mousePosLabel, BorderLayout.LINE_START);

        controlPanel.add(mousePosPanel, BorderLayout.CENTER);
        controlPanel.add(colorPickerPanel, BorderLayout.CENTER);
        controlPanel.add(drawingToolsPanel, BorderLayout.CENTER);
        controlPanel.add(gridPanel, BorderLayout.CENTER);

        //sidebar
        sidebar = new JScrollPane(controlPanel);
        sidebar.setPreferredSize(new Dimension(250, 500));

        canvas.setBorder(new LineBorder(Color.gray));
        canvas.setPreferredSize(new Dimension(500, 500));
        canvas.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        canvas.addMouseMotionListener(new CanvasMouseMotionListener(this));
        canvas.addMouseListener(new CanvasMouseListener(this));
        canvas.setBackground(Color.white);

        messageArea.setBorder(new TitledBorder(new EtchedBorder(), "Message Area"));
        messageArea.setPreferredSize(new Dimension(750, 120));
        messageArea.add(scroll, BorderLayout.PAGE_START);

        //Adding Componentsto the Frame
        frame.add(menuBar, BorderLayout.PAGE_START);
        frame.add(sidebar, BorderLayout.LINE_START);
        frame.add(canvas, BorderLayout.CENTER);
        frame.add(messageArea, BorderLayout.PAGE_END);

        frame.pack();

        //Finally
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            // handle exception
        }
        DrawingApplication app = new DrawingApplication();
    }

    public JSlider getFreehandSlider() {
        return freehandSizeSlider;
    }

    public boolean getFreehandTool() {
        return freehand.isSelected();
    }
    public boolean getShapeTool() {
        return shape.isSelected();
    }

    public boolean getFineCheckBoxIsSelected() {
        return fineCheckBox.isSelected();
    }

    public boolean getCoarseCheckBoxIsSelected() {
        return coarseCheckBox.isSelected();
    }

    public JLabel getMousePosLabel() {
        return mousePosLabel;
    }

    public JPanel getColorMainDisplay() {
        return colorMainDisplay;
    }

    public JButton getColorPickerButton() {
        return colorPickerButton;
    }

    public static JTextArea getMsgBox() {
        return msgBox;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    
}
