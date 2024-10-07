package command;

import main.Main;
import entities.StudentRecord;

import java.util.Scanner;

public class RemoveRecordCommand<T extends StudentRecord> implements Command {
    private final Class<T> recordClass;

    public RemoveRecordCommand(Class<T> recordClass) {
        this.recordClass = recordClass;
    }

    @Override
    public void execute() {
        Main.clearConsole();
        Scanner scanner = Main.getScanner();
        System.out.print("Введите ID записи для удаления: ");
        String id = scanner.nextLine();

        T record = Main.getRepository(recordClass).findById(id);
        if (record != null) {
            Main.getRepository(recordClass).remove(record);
            System.out.println("Запись с ID " + id + " была удалена.");
        } else {
            System.out.println("Запись с ID " + id + " не найдена.");
        }
    }
}
