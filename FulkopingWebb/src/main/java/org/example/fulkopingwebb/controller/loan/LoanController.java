package org.example.fulkopingwebb.controller.loan;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.fulkopingwebb.dao.BookDAO;
import org.example.fulkopingwebb.dao.LoanDAO;
import org.example.fulkopingwebb.model.Book;
import org.example.fulkopingwebb.model.Loan;
import org.example.fulkopingwebb.model.User;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;


@WebServlet("/loan")
public class LoanController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res){

        //Kontrollerar om någon är inloggad
        try{
            HttpSession session = req.getSession(false);
            if(session == null || session.getAttribute("user") == null){
                //Om session null skicka till login.jsp för att logga in
                req.setAttribute("error", "Vänligen logga in för att låna en bok!");
                req.getRequestDispatcher("view/login.jsp").forward(req, res);
                return;
        }

            User user = (User)session.getAttribute("user");
            String action = req.getParameter("action");
            BookDAO bookDAO = new BookDAO();
            //Om inputen i bookDetail "låna" knappen är "borrow"
            if("borrow".equals(action)){
                //Hämta bokid parametern
                int bookId = Integer.parseInt(req.getParameter("bookId"));

                Book book = bookDAO.getBookById(bookId);
                Loan loan = new Loan();

                loan.setBook(book);
                loan.setUser(user);

                LocalDate today = LocalDate.now();
                loan.setLoanDate(Date.valueOf(today));
                loan.setReturnDate(Date.valueOf(today.plusDays(30)));


                LoanDAO.saveLoan(loan);
                book.setAvailable(false);
                new BookDAO().updateBook(book);
                req.setAttribute("message", book.getTitle() + " har nu utlånats till " + user.getUsername() + "!");
                req.getRequestDispatcher("/currentLoans").forward(req, res);


            }else if("return".equals(action)){
                int bookId = Integer.parseInt(req.getParameter("bookId"));
                Loan loan = LoanDAO.getActiveLoanForBook(bookId);
                if(loan != null){
                    loan.setReturned(true);
                    loan.setReturnDate(Date.valueOf(LocalDate.now()));

                    Book book = loan.getBook();
                    book.setAvailable(true);
                    new BookDAO().updateBook(book);

                    LoanDAO.updateLoan(loan);

                    req.setAttribute("message", "Boken: " + book.getTitle() + " har lämnats tillbaka!");
                    req.getRequestDispatcher("/currentLoans").forward(req, res);


                }else{
                    req.setAttribute("error", "Inget lån hittades för boken");
                    req.getRequestDispatcher("/books").forward(req, res);
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/books").forward(req, res);
    }
}
