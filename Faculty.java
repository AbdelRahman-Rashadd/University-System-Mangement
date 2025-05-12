

import java.util.ArrayList;
import java .util.List;
public class Faculty extends User {
    private String facultyId;
    private String name;
    private Department department;
    private String expertise;
    private List<String> coursesTeaching=new ArrayList<>();
    private Course course;

    public Faculty(String userId, String username, String password, String name, String email, String contactInfo,boolean loggedIn ,String facultyId,String expertise,List<String>coursesTeaching ,Course course,Department department) {
      super(userId, username, password, name, email, contactInfo,loggedIn);
      this.facultyId=facultyId;
      this.department=department;
      this.expertise=expertise;
      this.coursesTeaching=coursesTeaching;
    }
    @Override
    public String getRole() {
        return "Faculty";
    }
    public String getFacultyId() {
      return facultyId;
  }
  
  public void setFacultyId(String facultyId) {
      this.facultyId = facultyId;
  }
  
  public String getName() {
      return name;
  }
  
  public void setName(String name) {
      this.name = name;
  }
  
  public Department getDepartment() {
      return department;
  }
  
  public void setDepartment(Department department) {
      this.department = department;
  }
  
  public String getExpertise() {
      return expertise;
  }
  
  public void setExpertise(String expertise) {
      this.expertise = expertise;
  }
  
  public List<String> getCoursesTeaching() {
      return coursesTeaching;
  }
  
  public void setCoursesTeaching(List<String> coursesTeaching) {
      this.coursesTeaching = coursesTeaching;
  }
  public void assignGrades(Enrollment enrollment, String grade) {
      enrollment.assignGrade(grade);

  }
  public void courseManagement(Course course,String  newschedule,int  newmax_capacity) {
      course.setSchedule(newschedule);
      course.setMaxCapacity(newmax_capacity);
  }
    @Override
    public void displayDashboard() {
      System.out.println("Faculty Dashboard");
      System.out.println("Name: " + getName());
      System.out.println("Department: " +department.getName());
      System.out.println("\nCourses Teaching:");
    for (int i = 0; i < coursesTeaching.size(); i++) {
        String courseId = coursesTeaching.get(i);
        System.out.println("- " + courseId);
    }
  }


}