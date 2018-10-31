import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class test4 {
	//增加节点
	public static void main(String[] args) throws Exception {
		SAXReader reader=new SAXReader();//创建解析器对象
		File file=new File("use.xml");
		Document doc = reader.read(file);//创建一个文档对象
		Element rootElement = doc.getRootElement();//获取根节点
		List<Element> elements = rootElement.elements();//获取一个子节点集合
		for (Element element : elements) {
			Attribute attribute = element.attribute("id");
			String text = attribute.getText();
			if (text.equals("1")) {
				Element child = element.addElement("Storage");
				child.setText("10G");
				
			}
		}
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer=new XMLWriter(new FileWriter("use.xml"), format);
		writer.write(doc);
		System.out.println("添加成功");
		writer.close();
		
	}

}
