package aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/*
 * 最终增强。。
 * 特点相当于finally
 */
@Aspect
public class AfterLogger {
	private static final Logger log = Logger.getLogger(AfterLogger.class);

	@After("execution(* service.UserService.*(..))")
	public void afterLogger(JoinPoint jp) {
		log.info(jp.getSignature().getName() + "  调用了最终增强。开始执行。。。。。。");
	}
}
