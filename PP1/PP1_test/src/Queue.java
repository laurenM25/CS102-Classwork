import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
//import java.util.Arrays;
import java.util.Random;

public class Queue {
	// Part A #######################################################

	public static Scanner scn = new Scanner(System.in);
	public static Random rand = new Random();

	// 1) read file, make list with first line !!!!!!!!!!!!!!!!!!!!
	public static String getFilePath() {
		System.out.println("What file would you like to open: ");
		String fpath = scn.nextLine();

		return fpath;
	}

	public static String getContentsOfFile(String fpath) {

		String fullText = "";
		// opening up a file may fail if the file is not there...
		try {
			// try to open the file and extract its contents
			Scanner scn = new Scanner(new File(fpath));
			while (scn.hasNextLine()) {
				String line = scn.nextLine();
				fullText += line + "\n"; // nextLine() removes line breaks, add back in
			}
			scn.close(); // be nice and close the Scanner
		} catch (FileNotFoundException e) {
			// in case we fail to open the file, output a friendly message.
			System.out.println("Oh no... can't find the file!");
		}
		return fullText; // return the full text
	}

	public static SinglyLinkedList<String[]> oneLineList(String line) {

		// make String array, splitting at semicolon
		String[] processes = line.split(";");
		String[][] resources = new String[processes.length][];

		// add resources into array
		for (int i = 0; i < processes.length; i++) {
			int start = 0;
			int end = 0;
			for (int j = 0; j < processes[i].length(); j++) {
				if (processes[i].charAt(j) == '(') {
					start = j + 1;
				}
				if (processes[i].charAt(j) == ')') {
					end = j; // substring is exclusive with end
				}
			}
			String resString = processes[i].substring(start, end);

			String[] resources1 = resString.split(",");

			resources[i] = resources1; // add array of resources to that process
		}

		// now make a list, passing the String[] as the element
		SinglyLinkedList<String[]> list = new SinglyLinkedList<String[]>();
		// add nodes
		for (int i = 0; i < processes.length; i++) {
			list.addLast(resources[i]);
		}

		return list;

	} // end of OneLineList method

	// keeping track of A's B's and C's
	public static boolean isRepeat(int[] count) {
		for (int l : count) {
			if (l > 1)
				return true; // there is a repeat
		}
		return false;
	}

	// now we want to see which processes can run in same cycle
	public static int countCycles(SinglyLinkedList<String[]> list) {
		int counter = 1;
		String[] cur = list.removeFirst(); // element of first node
		int[] tracker = { 0, 0, 0 }; // use ONE array to track elements

		do {
			String[] next = list.removeFirst(); // element of second node

			// compare current.resources to next.resources
			// do a counter array to track A's B's and C's

			for (String e : cur) {// track each element of FIRST program
				if (e.equals("A"))
					tracker[0]++;
				else if (e.equals("B"))
					tracker[1]++;
				else if (e.equals("C"))
					tracker[2]++;
			}
			for (String e : next) {// track each element of SECOND program
				if (e.equals("A"))
					tracker[0]++;
				else if (e.equals("B"))
					tracker[1]++;
				else if (e.equals("C"))
					tracker[2]++;
			}

			// if counter > 1 for any resource, run only current (not next)
			if (isRepeat(tracker)) {
				counter++; // add a cycle for repeat
				tracker = new int[] { 0, 0, 0 }; // reset tracker (otherwise, wanna use same tracker bc in same cycle)
			}
			// set new current (walk over to next one)
			cur = next;

		} while (!list.isEmpty());

		return counter;
	}

	// Part B #######################################################

	public static String randABC() {
		int num = rand.nextInt(3); // 0 1 or 2
		if (num == 0)
			return "A";
		else if (num == 1)
			return "B";
		else
			return "C";
	}

	public static boolean containsLetter(String l, String[] array) {
		for (String r : array) {
			if (r == null) // empty (completely)
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
				isValid = !containsLetter(abc, reStrings); // CHECK BEFORE ADD

				if (isValid) {
					reStrings[i] = abc; // add letter to Str[]
				}

			} while (!isValid);

		}
		return reStrings; // return String[]
	}

	// modify list each cycle
	public static SinglyLinkedList<String[]> modifiedList(SinglyLinkedList<String[]> list) {
		int cycles = 1;
		String[] cur = list.removeFirst(); // element of first node
		int[] tracker = { 0, 0, 0 }; // use ONE array to track elements

		do {
			String[] next = list.removeFirst(); // element of second node

			// compare current.resources to next.resources
			// do a counter array to track A's B's and C's

			for (String e : cur) {// track each element of FIRST program
				if (e.equals("A"))
					tracker[0]++;
				else if (e.equals("B"))
					tracker[1]++;
				else if (e.equals("C"))
					tracker[2]++;
			}
			for (String e : next) {// track each element of SECOND program
				if (e.equals("A"))
					tracker[0]++;
				else if (e.equals("B"))
					tracker[1]++;
				else if (e.equals("C"))
					tracker[2]++;
			}

			// if counter > 1 for any resource, run only current (not next)
			if (isRepeat(tracker)) {
				cycles++; // add a cycle for repeat
				tracker = new int[] { 0, 0, 0 }; // reset tracker (otherwise, wanna use same tracker bc in same cycle)
				list.addLast(randResources());// add 2 processes
				list.addLast(randResources());
			}
			// set new current (walk over to next one)
			cur = next;
		} while (cycles < 100);

		return list;

	}

	public static void GenerateProcesses() { // print out statements
		// initial 20 processes
		SinglyLinkedList<String[]> list = new SinglyLinkedList<String[]>();
		for (int i = 0; i < 20; i++) {
			String[] objRes = randResources();
			// add resources (String array) using list.addLast
			list.addLast(objRes);
		}

		for (int c = 1; c <= 10; c++) {
			list = modifiedList(list); // modify List eACH CYCLE, for 100 cycles
			int length = list.size(); // count PROGRAMS after 100 cycles

			// report processes left (length of list)
			System.out.println("Length of processes at cycle " + (c * 100) + ": " + length + "\n");

			// report final
			if (c == 10) {
				System.out.println("We have a total of " + length + " left.");
			}
		}

	}

	public static void main(String[] args) {

		// A
		String filePath = getFilePath();
		String file = getContentsOfFile(filePath);
		String[] lines = file.split("\n");

		// make list for EACH LINE of file
		for (int i = 0; i < lines.length; i++) {
			SinglyLinkedList<String[]> list = oneLineList(lines[i]);

			// calculate/print cycles required
			int cycles = countCycles(list);
			System.out.println(lines[i]); // print out line
			System.out.println("Total required cycles: " + cycles + "\n");
		}

		// B

		GenerateProcesses();
	}

}