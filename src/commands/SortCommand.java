package commands;

import entities.StudentRecord;
import repositories.SearchableStudentRecordRepository;

import java.util.List;

public class SortCommand<T extends StudentRecord> implements Command {
    private final SearchableStudentRecordRepository<T> repository;
    private final String criterion;

    public SortCommand(SearchableStudentRecordRepository<T> repository, String criterion) {
        this.repository = repository;
        this.criterion = criterion;
    }

    @Override
    public void execute() {
        List<T> sortedRecords;

        if ("date".equals(criterion)) {
            sortedRecords = repository.sortByDate();
            System.out.println("\nЗаписи, отсортированные по дате:");
            sortedRecords.forEach(record ->
                    System.out.printf("- %s (Дата: %s)%n", record.getStudentName(), record.getDate())
            );
        } else if ("grade".equals(criterion)) {
            sortedRecords = repository.sortByGrade();
            System.out.println("\nЗаписи, отсортированные по оценке:");
            sortedRecords.forEach(record ->
                    System.out.printf("- %s (Оценка: %d)%n", record.getStudentName(), record.getGrade())
            );
        } else {
            System.out.println("Некорректный критерий сортировки.");
        }
    }

    @Override
    public String getDescription() {
        return "Сортировать записи по " + ("date".equals(criterion) ? "дате" : "оценке");
    }
}
