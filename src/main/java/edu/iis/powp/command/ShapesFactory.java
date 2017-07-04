
package edu.iis.powp.command;

        import java.util.ArrayList;
        import java.util.List;

public class ShapesFactory {

    public ComplexCommand getRectangle(int x, int y, int width, int height) {

        List<IPlotterCommand> commandList = new ArrayList<IPlotterCommand>();

        commandList.add(new CommandSetPosition(x,y));
        commandList.add(new CommandDrawLineToPosition(x + width, y));
        commandList.add(new CommandSetPosition(x + width,y));
        commandList.add(new CommandDrawLineToPosition(x + width, y + height));
        commandList.add(new CommandSetPosition(x + width, y + height));
        commandList.add(new CommandDrawLineToPosition(x, y + height));
        commandList.add(new CommandSetPosition(x, y + height));
        commandList.add(new CommandDrawLineToPosition(x, y));

        return new ComplexCommand(commandList);
    }

    public ComplexCommand getTriangle(int aX, int aY, int bX, int bY,int cX, int cY) {
        List<IPlotterCommand> commandList = new ArrayList<IPlotterCommand>();

        commandList.add(new CommandSetPosition(aX,aY));
        commandList.add(new CommandDrawLineToPosition(bX, bY));
        commandList.add(new CommandDrawLineToPosition(cX, cY));
        commandList.add(new CommandDrawLineToPosition(aX,aY));

        return new ComplexCommand(commandList);
    }

}
