package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.util.List;

public interface MealDao {
    void addMeal(Meal meal);
    void deleteMeal(Meal meal);
    void updateMeal(Meal meal);
    List<MealTo> getAllMealsto();
    Meal getById(int id);
}
