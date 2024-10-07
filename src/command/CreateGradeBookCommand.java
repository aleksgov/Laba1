package command;

import entities.GradeBook;
import main.Main;

import java.time.LocalDate;

public class CreateGradeBookCommand extends CreateRecordCommand<GradeBook> {
    @Override
    protected GradeBook createRecord(String id, String name, LocalDate date, String additionalInfo, int grade) {
        return new GradeBook(id, name, date, grade);
    }

    @Override
    protected String getAdditionalInfo() {
        return "";
    }

    @Override
    protected void addRecord(GradeBook record) {
        Main.getGradeBookRepo().add(record);
    }
}
