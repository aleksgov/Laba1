package command;

import command.Command;
import entities.CourseWork;
import main.Main;

import java.time.LocalDate;
import java.util.Scanner;
import main.Main;

public class CreateCourseWorkCommand implements Command {
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
        System.out.print("Введите предмет: ");
        String subject = scanner.nextLine();
        System.out.print("Введите оценку: ");
        int grade = Integer.parseInt(scanner.nextLine());

        CourseWork courseWork = new CourseWork(id, name, date, subject, grade);
        Main.getCourseWorkRepo().add(courseWork);
        System.out.println("Запись добавлена в CourseWork.");
    }
}

