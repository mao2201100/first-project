package com.company;

public class Converter {
    double stepMeter = 0.75; // 1 шаг 0,75м
    int stepKolory = 50; // 1 шаг 50 калорий
    //StepTracker stepTracker = new StepTracker();
    public void meters(int month,StepTracker.MonthData [] monthToData){
        int k=0;
        for(int i=0;i<30;i++ ){
            k = monthToData[month].days[i].step+k;
        }
        double z=k*stepMeter;
        System.out.println("В этом месяце пройденая дистанция : "+z);
    }
    public void calories(int month,StepTracker.MonthData [] monthToData) {
        int k = 0;
        for (int i = 0; i < 30; i++) {
            k = monthToData[month].days[i].step + k;
        }
        k = k * stepKolory;
        System.out.println("В этом месяце потрачено калорий : " + k);
    }
}
