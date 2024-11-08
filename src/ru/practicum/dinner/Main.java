package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine().trim();

            switch (command) {
                case "1":
                    addNewDish(dc);
                    break;
                case "2":
                    generateDishCombo(dc);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Команда не распознана!");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish(DinnerConstructor dinnerConstructor) {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine().trim();
        if (dishType.isEmpty()) {
            System.out.println("Введен пустой тип блюда!");
            return;
        }

        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine().trim();
        if (dishName.isEmpty()) {
            System.out.println("Введено пустое название блюда!");
            return;
        }

        dinnerConstructor.addNewDish(dishType, dishName);
    }

    private static void generateDishCombo(DinnerConstructor dinnerConstructor) {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = -1;
        if (scanner.hasNextInt()) {
            numberOfCombos = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Количество наборов должно быть целым положительным числом.");
            scanner.nextLine();
            return;
        }

        if (numberOfCombos <= 0) {
            System.out.println("Введено некорректное число наборов. Требуется ввести число больше 0");
            return;
        }

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        ArrayList<String> dishTypes = new ArrayList<>();
        while (true) {
            String nextItem = scanner.nextLine().trim();
            if (nextItem.isEmpty()) {
                break;
            }
            if (!dinnerConstructor.checkType(nextItem)) {
                System.out.println("Такого типа блюд нет в меню! Введите корректный тип.");
                continue;
            }
            dishTypes.add(nextItem);
        }

        if (dishTypes.size() == 0) {
            System.out.println("Не введено ни одного типа блюда!");
            return;
        }

        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println(dc.generateDishCombo(dishTypes));
        }

    }
}
