
public class Test {

	public static void main(String[] args) {
		ISinger targer = new Sing();

		ISinger proxy = new SingerProxy(targer);

		proxy.sing();
	}

}

// ��̬����ģʽ
// JDK����ģʽ
// Cglib����
