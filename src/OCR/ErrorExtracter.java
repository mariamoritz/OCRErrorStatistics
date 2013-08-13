package OCR;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ErrorExtracter {
	
	public static void main(String[] args) throws Exception{
  
		File dir = new File("Demetrius-De_elocutione.book");
		File[] files = dir.listFiles();
			
		for(File file : files) {
			Scanner sc = new Scanner(new FileInputStream("Demetrius-De_elocutione.book\\" + file.getName()), "UTF-8" );
			//Scanner sc = new Scanner(new FileInputStream("Demetrius-De_elocutione.book\\p0012.html"), "UTF-8" );
			PrintWriter pw = new PrintWriter(new File("output1\\" + file.getName() + ".out1"), "UTF-8");
			//PrintWriter pw = new PrintWriter(new File("output1\\p0012.html.out1"), "UTF-8");
			
			System.out.print("Loading xml file: ");

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			docFactory.setNamespaceAware(false);
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = (Document) docBuilder.parse(new FileInputStream(new File("Demetrius-De_elocutione.book\\" + file.getName())));
			//Document doc = (Document) docBuilder.parse(new FileInputStream(new File("Demetrius-De_elocutione.book\\p0012.html")));
		 
			System.out.print("OK\nCompiling XPath: ");
			XPath xpath = XPathFactory.newInstance().newXPath();
			
			XPathExpression ex2 = xpath.compile("//ins");
			System.out.print("OK\nEvaluating XPath on file: ");
			NodeList list2 = (NodeList) ex2.evaluate(doc, XPathConstants.NODESET);
			System.out.println("OK");
			for (int j = 1; j <= list2.getLength(); j++) {			   
				NamedNodeMap attr = list2.item(j-1).getAttributes();
				pw.println(attr.getNamedItem("title").getNodeValue());
			  
			}
		  	pw.close();
		  
		}
			
	}
}
