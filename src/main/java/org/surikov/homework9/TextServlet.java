package org.surikov.homework9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "textServlet", value = "/text-servlet")
public class TextServlet extends HttpServlet {
    //Решаю задачу через регулярные выражения
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> questions = new ArrayList<>();
        //Выражение (?<=\.) позволяет увидеть на один символ вперед.
        //Это помогает сохранить символ вопроса, для дальнейшей индикации
        String[] text = req.getParameter("text").split("(?<=\\.) |(?<=\\?) |(?<=\\?$) |(?<=\\.$) ");
        //Задаем шаблон для индикации вопросительного предложения
        String pattern = "(.\\?)";
        Pattern regular = Pattern.compile(pattern) ;
        //Счетчик нужен только для информативности при выводе :)
        int counter = 0;

        for (String string: text){
            Matcher matcher = regular.matcher(string);
            if(matcher.find()) {
                String name = "question_"+counter;
                System.out.println(string);
                //Cookie не хранят символ пробела. Меняем символ.
                Cookie cookie = new Cookie(name,string.replace(" ","_"));
                resp.addCookie(cookie);
                //Cookie записываются, все хорошо.
                questions.add(string);
                counter++;
            }
        }

        req.setAttribute("questions", questions);
        req.setAttribute("counter",counter);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}

