package entities;

import java.time.LocalDate;

public class GradeBook extends StudentRecord {
    public GradeBook(String id, String studentName, LocalDate date, int grade) {
        super(id, studentName, date, grade);
    }
}