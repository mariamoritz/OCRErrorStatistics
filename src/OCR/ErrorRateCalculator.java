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

public class ErrorRateCalculator {

	public static void main(String[] args) throws Exception{
		  
		File dir = new File("output1");
		File[] files = dir.listFiles();
		
		double total_gl = 0;
		double error_gl = 0;
		for(File file : files) {
			Scanner sc = new Scanner(new FileInputStream("output1\\" + file.getName()), "UTF-8" );
			
			double total = 0;
			double error = 0;
			while (sc.hasNext()){
				String[] line = sc.nextLine().split("\\s+");
				double figure = Double.valueOf(line[1]);
				if (figure == 1.00 || figure == 0.99 || figure == 0.70 ){
					total++; total_gl++;
				}else if (figure == 0.98 || figure == 0.97 || figure == 0.96 || figure == 0.95 || figure == 0.94 ){
					total++; error++; total_gl++; error_gl++;
				}else if (figure >= 0.71 && figure <= 0.90)
					continue;								
			}
		  	System.out.println(file.getName() + ": " + error/total);	  
		}
		System.out.println("total: " + error_gl/total_gl);
	}
}
