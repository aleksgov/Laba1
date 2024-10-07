package command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import main.Main;

public class DisplayRecordsCommand implements Command {
    private Map<String, Command> subCommands = new HashMap<>();

    public DisplayRecordsCommand() {
        subCommands.put("1", new DisplayThesisCommand());
        //subCommands.put("2", new DisplayCourseWorkCommand());
        //subCommands.put("3", new DisplayGradeBookCommand());
    }

    @Override
    public void execute() {
        Main.clearConsole();
        System.out.println("Выберите тип записи для отображения:");
        System.out.println("1. Дипломные работы (Thesis)");
        System.out.println("2. Курсовые работы (CourseWork)");
        System.out.println("3. Ведомости (GradeBook)");

        Scanner scanner = Main.getScanner();
        String choice = scanner.nextLine();

        Command command = subCommands.get(choice);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Неверный выбор. Попробуйте снова.");
        }
    }
}
