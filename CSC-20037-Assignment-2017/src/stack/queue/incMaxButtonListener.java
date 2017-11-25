package stack.queue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class incMaxButtonListener implements ActionListener {
    
    StackQueue appRef;
    
    public incMaxButtonListener(StackQueue appRef) {
        this.appRef = appRef;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (appRef.appState) {
            appRef.getStack().setMax(appRef.getStack().getMax() + 1);
        }else{
            appRef.getQueue().setMax(appRef.getQueue().getMax() + 1);
        }
        appRef.getCanvas().repaint();
        appRef.updateInfo();
    }
    
}
