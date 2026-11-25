package school.management.system;
import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private String adminRole;
    private int adminAccessLevel;
    private List<Module> managedModules;

    public Admin(int userId, String userName, String email, String password, String adminRole) {
        super(userId, userName, email, password, "admin");
        this.adminRole = adminRole;
        this.adminAccessLevel = 1; 
        this.managedModules = new ArrayList<>();
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }
    public void displayAdminInfo() {
        displayUserInfo();
        System.out.println("Admin Role: " + adminRole);
        System.out.println("Access Level: " + adminAccessLevel);
    }

    public void addModule(Module module) {
        if (module != null) {
            managedModules.add(module);
            System.out.println("Module " + module.getModuleName() + " added successfully.");
        } else {
            System.out.println("Invalid module.");
        }
    }

  

    public String getAdminRole() { return adminRole; }
    public void setAdminRole(String adminRole) { this.adminRole = adminRole; }

    public int getAdminAccessLevel() { return adminAccessLevel; }
    public void setAdminAccessLevel(int adminAccessLevel) { 
        this.adminAccessLevel = adminAccessLevel; 
    }

    public List<Module> getManagedModules() { return managedModules; }
    
}
