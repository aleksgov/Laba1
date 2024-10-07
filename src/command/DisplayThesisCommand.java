package command;
import entities.Thesis;
import main.Main;
import repositories.ThesisRepository;

public class DisplayThesisCommand implements Command {
    @Override
    public void execute() {
        Main.clearConsole();
        System.out.println("Все данные о дипломных работах:");

        // Предполагая, что вы получаете доступ к репозиторию дипломных работ
        ThesisRepository thesisRepo = Main.getThesisRepo();

        // Вывод всех дипломных работ с использованием геттеров
        for (Thesis thesis : thesisRepo.findAll()) { // Здесь используйте метод для получения всех дипломных работ
            System.out.println("ID: " + thesis.getId());
            System.out.println("Студент: " + thesis.getStudentName());
            System.out.println("Дата: " + thesis.getDate());
            System.out.println("Тема: " + thesis.getTitle());
            System.out.println("Оценка: " + thesis.getGrade());
            System.out.println("---------------------------");
        }
    }
}


