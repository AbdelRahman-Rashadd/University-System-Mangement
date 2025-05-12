import model.*;
import model.users.*;
import util.FileManager;
import util.AuthenticationException;
import java.util.*;
import java.io.IOException;

public class Main {
    private static University university;
    private static User currentUser;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeSystem();
        showMainMenu();
    }

    private static void initializeSystem() {
        try {
            // Load all data
            List<Department> departments = FileManager.loadDepartments();
            List<User> users = FileManager.loadUsers();
            List<Course> courses = FileManager.loadCourses(users);
            List<Enrollment> enrollments = FileManager.loadEnrollments(users, courses);
            
            // Connect related objects
            connectUsersToDepartments(users, departments);
            connectCoursesToDepartments(courses, departments);
            connectEnrollments(users, courses, enrollments);
            
            // Create university instance
            university = new University();
            university.setDepartments(departments);
            university.setUsers(users);
            university.setCourses(courses);
            
            System.out.println("System initialized with:");
            System.out.println("- " + departments.size() + " departments");
            System.out.println("- " + users.size() + " users");
            System.out.println("- " + courses.size() + " courses");
            System.out.println("- " + enrollments.size() + " enrollments");
            
        } catch (IOException e) {
            System.err.println("Failed to initialize system: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n=== University Management System ===");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    handleLogin();
                    break;
                case 2:
                    saveAllData();
                    System.out.println("Exiting system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleLogin() {
        System.out.println("\n=== Login ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        try {
            currentUser = university.authenticateUser(username, password);
            if (currentUser != null) {
                System.out.println("\nLogin successful! Welcome, " + currentUser.getName());
                showUserDashboard();
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }

    private static void showUserDashboard() {
        if (currentUser instanceof Student) {
            showStudentDashboard((Student) currentUser);
        } else if (currentUser instanceof Faculty) {
            showFacultyDashboard((Faculty) currentUser);
        } else if (currentUser instanceof AdminStaff) {
            showAdminDashboard((AdminStaff) currentUser);
        } else if (currentUser instanceof SystemAdmin) {
            showSystemAdminDashboard((SystemAdmin) currentUser);
        }
    }

    private static void showStudentDashboard(Student student) {
        while (true) {
            System.out.println("\n=== Student Dashboard ===");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for Course");
            System.out.println("3. Drop Course");
            System.out.println("4. View Grades");
            System.out.println("5. View Profile");
            System.out.println("6. Update Profile");
            System.out.println("7. Logout");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    displayAvailableCourses();
                    break;
                case 2:
                    handleCourseRegistration(student);
                    break;
                case 3:
                    handleCourseDrop(student);
                    break;
                case 4:
                    displayStudentGrades(student);
                    break;
                case 5:
                    displayStudentProfile(student);
                    break;
                case 6:
                    updateStudentProfile(student);
                    break;
                case 7:
                    currentUser.logout();
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showFacultyDashboard(Faculty faculty) {
        while (true) {
            System.out.println("\n=== Faculty Dashboard ===");
            System.out.println("1. View Teaching Courses");
            System.out.println("2. View Course Roster");
            System.out.println("3. Enter Grades");
            System.out.println("4. Update Office Hours");
            System.out.println("5. View Profile");
            System.out.println("6. Update Profile");
            System.out.println("7. Logout");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    displayTeachingCourses(faculty);
                    break;
                case 2:
                    displayCourseRoster(faculty);
                    break;
                case 3:
                    enterStudentGrades(faculty);
                    break;
                case 4:
                    updateOfficeHours(faculty);
                    break;
                case 5:
                    displayFacultyProfile(faculty);
                    break;
                case 6:
                    updateFacultyProfile(faculty);
                    break;
                case 7:
                    currentUser.logout();
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showAdminDashboard(AdminStaff admin) {
        while (true) {
            System.out.println("\n=== Admin Dashboard ===");
            System.out.println("1. Register New Student");
            System.out.println("2. Create New Course");
            System.out.println("3. Assign Faculty to Course");
            System.out.println("4. Generate Reports");
            System.out.println("5. View Department Info");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    registerNewStudent();
                    break;
                case 2:
                    createNewCourse();
                    break;
                case 3:
                    assignFacultyToCourse();
                    break;
                case 4:
                    generateReports();
                    break;
                case 5:
                    viewDepartmentInfo();
                    break;
                case 6:
                    currentUser.logout();
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showSystemAdminDashboard(SystemAdmin admin) {
        while (true) {
            System.out.println("\n=== System Admin Dashboard ===");
            System.out.println("1. Create New User");
            System.out.println("2. Modify System Settings");
            System.out.println("3. Backup System Data");
            System.out.println("4. Restore System Data");
            System.out.println("5. View System Logs");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    createNewUser();
                    break;
                case 2:
                    modifySystemSettings();
                    break;
                case 3:
                    backupSystemData();
                    break;
                case 4:
                    restoreSystemData();
                    break;
                case 5:
                    viewSystemLogs();
                    break;
                case 6:
                    currentUser.logout();
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Helper methods for each menu option would be implemented here
    // For example:
    private static void displayAvailableCourses() {
        System.out.println("\nAvailable Courses:");
        university.getCourses().forEach(course -> {
            if (course.hasAvailableSeats()) {
                System.out.printf("- %s: %s (Seats: %d/%d)\n",
                    course.getCourseId(),
                    course.getTitle(),
                    course.getEnrolledStudents().size(),
                    course.getMaxCapacity());
            }
        });
    }

    private static void handleCourseRegistration(Student student) {
        displayAvailableCourses();
        System.out.print("\nEnter Course ID to register: ");
        String courseId = scanner.nextLine();
        
        Course course = university.findCourse(courseId);
        if (course != null) {
            try {
                student.registerForCourse(course);
                System.out.println("Successfully registered for " + course.getTitle());
            } catch (Exception e) {
                System.out.println("Registration failed: " + e.getMessage());
            }
        } else {
            System.out.println("Course not found.");
        }
    }

    private static void saveAllData() {
        try {
            FileManager.saveUsers(university.getUsers());
            FileManager.saveCourses(university.getCourses());
            FileManager.saveDepartments(university.getDepartments());
            
            // Collect all enrollments from students
            List<Enrollment> allEnrollments = new ArrayList<>();
            university.getUsers().stream()
                .filter(user -> user instanceof Student)
                .map(user -> (Student) user)
                .forEach(student -> allEnrollments.addAll(student.getEnrollments()));
            
            FileManager.saveEnrollments(allEnrollments);
            System.out.println("All data saved successfully.");
        } catch (IOException e) {
            System.err.println("Failed to save data: " + e.getMessage());
        }
    }

    // Additional helper methods for connecting objects during initialization
    private static void connectUsersToDepartments(List<User> users, List<Department> departments) {
        Map<String, Department> deptMap = new HashMap<>();
        departments.forEach(dept -> deptMap.put(dept.getDepartmentId(), dept));
        
        users.forEach(user -> {
            if (user instanceof Faculty) {
                Faculty faculty = (Faculty) user;
                Department dept = deptMap.get(faculty.getDepartment().getDepartmentId());
                if (dept != null) {
                    faculty.setDepartment(dept);
                    dept.addFaculty(faculty);
                }
            }
        });
    }
    
    // Other connection methods would follow similar patterns
}