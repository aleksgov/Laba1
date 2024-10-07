package command;

import main.Main;

import java.util.Map;

public class UpdateRecordMenuCommand implements Command {
    private final Map<Integer, Command> commands;

    public UpdateRecordMenuCommand(Map<Integer, Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        System.out.println("Выберите тип записи для обновления:");
        System.out.println("1. Обновить ведомость");
        System.out.println("2. Обновить дипломную работу");
        System.out.println("3. Обновить курсовую работу");
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
