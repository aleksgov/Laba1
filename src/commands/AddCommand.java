package commands;

import entities.StudentRecord;
import repositories.StudentRecordRepository;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AddCommand<T extends StudentRecord> implements Command {
    private final StudentRecordRepository<T> repository;
    private final String recordType;

    public AddCommand(StudentRecordRepository<T> repository, String recordType) {
        this.repository = repository;
        this.recordType = recordType;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добавление новой записи (" + recordType + "):");

        int id = -1;
        while (true) {
            System.out.print("Введите ID: ");
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: ID должен быть целым числом. Попробуйте снова.");
            }
        }

        System.out.print("Введите имя студента: ");
        String studentName = scanner.nextLine();

        LocalDate submissionDate = null;
        while (submissionDate == null) {
            System.out.print("Введите дату сдачи (yyyy-mm-dd): ");
            try {
                submissionDate = LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Ошибка: дата должна быть в формате yyyy-mm-dd. Попробуйте снова.");
            }
        }


        int grade = -1;
        while (true) {
            System.out.print("Введите оценку: ");
            try {
                grade = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: оценка должна быть целым числом. Попробуйте снова.");
            }
        }

        if ("CourseWork".equals(recordType)) {
            System.out.print("Введите тему курсовой работы: ");
            String topic = scanner.nextLine();
            T record = (T) new entities.CourseWork(id, studentName, submissionDate, grade, topic);
            repository.add(record);
        } else if ("Thesis".equals(recordType)) {
            System.out.print("Введите название диплома: ");
            String thesisTitle = scanner.nextLine();
            T record = (T) new entities.Thesis(id, studentName, submissionDate, grade, thesisTitle);
            repository.add(record);
        } else if ("GradeBook".equals(recordType)) {
            T record = (T) new entities.GradeBook(id, studentName, submissionDate, grade);
            repository.add(record);
        } else {
            System.out.println("Неизвестный тип записи.");
            return;
        }

        System.out.println("Запись успешно добавлена.");
    }

    @Override
    public String getDescription() {
        return "Добавить новую запись (" + recordType + ")";
    }
}
