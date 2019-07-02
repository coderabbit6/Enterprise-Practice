package factory;

import simple.Bus;
import simple.Car;
import simple.ICarFactory;

public class BusFactory implements ICarFactory {

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new Bus();
	}

}
