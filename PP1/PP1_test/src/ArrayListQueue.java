import java.util.Random;
import java.util.Iterator; //parse data
import java.util.ArrayList; //store data, can remove in between, etc.

public class ArrayListQueue {

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
    public static ArrayList<String[]> modifiedQueue(ArrayList<String[]> queue) { //bruh i didn't use Iterator

        // compare current.resources to next.resources

        String[] cur = queue.get(0);
        queue.remove(0); // removes first from queue

        String[] trackerS = { "", "", "" };
        boolean repeat = true;
        boolean end = false;
        boolean full = false;

        do {
            int indexN = 0;
            String[] next = { "", "" };
            do {
                next = queue.get(indexN); // get but don't remove yet
                int indexTS = 0;// index to start adding to trackerS
                repeat = false; // initial, can be changed

                boolean Empty = true; // see if tracker has been reset
                for (int i = 0; i < trackerS.length; i++) {
                    if (trackerS[i] != "") {
                        Empty = false;
                        indexTS = i + 1;
                    }
                }

                if (indexTS >= 2) {
                    full = true;
                    repeat = true;
                    break;
                } // trackerS is full, need to start new cycle

                if (Empty == true) { // need to recount after reset
                    for (; indexTS < cur.length; indexTS++) {// track each element of FIRST program
                        trackerS[indexTS] = cur[indexTS];
                    }
                }
                String[] temp = trackerS; // with just current

                for (int j = 0; j < next.length; j++) {// track each element of SECOND program
                    if (!containsLetter(next[j], trackerS)) {
                        trackerS[indexTS + j] = next[j];
                    } else {
                        repeat = true;
                        break;
                    }
                }

                // repeat = isRepeat(tracker);
                indexN++;
                end = indexN == queue.size(); // no more indicies to look at

                // reset tracker to one before invalid next
                trackerS = temp;

            } while (repeat && !end && !full);

            // if counter > 1 for any resource, complete cycle
            if (repeat) {
                queue.add(randResources());// add 2 processes
                queue.add(randResources());
                break;
            }
            queue.remove(indexN); // remove
            // set new current (walk over to next one)
            cur = next;

        } while (!repeat);

        return queue;

    }

    public static void GenerateProcesses() { // print out statements
        // initial 20 processes into a QUEUE
        ArrayList<String[]> queue = new ArrayList<String[]>(); // ArrayList
        for (int i = 0; i < 20; i++) {
            String[] objRes = randResources();
            // add resource to the QUEUE
            queue.add(objRes);
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
