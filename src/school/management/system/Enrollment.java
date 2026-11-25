package school.management.system;

import java.util.Date;

public class Enrollment {
    private int enrollmentId;
    private Date enrollmentDate;
    private Student student;
    private Module module;
    private String status;

    public Enrollment(int enrollmentId, Module module) {
        this.enrollmentId = enrollmentId;
        this.enrollmentDate = new Date();
        this.module = module;
        this.status = "Active";
    }

    public void displayEnrollmentDetails() {
        System.out.println("Enrollment ID: " + enrollmentId);
        System.out.println("Date: " + enrollmentDate);
        System.out.println("Student: " + student.getUserName());
        System.out.println("Module: " + module.getModuleName());
        System.out.println("Status: " + status);
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("Enrollment status updated to: " + newStatus);
    }

    public void cancelEnrollment() {
        this.status = "Cancelled";
        System.out.println("Enrollment cancelled for " + student.getUserName() + 
                          " in " + module.getModuleName());
    }

    public int getEnrollmentId() { return enrollmentId; }
    public Date getEnrollmentDate() { return enrollmentDate; }
    public Student getStudent() { return student; }
    public Module getModule() { return module; }
    public String getStatus() { return status; }

    public void setEnrollmentId(int enrollmentId) { this.enrollmentId = enrollmentId; }
    public void setStudent(Student student) { this.student = student; }
    public void setModule(Module module) { this.module = module; }
}