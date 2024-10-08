package entities;

import java.time.LocalDate;

public class CourseWork extends StudentRecord {
    private String subject;

    public CourseWork(String id, String studentName, LocalDate date, String subject, int grade) {
        super(id, studentName, date, grade);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "CourseWork {" +
                "ID='" + id + '\'' +
                ", Student Name='" + studentName + '\'' +
                ", Date=" + date +
                ", Subject='" + subject + '\'' +
                ", Grade=" + grade +
                '}';
    }
}