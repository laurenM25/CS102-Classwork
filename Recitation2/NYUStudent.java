
public class NYUStudent extends NYUPerson implements Cloneable {

	private String SID;
	private NYUFaculty Advisor;
	private NYUPlan Program;
	private NYUMajor Major;
	private NYUTranscript Transcript;

	public NYUStudent(String inname, String inid) {
		name = inname;
		SID = inid;
	}

	public String toString() {
		return " Student Name: " + name + " ID: " + SID;
	}

	public void sendemail(String message, int priority) {
		// send an email with above message with given priority
		System.out.println("NYUStudent class " + message + " " + Integer.toString(priority));
	}

	public NYUStudent clone() throws CloneNotSupportedException { // clone method
		// deep clone the Transcript
		NYUStudent cloned = (NYUStudent) super.clone();
		cloned.Transcript = this.Transcript.clone();
		return cloned;
	}

	// set methods
	public void setMajor(NYUMajor m) { // set major and transcript
		Major = m;
	}

	public void setTranscript(NYUTranscript t) {
		Transcript = t;
	}

	public void setAdvisor(NYUFaculty f) {
		Advisor = f;
	}

	public void setName(String n) {
		name = n;
	}

	public void setSID(String sid) {
		SID = sid;
	}

	public void setProgram(NYUPlan p) {
		Program = p;
	}

	// get methods
	public NYUMajor getMajor() {
		return Major;
	}

	public NYUTranscript getTranscript() {
		return Transcript;
	}

	public NYUFaculty getAdvisor() {
		return Advisor;
	}

	public String getName() {
		return name;
	}

	public String getSID() {
		return SID;
	}

	public NYUPlan getProgram() {
		return Program;
	}

}
