package command;
import main.Main;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Выход из программы...");
        System.exit(0);
    }
}
