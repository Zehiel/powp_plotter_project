package edu.iis.powp.events.predefine;

import edu.iis.powp.app.Application;
import edu.iis.powp.appext.LineParametersManager;
import edu.kis.powp.drawer.shape.LineFactory;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by grusz on 31.03.2017.
 */
public class SelectBasicLineOptionListener implements ActionListener{


    @Override
    public void actionPerformed(ActionEvent e) {
        LineParametersManager lineParametersManager = Application.getComponent(LineParametersManager.class);
        lineParametersManager.setLine(LineFactory.getBasicLine());
    }
}
