package cn.yd.dao;

import cn.yd.model.Product;

public interface ProductDao {

	//	// 根据ID查询唯一的对象
	public abstract Product getById(int id);

	public abstract void save(Product product);

	public abstract void update(Product product);

	public abstract void delete(int id);

}