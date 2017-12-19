package cn.yd.service.impl;

import cn.yd.model.Product;

public interface ProductService {

	public abstract void save(Product product);

	public abstract Product getById(int id);
	
	public abstract void update(Product product);

	public abstract void delete(int id);

}