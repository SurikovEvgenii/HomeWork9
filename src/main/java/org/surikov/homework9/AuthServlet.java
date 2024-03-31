package org.surikov.homework9;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.surikov.homework9.entity.RegistrationBase;

import java.io.IOException;

@WebServlet(name = "authServlet", value = "/auth-servlet")
public class AuthServlet extends HttpServlet {

    //Реализовал макисмально простую версию авторизации через Map...
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(RegistrationBase.getMap().containsKey("login") && RegistrationBase.getMap().containsValue("password")){
            resp.sendRedirect("index.jsp");
        } else {
            req.setAttribute("authResult", "false");
            req.getRequestDispatcher("authorization.jsp").forward(req,resp);
        }
    }
}
