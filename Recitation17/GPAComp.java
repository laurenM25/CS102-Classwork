public class GPAComp {

    public int compare(Student s1, Student s2) {
        if (s1.getGPA2() < s2.getGPA2()) {
            return -1;
        }
        if (s1.getGPA2() > s2.getGPA2()) {
            return 1;
        }
        return s1.getName().compareTo(s2.getName());
    }
}
