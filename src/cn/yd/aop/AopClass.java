package cn.yd.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

import cn.yd.model.Product;

// 切面类,里面有存储都是在运行时候横切入的方法(通知)
public class AopClass {

	// JoinPoint: 就是通知要切入的方法本身
	public void logs(JoinPoint joinPoint) {
//		Integer.parseInt("xxxx");
		System.out.println("如果操作执行成功,则日志记录.........");
		System.out.println("被切方法的参数信息:" + joinPoint.getSignature());
		System.out.println("被切方法所属的对象,目标对象:" + joinPoint.getTarget());
		System.out.println("被切方法的参数:" + Arrays.toString(joinPoint.getArgs()));
	}

	// 通知  e:和xml中相匹配,spring会把异常对象交给当前e变量
	public void ex(Exception e) {
		System.out.println("异常信息为:" + e.getMessage());
	}

	public void finallys() {
		System.out.println("后置通知,一般用来释放资源.........");
	}
}
