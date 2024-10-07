package command;

import java.util.Map;
import main.Main;

public class CreateRecordMenuCommand implements Command {
    private final Map<Integer, Command> createRecordCommands;

    public CreateRecordMenuCommand(Map<Integer, Command> createRecordCommands) {
        this.createRecordCommands = createRecordCommands;
    }

    @Override
    public void execute() {
        Main.clearConsole();
        System.out.println("Выберите тип записи для создания:");
        System.out.println("1. GradeBook");
        System.out.println("2. Thesis");
        System.out.println("3. CourseWork");
        System.out.print("Введите номер команды: ");

        int choice = Integer.parseInt(Main.getScanner().nextLine());

        Command command = createRecordCommands.get(choice);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Неверная команда. Попробуйте снова.");
        }
    }
}
