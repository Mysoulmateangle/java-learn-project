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

public class test3 {
	//修改根节点的值
	public static void main(String[] args) throws Exception {
		SAXReader reader =new SAXReader();//创建解析器
		File file = new File("use.xml");
		Document doc = reader.read(file);//创建对xml文档进行操作的document对象
		Element rootElement = doc.getRootElement();//获取根节点
		List<Element> elements = rootElement.elements();
		for (Element element : elements) {
			Attribute attribute = element.attribute("id");
			String text = attribute.getText();
			if (text.equals("2")) {
				List<Element> childs = element.elements();
				for (Element child : childs) {
					if (child.getName().equals("price")) {
						child.setText("4500元");
					}
				}
			}
		}
		//内存中document对象进行修改后，需要在次保存
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer=new XMLWriter(new FileWriter("use.xml"),format);
		writer.write(doc);
		System.out.println("修改成功");
		writer.close();
	}

}
