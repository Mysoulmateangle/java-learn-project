import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zhou.bean.phone;

public class test2 {
	
	//将xml封装成对象，然后用一个list进行输出
	public static void main(String[] args) throws Exception {
		int id;
		String brand="";
		String type="";
		int price=0;
		List<phone> list = new ArrayList<phone>();
		SAXReader reader=new SAXReader();//获取解析器对象
		File file =new File("use.xml");//文档位置
		Document doc = reader.read(file);//获取一个对use.xml文件的doucment的对象
		Element rootElement = doc.getRootElement();//获取根节点
		List<Element> elements = rootElement.elements();//获取子节点
		for (Element element : elements) {
			Attribute attribute = element.attribute("id");//获取子节点的属性
			String attributeName = attribute.getName();//获取id
			 
			String attributeText = attribute.getText();//获取id值
			 id = Integer.parseInt(attributeText);
			List<Element> childs = element.elements();
			
			for (Element c : childs) {
				String name = c.getName();
				String text = c.getText();
				if (name.equals("brand")) {
					brand=text;//获取值
				}
				else if (name.equals("type")) {
					type=text;
				}
				else if (name.equals("price")) {
					price=Integer.parseInt(text);
				}
			}
			phone phone=new phone(id, brand, type, price);
			list.add(phone);
		}
		for (phone phone : list) {
			System.out.println(phone);
		}
	}

}
