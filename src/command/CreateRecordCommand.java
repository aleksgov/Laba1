package command;

import main.Main;
import java.time.LocalDate;
import java.util.Scanner;

public abstract class CreateRecordCommand<T> implements Command {
    protected abstract T createRecord(String id, String name, LocalDate date, String additionalInfo, int grade);

    @Override
    public void execute() {
        Main.clearConsole();
        Scanner scanner = Main.getScanner();

        System.out.print("Введите ID: ");
        String id = scanner.nextLine();
        System.out.print("Введите имя студента: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату (ГГГГ-ММ-ДД): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.print("Введите оценку: ");
        int grade = Integer.parseInt(scanner.nextLine());

        String additionalInfo = getAdditionalInfo();

        T record = createRecord(id, name, date, additionalInfo, grade);
        addRecord(record);
        System.out.println("Запись добавлена.");
    }

    protected abstract String getAdditionalInfo();

    protected abstract void addRecord(T record);
}
