package aop;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import entity.User;

/*
 * ����������
 * �޸ķ���ֵ����
 * 
 * @Aspect  ������ǰ������ǿ��
 * @Around("execution(* service.UserService.*(..))")    ���������
 */

@Aspect
public class AroundLogger {
	private static final Logger log = Logger.getLogger(AroundLogger.class);

	@Around("execution(* service.UserService.*(..))")
	public Object aroundLogger(ProceedingJoinPoint jp) throws Throwable {
		log.info("���ã���" + jp.getTarget() + "��  �ġ�" + jp.getSignature().getName() + "�� ������������Σ���"
				+ Arrays.toString(jp.getArgs()) + "��");
		User result = null;
		result = (User) jp.proceed();
		System.out.println("AroundLogger: " + result.getUsername());
		log.info("���ã��� " + jp.getTarget() + "�� �ġ�" + jp.getSignature().getName() + "�� ��������������ֵ��" + result + "��");
		result.setUsername("�޸����֣����ĳ�����");
		return result;

	}
}
