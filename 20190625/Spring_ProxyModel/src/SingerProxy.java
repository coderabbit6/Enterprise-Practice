/*
 * 代理对象
 */
public class SingerProxy implements ISinger {
	private ISinger targer;

	public SingerProxy(ISinger target) {
		this.targer = target;
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("向观众鞠躬问好");
		targer.sing();
		System.out.println("谢谢大家欣赏");

	}

}
