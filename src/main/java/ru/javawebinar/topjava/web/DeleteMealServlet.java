package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.dao.MealDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteMealServlet extends HttpServlet {
    private MealDao mealDao;

    public DeleteMealServlet() {
        this.mealDao = new MealDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mealDao.deleteMeal(mealDao.getById(Integer.parseInt(request.getParameter("id"))));
        response.sendRedirect("meals");
    }
}
