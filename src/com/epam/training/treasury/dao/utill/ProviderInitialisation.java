package com.epam.training.treasury.dao.utill;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.training.treasury.beans.Treasure;
import com.epam.training.treasury.dao.utill.builderImpl.ArtBuilder;
import com.epam.training.treasury.dao.utill.builderImpl.ClothesBuilder;

final class ProviderInitialisation {
	private final Map<String, Builder> repository = new HashMap<>();

	ProviderInitialisation() {
		repository.put("c", new ClothesBuilder());
		repository.put("art", new ArtBuilder());
	}

	Treasure getTreasure(Treasure treasure, List<String> content) {
		Treasure result = null;
		try {
			for (String str : content) {
				String[] arr = str.split(":");
				result = repository.get(arr[0]).initialization(treasure, content);
			}
		} catch (IllegalArgumentException | NullPointerException e) {
			treasure = null;
		}
		return result;
	}
	
	
}
