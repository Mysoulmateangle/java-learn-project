package com.zhou.service;

import com.zhou.bean.products;

public interface productsService {
	
	public int addproduct(products products) ;//添加商品
	public int deleteproduct(String productid) ;//删除商品根据id
	public void queryproduct() ;//查询商品
	public void queryProductById(String productId) ;//通过ID进行查找
	public int updateproduct(products products) ;//更新商品信息
}
