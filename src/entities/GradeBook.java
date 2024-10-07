package entities;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class GradeBook extends StudentRecord {
    private Map<String, Integer> grades;

    public GradeBook(String id, String studentName, LocalDate date, int grade) {
        super(id, studentName, date, grade);
        this.grades = new HashMap<>();
    }
    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public int getAverageGrade() {
        return (int) grades.values().stream().mapToInt(Integer::intValue).average().orElse(0);
    }
}
