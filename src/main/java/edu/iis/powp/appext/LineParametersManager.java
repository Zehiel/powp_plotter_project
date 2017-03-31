package edu.iis.powp.appext;

import edu.kis.powp.drawer.shape.ILine;
import edu.kis.powp.drawer.shape.LineFactory;

import java.util.logging.Logger;

/**
 * Created by grusz on 31.03.2017.
 */
public class LineParametersManager {

    private ILine line = LineFactory.getBasicLine();

    private static final Logger LOGGER = Logger.getLogger("global");


    public synchronized ILine getLine() {
        return line;
    }

    public synchronized void setLine(ILine line) {
        this.line = line;
    }
}
