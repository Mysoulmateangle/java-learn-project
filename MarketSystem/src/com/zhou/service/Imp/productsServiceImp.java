package com.zhou.service.Imp;

import com.zhou.bean.products;
import com.zhou.dao.Imp.productsDaoImp;
import com.zhou.service.productsService;

public class productsServiceImp implements productsService {
	productsDaoImp pd=new productsDaoImp();
	@Override
	public int addproduct(products products) {
		// TODO Auto-generated method stub
		return pd.addproduct(products);
	}
	@Override
	public int deleteproduct(String productid) {
		// TODO Auto-generated method stub
		return pd.deleteproduct(productid);
	}
	@Override
	public void queryproduct() {
		// TODO Auto-generated method stub
		pd.queryproduct();
	}
	@Override
	public void queryProductById(String productId) {
		// TODO Auto-generated method stub
		pd.queryProductById(productId);
		
	}
	@Override
	public int updateproduct(products products) {
		// TODO Auto-generated method stub
		return pd.updateproduct(products);
	}

}
