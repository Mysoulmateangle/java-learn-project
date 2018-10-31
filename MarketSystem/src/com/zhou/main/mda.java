package com.zhou.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.zhou.bean.products;
import com.zhou.bean.user;
import com.zhou.service.Imp.productsServiceImp;
import com.zhou.service.Imp.userServiceImp;

public class mda {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		userServiceImp userServiceImp = new userServiceImp();
		productsServiceImp productsServiceImp = new productsServiceImp();
		Scanner scanner = new Scanner(System.in);
		boolean point = true;
		boolean point1 = true;
		boolean point2 = true;
		boolean point3 = true;
		boolean point4 = true;
		boolean point5=true;
		System.out.println("---------欢迎来到德莱联盟--------------");
		while (point) {
			System.out.println("请选择登录方式；1 管理员 2 用户 3 注册");
			int way = scanner.nextInt();
			if (way == 1) {
				System.out.println("请输入管理员的名字");
				String uname = scanner.next();
				System.out.println("请输入管理员的密码");
				String password = scanner.next();
				user u = new user(uname, password);
				int count = userServiceImp.queryad(u);
				if (count == 1) {
					System.out.println("正在跳转");
					System.out.println("欢迎管理员登录账号");
					System.out.println("请你选择需要进行的操作");
					while (point1) {
						System.out.println("1 添加商品 2 删除商品 3 修改商品信息 4 查询商品信息 5 退出本次操作");
						int choice = scanner.nextInt();
						switch (choice) {
						case 1:
							point2 = true;// 重置
							while (point2) {
								System.out.println("请输入商品信息");
								System.out.println("依次为 productId name price stock  uid");
								String productId = scanner.next();
								String name = scanner.next();
								double price = scanner.nextDouble();
								int stock = scanner.nextInt();
								SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								String addTime = df.format(new Date());
								int uid = scanner.nextInt();
								products pro = new products(productId, name, price, stock, addTime, uid);
								int count1 = productsServiceImp.addproduct(pro);
								if (count1 == 1) {
									System.out.println("新增商品成功 是否继续添加？ 1 继续 2 退出添加");
									int count2 = scanner.nextInt();
									if (count2 == 2) {
										point2 = false;
									}
								} else {
									System.out.println("添加失败 是否继续添加 1 继续 2退出本次添加 ");
									int count2 = scanner.nextInt();
									if (count2 == 2) {
										point2 = false;
									}
								}
							}

							break;
						case 2:
							while (point3) {
								point3 = true;// 重置
								System.out.println("请输入需要删除的商品id");
								String productid = scanner.next();
								int count1 = productsServiceImp.deleteproduct(productid);
								if (count1 == 1) {
									System.out.println("删除成功 是否继续删除 1 继续 2 退出本次删除操作");
									int choice1 = scanner.nextInt();
									if (choice1 == 2) {
										point3 = false;
									}
								} else {
									System.out.println("删除失败 是否继续删除 1 继续 2 退出本次删除操作");
									int choice1 = scanner.nextInt();
									if (choice1 == 2) {
										point3 = false;
									}
								}

							}
							break;
						case 3:
							while (point4) {
								System.out.println("请输入需要修改的productid");
								String productId1 = scanner.next();
								productsServiceImp.queryProductById(productId1);
								System.out.println("请依次输入修改后的商品信息");
								String productId = scanner.next();
								String name = scanner.next();
								double price = scanner.nextDouble();
								int stock = scanner.nextInt();
								SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								String addTime = df.format(new Date());
								int uid = scanner.nextInt();
								products pro = new products(productId, name, price, stock, addTime, uid);
								productsServiceImp.updateproduct(pro);
							}
						case 4:
							productsServiceImp.queryproduct();
							break;
							case 5:
								point1=false;
								break;
								
						default:
							System.out.println("能不能别乱输，像个弟弟一样");
							break;
						}
					}

				} else {
					System.out.println("您还不是管理员，请浩天哥给你升级权限");
				}

			} else if (way == 2) {
				System.out.println("请输入用户的名字");
				String uname = scanner.next();
				System.out.println("请输入用户的密码");
				String password = scanner.next();
				user u = new user(uname, password);
				int count = userServiceImp.query(u);
				if (count == 1) {
					System.out.println("正在跳转");
					System.out.println("尊敬的用户欢迎回来");
					System.out.println("请你选择需要进行的操作");
					
					while (point5) {
						System.out.println("1 查询商品信息 2  购买商品  3  查看购买的记录 ");
						int sc = scanner.nextInt();
						switch (sc) {
						case 1:
							productsServiceImp.queryproduct();
							
							break;
							case 2:
								System.out.println("请输入购买的商品id");
								String id = scanner.next();
								productsServiceImp.queryProductById(id);
								System.out.println("请检查购买商品信息，确认购买");
								System.out.println("1 确认 2取消");
								int nextInt = scanner.nextInt();
								if (nextInt==1) {
									System.out.println("购买成功哦，请在购物车查询信息");
								}
								else if (nextInt==2) {
									System.out.println("您已经放弃购买");
								}
								
								
							break;
							case 3:
							System.out.println("您还没有购买商品哟");
								break;

						default:
							break;
						}
					}
				} else {
					System.out.println("您还不是我们的用户，请进行注册");
				}
			} else if (way == 3) {
				System.out.println("即将开始进注册，可爱的准用户");
				System.out.println("请输入您的网名");
				String uname = scanner.next();
				System.out.println("请输入您的密码，记的拿个小本本记下来哟");
				String password = scanner.next();
				System.out.println("请输入您的真实姓名");
				String realname = scanner.next();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String regtime = df.format(new Date());
				user user = new user(uname, password, realname, 2, regtime);
				int count = userServiceImp.add(user);
				if (count == 1) {
					System.out.println("注册成功，正在跳转登录");
				}
			}
		}
		scanner.close();
	}

}
