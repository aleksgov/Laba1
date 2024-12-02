package entities;

import java.time.LocalDate;

public abstract class StudentRecord {
    private int id;
    private String studentName;
    private LocalDate date;
    private int grade;

    public StudentRecord(int id, String studentName, LocalDate date, int grade) {
        this.id = id;
        this.studentName = studentName;
        this.date = date;
        this.grade = grade;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }
    public String getType() { return this.getClass().getSimpleName(); }

    @Override
    public String toString() {
        return String.format("ID: %d\nСтудент: %s\nДата: %s\nОценка: %d",
                id, studentName, date, grade);
    }

}
