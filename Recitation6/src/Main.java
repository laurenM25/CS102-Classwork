public class Main {

    //converting an integer into a string of digits

    public static String method3(int n){
        int lastDigit = n % 10;
        String s = "" + lastDigit;
        if(n < 10){
            return s;
        }
        //string concatenation
        int newNumber = n/10;
        return method3(newNumber) + s;
        
    }
    public static void main(String[] args) {
        String p = method3(123);
        System.out.println(p);
        
    }


}