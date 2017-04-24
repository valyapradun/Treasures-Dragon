package com.epam.training.treasury.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import com.epam.training.treasury.beans.*;
import com.epam.training.treasury.dao.TreasureDAO;
import com.epam.training.treasury.dao.utill.SimpleTreasureFactory;

public class SaxParser extends DefaultHandler implements TreasureDAO{
	private String text;
	private StringBuilder builder;
	private Treasure treasure;
	private List<Treasure> treasures;
	private List<String> content;
	private String tagTreasure;
	private SimpleTreasureFactory factory = new SimpleTreasureFactory();

	public SaxParser() {
		this.tagTreasure = "";
		this.content = new ArrayList<String>();
	}

	@Override
	public void startDocument() throws SAXException {
		treasures = new ArrayList<Treasure>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		builder = new StringBuilder();
		if (!qName.equals("treasures") & tagTreasure.isEmpty()) {
			tagTreasure = qName;
			treasure = factory.createTreasure(tagTreasure);
		}
	}

	@Override
	public void characters(char[] buf, int start, int length) throws SAXException {
		text = builder.append(buf, start, length).toString().trim();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals(tagTreasure)) {
			treasures.add(factory.initializationTreasure(treasure, content));
			content.clear();
			tagTreasure = "";
		} else {
			content.add(qName + ":" + text);
		}
	}

	@Override
	public void endDocument() throws SAXException {
		treasures.removeAll(Collections.singleton(null));
	}

	@Override
	public void connection() {
		try {
			org.xml.sax.XMLReader reader;
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(this);
			reader.parse(XML);
		} catch (IOException | SAXException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<Treasure> getTreasures() {
		return treasures;
	}

}
