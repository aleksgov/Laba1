package command;

import entities.Thesis;
import main.Main;

import java.time.LocalDate;

public class CreateThesisCommand extends CreateRecordCommand<Thesis> {
    @Override
    protected Thesis createRecord(String id, String name, LocalDate date, String title, int grade) {
        return new Thesis(id, name, date, title, grade);
    }

    @Override
    protected String getAdditionalInfo() {
        System.out.print("Введите тему: ");
        return Main.getScanner().nextLine();
    }

    @Override
    protected void addRecord(Thesis record) {
        Main.getThesisRepo().add(record);
    }
}
