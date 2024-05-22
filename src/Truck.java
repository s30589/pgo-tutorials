public class Truck extends Vehicle{
    double milesDriven;
    double fuelConsumed;
    double cargoWeight;


    public Truck(String make, String model, int year, double milesDriven, double fuelConsumed, double cargoWeight) {
        super(make, model, year);
        this.cargoWeight = cargoWeight;
        this.fuelConsumed = fuelConsumed;
        this.milesDriven = milesDriven;
    }

    public double calculateFuelEfficiency(){
        return milesDriven/(fuelConsumed+(cargoWeight*0.5));
    }
}

