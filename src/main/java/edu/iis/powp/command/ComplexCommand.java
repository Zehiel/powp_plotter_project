package edu.iis.powp.command;

import java.util.List;

import edu.iis.client.plottermagic.IPlotter;

public class ComplexCommand implements IPlotterCommand {


	List<IPlotterCommand> commands;

	public ComplexCommand() {
		super();		
	}

	public ComplexCommand(List<IPlotterCommand> commands) {
		this.commands = commands;
	}

	@Override
	public void execute(IPlotter plotterDriver) {
		for (IPlotterCommand plotterCommand : commands) {			
			plotterCommand.execute(plotterDriver);
		}
	}

	public void addCommand(IPlotterCommand command) {
		commands.add(command);
	}

	public void removeCommand(IPlotterCommand command) {
		commands.remove(command);
	}

	public IPlotterCommand getCommand(int position) {
		return commands.get(position);
	}


}
