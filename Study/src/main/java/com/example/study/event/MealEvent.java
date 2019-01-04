package com.example.study.event;

import org.springframework.context.ApplicationEvent;

public class MealEvent extends ApplicationEvent {

    private MealEnum mealEnum;

    /**
     * @param mealContent
     *        吃什么
     * @param mealEnum
     *        早餐还是午餐？
     */
    public MealEvent(String mealContent, MealEnum mealEnum) {
        super(mealContent);
        this.mealEnum = mealEnum;
    }

    public MealEnum getMealEnum() {
        return mealEnum;
    }
}
