package org.example.fulkopingwebb.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.fulkopingwebb.dao.BookDAO;
import org.example.fulkopingwebb.model.Book;
import org.example.fulkopingwebb.util.HibernateUtil;

import java.io.IOException;
import java.util.List;

public class AppController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        //Book book = new Book();
        //book.setTitle("Harry Potter och De Vises Sten");
        //book.setAuthor("J.K Rowling");
        //book.setGenre("Fantasy");
        //BookDAO bookDAO = new BookDAO();
        //bookDAO.saveBook(book);

        HttpSession session = req.getSession(false);

        try{
            req.getRequestDispatcher("view/index.jsp").forward(req, res);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }
}
