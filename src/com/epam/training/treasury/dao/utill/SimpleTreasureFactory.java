package com.epam.training.treasury.dao.utill;

import java.util.List;

import com.epam.training.treasury.beans.Treasure;

public class SimpleTreasureFactory {
	private Treasure treasure;
	private ProviderCreator createProvider = new ProviderCreator();
	private ProviderInitialisation initProvider = new ProviderInitialisation();
	
	public Treasure createTreasure(String tag) {
		treasure = createProvider.getTreasure(tag);
		return treasure;
	}

	public Treasure initializationTreasure(Treasure emptyTreasure, List<String> content) {
		treasure = initProvider.getTreasure(emptyTreasure, content);
		return treasure;
	}

}
