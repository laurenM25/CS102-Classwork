import java.util.Random;
import java.util.Arrays;
import net.datastructures.*;

public class Main {
    public static void main(String[] args) {

        Integer[] keys = new Integer[100];

        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            keys[i] = rand.nextInt(1000) + 1;
        }

        Integer[] values = Arrays.copyOf(keys, keys.length); // print initial stuff
        System.out.println("Part1:\n");

        HeapSorty<Integer, Integer> heap = new HeapSorty<Integer, Integer>(keys, values); // heap
        System.out.println("number of compares: " + heap.compares + "\n\nPart2:\n");

        //// part 2
        for (int i = 0; i < 100; i++) {
            keys[i] = i + 1;
        }
        values = Arrays.copyOf(keys, keys.length);
        heap = new HeapSorty<Integer, Integer>(keys, values);
        System.out.println("number of compares: " + heap.compares + "\n\nPart3:\n");

        //// part 3
        for (int i = 0; i < 100; i++) {
            keys[i] = 110 - i;
        }
        values = Arrays.copyOf(keys, keys.length);
        heap = new HeapSorty<Integer, Integer>(keys, values);
        System.out.println("number of compares: " + heap.compares + "\n\nPart4: \n");

        //// part 4 /////////////////

        // 4.a
        heap = new HeapSorty<Integer, Integer>();
        for (int i = 0; i < 100; i++) {
            Integer n = rand.nextInt(1000) + 1;
            heap.insert(n, n);
        }
        System.out.println("number of compares: " + heap.compares + "\n\n");

        // 4.b
        heap = new HeapSorty<Integer, Integer>();
        for (int i = 0; i < 100; i++) {
            Integer n = i + 1;
            heap.insert(n, n);
        }
        System.out.println("number of compares: " + heap.compares + "\n\n");

        // 4.c
        heap = new HeapSorty<Integer, Integer>();
        for (int i = 0; i < 100; i++) {
            Integer n = 110 - i;
            heap.insert(n, n);
        }
        System.out.println("number of compares: " + heap.compares + "\n\nPart5:\n");

        // Part 5
        for (int i = 0; i < 100; i++) {
            keys[i] = rand.nextInt(1000) + 1;
        }

        values = Arrays.copyOf(keys, keys.length);
        heap = new HeapSorty<Integer, Integer>(keys, values);
        System.out.println("Sorted Output:");
        heap.printArray();
        System.out.println("number of compares: " + heap.compares + "\n\n");
    }
}
