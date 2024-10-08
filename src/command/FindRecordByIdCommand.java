package command;
import entities.StudentRecord;
import main.Main;
import repositories.GeneralStudentRecordRepository;
import java.util.Scanner;

public class FindRecordByIdCommand<T extends StudentRecord> implements Command {
    private final GeneralStudentRecordRepository<T> repository;
    private final String recordTypeName;

    public FindRecordByIdCommand(GeneralStudentRecordRepository<T> repository, String recordTypeName) {
        this.repository = repository;
        this.recordTypeName = recordTypeName;
    }

    @Override
    public void execute() {
        Scanner scanner = Main.getScanner();

        System.out.print("Введите ID для поиска " + recordTypeName + ": ");
        String id = scanner.nextLine();

        T record = repository.findById(id);
        if (record != null) {
            System.out.println("Запись найдена: " + record);
        } else {
            System.out.println(recordTypeName + " с ID " + id + " не найдена.");
        }
    }
}
