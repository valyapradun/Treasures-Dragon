package com.epam.training.treasury.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.epam.training.treasury.beans.Treasure;
import com.epam.training.treasury.beans.clothes.Clothes;
import com.epam.training.treasury.dao.TreasureDAO;
import com.epam.training.treasury.dao.impl.DomParser;
import com.epam.training.treasury.dao.impl.SaxParser;
import com.epam.training.treasury.dao.impl.StAXParser;

public class TreasureService {

	public List<Treasure> expensiveTreasure() {
		List<Treasure> list = allSAXTreasures();
		double maxPrice = 0;
		Treasure expensive = null;
		Iterator<Treasure> iterator = list.iterator();
		while (iterator.hasNext()) {
			Treasure treasure = iterator.next();
			try {
				double price = (Double) treasure.getClass().getMethod("getPrice").invoke(treasure);
				if (price > maxPrice) {
					maxPrice = price;
					expensive = treasure;
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
		list.clear();
		list.add(expensive);
		return list;
	}

	public List<Treasure> allHelmets() {
		TreasureDAO parser = new DomParser();
		parser.connection();
		List<Treasure> list = parser.getTreasures();
		return list;
	}

	public List<Treasure> allSAXTreasures() {
		TreasureDAO parser = new SaxParser();
		parser.connection();
		List<Treasure> list = parser.getTreasures();
		return list;
	}

	public List<Treasure> priceRange() {
		TreasureDAO parser = new StAXParser();
		parser.connection();
		List<Treasure> allList = parser.getTreasures();
		List<Treasure> rangeList = new ArrayList<Treasure>();
		Iterator<Treasure> iterator = allList.iterator();
		while (iterator.hasNext()) {
			Treasure treasure = iterator.next();
			try {
				double price = (Double) treasure.getClass().getMethod("getPrice").invoke(treasure);
				if ((price >= 100) && (price <= 300)) {
					rangeList.add(treasure);
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return rangeList;
	}

	public List<Treasure> steelTreasure() {
		TreasureDAO parser = new StAXParser();
		parser.connection();
		List<Treasure> allList = parser.getTreasures();
		List<Treasure> steelList = new ArrayList<Treasure>();
		Iterator<Treasure> iterator = allList.iterator();
		while (iterator.hasNext()) {
			Treasure treasure = iterator.next();
			if ((treasure instanceof Clothes) && (((Clothes) treasure).getMaterial().equals("steel"))) {
				steelList.add(treasure);
			}
		}
		return steelList;
	}

}
