package com.pferrervich.web;

//Import de los modulos donde se encuentran los metodos
import com.pferrervich.core.ConnectDB;
import com.pferrervich.core.Restaurants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        // Actual logic goes here.
        Restaurants rest = null;
        String id = request.getParameter("id");

        rest = ConnectDB.readRestOpi(id);
        request.setAttribute("restaurant", rest);
        request.getRequestDispatcher("restaurant.jsp").forward(request, response);

    }
}
