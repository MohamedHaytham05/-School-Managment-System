package school.management.system;
import java.util.ArrayList;
import java.util.List;

public class Module {
    private String moduleId;
    private String moduleName;
    private int maxCapacity;
    private boolean isFull;
    private List<Student> enrolledStudents;
    private Teacher assignedTeacher;
    private Admin managingAdmin;
    public Module(String moduleId, String moduleName, int maxCapacity, Admin admin) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.maxCapacity = maxCapacity;
        this.isFull = false;
        this.enrolledStudents = new ArrayList<>();
        this.managingAdmin = admin;
    }
   
      public void displayModuleDetails() {
        System.out.println("Module ID: " + moduleId);
        System.out.println("Module Name: " + moduleName);
        System.out.println("Max Capacity: " + maxCapacity);
        System.out.println("Current Enrollment: " + enrolledStudents.size());
        System.out.println("Is Full: " + isFull);
        if (assignedTeacher != null) {
            System.out.println("Assigned Teacher: " + assignedTeacher.getUserName());
        }
    }

    public void checkAvailability() {
        if (enrolledStudents.size() < maxCapacity) {
            System.out.println("Module is available for enrollment.");
            isFull = false;
        } else {
            isFull = true;
            System.out.println("Module is full.");
        }
    }

    public void enrollStudent(Student student) {
        if (!isFull) {
            enrolledStudents.add(student);
            System.out.println("Student " + student.getUserName() + " enrolled in " + moduleName);
            checkAvailability();
        } else {
            System.out.println("Cannot enroll - module is full.");
        }
    }

    public void updateMaxCapacity(int newCapacity) {
        this.maxCapacity = newCapacity;
        System.out.println("Module max capacity updated to " + newCapacity);
        checkAvailability();
    }
    public String getModuleId() { return moduleId; }
    public String getModuleName() { return moduleName; }
    public int getMaxCapacity() { return maxCapacity; }
    public boolean isFull() { return isFull; }
    public List<Student> getEnrolledStudents() { return enrolledStudents; }
    public Teacher getAssignedTeacher() { return assignedTeacher; }
    public Admin getManagingAdmin() { return managingAdmin; }

    public void setModuleId(String moduleId) { this.moduleId = moduleId; }
    public void setModuleName(String moduleName) { this.moduleName = moduleName; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }
    public void setAssignedTeacher(Teacher teacher) { this.assignedTeacher = teacher; }
}