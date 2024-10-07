package entities;

import java.time.LocalDate;

public class Thesis extends StudentRecord {
    private String title;

    public Thesis(String id, String studentName, LocalDate date, String title, int grade) {
        super(id, studentName, date, grade);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}