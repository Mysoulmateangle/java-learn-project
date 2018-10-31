import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class test {
	//获取，并查询xmL文件下的内容
	public static void main(String[] args) throws Exception {
		SAXReader reader=new SAXReader();//创建解析器对象
		File file=new File("use.xml");//得到文件相对路径
		Document doc = reader.read(file);//创建一个doucment xml 文档对象
		//对doument 文档对象进行操作
		Element rootElement = doc.getRootElement(); //获取根节点
		List<Element> elements = rootElement.elements();
		System.out.println(rootElement.getName());
		for (Element element : elements) {//用迭代器进行遍历获取子节点 phone,子节点类型为element
			System.out.println(element.getName());
			System.out.println("---------------------------");
			Attribute attribute = element.attribute("id");//获取属性，属性类型是attribute
			String attributeName = attribute.getName();
			String attributeText = attribute.getText();
			System.out.println(attributeName+"---"+attributeText);
			List<Element> childs = element.elements();
			for (Element c : childs) {
				String name = c.getName();//通过getName,getText进行获取子节点的内容
				String text = c.getText();
				System.out.println(name+"---"+text);
				
			}
			System.out.println("---------------------------");
		}
	}

}
