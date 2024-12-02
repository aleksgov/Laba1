package entities;

import java.time.LocalDate;

public class Thesis extends StudentRecord {
    private String thesisTitle;

    public Thesis(int id, String studentName, LocalDate submissionDate, int grade, String thesisTitle) {
        super(id, studentName, submissionDate, grade);
        this.thesisTitle = thesisTitle;
    }

    public String getThesisTitle() { return thesisTitle; }
    public void setThesisTitle(String thesisTitle) { this.thesisTitle = thesisTitle; }

    @Override
    public String toString() {
        return super.toString() + String.format("\nНазвание диплома: %s", thesisTitle);
    }
}
