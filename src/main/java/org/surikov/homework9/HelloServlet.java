package org.surikov.homework9;

import java.io.*;
import java.util.Enumeration;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.surikov.homework9.entity.RegistrationBase;

@WebServlet(name = "textServlet", value = "/text-servlet")
public class HelloServlet extends HttpServlet {
    //Решаю задачу через регулярные выражения
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] text = req.getParameter("text").split("(?<=\\.) |(?<=\\?) ");
        String pattern = "(.\\?)";
        Pattern regular = Pattern.compile(pattern) ;
        int counter = 0;

        for (String string: text){

            Matcher matcher = regular.matcher(string);
            if(matcher.find()) {
                counter++;
            }
        }
        req.setAttribute("counter",counter);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}

