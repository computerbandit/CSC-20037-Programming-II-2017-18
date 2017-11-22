/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.queue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author w4f21
 */
public class clearMsgBoxButtonListener implements ActionListener {

    public clearMsgBoxButtonListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StackQueue.clearLog();
    }

}
