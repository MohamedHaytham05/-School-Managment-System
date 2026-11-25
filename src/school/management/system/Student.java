package school.management.system;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User {
    private char academicPerformance;
    private String studentLevel;
    public Student(int userId, String userName, String email, String password, 
                  char academicPerformance, String studentLevel, String role) {
        super(userId, userName, email, password, role);
        this.academicPerformance = academicPerformance;
        this.studentLevel = studentLevel;
    }

    public void studentDetails() {
        displayUserInfo();
        System.out.println("Academic Performance: " + academicPerformance);
        System.out.println("Level: " + studentLevel);
    }
    
public void manageAccount(Scanner scanner) {
    boolean managing = true;
    while (managing) {
        System.out.print("\n=== Account Management ===");
        System.out.println("1. Change Password");
        System.out.println("2. Update Personal Info");
        System.out.println("3. View Account Details");
        System.out.println("4. Back to Menu");
        System.out.print("Choose option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                System.out.print("Enter current password: ");
                String current = scanner.nextLine();
                if (current.equals(password)) {
                    System.out.print("Enter new password: ");
                    password = scanner.nextLine();
                    System.out.println("Password changed successfully!");
                } else {
                    System.out.println("Incorrect current password!");
                }
                break;
            case 2:
                System.out.print("Enter new email: ");
                email = scanner.nextLine();
                System.out.print("Enter new year (Freshman/Sophomore/Junior/Senior): ");
                studentLevel = scanner.nextLine();
                System.out.println("Information updated successfully!");
                break;
            case 3:
                displayAccountInfo();
                break;
            case 4:
                managing = false;
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}

public void displayAccountInfo() {
    System.out.print("\n=== Account Information ===");
    System.out.println("ID: " + userId);
    System.out.println("Name: " + userName);
    System.out.println("Email: " + email);
    System.out.println("Year: " + studentLevel);
    System.out.println("Performance: " + academicPerformance);
      System.out.println("Level: " + studentLevel);
}
   
    public void addSubmission() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding submission for: " + userName);
        
        System.out.print("Enter submission title: ");
        String submissionTitle = scanner.nextLine();
        
        System.out.print("Enter submission description: ");
        String submissionDescription = scanner.nextLine();
        
        System.out.println("Submission added successfully!");
        System.out.println("Title: " + submissionTitle);
        System.out.println("Description: " + submissionDescription);
    }

    public void removeSubmission() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Removing submission for: " + userName);
        
        System.out.print("Enter submission title to remove: ");
        String submissionTitle = scanner.nextLine();
        
        System.out.println("Submission '" + submissionTitle + "' removed successfully!");
    }
    
  
    public void setAcademicPerformance(char academicPerformance) { 
        this.academicPerformance = academicPerformance; 
    }
    
    public char getAcademicPerformance() { return academicPerformance; }
    

    public String getStudentLevel() { return studentLevel; }
    public void setStudentLevel(String studentLevel) { 
        this.studentLevel = studentLevel; 
    }
     public int getId() { return userId; }
    public String getName() { return userName; }
    @Override
    public String getEmail() { return email; }
    @Override
    public String getPassword() { return password; }
   


}