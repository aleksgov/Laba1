package entities;

import java.time.LocalDate;

public class GradeBook extends StudentRecord {
    public GradeBook(String id, String studentName, LocalDate date, int grade) {
        super(id, studentName, date, grade);
    }
    @Override
    public String toString() {
        return "GradeBook {" +
                "ID='" + id + '\'' +
                ", Student Name='" + studentName + '\'' +
                ", Date=" + date +
                ", Grade=" + grade +
                '}';
    }
}