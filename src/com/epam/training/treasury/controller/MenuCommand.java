package com.epam.training.treasury.controller;

import java.util.List;

import com.epam.training.treasury.beans.Treasure;

public interface MenuCommand {
	public List<Treasure> execute(int request);

}
