package edu.iis.powp.command;

import edu.iis.client.plottermagic.IPlotter;

public class CommandSetPosition implements IPlotterCommand {

	private int x;
	private int y;

	public CommandSetPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void execute(IPlotter plotter) {
		// TODO Auto-generated method stub
		plotter.setPosition(x, y);
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
}
