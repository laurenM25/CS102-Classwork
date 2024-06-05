
public class Main {

	public static void main(String[] args) {
		NYUFaculty chair = new NYUFaculty("name", "id");
		NYUMajor major = new NYUMajor("major", chair, 128);
		NYUTranscript transcript = new NYUTranscript();
		NYUFaculty advisor = new NYUFaculty();
		NYUPlan program = new NYUPlan();

		NYUStudent student = new NYUStudent("Joyce", "N21905");
		student.setAdvisor(advisor);
		student.setMajor(major);
		student.setTranscript(transcript);
		student.setProgram(program);

		// Create a clone2
		NYUStudent student2 = student.clone();

		// give clone new properties //REMEMBER DISCUSSION W/ PROF -- DEEP CLONE, GOTTA
		// CREATE CLONE METHOD IN TRANSCRIPT CLASS
		// YEAHHH FIX IT WE JUST WANNA MAKE THE TWO STUDENTS SEPARATEEEEE (so not using
		// set methods rn, not the point)
		String[] courses = { "course 1", "course 2" };
		NYUTranscript transcript2 = new NYUTranscript(32, courses);
		student2.setTranscript(transcript2);
		student2.setName("Bob");
		student2.setSID("b21958");

	}
}
