public class EmergencyVehicle extends Vehicle {
    private int feesOwed = 0;

    public EmergencyVehicle(String na, String p, int an) {
        super.owner = na;
        super.charge = 0;
        super.licensePlate = p;
        super.accountNumber = an;
    }

    public void crossTheBridge() {

    }

    public int AmountOwed() {
        return feesOwed;
    }
}
