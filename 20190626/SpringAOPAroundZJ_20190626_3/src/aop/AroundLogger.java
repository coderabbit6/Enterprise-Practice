package aop;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import entity.User;

/*
 * 环绕增后置
 * 修改返回值内容
 * 
 * @Aspect  声明当前类是增强类
 * @Around("execution(* service.UserService.*(..))")    声明切入点
 */

@Aspect
public class AroundLogger {
	private static final Logger log = Logger.getLogger(AroundLogger.class);

	@Around("execution(* service.UserService.*(..))")
	public Object aroundLogger(ProceedingJoinPoint jp) throws Throwable {
		log.info("调用：【" + jp.getTarget() + "】  的【" + jp.getSignature().getName() + "】 方法。方法入参：【"
				+ Arrays.toString(jp.getArgs()) + "】");
		User result = null;
		result = (User) jp.proceed();
		System.out.println("AroundLogger: " + result.getUsername());
		log.info("调用：【 " + jp.getTarget() + "】 的【" + jp.getSignature().getName() + "】 方法。方法返回值【" + result + "】");
		result.setUsername("修改名字，，改成张三");
		return result;

	}
}
