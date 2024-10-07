package main;

import command.*;
import repositories.GradeBookRepository;
import repositories.ThesisRepository;
import repositories.CourseWorkRepository;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static GradeBookRepository gradeBookRepo = new GradeBookRepository();
    private static ThesisRepository thesisRepo = new ThesisRepository();
    private static CourseWorkRepository courseWorkRepo = new CourseWorkRepository();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Integer, Command> mainMenuCommands = new HashMap<>();
        Map<Integer, Command> createRecordCommands = new HashMap<>();
        Map<Integer, Command> sortRecordCommands = new HashMap<>();

        // Команды для главного меню
        mainMenuCommands.put(1, new CreateRecordMenuCommand(createRecordCommands)); // Подменю создания записей
        mainMenuCommands.put(2, new SortRecordMenuCommand(sortRecordCommands));     // Подменю сортировки записей
        mainMenuCommands.put(3, new ExitCommand());

        // Команды создания записей
        createRecordCommands.put(1, new CreateGradeBookCommand());
        createRecordCommands.put(2, new CreateThesisCommand());
        createRecordCommands.put(3, new CreateCourseWorkCommand());

        // Команды сортировки записей
        sortRecordCommands.put(1, new SortGradeBookCommand());
        sortRecordCommands.put(2, new SortThesisCommand());
        sortRecordCommands.put(3, new SortCourseWorkCommand());

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
        System.out.println("3. Выйти");
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

    public static Scanner getScanner() {
        return scanner;
    }

    public static GradeBookRepository getGradeBookRepo() {
        return gradeBookRepo;
    }

    public static ThesisRepository getThesisRepo() {
        return thesisRepo;
    }

    public static CourseWorkRepository getCourseWorkRepo() {
        return courseWorkRepo;
    }
}
