public abstract class Vehicle {

    public String owner;
    public String licensePlate;
    public int accountNumber;
    public int charge;

    // public Vehicle(String o, String lP, int aN, int c){
    // owner = o;
    // }

    public abstract void crossTheBridge();

    public abstract int AmountOwed();

    public String name() {
        return owner;
    }
    // charge = c;
    // }

}
