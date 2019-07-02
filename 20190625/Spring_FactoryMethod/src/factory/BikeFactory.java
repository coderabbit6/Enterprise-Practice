package factory;

import simple.Bike;
import simple.Car;
import simple.ICarFactory;

public class BikeFactory implements ICarFactory {

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new Bike();
	}

}
