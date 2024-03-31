package org.surikov.homework9;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.surikov.homework9.entity.RegistrationBase;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet(name = "authServlet", value = "/auth-servlet")
public class AuthServlet extends HttpServlet {
    //Реализовал макисмально простую версию авторизации через Map
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if(RegistrationBase.getMap().containsKey(req.getParameter("login")) && RegistrationBase.getMap().containsValue(req.getParameter("password"))) {
           session.setAttribute("authResult","true");
           session.setAttribute("time", Time.valueOf(LocalTime.now()));
           session.setAttribute("date", Date.valueOf(LocalDate.now()));
           req.getRequestDispatcher("index.jsp").forward(req,resp);
        } else {
           session.setAttribute("authResult","false");
           req.getRequestDispatcher("authorization.jsp").forward(req,resp);
        }
    }
}
