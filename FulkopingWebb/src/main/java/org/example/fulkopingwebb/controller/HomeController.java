package org.example.fulkopingwebb.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.fulkopingwebb.dao.LoanDAO;
import org.example.fulkopingwebb.model.Loan;
import org.example.fulkopingwebb.model.User;

import java.util.List;

@WebServlet("/home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                req.setAttribute("error", "Du måste vara inloggad för att få tillgång till startsidan");
                req.getRequestDispatcher("/login").forward(req, res);
                return;
            }
            req.getRequestDispatcher("WEB-INF/home.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
