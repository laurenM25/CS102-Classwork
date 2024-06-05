public class Main {
    public static void main(String[] args) {

        // create some vehicles
        Car car = new Car("Bob Peterson", "A5859B", 12490712);
        Truck truck = new Truck("coporateY", "B951JU", 1209578, 4);
        EmergencyVehicle ev = new EmergencyVehicle("ems", "A859HV", 24891257);

        Vehicle[] vehicles = { car, truck, ev };

        for (Vehicle vehicle : vehicles) {
            vehicle.crossTheBridge();
            vehicle.crossTheBridge();
            System.out.println(vehicle.name() + ": " + vehicle.AmountOwed());
        }

    }
}
