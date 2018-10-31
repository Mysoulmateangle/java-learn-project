package com.zhou.dao.Imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zhou.Utils.DBUtils;
import com.zhou.bean.products;
import com.zhou.dao.productsDao;

public class productsDaoImp implements productsDao{

	@Override
	public int addproduct(products products) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConn();
		String sql="insert into products values (?,?,?,?,?,?)";
		QueryRunner qr=new QueryRunner();
		Object[] params= {products.getProductId(),products.getName(),products.getPrice(),products.getStock(),products.getAddTime(),products.getUid()};
		try {
			int count = qr.update(conn, sql, params);
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteproduct(String productid) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConn();
		String sql="delete from products where productId=?";
		QueryRunner qr=new QueryRunner();
		Object[] params= {productid};
		try {
			return qr.update(conn, sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void queryproduct() {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConn();
		String sql="select * from products ";
		QueryRunner qr=new QueryRunner();
		try {
			List<products> query = qr.query(conn,sql, new BeanListHandler<>(products.class));
			for (products products : query) {
				System.out.println(products);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void queryProductById(String productId) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConn();
		String sql="select * from products where productId =? ";
		QueryRunner qr=new QueryRunner();
		try {
			Object[] params= {productId};
			products products = qr.query(sql, new BeanHandler<>(products.class), params);
			System.out.println(products);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public int updateproduct(products products) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		String sql="update products set name=? and price=? and stock=? and addtime=? and uid=? where productId=?";
		QueryRunner qr = new QueryRunner();
		Object[] params= {products.getName(),products.getPrice(),products.getStock(),products.getAddTime(),products.getUid(),products.getProductId(),};
		try {
			int update = qr.update(conn, sql, params);
			return update;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
