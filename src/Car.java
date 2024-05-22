public class Car extends Vehicle{
    double milesDriven;
    double fuelConsumed;


    public Car(String make, String model, int year, double milesDriven, double fuelConsumed) {
        super(make, model, year);
        this.fuelConsumed = fuelConsumed;
        this.milesDriven = milesDriven;
    }

    @Override
    public double calculateFuelEfficiency(){
        return milesDriven/fuelConsumed;
    }
}
