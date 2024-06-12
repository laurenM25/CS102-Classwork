public class Main{

    public static String ReverseString(String s){
        int length = s.length();
        if(length == 1){
            return s;
        }
        if(length == 0){
            return null;
        }
        String lastLetter = s.getChartAt(length - 1);
        String newS = s.substring(0,length-1);
        return lastLetter + ReverseString(newS);
    }
    public static void Main(){

    }
}
