package stack.queue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class stackButtonListener implements ActionListener {

    StackQueue appRef;

    public stackButtonListener(StackQueue appRef) {
        this.appRef = appRef;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!appRef.appState) {
            appRef.appState = true;
            appRef.setStack(Queue.toStack(appRef.getQueue()));

            appRef.getCanvas().repaint();
        }
        appRef.updateInfo();
    }

}
