package command;
import main.Main;

public class SortCourseWorkCommand implements Command {
    @Override
    public void execute() {
        Main.clearConsole();
        System.out.println("Сортировка курсовых работ по баллам:");
        Main.getCourseWorkRepo().sortByGrade().forEach(courseWork ->
                System.out.println(courseWork.getStudentName() + ": " + courseWork.getGrade())
        );
    }
}
