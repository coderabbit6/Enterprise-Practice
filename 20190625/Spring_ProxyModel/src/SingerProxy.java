/*
 * �������
 */
public class SingerProxy implements ISinger {
	private ISinger targer;

	public SingerProxy(ISinger target) {
		this.targer = target;
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("����ھϹ��ʺ�");
		targer.sing();
		System.out.println("лл�������");

	}

}
