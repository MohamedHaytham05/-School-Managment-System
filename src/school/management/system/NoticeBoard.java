package school.management.system;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoticeBoard {
    private List<String> announcements;
    private Admin adminInCharge;

    public NoticeBoard(Admin admin) {
        this.announcements = new ArrayList<>();
        this.adminInCharge = admin;
    }

    
    public void displayAnnouncements() {
        if (announcements.isEmpty()) {
            System.out.println("No announcements available.");
        } else {
            System.out.println("=== Current Announcements ===");
            for (int i = 0; i < announcements.size(); i++) {
                System.out.println((i+1) + ". " + announcements.get(i));
            }
        }
        
    }

    public void addAnnouncement(String announcement) {
        if (announcement != null && !announcement.isEmpty()) {
            announcements.add(announcement);
            System.out.println("Announcement added successfully.");
        } else {
            System.out.println("Cannot add empty announcement.");
        }
    }

    public void removeAnnouncement(int index) {
        if (index >= 0 && index < announcements.size()) {
            announcements.remove(index);
            System.out.println("Announcement removed successfully.");
        } else {
            System.out.println("Invalid announcement number.");
        }
    }

    public void adminAddAnnouncement() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new announcement: ");
        String announcement = scanner.nextLine();
        addAnnouncement(announcement);
    }
   
    public List<String> getAnnouncements() { return announcements; }
    public Admin getAdminInCharge() { return adminInCharge; }
}