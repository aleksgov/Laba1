package command;

import main.Main;
import entities.StudentRecord;

import java.util.Scanner;

public class UpdateRecordCommand<T extends StudentRecord> implements Command {
    private final Class<T> recordClass;

    public UpdateRecordCommand(Class<T> recordClass) {
        this.recordClass = recordClass;
    }

    @Override
    public void execute() {
        Main.clearConsole();
        Scanner scanner = Main.getScanner();
        System.out.print("Введите ID записи для обновления: ");
        String id = scanner.nextLine();

        T record = Main.getRepository(recordClass).findById(id);
        if (record != null) {
            System.out.println("Текущие данные записи:");
            System.out.println(record);

            System.out.print("Введите новую оценку: ");
            int newGrade = Integer.parseInt(scanner.nextLine());
            record.setGrade(newGrade);

            Main.getRepository(recordClass).update(record);
            System.out.println("Запись с ID " + id + " была обновлена.");
        } else {
            System.out.println("Запись с ID " + id + " не найдена.");
        }
    }
}
