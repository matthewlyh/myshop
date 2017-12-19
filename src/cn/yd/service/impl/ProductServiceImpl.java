package cn.yd.service.impl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yd.dao.ProductDao;
import cn.yd.model.Product;

// 自定义注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
	int num() default 123; // 注解的每一个属性都必须赋值,除非已经定义缺省值

	String value(); // 注解属性都必须带括号,赋值直接通过属性,那值通过方法

	double score();
}

// @MyAnno(value="java",score=100.00)
@Service("productService")  // 如果没有定义名称则默认类简单名称
public class ProductServiceImpl implements ProductService {

	// public static void main(String[] args) {
	// MyAnno annotation = ProductServiceImpl.class.getAnnotation(MyAnno.class);
	// System.out.println(annotation);
	// System.out.println(annotation.num() + "," + annotation.score());
	// }

	public ProductServiceImpl() {
		System.out.println("ProductServiceImpl()............");
	}

	// new对象三个缺点:
	// 1: 不能控制数量(单例模式),
	// 2: 不能控制对象创建时间(项目启动的时候就实例化而且单例模式,)
	// 3: 不能控制对象创建类型(工厂模式)
	// 面向接口编程(具体层与层之间的依赖都是依靠接口)
	
	// 1: 如果指定名称则默认只会按照名称查找
	// 2: 如果没有指定名称,则默认采用属性名查找
	// 3: 如果属性名称没有查找成功,则最后按照类型查找
	@Resource 
	private ProductDao productDao = null;

	@Override
	public void save(Product product) {
		System.out.println("save.......");
		productDao.save(product); // 订单入库
		// 订单项入库
//		Integer.parseInt("xyz");
	}

	@Override
	public Product getById(int id) {
		System.out.println("getById.......");

		return productDao.getById(id);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productDao.delete(id);
	}

}
