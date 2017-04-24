package com.epam.training.treasury.dao.utill.builderImpl;

import java.util.List;

import com.epam.training.treasury.beans.Treasure;
import com.epam.training.treasury.beans.clothes.Armor;
import com.epam.training.treasury.beans.clothes.Body;
import com.epam.training.treasury.beans.clothes.Boot;
import com.epam.training.treasury.beans.clothes.Clothes;
import com.epam.training.treasury.beans.clothes.ClothesTagElement;
import com.epam.training.treasury.beans.clothes.Helmet;
import com.epam.training.treasury.beans.clothes.Leg;
import com.epam.training.treasury.beans.clothes.Pants;
import com.epam.training.treasury.beans.clothes.Spaulder;
import com.epam.training.treasury.dao.utill.Builder;

public class ClothesBuilder implements Builder{

	@Override
	public Treasure initialization(Treasure treasure, List<String> content) {
		if (treasure != null) {
			for (String str : content) {
				String[] arr = str.split(":");
				if (arr[0].equals("c")) {
					ClothesTagElement element = ClothesTagElement.valueOf(arr[1].toUpperCase());
					switch (element) {
					case TITLE:
						((Clothes) treasure).setTitle(arr[2]);
						break;
					case MATERIAL:
						((Clothes) treasure).setMaterial(arr[2]);
						break;
					case TYPE:
						((Clothes) treasure).setType(arr[2]);
						break;
					case PRICE:
						((Clothes) treasure).setPrice(Double.parseDouble(arr[2]));
						break;
					case HEAD_PROTECTION:
						((Helmet) ((Clothes) treasure)).setHeadProtection(Double.parseDouble(arr[2]));
						break;
					case HEAD_GIRTH:
						((Helmet) ((Clothes) treasure)).setHeadGirth(Double.parseDouble(arr[2]));
						break;
					case BODY_PROTECTION:
						((Body) ((Clothes) treasure)).setBodyProtection(Double.parseDouble(arr[2]));
						break;
					case SHOULDER_GIRTH:
						((Spaulder) ((Clothes) treasure)).setShoulderGirth(Double.parseDouble(arr[2]));
						break;
					case BODY_GIRTH:
						((Armor) ((Clothes) treasure)).setBodyGirth(Double.parseDouble(arr[2]));
						break;
					case PICTURE:
						((Armor) ((Clothes) treasure)).setPicture(Boolean.parseBoolean(arr[2]));
						break;
					case LEG_PROTECTION:
						((Leg) ((Clothes) treasure)).setLegProtection(Boolean.parseBoolean(arr[2]));
						break;
					case LEG_GIRTH:
						((Pants) ((Clothes) treasure)).setLegGirth(Double.parseDouble(arr[2]));
						break;
					case FOOT_GIRTH:
						((Boot) ((Clothes) treasure)).setFootGirth(Double.parseDouble(arr[2]));
						break;
					default:
						break;
					}
				}
			}

		}
		return treasure;
	}
}
