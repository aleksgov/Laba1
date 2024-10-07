package command;

import entities.Thesis;

import java.time.LocalDate;
import java.util.Scanner;
import main.Main;

public class CreateThesisCommand implements Command {
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
        System.out.print("Введите тему: ");
        String title = scanner.nextLine();
        System.out.print("Введите оценку: ");
        int grade = Integer.parseInt(scanner.nextLine());

        Thesis thesis = new Thesis(id, name, date, title, grade);
        Main.getThesisRepo().add(thesis);
        System.out.println("Запись добавлена в Thesis.");
    }
}
