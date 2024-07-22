import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] data = new int[100];
        int collisions = 0;

        Random rand = new Random(8);

        for (int i = 0; i < 40; i++) {
            int n = rand.nextInt(1000) + 1;
            int position = n % 13; // hashcode

            boolean valid = false;
            int q = 1;

            // int p = position; // for resets
            int increment = 12 - (n % 12);

            while (!valid) {
                // System.out.println("Try putting " + n + " in spot " + position + ".");
                if (data[position] == 0) {
                    // System.out.println("success");
                    data[position] = n;
                    valid = true;
                } else {
                    // System.out.println("collision (" + (collisions + 1) + ")");
                    collisions++;
                    position += increment;
                    q++;
                }
            }
        }

        System.out.println("Collisions: " + collisions);
    }
}
