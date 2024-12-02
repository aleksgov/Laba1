package entities;

import java.time.LocalDate;

public class GradeBook extends StudentRecord {
    public GradeBook(int id, String studentName, LocalDate submissionDate, int grade) {
        super(id, studentName, submissionDate, grade);
    }
}
