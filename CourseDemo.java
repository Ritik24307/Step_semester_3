class Course {

    String code;
    String title;
    int credits;
    int labCredits;

    // Four-argument constructor
    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Three-argument constructor
    // Calls the four-argument constructor
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    // Calculate total credits
    public int totalCredits() {
        return credits + labCredits;
    }
}

class CourseDemo {

    public static void main(String[] args) {

        // Theory-only course
        Course c1 = new Course("21CSC201J", "Data Structures", 4);

        // Course with lab
        Course c2 = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(c1.code + " total credits: " + c1.totalCredits());
        System.out.println(c2.code + " total credits: " + c2.totalCredits());
    }
}