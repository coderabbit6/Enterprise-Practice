package text;

import factory.BikeFactory;
import factory.BusFactory;
import simple.Car;
import simple.ICarFactory;

public class text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICarFactory factory = null;

		factory = new BikeFactory();
		Car bike = factory.getCar();
		bike.gotoWord();

		factory = new BusFactory();
		Car bus = factory.getCar();
		bus.gotoWord();

	}

}
