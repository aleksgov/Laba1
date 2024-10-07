package command;

import main.Main;

import java.util.Map;

public class RemoveRecordMenuCommand implements Command {
    private final Map<Integer, Command> removeRecordCommands;

    public RemoveRecordMenuCommand(Map<Integer, Command> removeRecordCommands) {
        this.removeRecordCommands = removeRecordCommands;
    }

    @Override
    public void execute() {
        Main.clearConsole();
        System.out.println("Выберите тип записи для удаления:");
        System.out.println("1. GradeBook");
        System.out.println("2. Thesis");
        System.out.println("3. CourseWork");
        System.out.print("Введите номер команды: ");
        int choice = Integer.parseInt(Main.getScanner().nextLine());

        Command command = removeRecordCommands.get(choice);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Неверная команда. Попробуйте снова.");
        }
    }
}
