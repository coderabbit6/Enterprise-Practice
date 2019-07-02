package aop;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/*
 * 环绕增后置
 * 修改返回值内容
 */
public class AroundLogger {
	private static final Logger log = Logger.getLogger(AroundLogger.class);

	public Object aroundLogger(ProceedingJoinPoint jp) {
		// 前置
		log.info("调用：【" + jp.getTarget() + "】  的【" + jp.getSignature().getName() + "】 方法。方法入参：【"
				+ Arrays.toString(jp.getArgs()) + "】");
		int aaa = 0;
		try {
			// 目标对象
			// jp.proceed()调用目标对象addNewUser(User)
			Object result = jp.proceed();
			System.out.println("AroundLogger: " + result);

			// 后置
			log.info("调用：【 " + jp.getTarget() + "】 的【" + jp.getSignature().getName() + "】 方法。方法返回值【" + result + "】");

			// 修改返回值内容
			aaa = (int) result + 100;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aaa;

	}
}
