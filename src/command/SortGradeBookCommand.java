package command;
import main.Main;

public class SortGradeBookCommand implements Command {
    @Override
    public void execute() {
        Main.clearConsole();
        System.out.println("Сортировка ведомостей по баллам:");
        Main.getGradeBookRepo().sortByGrade().forEach(gb ->
                System.out.println(gb.getStudentName() + ": " + gb.getGrade())
        );
    }
}

