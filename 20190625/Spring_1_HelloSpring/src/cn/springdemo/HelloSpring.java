package cn.springdemo;

public class HelloSpring {
	private String whoo = null;
	private String my = null;

	public String getWho() {
		return whoo;
	}

	public void setWho(String who) {
		this.whoo = who;
	}

	public String getMy() {
		return my;
	}

	public void setMy(String my) {
		this.my = my;
	}

	public void printWho() {
		System.out.println("Hello," + this.getWho());
	}

	public void printMy() {
		System.out.println("Hello," + this.getMy());
	}
}
