package edu.iis.powp.command;

import edu.iis.client.plottermagic.IPlotter;

public class CommandDrawLineToPosition implements IPlotterCommand {

	private int x;
	private int y;

	public CommandDrawLineToPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void execute(IPlotter ploter) {
		ploter.drawTo(x,y);
		
	}

}
