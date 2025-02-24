package org.example.fulkopingwebb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.fulkopingwebb.dao.UserDAO;
import org.example.fulkopingwebb.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        //Logga ut
        try {
            Boolean logout = Boolean.parseBoolean(req.getParameter("logout"));
            if(logout) {

                HttpSession session = req.getSession(false);
                if(session != null) {
                    session.setAttribute("user", null);
                    session.invalidate();
                }
                req.setAttribute("message", "Du har loggats ut");
            }
            req.getRequestDispatcher("/view/login.jsp").forward(req, res);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //Logga in
        String username = req.getParameter("username") == null ? "" : req.getParameter("username");
        String password = req.getParameter("password") == null ? "" : req.getParameter("password");
        String error = null;

        if(username.isBlank() || password.isBlank()){
            error = "Vänligen fyll i båda fälten";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/view/login.jsp").forward(req, res);
            return;
        }

        UserDAO userDAO = new UserDAO();
        User user = null;

        try{
            user = userDAO.getUser(username);
            if(user == null){
                error = "Användaren hittades inte";
                req.setAttribute("error", error);
                req.getRequestDispatcher("/view/login.jsp").forward(req, res);
                return;
            }
            if (!BCrypt.checkpw(password, user.getPassword())){
                error = "Fel lösenord";
                req.setAttribute("error", error);
                req.getRequestDispatcher("/view/login.jsp").forward(req, res);
                return;
            }

            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            req.getRequestDispatcher("WEB-INF/home.jsp").forward(req, res);

        }catch(Exception e){
            error = "Ett internt fel inträffade, försök igen!";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/view/login.jsp").forward(req, res);
        }
    }

}
