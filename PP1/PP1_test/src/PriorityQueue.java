import java.util.Random;
import java.util.Iterator;

public class PriorityQueue {
    public final int CAPACITY = 1000; // default array capacity

    private String[][] data = new String[1000][]; // generic array used for storage

    private int f = 0; // index of the front element

    private int sz = 0; // current number of elements

    public PriorityQueue() {
    } // constructs queue with default capacity

    public int size() {
        return sz;
    }

    public boolean isEmpty() {
        return (sz == 0);
    }

    // adds to the last
    public void enqueue(String[] e) throws IllegalStateException {
        if (sz == data.length)
            throw new IllegalStateException("Queue is full");
        int avail = (f + sz) % data.length; // use modular arithmetic
        data[avail] = e;
        sz++;
    }

    public String[] first() {
        if (isEmpty())
            return null;
        return data[f];
    }

    // removes from the first
    public String[] dequeue() {
        if (isEmpty())
            return null;
        String[] answer = data[f];
        data[f] = null; // dereference to help garbage collection
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }

    // Part B methods
    public static Random rand = new Random();

    public static String randABC() {
        int num = rand.nextInt(3); // 0 1 or 2
        if (num == 0)
            return "A";
        else if (num == 1)
            return "B";
        else
            return "C";
    }

    // keeping track of repeats of A's B's and C's
    public static boolean isRepeat(int[] count) {
        for (int l : count) {
            if (l > 1)
                return true;
        }
        return false;
    }

    public static boolean containsLetter(String l, String[] array) {
        for (String r : array) {
            if (r == null) // empty array
                return false;
            else if (r.equals(l))
                return true; // contains duplicate
        }
        return false; // no duplicate
    }

    public static String[] randResources() {
        int strlen = rand.nextInt(3) + 1; // how many resources
        String[] reStrings = new String[strlen]; // initilaize array w/ capacity

        String abc;
        boolean isValid = false; // loop variable

        // assign random resources to array, NO DUPLICATES
        for (int i = 0; i < reStrings.length; i++) {
            do {
                abc = randABC(); // assign a random resource
                isValid = !containsLetter(abc, reStrings); // check if valid

                if (isValid) {
                    reStrings[i] = abc; // add letter to String[]
                }

            } while (!isValid);

        }
        return reStrings; // return String[]
    }

    // note: this method completes when the cycle finishes
    public static PriorityQueue modifiedQueue(PriorityQueue queue) {

        // compare current.resources to next.resources

        String[] cur = queue.dequeue();
        int[] tracker = { 0, 0, 0 };
        boolean repeat = true;

        do {
            String[] next = queue.first();

            boolean Empty = true; // see if tracker has been reset
            for (int i = 0; i < tracker.length; i++) {
                if (tracker[i] != 0) {
                    Empty = false;
                }
            }
            if (Empty == true) { // need to recount after reset
                for (String e : cur) {// track each element of FIRST program
                    if (e.equals("A"))
                        tracker[0]++;
                    else if (e.equals("B"))
                        tracker[1]++;
                    else if (e.equals("C"))
                        tracker[2]++;
                }
            }
            for (String e : next) {// track each element of SECOND program
                if (e.equals("A"))
                    tracker[0]++;
                else if (e.equals("B"))
                    tracker[1]++;
                else if (e.equals("C"))
                    tracker[2]++;
            }

            repeat = isRepeat(tracker);

            // if counter > 1 for any resource, complete cycle
            if (repeat) {
                queue.enqueue(randResources());// add 2 processes
                queue.enqueue(randResources());
                break;
            }
            queue.dequeue();
            // set new current (walk over to next one)
            cur = next;

        } while (!repeat);

        return queue;

    }

    public static void GenerateProcesses() { // print out statements
        // initial 20 processes into a QUEUE
        PriorityQueue queue = new PriorityQueue(); // LIST IS GONE, QUEUE IS IN
        for (int i = 0; i < 20; i++) {
            String[] objRes = randResources();
            // add resource to the QUEUE
            queue.enqueue(objRes);
        }

        int group = 1;
        int cyclesPerGroup = 100;

        for (; group <= 10; group++) {

            for (int i = 0; i < cyclesPerGroup; i++) {
                queue = modifiedQueue(queue); // modify List EACH CYCLE --> Queue
            }
            int length = queue.size(); // count programs left after 100 cycles

            // report processes left (length of list)
            System.out.println("Length of processes at cycle " + (group * cyclesPerGroup) + ": " + length + "\n");

            // report final
            if (group == 10) {
                System.out.println("We have a total of " + length + " left.");
            }
        }

    }

    public static void main(String[] args) {

        PartB.GenerateProcesses();
    }
}
