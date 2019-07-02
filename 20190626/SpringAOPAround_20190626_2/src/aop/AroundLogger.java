package aop;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/*
 * ����������
 * �޸ķ���ֵ����
 */
public class AroundLogger {
	private static final Logger log = Logger.getLogger(AroundLogger.class);

	public Object aroundLogger(ProceedingJoinPoint jp) {
		// ǰ��
		log.info("���ã���" + jp.getTarget() + "��  �ġ�" + jp.getSignature().getName() + "�� ������������Σ���"
				+ Arrays.toString(jp.getArgs()) + "��");
		int aaa = 0;
		try {
			// Ŀ�����
			// jp.proceed()����Ŀ�����addNewUser(User)
			Object result = jp.proceed();
			System.out.println("AroundLogger: " + result);

			// ����
			log.info("���ã��� " + jp.getTarget() + "�� �ġ�" + jp.getSignature().getName() + "�� ��������������ֵ��" + result + "��");

			// �޸ķ���ֵ����
			aaa = (int) result + 100;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aaa;

	}
}
