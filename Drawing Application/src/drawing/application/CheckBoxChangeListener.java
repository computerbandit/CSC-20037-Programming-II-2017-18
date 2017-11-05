package drawing.application;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CheckBoxChangeListener implements ChangeListener {
    
    private Canvas canvas;
    public CheckBoxChangeListener(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        canvas.repaint();
    }
}
