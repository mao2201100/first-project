package com.company;
import java.util.Scanner;
public class StepTracker {
    public static int goalStep = 10000; // Целевое количество шагов. При старте приложения устанавливается равным 10 000 в день.
    Converter converter = new Converter();
    MonthData[] monthToData;
    StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    class MonthData {
        Day[] days;
        public MonthData() {
            days = new Day[30];
            for (int i = 0; i < days.length; i++) {
                days[i] = new Day(i);
            }
        }
        class Day {
            int day;
            int step;

            public Day(int day) {
                this.day = day;
            }
            @Override
            public String toString() {
                return "день = " + day + ": " + step;
            }
        }
    }
    public void enter(int month, int day, int steps) {
        MonthData m = monthToData[month]; // присваиваем переменной m элемент массива monthToData[month]
        MonthData.Day d = m.days[day]; //
        d.step = steps;
    }
    public MonthData.Day[] getByMonth(int month){
         return monthToData[month].days;
    }
    public void insert(int month){ // общее кол.во шагов за месяц
        int k=0;
        for(int i=0;i<30;i++ ){
            k = monthToData[month].days[i].step+k;
        }
          System.out.println("Общее колличесво шагов за "+month+" месяц: "+k);
    }
    public void setMax(int month){ // общее кол.во шагов за месяц
        int k=0;
        for(int i=0;i<29;i++ ){
            if(monthToData[month].days[i].step>k)
            k = monthToData[month].days[i].step;
        }
        System.out.println("Максимальное колличество шагов в этом месяце: "+k);
    }
    public void insertSrednee(int month){ //среднее колличество шагов
        double l=0;
        for(int i=0;i<30;i++ ){
            l = monthToData[month].days[i].step+l;
        }
        System.out.println("Среднее колличество шагов за "+month+" месяц: "+(l/30));
    }
    public void distance(int month){
        int k=0;
        for(int i=0;i<30;i++ ){
            k = monthToData[month].days[i].step+k;
        }
        System.out.println("Общее колличесво шагов за "+month+" месяц: "+k);
    }
    void changeGoalStep() { //целевое колличество шагов
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите новую цель по колличеству");
            goalStep = scanner.nextInt();
            if (goalStep >= 0) {
                System.out.println("Значение сохранено.");
                break;
            } else if (goalStep < 0) {
                System.out.println("Вводимое заначение должно быть положительным попробуйте еще раз.");
            }
        }
    }
     public int seriya(int month){ // лучшая серия шагов

        int count=0;
        int result=0;
        for(int i=0; i < monthToData[month].days.length; i++ ) {
            if (monthToData[month].days[i].step >= goalStep) {
                count = count + 1;
            } else {
                result = Math.max(count, result);
                count = 0;
            }
        }
         return result;
    }
}


