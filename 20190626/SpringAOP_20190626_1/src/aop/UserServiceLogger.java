package aop;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

/*
 * ��־�ļ�  ��ǿ
 */
public class UserServiceLogger {
	private static final Logger log = Logger.getLogger(UserServiceLogger.class);

	// ǰ����ǿ
	// jp.getTarget() ����֪��Ŀ�������
	// jp.getSignature().getName() Ŀ�����ķ���
	// jp.getArgs()Ŀ�����Ĳ���

	public void before(JoinPoint jp) {
		log.info("���ã���" + jp.getTarget() + "��  �ġ�" + jp.getSignature().getName() + "�� ������������Σ���"
				+ Arrays.toString(jp.getArgs()) + "��");
	}

	// ������ǿ
	// result ��ȡĿ�����ķ�������ֵ�����������ļ��з��صġ�
	public void afterReturning(JoinPoint jp, Object result) {
		log.info("���ã��� " + jp.getTarget() + "�� �ġ�" + jp.getSignature().getName() + "�� ��������������ֵ��" + result + "��");
	}
}
