package cn.yd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.yd.model.Product;
import cn.yd.service.impl.ProductService;
import cn.yd.service.impl.ProductServiceImpl;

public class SpringTest {

	public static void main(String[] args) {
		// 加载spring配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-*.xml");
		System.out.println("----配置文件已经加载完毕----");
		// 通过spring来创建bean 
		ProductService productService = context.getBean("productService",ProductService.class);
//		productService = context.getBean("productService",ProductServiceImpl.class);
		// 直接还是通过JVM自己创建,因此没有IOC和Spring任何功能
//		ProductServiceImpl productService = new ProductServiceImpl();
		Product product = new Product();
		product.setName("testzzz");
		product.setPrice(3.15);
		productService.save(product);
		System.out.println(productService.getById(1));
	}
}
