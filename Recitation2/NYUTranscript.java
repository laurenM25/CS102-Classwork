import java.util.Arrays;

public class NYUTranscript implements Cloneable {
	int EarnedCredits;
	String[] CoursesTaken;

	public NYUTranscript(int credits, String[] courses) {
		EarnedCredits = credits;
		CoursesTaken = courses;
	}

	public void addCourse(String course, int credits) {
		int capacity = CoursesTaken.length + 1;
		String[] newCourses = new String[capacity];
		for (int i = 0; i < CoursesTaken.length; i++) {
			newCourses[i] = CoursesTaken[i];
		}
		newCourses[capacity - 1] = course;
		CoursesTaken = newCourses; // update the array
		EarnedCredits += credits;
	}

	public NYUTranscript clone() throws CloneNotSupportedException {
		return (NYUTranscript) super.clone();
	}

	public String toString() {
		String s = "Earned Credits: " + Integer.toString(EarnedCredits) + "\nCourses Taken:"
				+ Arrays.toString(CoursesTaken);
		return s;
	}
}
