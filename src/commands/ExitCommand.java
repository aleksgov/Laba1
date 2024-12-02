package commands;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Выход...");
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "Выход из приложения";
    }
}
