package entities;

import java.time.LocalDate;

public abstract class StudentRecord {
    protected String id;
    protected String studentName;
    protected LocalDate date;
    protected int grade;

    public StudentRecord(String id, String studentName, LocalDate date, int grade) {
        this.id = id;
        this.studentName = studentName;
        this.date = date;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}