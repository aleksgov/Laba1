package command;

import entities.GradeBook;
import java.time.LocalDate;
import java.util.Scanner;
import main.Main;

public class CreateGradeBookCommand implements Command {
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

        GradeBook gradeBook = new GradeBook(id, name, date, grade);
        Main.getGradeBookRepo().add(gradeBook);
        System.out.println("Запись добавлена в GradeBook.");
    }
}

