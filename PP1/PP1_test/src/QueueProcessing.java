public class QueueProcessing {
	

	public static void main(String[] args) {

		// A
		String filePath = PartA.getFilePath();
		String file = PartA.getContentsOfFile(filePath);
		String[] lines = file.split("\n");

		// make list for EACH LINE of file
		for (int i = 0; i < lines.length; i++) {
			SinglyLinkedList<String[]> list = PartA.oneLineList(lines[i]);

			// calculate/print cycles required
			int cycles = PartA.countCycles(list);
			System.out.println(lines[i]); // print out line
			System.out.println("Total required cycles: " + cycles + "\n");
		}

		// B

		PartB.GenerateProcesses();
	}

}
