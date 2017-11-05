package drawing.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearMenuItemListener implements ActionListener {

    DrawingApplication appRef;

    public ClearMenuItemListener(DrawingApplication appRef) {
        this.appRef = appRef;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MessageBox.clear();
    }
}
