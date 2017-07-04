package edu.iis.powp.events.predefine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.client.plottermagic.preset.FiguresJoe;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.command.ComplexCommand;
import edu.iis.powp.command.ShapesFactory;

public class SelectTestFigureOptionListener implements ActionListener
{

    private int scriptNumber=1;

    public SelectTestFigureOptionListener(int scriptNumber) {
        this.scriptNumber=scriptNumber;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (scriptNumber == 1) {
            FiguresJoe.figureScript1(Application.getComponent(DriverManager.class).getCurrentPlotter());
        } else if (scriptNumber == 2) {
            FiguresJoe.figureScript2(Application.getComponent(DriverManager.class).getCurrentPlotter());
        }else if(scriptNumber == 3) {
            ComplexCommand complexCommand = new ShapesFactory().getRectangle(0,0,50,50);
            complexCommand.execute(Application.getComponent(DriverManager.class).getCurrentPlotter());

        }else if(scriptNumber == 4) {
            ComplexCommand complexCommand = new ShapesFactory().getTriangle(0,0,0,50, 50,0);
            complexCommand.execute(Application.getComponent(DriverManager.class).getCurrentPlotter());

        }else {
            //use figureScript1 as default or if demanded script not found
            FiguresJoe.figureScript1(Application.getComponent(DriverManager.class).getCurrentPlotter());
        }

    }
}
