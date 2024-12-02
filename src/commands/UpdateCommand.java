package commands;

import entities.StudentRecord;
import repositories.StudentRecordRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class UpdateCommand<T extends StudentRecord> implements Command {
    private final StudentRecordRepository<T> repository;

    public UpdateCommand(StudentRecordRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ID записи для обновления: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        T record = repository.findById(id);
        if (record == null) {
            System.out.println("Запись не найдена.");
            return;
        }

        System.out.print("Введите новое имя студента: ");
        record.setStudentName(scanner.nextLine());
        System.out.print("Введите новую дату сдачи (yyyy-mm-dd): ");
        record.setDate(LocalDate.parse(scanner.nextLine()));
        System.out.print("Введите новую оценку: ");
        record.setGrade(scanner.nextInt());
        scanner.nextLine();

        if (record instanceof entities.CourseWork) {
            System.out.print("Введите новую тему курсовой работы: ");
            ((entities.CourseWork) record).setTopic(scanner.nextLine());
        } else if (record instanceof entities.Thesis) {
            System.out.print("Введите новое название диплома: ");
            ((entities.Thesis) record).setThesisTitle(scanner.nextLine());
        }

        repository.update(record);
        System.out.println("Запись успешно обновлена.");
    }

    @Override
    public String getDescription() {
        return "Обновить запись по ID";
    }
}
