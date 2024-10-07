package command;
import entities.CourseWork;
import main.Main;
import java.time.LocalDate;

public class CreateCourseWorkCommand extends CreateRecordCommand<CourseWork> {
    @Override
    protected CourseWork createRecord(String id, String name, LocalDate date, String subject, int grade) {
        return new CourseWork(id, name, date, subject, grade);
    }

    @Override
    protected String getAdditionalInfo() {
        System.out.print("Введите предмет: ");
        return Main.getScanner().nextLine();
    }

    @Override
    protected void addRecord(CourseWork record) {
        Main.getCourseWorkRepo().add(record);
    }
}
