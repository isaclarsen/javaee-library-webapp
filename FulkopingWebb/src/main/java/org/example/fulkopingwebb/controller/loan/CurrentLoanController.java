package org.example.fulkopingwebb.controller.loan;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.fulkopingwebb.dao.LoanDAO;
import org.example.fulkopingwebb.model.Loan;
import org.example.fulkopingwebb.model.User;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

//TODO:
//När man trycker ppå lämna tillbaka bok ska sidan uppdateras och boken försivnner, inte att man kommerr till en tom lista
//Fixa historik över lån
//GÖR SIDAN SNYGGARE
//VG KRAV

@WebServlet("/currentLoans")
public class CurrentLoanController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                req.setAttribute("error", "Du måste vara inloggad för att få tillgång till dina lånade böcker");
                req.getRequestDispatcher("/login").forward(req, res);
                return;
            }
            List<Loan> currentLoans = LoanDAO.getActiveLoansForUser(user.getId());
            req.setAttribute("currentLoans", currentLoans);
            req.getRequestDispatcher("view/loan/currentLoans.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }

}
