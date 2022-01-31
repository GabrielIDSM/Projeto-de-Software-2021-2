package Controller;

import Model.UserModel;
import Repository.UserRepository;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
@WebServlet(name = "User", urlPatterns = {"/User"})
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher page;
        HttpSession session = request.getSession();
        String action = (String) request.getParameter("a");
        UserRepository userRepository = new UserRepository();
        
        if (action == null)
            action = "";
        
        switch(action) {
            case "login":
                String pageRef;
                if (session.getAttribute("user") != null) {
                    UserModel user = (UserModel) session.getAttribute("user");
                    session.setAttribute("user", user);
                    pageRef = "/index.jsp";
                } else {
                    pageRef = "/login.jsp";
                }
                page = getServletContext().getRequestDispatcher(pageRef);
                page.forward(request, response);
                break;
            case "logout":
                session.invalidate();
                page = getServletContext().getRequestDispatcher("/index.jsp");
                page.forward(request, response);
                break;
            default:
                List<UserModel> users = userRepository.allModel();
                
                request.setAttribute("users", users);
                
                page = getServletContext().getRequestDispatcher("/users.jsp");
                page.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher page;
        String action = (String) request.getParameter("a");
        String message = "";
        
        if (action == null)
            action = "";

        try {
            switch(action) {
                case "login":
                    
                    if (request.getParameter("username").equals("")) {
                        message = "O campo 'Username' não foi preenchido";
                        request.setAttribute("error", 1);
                    }

                    if (request.getParameter("password").equals("")) {
                        message = "O campo 'Senha' não foi preenchido";
                        request.setAttribute("error", 1);
                    }

                    if (message.equals("")) {
                        String username = request.getParameter("username");
                        String password = request.getParameter("password");

                        UserRepository userRepository = new UserRepository();
                        UserModel user = userRepository.login(username, password);

                        if (user != null) {
                            HttpSession session = request.getSession();
                            session.setAttribute("user", user);
                            page = getServletContext().getRequestDispatcher("/index.jsp");
                            page.forward(request, response);
                        } else {
                            message = "Usuário não encontrado";
                            request.setAttribute("error", 1);  
                            request.setAttribute("message", message);
                            page = getServletContext().getRequestDispatcher("/login.jsp");
                            page.forward(request, response);
                        }
                    }
                    
                    break;
                default:
                    page = getServletContext().getRequestDispatcher("/users.jsp");
                    page.forward(request, response);
            }
        } catch(IOException | NumberFormatException | ServletException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}