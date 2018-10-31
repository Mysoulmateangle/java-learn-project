import java.util.List;
import java.util.Scanner;

import com.zhou.bean.phone;
import com.zhou.utils.phoneUtils;

public class phoneSystem {
	public static void main(String[] args) throws Exception {
		System.out.println("欢迎来到xml解析器功能");
		boolean point =true;
		while (point) {
			System.out.println("请选择要进行的操作：1.查询全部  2.新增手机节点  3.删除手机节点  4.修改手机节点  5.封装成phone对象  6.退出：");
			Scanner scanner = new Scanner(System.in);
			String a = scanner.next();
			int i = Integer.parseInt(a);
			switch (i) {
			case 1:
				phoneUtils.queryall();
				break;
			case 2:
				int addChild = phoneUtils.addChild();
				if (addChild == 0) {
					System.out.println("请重新新增");
				}
				break;
			case 3:
				int deleChild = phoneUtils.deleChild();
				if (deleChild == 0) {
					System.out.println("请重新删除");
				}
				break;
			case 4:
				int changeChild = phoneUtils.changeChild();
				if (changeChild == 0) {
					System.out.println("请重新修改");
				}
				break;
			case 5:
				List<phone> list = phoneUtils.getall();
				System.out.println("是否存入文本");
				break;
				case 6:
					point=false;
					break;
					
			default:
				System.out.println("别他妈乱输");
				break;
			}
		}
	}

}
