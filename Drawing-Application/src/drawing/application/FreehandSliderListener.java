package drawing.application;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FreehandSliderListener implements ChangeListener {

    DrawingApplication appRef;
    
    public FreehandSliderListener(DrawingApplication appRef) {
        this.appRef = appRef;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        appRef.getCanvas().setFreehandSize(appRef.getFreehandSlider().getValue());
        appRef.getCanvas().repaint();
    }

}
