
import java.util.ArrayList;
import java .util.List;

public class Students extends User {
    private String studentId;
    private String admissionDate;
    private String academicStatus;
    private List <String>enrolledCourses;
    private Course course;
    private Enrollment enrollment;
    public Students(String userId, String username, String password, String name, String email, String contactInfo,String studentId,String admissionDate,String academicStatus,List<String>enrolledCourses,String grades,Course course,Enrollment enrollment) {
        super(userId, username, password, name, email, contactInfo,false);
        this.studentId=studentId;
        this.academicStatus=academicStatus;
        this.admissionDate=admissionDate;
        this.enrolledCourses=new ArrayList<>();
        this.course=course;
        this.enrollment=enrollment;
    }
    public String getStudentId() {
        return studentId;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public String getAcademicStatus() {
        return academicStatus;
    }

    public void setAcademicStatus(String academicStatus) {
        this.academicStatus = academicStatus;
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }
    public boolean registerForCourse(Course course,String courseId){
        if(!course.isPrerequisiteSatisfied()||enrolledCourses.contains(courseId)){
            System.out.println("Course registeration faild");
            return false;
        }
        else{
            enrolledCourses.add(courseId);
            System.out.println("course: " +course.getTitle()+ " registered");
            return true;
        }
    }
    public void dropCourse(String courseId) {
        this.enrolledCourses.remove(courseId);
        System.out.println("Dropped course: " + courseId);
    }
    @Override
    public String getRole(){
        return "student";
    }
    public double calculateGPA(){
        double totalPoints=0.0;
        int totalCreditHours=0;
        for(int i=0;i<enrolledCourses.size();i++){
            String courseId=enrolledCourses.get(i);
            if(enrolledCourses.contains(courseId)){
                totalPoints+=enrollment.getGradePoints();
                totalCreditHours+=course.getCreditHours();
            }
        }
        return totalPoints/totalCreditHours;
    }

    @Override
    public void displayDashboard() {
        System.out.println("\n---- Student Dashboard ----");
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + getName());
        System.out.println("Academic Status: " + academicStatus);
        System.out.println("Enrolled Courses: " + enrolledCourses);
        System.out.println("-------------------------\n");
    }

    
    }