package stack.queue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

public class loadFileListener implements ActionListener {

    StackQueue appRef;
    public loadFileListener(StackQueue appRef) {
        this.appRef = appRef;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(fileChooser);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            StackQueue.log("Selected file: " + selectedFile.getAbsolutePath());
            appRef.loadFile(selectedFile);
            
        }

    }
}
