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
        //Funkar ej
        if(req.getParameter("q") == null){
            req.setAttribute("error", "Ange en sökterm");
            req.getRequestDispatcher("/view/book/bookList.jsp").forward(req, res);
            return;
        }
        //Search Result
        List<Book> books = bookDAO.searchBooks(req.getParameter("q"));
        req.setAttribute("books", books);
        req.getRequestDispatcher("/view/book/bookList.jsp").forward(req, res);


    }
}
