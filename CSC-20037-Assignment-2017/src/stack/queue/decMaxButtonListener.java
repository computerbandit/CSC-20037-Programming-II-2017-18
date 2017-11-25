package stack.queue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class decMaxButtonListener implements ActionListener {

    StackQueue appRef;

    public decMaxButtonListener(StackQueue appRef) {
        this.appRef = appRef;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (appRef.appState) {
            if (appRef.getStack().getMax() > 8) {
                appRef.getStack().setMax(appRef.getStack().getMax() - 1);
            }
        } else {
            if (appRef.getQueue().getMax() > 8) {
                appRef.getQueue().setMax(appRef.getQueue().getMax() - 1);
            }
        }
        appRef.getCanvas().repaint();
        appRef.updateInfo();
    }

}
