package com.epam.training.treasury.dao.utill.builderImpl;

import java.util.List;

import com.epam.training.treasury.beans.*;
import com.epam.training.treasury.beans.art.*;
import com.epam.training.treasury.dao.utill.Builder;

public class ArtBuilder implements Builder {

	@Override
	public Treasure initialization(Treasure treasure, List<String> content) {
		if (treasure != null) {
			for (String str : content) {
				String[] arr = str.split(":");
				if (arr[0].equals("art")) {
					ArtTagElement element = ArtTagElement.valueOf(arr[1].toUpperCase());
					switch (element) {
					case TITLE:
						((Art) treasure).setTitle(arr[2]);
						break;
					case TYPE:
						((Art) treasure).setType(arr[2]);
						break;
					case PRICE:
						((Art) treasure).setPrice(Double.parseDouble(arr[2]));
						break;
					case CREATION_DATE:
						((Masterpiece) ((Art) treasure)).setYear(Integer.parseInt(arr[2]));
						break;
					case MASTER:
						((Masterpiece) ((Art) treasure)).setMaster(arr[2]);
						break;
					case QUALITY:
						((Picture) ((Art) treasure)).setQuality(Integer.parseInt(arr[2]));
						break;
					case PAINT_TYPE:
						((Picture) ((Art) treasure)).setPaintType(arr[2]);
						break;
					case LENGTH:
						((Staff) ((Art) treasure)).setLength(Double.parseDouble(arr[2]));
						break;
					case TIP_TYPE:
						((Staff) ((Art) treasure)).setTipType(arr[2]);
						break;
					case WEIGHT:
						((Statue) ((Art) treasure)).setWeight(Double.parseDouble(arr[2]));
						break;
					case SIZE:
						((Statue) ((Art) treasure)).setSize(Double.parseDouble(arr[2]));
						break;
					case VOLUME:
						((Vase) ((Art) treasure)).setVolume(Double.parseDouble(arr[2]));
						break;
					case PICTURE:
						((Vase) ((Art) treasure)).setPicture(Boolean.parseBoolean(arr[2]));
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
