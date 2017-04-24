package com.epam.training.treasury.controller;

import java.util.HashMap;
import java.util.Map;

import com.epam.training.treasury.controller.MenuCommand;
import com.epam.training.treasury.controller.impl.AllHelmets;
import com.epam.training.treasury.controller.impl.ExpensiveTreasure;
import com.epam.training.treasury.controller.impl.PriceRange;
import com.epam.training.treasury.controller.impl.SteelTreasure;

final class CommandProvider {
	private final Map<Integer, MenuCommand> repository = new HashMap<>();

	CommandProvider() {
		repository.put(1, new ExpensiveTreasure());
		repository.put(2, new AllHelmets());
		repository.put(3, new PriceRange());
		repository.put(4, new SteelTreasure());
	}

	MenuCommand getCommand(int commandValue) {
		MenuCommand menuCommand = null;
		try {
			menuCommand = repository.get(commandValue);
		} catch (IllegalArgumentException | NullPointerException e) {
			menuCommand = null;
		}
		return menuCommand;
	}

}
