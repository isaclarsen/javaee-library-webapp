package org.example.fulkopingwebb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.fulkopingwebb.dao.BookDAO;
import org.example.fulkopingwebb.dao.LoanDAO;
import org.example.fulkopingwebb.model.Book;
import org.example.fulkopingwebb.model.Loan;

import java.io.IOException;

@WebServlet("/books")
public class BookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            BookDAO bookDAO = new BookDAO();
            //Single view
            if (req.getParameter("id") != null) {
                int id = Integer.parseInt(req.getParameter("id"));
                Book book = bookDAO.getBookWithActiveLoan(id);

                // Hitta eventuellt aktivt lån (där returned = false)
                Loan activeLoan = null;
                if (book.getLoans() != null) {
                    for (Loan loan : book.getLoans()) {
                        if (!loan.isReturned()) {
                            activeLoan = loan;
                            break;
                        }
                    }
                }

                req.setAttribute("loan", activeLoan);
                req.setAttribute("book", book);
                req.getRequestDispatcher("view/book/bookDetail.jsp").forward(req, res);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}


