package com.zhou.dao;

import com.zhou.bean.products;

public interface productsDao {
	
	public int addproduct(products products) ;//增加商品
	public int deleteproduct(String productid) ;//删除商品按id
	public void queryproduct() ;//查询商品信息
	public void queryProductById(String productId) ;//通过ID进行查找
	public int updateproduct(products products) ;//更新商品信息
}
