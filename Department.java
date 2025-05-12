
import java.util.List;
import java.util.ArrayList;
public class Department {
    private String departmentId;
    private String name;
    private List<Course> offeredCourses;
    private List<Faculty> faculty;
    public Department(String departmentId, String name, List<Course> offeredCourses, List<Faculty> faculty) {
        this.departmentId = departmentId;
        this.name = name;
        this.offeredCourses = new ArrayList<>();
        this.faculty = new ArrayList<>();
    }
    public String getDepartmentId() {
        return departmentId;
    }
    
    public String getName() {
        return name;
    }
    
    public List<Course> getOfferedCourses() {
        return offeredCourses;
    }
    
    public List<Faculty> getFacultyList() {
        return faculty;
    }
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setOfferedCourses(List<Course> offeredCourses) {
        this.offeredCourses = offeredCourses;
    }
    
    public void setFacultyList(List<Faculty> faculty) {
        this.faculty = faculty;
    }
    public boolean addFaculty(Faculty faculty){
        if(this.faculty.contains(faculty)){
            System.out.println("Faculty already exists in the department.");
            return false;
        }
        this.faculty.add(faculty);
        System.out.println("Faculty added to the department: " + faculty.getName());
        return true;
    }
    public boolean removeFaculty(Faculty faculty){
        if(!this.faculty.contains(faculty)){
            System.out.println("Faculty not found in the department.");
            return false;
        }
        this.faculty.remove(faculty);
        System.out.println("Faculty removed from the department: " + faculty.getName());
        return true;
    }
    public boolean addCourse(Course course){
        if(this.offeredCourses.contains(course)){
            System.out.println("Course already exists in the department.");
            return false;
        }
        this.offeredCourses.add(course);
        System.out.println("Course added to the department: " + course.getTitle());
        return true;
    }


}