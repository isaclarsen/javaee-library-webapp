package org.example.fulkopingwebb.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.fulkopingwebb.dao.UserDAO;
import org.example.fulkopingwebb.model.User;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        try{
            req.getRequestDispatcher("/view/register").forward(req, res);
        }catch(Throwable e){
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res){

        //Skapar variablerna för att registrera sig och hindar dem från att bli null för att förebygga errors
        String username = req.getParameter("username") == null ? "" : req.getParameter("username");
        String password = req.getParameter("password") == null ? "" : req.getParameter("password");
        String password2 = req.getParameter("password2") == null ? "" : req.getParameter("password2");
        String error = null;

        if (username.isBlank() || password.isBlank() || password2.isBlank()){
            error = "Vänligen fyll i alla fält";
            req.setAttribute("error", error);
        } else if (!password.equals(password2)){
            error = "Lösenorden matchar inte";
            req.setAttribute("error", error);
        }


        //Om det finns ett error
        if(error != null){
            //Spara värdena
            req.setAttribute("error", error);
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("password2", password2);
            //Skicka tillbaka till registrerings sidan
            try{
                req.getRequestDispatcher("/view/register.jsp").forward(req, res);
            }catch(Throwable e){
                throw new RuntimeException(e);
            }
            return;
        }
        //Skapar användaren och hashar lösenordet
        User user = new User();
        user.setUsername(username);
        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        //Hämtar userDAO för att få tillgång till databas
        UserDAO userDAO = new UserDAO();
        try{
            //Om allt lyckades så sparas en ny användare i databasen med värdena
            userDAO.saveUser(user);
            req.setAttribute("success", "Du har blivit registrerad!");
        }catch(Throwable e){
            //Om något inte funkade så skrivs det ut
            req.setAttribute("error", "Din användare kunde inte skapas, försök igen");
            System.out.println(e.getMessage());
        }try {
            //Skickar tillbaka användaren till registreringssidan med antingen success meddelande eller ett error
            //Eventuellt gör en success sida!!!!!!
            req.getRequestDispatcher("view/register.jsp").forward(req, res);
        }catch(Throwable e){
            throw new RuntimeException(e);
        }
    }


}
