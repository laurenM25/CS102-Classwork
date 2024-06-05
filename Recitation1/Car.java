public class Car extends Vehicle {
    private int feesOwed = 0;

    public Car(String na, String p, int an) {
        super.owner = na;
        super.charge = 5;
        super.licensePlate = p;
        super.accountNumber = an;
    }

    public void crossTheBridge() {
        feesOwed += charge;
    }

    public int AmountOwed() {
        return feesOwed;
    }
}
