public class Main {
    public static void main(String[] args) {
        Car car = new Car("Opel", "Astra", 2006, 1500, 20);
        System.out.println("Car Fuel Efficiency: " + car.calculateFuelEfficiency());

        Truck truck = new Truck("Scania", "master", 2019, 800, 40, 5);
        System.out.println("Truck Fuel Efficiency: " + truck.calculateFuelEfficiency());
    }
}
