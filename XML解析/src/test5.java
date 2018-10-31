import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class test5 {
	//删除元素，
	public static void main(String[] args) throws Exception {
		SAXReader reader=new SAXReader();
		Document document = reader.read("use.xml");
		Element root = document.getRootElement();

		List<Element> elements = root.elements();
		for (Element element : elements) {
			String id = element.attribute("id").getText(); // ID值
			if ("1".equals(id)) {
				List<Element> childs = element.elements();
				for (Element c : childs) {
					String name = c.getName();
					if (name.equals("dada")) {
						element.remove(c);
					}
				}
			}
		}

		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer=new XMLWriter(new FileWriter("use.xml"), format);
		writer.write(document);
		System.out.println("删除成功");
		writer.close();
	}

}
