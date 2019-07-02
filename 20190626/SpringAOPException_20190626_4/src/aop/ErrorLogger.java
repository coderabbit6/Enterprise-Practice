package aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/*
 * �쳣�׳���ǿ
 */
@Aspect
public class ErrorLogger {
	private static final Logger log = Logger.getLogger(ErrorLogger.class);

	@AfterThrowing(pointcut = "execution(* service.UserService.*(..))", throwing = "e")
	public void afterThrowing(JoinPoint jp, Exception e) {
		log.error(jp.getSignature().getName() + " �����쳣��Ϣ��" + e);
	}
}
