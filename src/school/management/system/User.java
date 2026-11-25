package school.management.system;
import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected int userId;
    protected String userName;
    protected String email;
    protected String password;
    protected String role;
    private static List<User> userList = new ArrayList<>();

    public User(int userId, String userName, String email, String password, String role) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        userList.add(this);
    }

    public int getUserId() { return userId; }
    public String getUserName() { return userName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    public void setUserId(int userId) { this.userId = userId; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }

    public boolean login(String inputEmail, String inputPassword) {
        if (this.email.equals(inputEmail) && this.password.equals(inputPassword)) {
            System.out.println(userName + " logged in successfully.");
            return true;
        }
        System.out.println("Login failed for ");
        return false;
    }

    public void logout() {
        System.out.println(userName + " logged out.");
    }

    public void displayUserInfo() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + userName);
        System.out.println("Email: " + email);
        System.out.println("Role: " + role);
    }
   
    public String String() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' + '}';
    }
}