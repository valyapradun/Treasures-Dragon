package com.epam.training.treasury.controller;

import java.util.List;

import com.epam.training.treasury.beans.Treasure;

public class Controller {
	private final CommandProvider provider = new CommandProvider();

	public List<Treasure> executeTask(int request) {
		MenuCommand executionCommand = provider.getCommand(request);
		List<Treasure> response = executionCommand.execute(request);
		return response;
	}
}
