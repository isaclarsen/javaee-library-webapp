package org.example.fulkopingwebb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.fulkopingwebb.dao.BookDAO;
import org.example.fulkopingwebb.model.Book;

import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        BookDAO bookDAO = new BookDAO();
        //Om man inte söker efter något
        String q = req.getParameter("q");
        if("q" == null || q.trim().isEmpty()) {
            error(req, res, "Sökrutan är tom! Vänligen fyll i sökrutan");
            return;
        }
        //Search Result
        List<Book> books = bookDAO.searchBooks(req.getParameter("q"));
        req.setAttribute("books", books);
        req.getRequestDispatcher("/view/book/bookList.jsp").forward(req, res);


    }

    private void error(HttpServletRequest req, HttpServletResponse res, String error){
        req.setAttribute("error", error);

        try {
            req.getRequestDispatcher("/view/index.jsp").forward(req, res);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
