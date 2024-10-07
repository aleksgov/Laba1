package main;

import command.*;
import entities.CourseWork;
import entities.GradeBook;
import entities.StudentRecord;
import entities.Thesis;
import repositories.GeneralStudentRecordRepository;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static GeneralStudentRecordRepository<GradeBook> gradeBookRepo = new GeneralStudentRecordRepository<>(GradeBook.class);
    private static GeneralStudentRecordRepository<Thesis> thesisRepo = new GeneralStudentRecordRepository<>(Thesis.class);
    private static GeneralStudentRecordRepository<CourseWork> courseWorkRepo = new GeneralStudentRecordRepository<>(CourseWork.class);

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Integer, Command> mainMenuCommands = new HashMap<>();
        Map<Integer, Command> createRecordCommands = new HashMap<>();
        Map<Integer, Command> sortRecordCommands = new HashMap<>();
        Map<Integer, Command> removeRecordCommands = new HashMap<>();
        Map<Integer, Command> updateRecordCommands = new HashMap<>();

        // Команды для главного меню
        mainMenuCommands.put(1, new CreateRecordMenuCommand(createRecordCommands)); // Подменю создания записей
        mainMenuCommands.put(2, new SortRecordMenuCommand(sortRecordCommands));     // Подменю сортировки записей
        mainMenuCommands.put(3, new RemoveRecordMenuCommand(removeRecordCommands)); // Подменю удаления записей
        mainMenuCommands.put(4, new UpdateRecordMenuCommand(updateRecordCommands)); // Подменю обновления записей
        mainMenuCommands.put(5, new ExitCommand());

        // Команды создания записей
        createRecordCommands.put(1, new CreateGradeBookCommand());
        createRecordCommands.put(2, new CreateThesisCommand());
        createRecordCommands.put(3, new CreateCourseWorkCommand());

        // Команды удаления записей
        removeRecordCommands.put(1, new RemoveRecordCommand<>(GradeBook.class));
        removeRecordCommands.put(2, new RemoveRecordCommand<>(Thesis.class));
        removeRecordCommands.put(3, new RemoveRecordCommand<>(CourseWork.class));

        // Команды обновления записей
        updateRecordCommands.put(1, new UpdateRecordCommand<>(GradeBook.class));
        updateRecordCommands.put(2, new UpdateRecordCommand<>(Thesis.class));
        updateRecordCommands.put(3, new UpdateRecordCommand<>(CourseWork.class));

        // Команды сортировки записей
        sortRecordCommands.put(1, new SortRecordCommand<>(getGradeBookRepo(), "ведомостей"));
        sortRecordCommands.put(2, new SortRecordCommand<>(getThesisRepo(), "дипломных работ"));
        sortRecordCommands.put(3, new SortRecordCommand<>(getCourseWorkRepo(), "курсовых работ"));

        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            Command command = mainMenuCommands.get(choice);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Неверная команда. Попробуйте снова.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Создать запись");
        System.out.println("2. Сортировать записи");
        System.out.println("3. Удалить запись");
        System.out.println("4. Обновить запись");
        System.out.println("5. Выйти");

        System.out.print("Введите номер команды: ");
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static GeneralStudentRecordRepository<GradeBook> getGradeBookRepo() {
        return gradeBookRepo;
    }

    public static GeneralStudentRecordRepository<Thesis> getThesisRepo() {
        return thesisRepo;
    }

    public static GeneralStudentRecordRepository<CourseWork> getCourseWorkRepo() {
        return courseWorkRepo;
    }

    public static <T extends StudentRecord> GeneralStudentRecordRepository<T> getRepository(Class<T> clazz) {
        if (clazz == GradeBook.class) {
            return (GeneralStudentRecordRepository<T>) gradeBookRepo;
        } else if (clazz == Thesis.class) {
            return (GeneralStudentRecordRepository<T>) thesisRepo;
        } else if (clazz == CourseWork.class) {
            return (GeneralStudentRecordRepository<T>) courseWorkRepo;
        }
        return null; // Возвращает null, если тип записи не найден
    }

    public static Scanner getScanner() {
        return scanner;
    }

}
