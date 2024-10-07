package command;
import main.Main;
import java.util.Map;

public class SortRecordMenuCommand implements Command {
    private final Map<Integer, Command> sortRecordCommands;

    public SortRecordMenuCommand(Map<Integer, Command> sortRecordCommands) {
        this.sortRecordCommands = sortRecordCommands;
    }

    @Override
    public void execute() {
        Main.clearConsole();
        System.out.println("Выберите тип записи для сортировки:");
        System.out.println("1. GradeBook");
        System.out.println("2. Thesis");
        System.out.println("3. CourseWork");
        System.out.print("Введите номер команды: ");
        int choice = Integer.parseInt(Main.getScanner().nextLine());

        Command command = sortRecordCommands.get(choice);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Неверная команда. Попробуйте снова.");
        }
    }
}
