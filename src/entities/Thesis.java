package entities;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Thesis extends StudentRecord {
    private String title;

  public Thesis(String id, String studentName, LocalDate date, String title, int grade) {
      super(id, studentName, date, grade);
      this.title = title;
      this.grade = grade;
  }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return super.getId();
    }

    public String getStudentName() {
        return super.getStudentName();
    }

    public LocalDate getDate() {
        return super.getDate();
    }

    public int getGrade() {
        return super.getGrade();
    }
}
