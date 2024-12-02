package commands;

import entities.StudentRecord;
import repositories.StudentRecordRepository;

import java.util.Scanner;

public class DeleteCommand<T extends StudentRecord> implements Command {
    private final StudentRecordRepository<T> repository;

    public DeleteCommand(StudentRecordRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ID записи для удаления: ");
        int id = scanner.nextInt();

        T record = repository.findById(id);
        if (record != null) {
            repository.delete(record);
            System.out.println("Запись успешно удалена.");
        } else {
            System.out.println("Запись не найдена.");
        }
    }

    @Override
    public String getDescription() {
        return "Удалить запись по ID";
    }
}
