package command;
import main.Main;
import repositories.GeneralStudentRecordRepository;
import entities.StudentRecord;

public class SortRecordCommand<T extends StudentRecord> implements Command {
    private GeneralStudentRecordRepository<T> repository;
    private String recordTypeName;

    public SortRecordCommand(GeneralStudentRecordRepository<T> repository, String recordTypeName) {
        this.repository = repository;
        this.recordTypeName = recordTypeName;
    }

    @Override
    public void execute() {
        Main.clearConsole();
        System.out.println("Сортировка " + recordTypeName + " по баллам:");
        repository.sortByGrade().forEach(record ->
                System.out.println(record.getStudentName() + ": " + record.getGrade())
        );
    }
}
