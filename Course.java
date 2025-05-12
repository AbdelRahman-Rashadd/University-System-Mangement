
import java .util.ArrayList;
import java .util.List;
public class Course{
    private  String courseId;
    private  String title;
    private String description;
    private int creditHours;
    private List<String>prerequisites;
    private String facultyAssigned;
    private int max_capacity;
    private String schedule;
    private List<String>enrolledStudents;
     private Faculty instructor;

    public Course(String courseId,String title,String description,int creditHours,List<String>prerequisites,String facultyAssigned,int max_capacity,List<String>enrolledStudents){
        this.courseId=courseId;
        this.title=title;
        this.description=description;
        this.creditHours=creditHours;
        this.prerequisites=new ArrayList<>();
        this.facultyAssigned=facultyAssigned;
        this.max_capacity=max_capacity;
        this.schedule=schedule;
        this.enrolledStudents=new ArrayList<>();
        this.instructor=instructor;
    }
    public String getDescription() {
    return description;
}

public int getCreditHours() {
    return creditHours;
}

public String getFacultyAssigned() {
    return facultyAssigned;
}

public int getMaxCapacity() {
    return max_capacity;
}

public String getSchedule() {
    return schedule;
}

public List<String> getEnrolledStudents() {
    return enrolledStudents;
}
    public String getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public int getEnrolledStudentCount() {
        return enrolledStudents.size();
    }

    public boolean addStudent(String studentId){
        if(enrolledStudents.size()<max_capacity&&!enrolledStudents.contains(studentId)){
            this.enrolledStudents.add(studentId);

            return true;
        }
        return false;
    }
    public boolean removeStudent(String studentId){
        if(enrolledStudents.contains(studentId)){
            this.enrolledStudents.remove(studentId);
    
            return true;
        }
        return false;
    }
    public boolean isPrerequisiteSatisfied(){
        if (prerequisites.isEmpty()){
            return true;
        }else{return false;}
    }
    public int getAvailableSeats(){
        return max_capacity-enrolledStudents.size();
    }
    public void setCourseId(String courseId) {
    this.courseId = courseId;
}

public void setTitle(String title) {
    this.title = title;
}

public void setDescription(String description) {
    this.description = description;
}

public void setCreditHours(int creditHours) {
    this.creditHours = creditHours;
}

public void setPrerequisites(List<String> prerequisites) {
    this.prerequisites = prerequisites;
}

public void setFacultyAssigned(String facultyAssigned) {
    this.facultyAssigned = facultyAssigned;
}

public void setMaxCapacity(int max_capacity) {
    this.max_capacity = max_capacity;
}

public void setSchedule(String schedule) {
    this.schedule = schedule;
}

public void setEnrolledStudents(List<String> enrolledStudents) {
    this.enrolledStudents = enrolledStudents;
}
    public void setInstructor(Faculty instructor) {
        this.instructor = instructor;
    }

    public Faculty getInstructor() {
        return instructor;
    }

}