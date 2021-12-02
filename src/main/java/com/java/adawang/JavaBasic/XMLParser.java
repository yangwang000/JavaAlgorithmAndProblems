package com.java.adawang.JavaBasic;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;

public class XMLParser {
	public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
		DocumentBuilderFactory factory =
				DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		StringBuilder xmlStringBuilder = new StringBuilder();
		xmlStringBuilder.append(xml);
		ByteArrayInputStream input = new ByteArrayInputStream(
				xmlStringBuilder.toString().getBytes("UTF-8"));
		Document doc = builder.parse(input);
		NodeList nList = doc.getElementsByTagName("folder");
		ArrayList<String> ans = new ArrayList<>();
		for(int i = 0; i < nList.getLength(); i++){
			Node n = nList.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE){
				Element eElement = (Element) n;
				String temp = eElement.getAttribute(
						"name");
				if(temp.indexOf(startingLetter) == 0){
					ans.add(temp);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		String xml =
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
						"<folder name=\"c\">" +
						"<folder name=\"program files\">" +
						"<folder name=\"uninstall information\" />" +
						"</folder>" +
						"<folder name=\"users\" />" +
						"</folder>";

		Collection<String> names = folderNames(xml, 'u');
		for(String name: names)
			System.out.println(name);
	}
}
