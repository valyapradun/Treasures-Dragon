package com.epam.training.treasury.dao.utill;

import java.util.HashMap;
import java.util.Map;

import com.epam.training.treasury.beans.*;
import com.epam.training.treasury.beans.art.*;
import com.epam.training.treasury.beans.clothes.*;

final class ProviderCreator {
	private final Map<TagName, Treasure> repository = new HashMap<>();

	ProviderCreator() {
		repository.put(TagName.HELMET, new Helmet());
		repository.put(TagName.SPAULDERS, new Spaulder());
		repository.put(TagName.ARMOR, new Armor());
		repository.put(TagName.PANTS, new Pants());
		repository.put(TagName.BOOTS, new Boot());
		repository.put(TagName.PICTURE, new Picture());
		repository.put(TagName.STAFF, new Staff());
		repository.put(TagName.STATUE, new Statue());
		repository.put(TagName.VASE, new Vase());
	}

	Treasure getTreasure(String tag) {
		Treasure treasure = null;
		TagName tagName = null;
		try {
			tagName = TagName.valueOf(tag.toUpperCase());
			treasure = repository.get(tagName).clone();
		} catch (IllegalArgumentException | NullPointerException | CloneNotSupportedException e) {
			treasure = null;
		}
		return treasure;
	}
}
