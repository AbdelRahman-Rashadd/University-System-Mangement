import java.util.ArrayList;
import java.util.List;

public class University {

    private String name;
    private List<User> users;
    private List<Students> students;
    private List<Faculty> faculty;
    private List<AdminStaff> adminStaff;
    private List<SystemAdmin> systemAdmins;
    private List<Course> courses;
    private List<Department> departments;

    // Constructor
    public University(String name) {
        this.name = name;
        this.users = new ArrayList<>();
        this.students = new ArrayList<>();
        this.faculty = new ArrayList<>();
        this.adminStaff = new ArrayList<>();
        this.systemAdmins = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    // Register a new student
    public void registerStudent(Students student) {
        students.add(student);
        users.add(student);
    }

    // Hire a new faculty member
    public void hireFaculty(Faculty f) {
        faculty.add(f);
        users.add(f);
    }

    // Add an admin staff member
    public void addAdminStaff(AdminStaff staff) {
        adminStaff.add(staff);
        users.add(staff);
    }

    // Add system administrator
    public void addSystemAdmin(SystemAdmin admin) {
        systemAdmins.add(admin);
        users.add(admin);
    }

    // Add a department
    public void createDepartment(Department dept) {
        departments.add(dept);
    }

    // Offer a new course
    public void offerCourse(Course course) {
        courses.add(course);
    }

    // Getters
    public List<Students> getStudents() { return students; }
    public List<Faculty> getFaculty() { return faculty; }
    public List<Course> getCourses() { return courses; }
    public List<Department> getDepartments() { return departments; }
    public List<User> getAllUsers() { return users; }

    public String getName() { return name; }
}
