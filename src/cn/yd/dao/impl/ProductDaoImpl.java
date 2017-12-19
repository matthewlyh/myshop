package cn.yd.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.yd.dao.ProductDao;
import cn.yd.model.Product;

@Repository("productDao") // @Repository 代表数据访问层,如果没有指定名称,默认就当前类的简单名称
public class ProductDaoImpl implements ProductDao {
	
	public ProductDaoImpl() {
		System.out.println("ProductDaoImpl().......");
	}

	// 在运行的时候通过xml的配置会自动注入
	@Resource
	private JdbcTemplate jdbcTemplate = null; // new对象有三个问题

	// // 根据ID查询唯一的对象
	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yd.dao.impl.ProductDao#getById(int)
	 */
	@Override
	public Product getById(int id) {
		String sql = "select id,name,price from product where id = ?"; // ResultSet
		try{
		return jdbcTemplate.queryForObject(sql, new Object[] { id },
				new RowMapper<Product>() {

					@Override
					// ResultSet 存储了查询的结果集
					public Product mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						// 数据库表-->类 数据库记录--->对象
						Product product = new Product();
						product.setId(rs.getInt("id"));
						product.setName(rs.getString("name"));
						product.setPrice(rs.getDouble("price"));
						return product;
					}

				});
		}catch (Exception e) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yd.dao.impl.ProductDao#save(cn.yd.model.Product)
	 */
	@Override
	public void save(Product product) {
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		jdbcTemplate.update(
				sql,
				new Object[] { product.getName(), product.getPrice(),
						product.getRemark() });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yd.dao.impl.ProductDao#update(cn.yd.model.Product)
	 */
	@Override
	public void update(Product product) {
		String sql = "update product set name=?,price=?,remark=? where id=?";
		jdbcTemplate.update(
				sql,
				new Object[] { product.getName(), product.getPrice(),
						product.getRemark(), product.getId() });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yd.dao.impl.ProductDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		String sql = "delete from product where id= ?";
		jdbcTemplate.update(sql, id);
	}
}
