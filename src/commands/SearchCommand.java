package commands;

import entities.StudentRecord;
import repositories.SearchableStudentRecordRepository;

import java.util.Scanner;

public class SearchCommand<T extends StudentRecord> implements Command {
    private final SearchableStudentRecordRepository<T> repository;

    public SearchCommand(SearchableStudentRecordRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ключевое слово для поиска по имени студента: ");
        String keyword = scanner.nextLine();
        /*
        repository.searchByTitle(keyword).forEach(record -> {
            System.out.println(record);
        });
         */
        repository.searchByTitle(keyword).stream()
                .forEach(record -> System.out.println(record));
    }

    @Override
    public String getDescription() {
        return "Поиск записей по ключевому слову (имя студента)";
    }
}
