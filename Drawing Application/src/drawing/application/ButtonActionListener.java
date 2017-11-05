package drawing.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;

public class ButtonActionListener implements ActionListener {

    //this is a commit made from the net beans app
    
    DrawingApplication appRef;
    public ButtonActionListener(DrawingApplication appRef) {
        this.appRef = appRef;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Canvas canvas = appRef.getCanvas();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        JColorChooser colourChooser = new JColorChooser(canvas.getColorMain());
        canvas.setColorMain(JColorChooser.showDialog(null, "Choose new drawing colour", canvas.getColorMain()));
        appRef.getColorMainDisplay().setBackground(canvas.getColorMain());
        appRef.getColorPickerButton().setBackground(canvas.getColorMain());
        canvas.repaint();
    }
}
