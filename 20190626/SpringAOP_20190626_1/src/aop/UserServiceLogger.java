package aop;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

/*
 * 日志文件  增强
 */
public class UserServiceLogger {
	private static final Logger log = Logger.getLogger(UserServiceLogger.class);

	// 前置增强
	// jp.getTarget() 可以知道目标对象类
	// jp.getSignature().getName() 目标对象的方法
	// jp.getArgs()目标对象的参数

	public void before(JoinPoint jp) {
		log.info("调用：【" + jp.getTarget() + "】  的【" + jp.getSignature().getName() + "】 方法。方法入参：【"
				+ Arrays.toString(jp.getArgs()) + "】");
	}

	// 后置增强
	// result 获取目标对象的方法返回值，接收配置文件中返回的。
	public void afterReturning(JoinPoint jp, Object result) {
		log.info("调用：【 " + jp.getTarget() + "】 的【" + jp.getSignature().getName() + "】 方法。方法返回值【" + result + "】");
	}
}
