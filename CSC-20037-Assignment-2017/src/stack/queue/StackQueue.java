package stack.queue;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author w4f21
 */
public final class StackQueue {

    public Font font;

    //Borders
    private JFrame frame;
    private JMenuBar menubar;
    private JMenu fileMenu, editMenu, aboutMenu;
    private JMenuItem newMenuItem, loadMenuItem, saveMenuItem, saveAsMenuItem;
    private static JTextArea msgBox;
    private JTextField inputTextField;
    private JPanel toolPanel, dataPanel;
    private JButton stackButton, queueButton, addButton, removeButton, removeAllButton, reverseButton, clearMsgBox;
    private final JLabel[] info = new JLabel[3];

    File file = new File("stack.txt");
    String line = null;

    private Canvas canvas;
    private Stack stack;
    private Queue queue;
    public boolean appState;

    public StackQueue() {
        font = new Font("Tahoma", Font.BOLD, 18);
        initGUI();
        appState = true;
        stack = new Stack(15);
        queue = new Queue(15);
        loadFile(file);
    }

    private void initGUI() {

        //Making the main frame for the application simple layout
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 720));
        frame.setTitle("CSC-20037 Stacks and Queues || 0.2sa");

        //Menu Bar Stuff
        menubar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        aboutMenu = new JMenu("About");

        newMenuItem = new JMenuItem("New");
        loadMenuItem = new JMenuItem("Load");
        loadMenuItem.addActionListener(new loadFileListener(this));
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
        canvas.setBackground(Color.white);

        toolPanel = new JPanel(new GridLayout(8, 1));
        toolPanel.setBorder(new LineBorder(Color.gray));
        toolPanel.setPreferredSize(new Dimension(250, 400));
        toolPanel.setBackground(Color.white);

        JPanel subPanel3 = new JPanel(new GridLayout(1, 2));

        info[0] = new JLabel("Stack");
        info[0].setFont(font);
        info[0].setHorizontalAlignment(0);
        info[1] = new JLabel("Size: ");
        info[1].setFont(font);

        subPanel3.add(info[0]);
        subPanel3.add(info[1]);
        toolPanel.add(subPanel3);

        JPanel subPanel2 = new JPanel(new GridLayout(2, 2));
        stackButton = new JButton("Stack");
        stackButton = buttonDesign(stackButton, new Color(71, 55, 135));
        stackButton.addActionListener(new stackButtonListener(this));
        subPanel2.add(stackButton);

        JButton incMax = new JButton("+");
        incMax = buttonDesign(incMax, new Color(119, 244, 66));
        incMax.addActionListener(new incMaxButtonListener(this));
        subPanel2.add(incMax);

        queueButton = new JButton("Queue");
        queueButton = buttonDesign(queueButton, new Color(71, 55, 135));
        queueButton.addActionListener(new queueButtonListener(this));
        subPanel2.add(queueButton);

        JButton decMax = new JButton("-");
        decMax = buttonDesign(decMax, new Color(244, 65, 65));
        decMax.addActionListener(new decMaxButtonListener(this));
        subPanel2.add(decMax);

        toolPanel.add(subPanel2);

        toolPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        JPanel subPanel1 = new JPanel(new GridLayout(1, 2));
        inputTextField = new JTextField();
        inputTextField.addActionListener(new addButtonListener(this));
        inputTextField.setFont(new Font("Tahoma", Font.BOLD, 18));

        subPanel1.add(inputTextField);
        addButton = new JButton("Add");
        addButton = buttonDesign(addButton, new Color(55, 135, 56));
        addButton.addActionListener(new addButtonListener(this));

        subPanel1.add(addButton);
        toolPanel.add(subPanel1);

        removeButton = new JButton("Remove");
        removeButton = buttonDesign(removeButton, new Color(55, 135, 56));
        removeButton.addActionListener(new removeButtonListener(this));
        toolPanel.add(removeButton);

        removeAllButton = new JButton("Remove All");
        removeAllButton = buttonDesign(removeAllButton, Color.RED);
        removeAllButton.addActionListener(new removeAllButtonListener(this));
        toolPanel.add(removeAllButton);
        toolPanel.add(new JSeparator(SwingConstants.HORIZONTAL));

        reverseButton = new JButton("Reverse");
        reverseButton = buttonDesign(reverseButton, Color.BLACK);
        reverseButton.addActionListener(new reverseButtonListener(this));
        toolPanel.add(reverseButton);

        dataPanel = new JPanel();
        dataPanel.setBorder(new LineBorder(Color.gray));
        dataPanel.setPreferredSize(new Dimension(400, 200));

        //msgbox
        msgBox = new JTextArea(4, 58);
        msgBox.setEditable(false);

        JScrollPane scroll = new JScrollPane(msgBox);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        dataPanel = new JPanel(new BorderLayout());
        dataPanel.setBorder(new LineBorder(Color.gray));

        clearMsgBox = new JButton("Clear");
        clearMsgBox = buttonDesign(clearMsgBox, Color.BLACK);
        clearMsgBox.addActionListener(new clearMsgBoxButtonListener());
        dataPanel.add(clearMsgBox);

        dataPanel.setPreferredSize(new Dimension(600, 120));
        dataPanel.add(scroll, BorderLayout.EAST);

        menubar.add(fileMenu);
        menubar.add(editMenu);
        menubar.add(aboutMenu);

        frame.add(menubar, BorderLayout.PAGE_START);
        frame.add(toolPanel, BorderLayout.WEST);
        frame.add(canvas, BorderLayout.CENTER);
        frame.add(dataPanel, BorderLayout.PAGE_END);

        frame.pack();
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
        msgBox.setCaretPosition(msgBox.getText().length());
    }

    public static void clearLog() {
        msgBox.setText("");
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public String dataInput() {
        return inputTextField.getText();
    }

    public Stack getStack() {
        return stack;
    }

    void setStack(Stack stack) {
        this.stack = stack;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public JLabel[] getInfo() {
        return info;
    }

    public JButton buttonDesign(JButton btn, Color c) {
        btn.setFont(new Font("Tahoma", Font.BOLD, 12));
        btn.setBackground(c);
        btn.setForeground(c);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(true);
        return btn;
    }

    public void loadFile(File file) {
        //loading defualt file with from the src folders
        try {
            //Filereader with correctly located file
            FileReader fileReader = new FileReader(file);
            //wrapped in a BufferedReader.
            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(fileReader);
            //Displaying Loaded file to the user in the msg Box.
            log("Loading Defualt File...");
            //iterating through each line of the text file until the end.
            stack.clear();
            int lineCount = 0;
            while ((line = bufferedReader.readLine()) != null) {
                lineCount++;
                if (stack.getMax() < lineCount) {
                    stack.setMax(stack.getMax() + 1);
                }
                log("Loading value: " + line);
                stack.push(Integer.parseInt(line));
            }
            appState = true;
            bufferedReader.close();
            log("File Loaded");
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + file + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + file + "'");
        }
        canvas.repaint();
        updateInfo();
    }

    public void updateInfo() {
        if (appState) {
            info[0].setText("Stack");
            info[1].setText("Size: " + stack.size(stack.peek()) + "/" + stack.MAX);
        } else {
            info[0].setText("Queue");
            info[1].setText("Size: " + queue.size(queue.peek()) + "/" + queue.MAX);
        }

    }
}
