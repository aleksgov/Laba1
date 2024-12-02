package entities;

import java.time.LocalDate;

public class CourseWork extends StudentRecord {
    private String topic;

    public CourseWork(int id, String studentName, LocalDate submissionDate, int grade, String topic) {
        super(id, studentName, submissionDate, grade);
        this.topic = topic;
    }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    @Override
    public String toString() {
        return super.toString() + String.format("\nТема курсовой работы: %s", topic);
    }
}
