import commands.*;
import entities.*;
import repositories.*;

import java.util.*;
import java.util.InputMismatchException;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Map<String, SearchableStudentRecordRepository<? extends StudentRecord>> repositories = new HashMap<>();
        repositories.put("CourseWork", new CourseWorkRepository());
        repositories.put("GradeBook", new GradeBookRepository());
        repositories.put("Thesis", new ThesisRepository());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите тип контента:");
            List<String> recordTypes = new ArrayList<>(repositories.keySet());
            /*
            for (int i = 0; i < recordTypes.size(); i++) {
                System.out.println((i + 1) + ". " + recordTypes.get(i));
            }
            */
            IntStream.range(0, recordTypes.size())
                    .forEach(i -> System.out.println((i + 1) + ". " + recordTypes.get(i)));

            System.out.println((recordTypes.size() + 1) + ". Выход");

            System.out.print("\nВведите номер: ");
            int typeChoice;

            try {
                typeChoice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено не число. Попробуйте снова.");
                scanner.nextLine();
                continue;
            }

            if (typeChoice < 1 || typeChoice > recordTypes.size() + 1) {
                System.out.println("Некорректный выбор. Попробуйте снова.");
                continue;
            }

            if (typeChoice == recordTypes.size() + 1) {
                System.out.println("Завершение работы...");
                System.exit(0);
            }

            String selectedType = recordTypes.get(typeChoice - 1);
            SearchableStudentRecordRepository<? extends StudentRecord> repository = repositories.get(selectedType);

            List<Command> commands = createCommands(repository, selectedType);
            runCommands(commands);
        }
    }

    private static <T extends StudentRecord> List<Command> createCommands(SearchableStudentRecordRepository<T> repository, String recordType) {
        return List.of(
                new AddCommand<>(repository, recordType),
                new DeleteCommand<>(repository),
                new UpdateCommand<>(repository),
                new SearchCommand<>(repository),
                new SortCommand<>(repository, "date"),
                new SortCommand<>(repository, "grade"),
                new ExitCommand()
        );
    }

    private static void runCommands(List<Command> commands) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nДоступные команды:");

            /*
            for (int i = 0; i < commands.size(); i++) {
                System.out.println((i + 1) + ". " + commands.get(i).getDescription());
            }
            */

            IntStream.range(0, commands.size())
                    .forEach(i -> System.out.println((i + 1) + ". " + commands.get(i).getDescription()));

            System.out.print("\nВведите номер команды: ");
            int choice;

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено не число. Попробуйте снова.");
                scanner.nextLine();
                continue;
            }

            if (choice < 1 || choice > commands.size()) {
                System.out.println("Некорректный выбор. Попробуйте снова.");
                continue;
            }

            commands.get(choice - 1).execute();
        }
    }
}
