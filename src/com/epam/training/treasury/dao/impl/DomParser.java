package com.epam.training.treasury.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.epam.training.treasury.beans.Treasure;
import com.epam.training.treasury.dao.TreasureDAO;
import com.epam.training.treasury.dao.utill.SimpleTreasureFactory;

public class DomParser implements TreasureDAO {
	private SimpleTreasureFactory factory = new SimpleTreasureFactory();
	private String tagTreasure;
	private List<String> content;
	private List<Treasure> treasures = new ArrayList<Treasure>();

	public DomParser() {
		this.tagTreasure = "";
		this.content = new ArrayList<String>();
	}

	public void parser(Document document) {
		Element root = document.getDocumentElement();
		NodeList treasureNodes = root.getElementsByTagName("helmet");
		// NodeList treasureNodes = root.getChildNodes();
		Treasure treasure = null;
		Treasure result = null;
		for (int i = 0; i < treasureNodes.getLength(); i++) {
			if (!(treasureNodes.item(i).getNodeName().equals("#text"))) {
				tagTreasure = treasureNodes.item(i).getNodeName().trim();
				treasure = factory.createTreasure(tagTreasure);
				NodeList tagList = treasureNodes.item(i).getChildNodes();
				for (int j = 0; j < tagList.getLength(); j++) {
					if (tagList.item(j).getNodeType() != 3) {
						content.add(tagList.item(j).getNodeName() + ":" + tagList.item(j).getTextContent());
					}
				}
				result = factory.initializationTreasure(treasure, content);
				treasures.add(result);
			}
			content.clear();
		}
	}

	@Override
	public void connection() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document document = builder.parse(XML);
			this.parser(document);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Treasure> getTreasures() {
		treasures.removeAll(Collections.singleton(null));
		return treasures;
	}
}
