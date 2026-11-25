package school.management.system;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teacher extends User {
    private List<Module> assignedModules;

    public Teacher(int userId, String userName, String email, String password, String role) {
        super(userId, userName, email, password, role);
        this.assignedModules = new ArrayList<>();
    }

    public void displayTeacherInfo() {
        displayUserInfo();
        System.out.println("Assigned Modules:");
        for (Module module : assignedModules) {
            System.out.println("- " + module.getModuleName());
        }
    }
    public void displayAccountInfo() {
    System.out.println("\n=== Account Information ===");
    System.out.println("ID: " + userId);
    System.out.println("Name: " + userName);
    System.out.println("Email: " + email);
    System.out.println("role: " + role);
}

    public void assignModule(Module module) {
        if (module != null && !assignedModules.contains(module)) {
            assignedModules.add(module);
            System.out.println("Module " + module.getModuleName() + " assigned to " + getUserName());
        } else {
            System.out.println("Module is already assigned to this teacher or is invalid.");
        }
    }
   
public void manageAccount(Scanner scanner) {
    boolean managing = true;
    while (managing) {
        System.out.println("\n=== Account Management ===");
        System.out.println("1. Change Password");
        System.out.println("2. Update Personal Info");
        System.out.println("3. View Account Details");
        System.out.println("4. Back to Menu");
        System.out.print("Choose option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1 -> {
                System.out.print("Enter current password: ");
                String current = scanner.nextLine();
                if (current.equals(password)) {
                    System.out.print("Enter new password: ");
                    password = scanner.nextLine();
                    System.out.println("Password changed successfully!");
                } else {
                    System.out.println("Incorrect current password!");
                }
            }
            case 2 -> {
                System.out.print("Enter new email: ");
                email = scanner.nextLine();
                System.out.print("Enter new role: ");
                role = scanner.nextLine();
                System.out.println("Information updated successfully!");
            }
            case 3 -> displayAccountInfo();
            case 4 -> managing = false;
            default -> System.out.println("Invalid choice!");
        }
    }
}

    public void updateStudentReport(Student student, String report) {
        System.out.println("Report updated for student " + student.getUserName() + " to: " + report);
    }

    public void displayStudentReport(Student student) {
        System.out.println("Student Name: " + student.getUserName());
        System.out.println("Report: Sample report data");
    }

    public void updateGrade(String studentName, int newGrade) {
        System.out.println("Grade updated for student " + studentName + " to " + newGrade);
    }

    public List<Module> getAssignedModules() { return assignedModules; }
    public void setAssignedModules(List<Module> assignedModules) { 
        this.assignedModules = assignedModules; 
    }
    public boolean login(String email, String password) {
    return this.email.equals(email) && this.password.equals(password);
}
    public String getName() { return userName; }
    @Override
    public String getEmail() { return email; }
    @Override
    public String getPassword() { return password; }
   
}