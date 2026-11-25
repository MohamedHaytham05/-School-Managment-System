package school.management.system;
import java.util.ArrayList;
import java.util.Scanner;
    public class SchoolManagmentSystem {
    public static Admin admin;
    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Teacher> teachers = new ArrayList<>();
    public static ArrayList<Module> modules = new ArrayList<>();
    public static NoticeBoard noticeBoard;
private static int nextId = 1;



    public static void Data() {
        admin = new Admin(1, "System Admin", "admin@bue.com", "1234", "Head Administrator");

        students.add(new Student(246842, "Ahmed Saied", "Ace@bue.com", "1234", 'A', "Freshman", "student"));
        students.add(new Student(246578, "Lila Ahmed", "lila@bue.com", "4567", 'B', "Sophomore", "student"));

        teachers.add(new Teacher(202, "Dr. Aya Nourelden", "aia@bue.com", "1234", "Professor"));
        teachers.add(new Teacher(201, "Dr. Mostafa Ali", "james@bue.com", "4567", "Associate Professor"));

        modules.add(new Module("MATH101", "Calculus", 30, admin));
        modules.add(new Module("PHYS101", "Physics", 25, admin));
        modules.add(new Module("CHEM101", "Chemistry", 20, admin));
        modules.add(new Module("BIO101", "Biology", 25, admin));

        noticeBoard = new NoticeBoard(admin);
        noticeBoard.addAnnouncement("Welcome to the new academic year!");
        noticeBoard.addAnnouncement("Registration deadline: September 15");

        teachers.get(0).assignModule(modules.get(0));
        teachers.get(1).assignModule(modules.get(1));
        
        javax.swing.SwingUtilities.invokeLater(() -> {
        //Login loginFrame = new Login();
        //loginFrame.setVisible(true);
        //loginFrame.setLocationRelativeTo(null); // Center on screen
        Home frm = new Home();
        frm.setVisible(true);
    });
    }
public static int generateUniqueId() {
    return nextId++;
}
    public static void main(String[] args) {
        Data();  // Load shared data

        Scanner scanner = new Scanner(System.in);
        boolean systemRunning = true;

        while (systemRunning) {
            System.out.println("\n*** School Management System ***");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Select option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> loginMenu(scanner, admin, students, teachers, modules, noticeBoard);
                case 2 -> signupMenu(scanner, students, teachers);
                case 3 -> {
                    systemRunning = false;
                    System.out.println("Exiting system. Goodbye!");
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }


    private static void loginMenu(Scanner scanner, Admin admin, 
                                ArrayList<Student> students, 
                                ArrayList<Teacher> teachers,
                                ArrayList<Module> modules,
                                NoticeBoard noticeBoard) {
        System.out.println("\n*** Login ***");
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (admin.login(email, password)) {
            adminMenu(scanner, admin, students, teachers, modules, noticeBoard);
            return;
        }
        for (Teacher teacher : teachers) {
            if (teacher.login(email, password)) {
                teacherMenu(scanner, teacher, modules);
                return;
            }
        }
        for (Student student : students) {
            if (student.login(email, password)) {
                studentMenu(scanner, student, modules);
                return;
            }
        }

        System.out.println("Login failed. Invalid credentials.");
    }
    private static void signupMenu(Scanner scanner, ArrayList<Student> students, ArrayList<Teacher> teachers) {
        System.out.println("\n=== Sign Up ===");
        System.out.println("1. Sign up as Student");
        System.out.println("2. Sign up as Teacher");
        System.out.print("Select option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1 -> signUpStudent(scanner, students);
            case 2 -> signUpTeacher(scanner, teachers);
            default -> System.out.println("Invalid option. Please try again.");
        }
    }
    private static void signUpStudent(Scanner scanner, ArrayList<Student> students) {
        System.out.println("\n ***Student Registration***");
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        System.out.print("Enter student level : ");
        char grade = scanner.nextLine().charAt(0);
        
        System.out.print("Enter Year (Freshman/Sophomore/Junior/Senior): ");
        String year = scanner.nextLine();
        
        System.out.print("Enter Role: ");
        String role = scanner.nextLine();
        
        Student newStudent = new Student(id, name, email, password, grade, year, role);
        students.add(newStudent);
        System.out.println("Student registration successful!");
    }
    private static void signUpTeacher(Scanner scanner, ArrayList<Teacher> teachers) {
        System.out.println("\n*** Teacher Registration ***");
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        System.out.print("Enter Position: ");
        String position = scanner.nextLine();
        
        Teacher newTeacher = new Teacher(id, name, email, password, position);
        teachers.add(newTeacher);
        System.out.println("Teacher registration successful!");
    }
    private static void adminMenu(Scanner scanner, Admin admin, 
                                ArrayList<Student> students,
                                ArrayList<Teacher> teachers,
                                ArrayList<Module> modules,
                                NoticeBoard noticeBoard) {
        boolean loggedIn = true; 
        while (loggedIn) {
            System.out.println("\n*** Admin Dashboard ***");
            System.out.println("1. View Admin Info");
            System.out.println("2. Manage Modules");
            System.out.println("3. Manage Notice Board");
            System.out.println("4. Logout");
            System.out.print("Select option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> admin.displayAdminInfo();
                case 2 -> manageModulesMenu(scanner, admin, modules, teachers);
                case 3 -> manageNoticeBoard(scanner, noticeBoard);
                case 4 -> {
                    admin.logout();
                    loggedIn = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void teacherMenu(Scanner scanner, Teacher teacher, 
                                  ArrayList<Module> modules) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n*** Teacher Dashboard ***");
            System.out.println("1. View Teacher Info");
            System.out.println("2. View Assigned Modules");
            System.out.println("3. Update Student Grade");
             System.out.println("4. Manage Account");
            System.out.println("5. Logout");
            System.out.print("Select option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> teacher.displayTeacherInfo();
                case 2 -> {
                    System.out.println("\n*** Assigned Modules ***");
                    for (Module module : teacher.getAssignedModules()) {
                        module.displayModuleDetails();
                        System.out.println("-------------------");
                    }
                }
                case 3 -> {
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter new grade: ");
                    int grade = scanner.nextInt();
                    scanner.nextLine();
                    teacher.updateGrade(studentName, grade);
                }
                case 4 -> teacher.manageAccount(scanner);
                case 5 -> {
                    teacher.logout();
                    loggedIn = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void studentMenu(Scanner scanner, Student student, 
                                 ArrayList<Module> modules) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n*** Student Dashboard ***");
            System.out.println("1. View Student Info");
            System.out.println("2. View Available Modules");
            System.out.println("3. Enroll in Module");
            System.out.println("4. Manage Account");
            System.out.println("5. Logout");
            System.out.print("Select option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> student.studentDetails();
                case 2 -> {
                    System.out.println("\n*** Available Modules ***");
                    for (Module module : modules) {
                        if (!module.isFull()) {
                            module.displayModuleDetails();
                            System.out.println("-------------------");
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Available Modules:");
                    for (int i = 0; i < modules.size(); i++) {
                        if (!modules.get(i).isFull()) {
                            System.out.println((i+1) + ". " + modules.get(i).getModuleName());
                        }
                    }
                    System.out.print("Select module to enroll: ");
                    int moduleIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    
                    if (moduleIndex >= 0 && moduleIndex < modules.size()) {
                        modules.get(moduleIndex).enrollStudent(student);
                    } else {
                        System.out.println("Invalid selection.");
                    }
                }
                case 4 -> student.manageAccount(scanner);
            
                  case 5 -> {
                    student.logout();
                    loggedIn = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void manageModulesMenu(Scanner scanner, Admin admin, 
                                       ArrayList<Module> modules,
                                       ArrayList<Teacher> teachers) {
        boolean managingModules = true;
        while (managingModules) {
            System.out.println("\n*** Module Management ***");
            System.out.println("1. List All Modules");
            System.out.println("2. Add New Module");
            System.out.println("3. Assign Teacher to Module");
            System.out.println("4. Back to Menu");
            System.out.print("Select option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> {
                    System.out.println("\n*** All Modules ***");
                    for (Module module : modules) {
                        module.displayModuleDetails();
                        System.out.println("-------------------");
                    }
                }
                case 2 -> {
                    System.out.print("Enter Module ID: ");
                    String moduleId = scanner.nextLine();
                    System.out.print("Enter Module Name: ");
                    String moduleName = scanner.nextLine();
                    System.out.print("Enter Max Capacity: ");
                    int capacity = scanner.nextInt();
                    scanner.nextLine();
                    
                    Module newModule = new Module(moduleId, moduleName, capacity, admin);
                    modules.add(newModule);
                    System.out.println("Module added successfully!");
                }
                case 3 -> {
                    System.out.println("Available Teachers:");
                    for (int i = 0; i < teachers.size(); i++) {
                        System.out.println((i+1) + ". " + teachers.get(i).getUserName());
                    }
                    System.out.print("Select teacher: ");
                    int teacherIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    
                    System.out.println("Available Modules:");
                    for (int i = 0; i < modules.size(); i++) {
                        System.out.println((i+1) + ". " + modules.get(i).getModuleName());
                    }
                    System.out.print("Select module: ");
                    int moduleIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    
                    if (teacherIndex >= 0 && teacherIndex < teachers.size() &&
                            moduleIndex >= 0 && moduleIndex < modules.size()) {
                        teachers.get(teacherIndex).assignModule(modules.get(moduleIndex));
                        modules.get(moduleIndex).setAssignedTeacher(teachers.get(teacherIndex));
                    } else {
                        System.out.println("Invalid selection.");
                    }
                }
                case 4 -> managingModules = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void manageNoticeBoard(Scanner scanner, NoticeBoard noticeBoard) {
        boolean managingNoticeBoard = true;
        while (managingNoticeBoard) {
            System.out.println("\n*** Notice Board Management ***");
            noticeBoard.displayAnnouncements();
            System.out.println("1. Add Announcement");
            System.out.println("2. Remove Announcement");
            System.out.println("3. Back to Menu");
            System.out.print("Select option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> noticeBoard.adminAddAnnouncement();
                case 2 -> {
                    System.out.print("Enter announcement number to remove: ");
                    int index = scanner.nextInt() - 1;
                    scanner.nextLine();
                    noticeBoard.removeAnnouncement(index);
                }
                case 3 -> managingNoticeBoard = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }   
    }