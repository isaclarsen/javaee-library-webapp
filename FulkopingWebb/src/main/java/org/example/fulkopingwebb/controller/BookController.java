package org.example.fulkopingwebb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.fulkopingwebb.dao.BookDAO;
import org.example.fulkopingwebb.model.Book;

import java.io.IOException;

@WebServlet("/books")
public class BookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        try{
        //Single view
        BookDAO bookDAO = new BookDAO();

        if (req.getParameter("id") != null){
            int id = Integer.parseInt(req.getParameter("id"));
            Book book = bookDAO.getBookById(id);
                req.setAttribute("book", book);
                req.getRequestDispatcher("view/book/bookDetail.jsp").forward(req, res);
        }
    }catch(ServletException | IOException e){
        throw new RuntimeException(e);}
    }
}
