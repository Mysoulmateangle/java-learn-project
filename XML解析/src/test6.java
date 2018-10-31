import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class test6 {
	public static void main(String[] args) throws Exception {
		SAXReader reader=new SAXReader();
		Document doc = reader.read(new File("use.xml"));
		Element rootElement = doc.getRootElement();
		System.out.println(rootElement.getName());
		List<Element> elements = rootElement.elements();
		for (Element element : elements) {
			System.out.println("==========================");
			Attribute attribute = element.attribute("id");
		
			String attributeName = attribute.getName();
			String attributeText = attribute.getText();
			System.out.println(element.getName()+":("+attributeName+":"+attributeText+")");
			List<Element> childs = element.elements();
			for (Element c : childs) {
				String name = c.getName();
				String text = c.getText();
				System.out.println(name+":"+text);
			}
			
		}
		
	}

}
