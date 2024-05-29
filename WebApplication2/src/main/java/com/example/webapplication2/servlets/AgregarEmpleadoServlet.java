package com.example.webapplication2.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

@WebServlet("/")
public class AgregarEmpleadoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        response.getWriter().println("<html><body><h1>Welcome to MainServlet</h1></body></html>");
        List<String> datos = new ArrayList<>();
        datos.add("Dato 1");
        datos.add("Dato 2");
        datos.add("Dato 3");

        // Enviamos los datos a la página JSP
        request.setAttribute("datos", datos);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
}
