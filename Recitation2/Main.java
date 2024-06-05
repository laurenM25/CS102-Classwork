
public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		NYUFaculty chair = new NYUFaculty("name", "id");
		NYUMajor major = new NYUMajor("major", chair, 128);
		String[] courses = { "course 1", "course 2" };
		NYUTranscript transcript = new NYUTranscript(32, courses);
		NYUFaculty advisor = new NYUFaculty("Advisory", "adID23");
		NYUPlan program = new NYUPlan();

		NYUStudent student = new NYUStudent("Joyce", "N21905");
		student.setAdvisor(advisor);
		student.setMajor(major);
		student.setTranscript(transcript);
		student.setProgram(program);

		// Create a clone2
		NYUStudent student2 = student.clone(); //this gives UNATTACHED transcript

		//REMEMBER DEEP CLONE
		// (created clone method in Transcript class)
		NYUTranscript transcript2 = student2.getTranscript();
		NYUTranscript transcript1 = student.getTranscript();

		// give clone new properties 
		student2.setName("Bob");
		student2.setSID("b21958");
		transcript2.addCourse("course 3", 4);

		// print out to see changes
		System.out.println(student.toString());
		System.out.println(transcript1.toString());

		System.out.println(student2.toString());
		System.out.println(transcript2.toString());

	}

}
