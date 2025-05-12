

public class Enrollment {
private Students student;
private Course course;
private String enrollmentDate;
private String status;
private String grade;
public Enrollment(Students student, Course course, String enrollmentDate, String status, String grade) {
    this.student = student;
    this.course = course;
    this.enrollmentDate = enrollmentDate;
    this.status = "Enrolled";
    this.grade = null;
}
public Students getStudent() {
    return student;
}

public void setStudent(Students student) {
    this.student = student;
}

public Course getCourse() {
    return course;
}

public void setCourse(Course course) {
    this.course = course;
}

public String getEnrollmentDate() {
    return enrollmentDate;
}

public void setEnrollmentDate(String enrollmentDate) {
    this.enrollmentDate = enrollmentDate;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}
public void withdraw() {
    this.status = "Withdrawn";
}
public void complete() {
    this.status = "Completed";
}
public void fail() {
    this.status = "Failed";
}

public String getGrade() {
    return grade;
}
public double getGradePoints() {
    if (grade == null) {
        return 0.0; // No grade assigned yet
    }
    switch (grade.toUpperCase()) {
        case "A":
            return 4.0;
        case "A-":
            return 3.7;
        case "B+":
            return 3.3;
        case "B":
            return 3.0;
        case "B-":
            return 2.7;
        case "C+":
            return 2.3;
        case "C":
            return 2.0;
        case "C-":
            return 1.7;
        case "D":
            return 1.0;
        case "F":
            return 0.0;
        default:
        throw new IllegalArgumentException("Invalid grade: " + grade);
    }
}

public void assignGrade(String grade) {
    this.grade = grade;
}
    public String toString() {
        return "Enrollment{" +
                "student=" + student.getName() +
                ", course=" + course.getTitle() +
                ", enrollmentDate=" + enrollmentDate +
                ", grade='" + grade + '\'' +
                ", status='" + status + '\'' +
                '}';
    }


}