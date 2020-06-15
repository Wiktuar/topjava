package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConvertMaptoListUtil {
    public static List<Meal> converter(Map<Integer, Meal> map){
        List<Meal> mealList = new ArrayList<>();
        map.forEach((k, v) -> mealList.add(v));
        return mealList;
    }
}
