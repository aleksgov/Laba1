package command;
import main.Main;
public class SortThesisCommand implements Command {
    @Override
    public void execute() {
        Main.clearConsole();
        System.out.println("Сортировка дипломных работ по баллам:");
        Main.getThesisRepo().sortByGrade().forEach(thesis ->
                System.out.println(thesis.getStudentName() + ": " + thesis.getGrade())
        );
    }
}
