package com.epam.training.treasury.controller.impl;

import java.util.List;

import com.epam.training.treasury.beans.Treasure;
import com.epam.training.treasury.controller.MenuCommand;
import com.epam.training.treasury.service.TreasureService;

public class AllHelmets implements MenuCommand{

	@Override
	public List<Treasure> execute(int request) {
		List<Treasure> list = new TreasureService().allHelmets();
		return list;
	}

}
