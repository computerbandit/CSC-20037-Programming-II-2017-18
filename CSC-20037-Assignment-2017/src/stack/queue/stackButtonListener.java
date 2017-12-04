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
            try {
                appRef.setStack(Queue.toStack(appRef.getQueue()));
            } catch (LinkedListException ex) {
                StackQueue.log(ex.getCause().getMessage());
            }
            appRef.getEmptyStackButton().setEnabled(true);
            appRef.getCanvas().repaint();
        }
        appRef.updateInfo();
    }

}
