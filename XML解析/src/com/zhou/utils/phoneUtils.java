package com.zhou.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.dom4j.Attribute;
import org.dom4j.Document;

import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


import com.zhou.bean.phone;

public class phoneUtils  {
	
	
	//xml文件地址
	 static String  xmlAdress="use.xml";
	
	//查询xml所有数据
	public static void queryall() throws Exception {
		SAXReader reader=new SAXReader();
		Document doc = reader.read(new File(xmlAdress));
		Element rootElement = doc.getRootElement();
		System.out.println(rootElement);
		List<Element> elements = rootElement.elements();
		System.out.println(rootElement.getName());
		System.out.println("-------------------------");
		for (Element element : elements) {
			System.out.println(element.getName());
			Attribute attribute = element.attribute("id");
			String attributeName = attribute.getName();
			String attributeText = attribute.getText();
			System.out.println(attributeName+":"+attributeText);
			List<Element> childs = element.elements();
			for (Element child : childs) {
				String name = child.getName();
				String text = child.getText();
				System.out.println(name+":"+text);
				System.out.println("-----------------");
			}
		}
	}
	//获取xml文件，返回一个封装的手机集合
	public static List<phone> getall() throws Exception {
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
		return list;
	}
	//删除节点
	public static int deleChild() throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请给出要删除的子节点");
		 String childName = scanner.next();
			System.out.println("请给出要删除的id");
			String id = scanner.next();
		SAXReader reader=new SAXReader();
		Document doc = reader.read(new File(xmlAdress));
		Element rootElement = doc.getRootElement();
		List<Element> elements = rootElement.elements();
		for (Element element : elements) {
			Attribute attribute = element.attribute("id");
			String attributeText = attribute.getText();
			if (id.equals(attributeText)) {
				List<Element> childs = element.elements();
				for (Element child : childs) {
					if (child.getName().equals(childName)) {
						element.remove(child);
					
						OutputFormat format=OutputFormat.createPrettyPrint();
						format.setEncoding("utf-8");
						XMLWriter writer=new XMLWriter(new FileWriter("use.xml"), format);
						writer.write(doc);
						System.out.println("删除成功");
						writer.close();
						return 1;
					}
				}
			}
		}
		
		return 0;
	}
	//增加节点
	
	public static int addChild() throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请给出要新增的子节点");
		 String childName = scanner.next();
		 System.out.println("请给出要新增的字节点的值");
		 String childText = scanner.next();
			System.out.println("请给出要新增的id");
			String id = scanner.next();
		SAXReader reader=new SAXReader();
		Document doc = reader.read(new File(xmlAdress));
		Element rootElement = doc.getRootElement();
		List<Element> elements = rootElement.elements();
		for (Element element : elements) {
			Attribute attribute = element.attribute("id");
			String attributeText = attribute.getText();
			if (attributeText.equals(id)) {
				Element addElement = element.addElement(childName);
				addElement.setText(childText);

				OutputFormat format=OutputFormat.createPrettyPrint();
				format.setEncoding("utf-8");
				XMLWriter writer=new XMLWriter(new FileWriter("use.xml"), format);
				writer.write(doc);
				System.out.println("添加成功");
				writer.close();
				return 1;
			}
			
		}
		
		return 0;
		
	}
	//修改节点内容
	public static int changeChild() throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请给出要修改的子节点");
		 String childName = scanner.next();
		 System.out.println("请给出要修改的字节点的值");
		 String childText = scanner.next();
			System.out.println("请给出要修改的id");
			String id = scanner.next();
		SAXReader reader=new SAXReader();
		Document doc = reader.read(new File(xmlAdress));
		Element rootElement = doc.getRootElement();
		List<Element> elements = rootElement.elements();
		for (Element element : elements) {
			Attribute attribute = element.attribute("id");
			String attributeText = attribute.getText();
			if (attributeText.equals(id)) {
				List<Element> childs = element.elements();
				for (Element c : childs) {
					if (c.getName().equals(childName)) {
						c.setText(childText);

						OutputFormat format=OutputFormat.createPrettyPrint();
						format.setEncoding("utf-8");
						XMLWriter writer=new XMLWriter(new FileWriter("use.xml"), format);
						writer.write(doc);
						System.out.println("修改成功");
						writer.close();
						return 1;
					}
				}
				
			}
			
		}
		
		return 0;
	}

	
}
