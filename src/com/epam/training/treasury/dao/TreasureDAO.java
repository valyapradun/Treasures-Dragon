package com.epam.training.treasury.dao;

import java.util.List;

import com.epam.training.treasury.beans.Treasure;

public interface TreasureDAO {
	public final static String XML = "resources/Treasure.xml";

	public void connection();

	public List<Treasure> getTreasures();

}
