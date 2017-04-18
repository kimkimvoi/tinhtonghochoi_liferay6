package com.fsoft.bn.util;

import java.io.ByteArrayInputStream;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

/**
 * @author ThangBN1
 * 
 */
public class XMLUtils {
	/** logger */
	private static Logger logger = Logger.getLogger(XMLUtils.class);
	
	public static DocumentBuilder getDocBuilder() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			db = dbf.newDocumentBuilder();
			return db;
		} catch (ParserConfigurationException e) {
			logger.info(e.getMessage());
			return null;
		}
	}

	public static Document getDoc(String xml) {
		try {
			return getDocBuilder().parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}
	}

	public static com.liferay.portal.kernel.xml.Document getDocLF(String xml) {
		try {
			return SAXReaderUtil.read(xml);
		} catch (DocumentException e) {
			logger.info(e.getMessage());
			return null;
		}
	}

	public static XPath XPath() {
		return XPathFactory.newInstance().newXPath();
	}

	public static NodeList getNodeList(String xml, String xPATH) {
		return getNodeList(getDoc(xml), xPATH);
	}

	public static NodeList getNodeList(Node doc, String xPATH) {
		return (NodeList) get(xPATH, doc, XPathConstants.NODESET);
	}

	public static Node getNode(String xml, String xPATH) {
		return getNode(getDoc(xml), xPATH);
	}

	public static Node getNode(Node doc, String xPATH) {
		return (Node) get(xPATH, doc, XPathConstants.NODE);
	}

	private static Object get(String xPATH, Node doc, QName nodeset) {
		try {
			return XPath().evaluate(xPATH, doc, nodeset);
		} catch (XPathExpressionException e) {
			logger.info(e.getMessage());
			return null;
		}
	}
}
