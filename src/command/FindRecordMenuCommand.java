package command;
import main.Main;
import java.util.Map;

public class FindRecordMenuCommand implements Command {
    private final Map<Integer, Command> commands;

    public FindRecordMenuCommand(Map<Integer, Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        System.out.println("Выберите тип записи для поиска:");
        System.out.println("1. Ведомость");
        System.out.println("2. Дипломная работа");
        System.out.println("3. Курсовая работа");
        System.out.print("Введите номер команды: ");

        int choice = Integer.parseInt(Main.getScanner().nextLine());

        Command command = commands.get(choice);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Неверный выбор.");
        }
    }
}

