public class Truck extends Vehicle {
    private int feesOwed = 0;
    private int axels;

    public Truck(String na, String p, int an, int ax) {
        super.owner = na;
        super.charge = 3;
        super.licensePlate = p;
        super.accountNumber = an;
        axels = ax;
    }

    public void crossTheBridge() {
        int charged = charge * axels;
        feesOwed += charged;
    }

    public int AmountOwed() { // return amount owed
        return feesOwed;
    }
}
