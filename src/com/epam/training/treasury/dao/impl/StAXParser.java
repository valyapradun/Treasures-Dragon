package com.epam.training.treasury.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.epam.training.treasury.beans.Treasure;
import com.epam.training.treasury.dao.TreasureDAO;
import com.epam.training.treasury.dao.utill.SimpleTreasureFactory;

public class StAXParser implements TreasureDAO {
	private SimpleTreasureFactory factory = new SimpleTreasureFactory();
	private StringBuilder builder;
	private String tagTreasure;
	private String text;
	private List<String> content;
	private List<Treasure> treasures = new ArrayList<Treasure>();

	public StAXParser() {
		this.tagTreasure = "";
		this.content = new ArrayList<String>();
	}

	public void parser(XMLStreamReader reader) throws XMLStreamException {
		Treasure treasure = null;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				builder = new StringBuilder();
				if (!reader.getLocalName().equals("treasures") & tagTreasure.isEmpty()) {
					tagTreasure = reader.getLocalName().trim();
					treasure = factory.createTreasure(tagTreasure);
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				text = builder.append(reader.getText()).toString().trim();
				break;
			case XMLStreamConstants.END_ELEMENT:
				if (reader.getLocalName().trim().equals(tagTreasure)) {
					treasures.add(factory.initializationTreasure(treasure, content));
					content.clear();
					tagTreasure = "";
				} else {
					content.add(reader.getPrefix() + ":" + reader.getLocalName().trim() + ":" + text);
				}
			}
		}
	}

	@Override
	public void connection() {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			InputStream input = new FileInputStream(XML);
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			this.parser(reader);
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Treasure> getTreasures() {
		treasures.removeAll(Collections.singleton(null));
		return treasures;
	}
}
