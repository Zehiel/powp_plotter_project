package edu.iis.powp.adapter;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.app.Application;
import edu.iis.powp.appext.LineParametersManager;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.ILine;
import edu.kis.powp.drawer.shape.LineFactory;

import javax.sound.sampled.Line;

/**
 * Created by grusz on 31.03.2017.
 */
public class LinePlotterAdapter implements IPlotter {

    private int startX = 0, startY = 0;
    private DrawPanelController drawPanelController;
    private ILine line ;
    private LineParametersManager lineParametersManager;

    public LinePlotterAdapter(DrawPanelController drawPanelController,ILine line) {
        this.drawPanelController = drawPanelController;
        this.line = line;
        lineParametersManager = Application.getComponent(LineParametersManager.class);
    }

    @Override
    public void setPosition(int x, int y)
    {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void drawTo(int x, int y)
    {
        line = lineParametersManager.getLine();
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);

        drawPanelController.drawLine(line);
        this.startX = x;
        this.startY = y;
    }

    @Override
    public String toString()
    {
        return "Line plot simulator";
    }


}
