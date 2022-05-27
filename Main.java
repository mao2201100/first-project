package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();
        int enterMonth;//переменная для  месяц в пункте 1 меню 1
        int enterDay; // переменная для день в пункте 1 меню 1
        int enterSteps; //переменная для шагов в пункте 1 меню 1
        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            while (userInput != 0) {
                if (userInput == 1) {
                    System.out.println("Введите номер месяца из расчета 0-январь, 1- февраль,... 11-декабрь");
                    enterMonth = scanner.nextInt();//вводим месяц
                    System.out.println("Введите номер дня в этом месяце из расчета 0 - 1-ый день,..., 29 - 30-ый день");
                    enterDay = scanner.nextInt();// воодим день
                    System.out.println("Введите колличество шагов");
                    while (true) {
                        enterSteps = scanner.nextInt();// вводим колличество шагов
                        if (enterSteps < 0) {
                            System.out.println("Колличество шагов не должно быть отрицательным. Попробуйте еще");
                        } else {
                            System.out.println("Данные сохранены");
                            break;
                        }
                    }
                    stepTracker.enter(enterMonth, enterDay, enterSteps);

                } else if (userInput == 2) {
                    printStatisticMenu();
                    int enter = scanner.nextInt(); // выбираем пункт основного меню
                    int m; // переменная месяца
                    while (enter <=7) {
                        if (enter == 1) { // кол-во шагов по дням 1 день: 3000 ...
                            System.out.println("Введите номер месяца из расчета 0-январь, 1- февраль,... 11-декабрь");
                            m = scanner.nextInt();// вводим номер месяца
                            for (StepTracker.MonthData.Day x : stepTracker.getByMonth(m)) {
                                System.out.println(x.toString());
                            }

                        } else if (enter == 2) { // общее кол-во шагов за месяц
                            System.out.println("Введите номер месяца из расчета 0-январь, 1- февраль,... 11-декабрь");
                            m = scanner.nextInt();// вводим номер месяца
                            stepTracker.insert(m); // общее колличество шагов за месяц

                        } else if (enter == 3) { // максимально пройденое кол-во шагов в месяце
                            System.out.println("Введите номер месяца из расчета 0-январь, 1- февраль,... 11-декабрь");

                            m = scanner.nextInt();// вводим номер месяца
                            stepTracker.setMax(m);// максимально пройденое кол-во шагов
                        } else if (enter == 4) { // Среднее количество шагов
                            System.out.println("Введите номер месяца из расчета 0-январь, 1- февраль,... 11-декабрь");
                            m = scanner.nextInt();// вводим номер месяца
                            stepTracker.insertSrednee(m);//

                        } else if (enter == 5) {// среднее кол-во шагов
                            System.out.println("Введите номер месяца из расчета 0-январь, 1- февраль,... 11-декабрь");
                            m = scanner.nextInt();// вводим номер месяца

                            converter.meters(m, stepTracker.monthToData);

                        } else if (enter == 6) { //определяем кол.во сожженных калорий
                            System.out.println("Введите номер месяца из расчета 0-январь, 1- февраль,... 11-декабрь");
                            m = scanner.nextInt();// вводим номер месяца

                            converter.calories(m, stepTracker.monthToData);

                        } else if (enter == 7) { //лучшая серия: максимальное количество подряд идущих дней
                            System.out.println("Введите номер месяца из расчета 0-январь, 1- февраль,... 11-декабрь");
                            m = scanner.nextInt();// вводим номер месяца
                            System.out.println("Лучшая серия подряд идущих дней:" + stepTracker.seriya(m));

                        } else {
                            System.out.println("Такой команды не существует.");
                        }
                        break;
                    }
                } else if (userInput == 3) { //Изменить цель по количеству шагов в день"
                    stepTracker.changeGoalStep();

                } else if (userInput == 0) { //Выход
                } else {
                    System.out.println("Такой команды нет");
                }
                break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
    public static void  printStatisticMenu(){
        System.out.println("Выберите действие:");
        System.out.println("1 - Количество пройденных шагов по дням");
        System.out.println("2 - Общее количество шагов за месяц");
        System.out.println("3 - Максимальное пройденое количество шагов в месяце");
        System.out.println("4 - Среднее количество шагов");
        System.out.println("5 - Пройденная дистанция (в км)");
        System.out.println("6 - Количество сожжённых килокалорий");
        System.out.println("7 - Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.");
    }
}



