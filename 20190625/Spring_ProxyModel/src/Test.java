
public class Test {

	public static void main(String[] args) {
		ISinger targer = new Sing();

		ISinger proxy = new SingerProxy(targer);

		proxy.sing();
	}

}

// 静态代理模式
// JDK代理模式
// Cglib代理
