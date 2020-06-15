package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.ConvertMaptoListUtil;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MealDaoImpl implements MealDao{
    private static final AtomicInteger AUTO_ID = new AtomicInteger(8);
    private static Map<Integer, Meal> mapOfmeals = new ConcurrentHashMap<>();

    static {
        mapOfmeals.put(1, new Meal(1, LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500));
        mapOfmeals.put(2, new Meal(2, LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000));
        mapOfmeals.put(3, new Meal(3, LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500));
        mapOfmeals.put(4, new Meal(4, LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100));
        mapOfmeals.put(5, new Meal(5, LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000));
        mapOfmeals.put(6, new Meal(6, LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500));
        mapOfmeals.put(7, new Meal(7, LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 600));
    }

    @Override
    public void addMeal(Meal meal) {
        meal.setId(AUTO_ID.getAndIncrement());
        mapOfmeals.put(meal.getId(), meal);
    }

    @Override
    public void deleteMeal(Meal meal) {
        mapOfmeals.remove(meal.getId());
    }

    @Override
    public void updateMeal(Meal meal) {
        mapOfmeals.put(meal.getId(), meal);
    }

    @Override
    public Meal getById(int id){
        return mapOfmeals.get(id);
    }

    @Override
    public List<MealTo> getAllMealsto()
    {
       return MealsUtil.filteredByStreams(ConvertMaptoListUtil.converter(mapOfmeals), LocalTime.MIN, LocalTime.MAX, 2000);
    }
}
