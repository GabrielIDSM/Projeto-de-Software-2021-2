package Controller;

import Model.ServiceModel;
import Repository.ServiceRepository;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
@WebServlet(name = "Service", urlPatterns = {"/Service"})
public class ServiceController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher page;
        String action = (String) request.getParameter("a");
        Integer serviceId;
        ServiceModel serviceModel = new ServiceModel();
        ServiceRepository serviceRepository = new ServiceRepository();
        
        if (action == null)
            action = "";
        
        switch(action) {
            case "create":
                serviceModel.setId(0);
                serviceModel.setName("");
                serviceModel.setQuery("");
                serviceModel.setImageFileName("");
                serviceModel.setHistoryList(new ArrayList<>());
                
                request.setAttribute("service", serviceModel);
                page = getServletContext().getRequestDispatcher("/createservice.jsp");
                page.forward(request, response);
                break;
                
            case "update":
                serviceId = Integer.parseInt(request.getParameter("id"));
                serviceModel = serviceRepository.getModel(serviceId);
                
                request.setAttribute("service", serviceModel);
                page = getServletContext().getRequestDispatcher("/updateservice.jsp");
                page.forward(request, response);
                break;
            case "delete":
                serviceId = Integer.parseInt(request.getParameter("id"));
                serviceRepository.deleteModel(serviceId);
                
                page = getServletContext().getRequestDispatcher("/services.jsp");
                page.forward(request, response);
                break;
                
            default:
                page = getServletContext().getRequestDispatcher("/services.jsp");
                page.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String message = "";
        RequestDispatcher page;
        
        try {
            String action = (String) request.getParameter("a");
            ServiceModel serviceModel = new ServiceModel();
            ServiceRepository serviceRepository = new ServiceRepository();
            
            if (action == null)
                action = "";
            
            switch(action) {
                case "submit":
                    if (request.getParameter("id").equals("")) {
                        message = "O campo 'Id' não existe";
                    }
                    
                    if (request.getParameter("name").equals("")) {
                        message = "O campo 'Nome' não foi preenchido";
                    }
                    
                    if (request.getParameter("query").equals("")) {
                        message = "O campo 'Query' não foi preenchido";
                    }
                    
                    if (request.getParameter("image").equals("")) {
                        message = "O campo 'Imagem' não foi preenchido";
                    }
                    
                    if (message.equals("")) {
                        serviceModel.setId(Integer.parseInt(request.getParameter("id")));
                        serviceModel.setName(request.getParameter("name"));
                        serviceModel.setQuery(request.getParameter("query"));
                        serviceModel.setImageFileName(request.getParameter("image"));
                    
                        if (serviceModel.getId() == 0) {
                            if (!serviceRepository.addService(serviceModel))
                                message = "Serviço não adicionado";
                        } else {
                            if (!serviceRepository.updateService(serviceModel))
                                message = "Serviço não alterado";
                        }
                    }
                    
                    request.setAttribute("message", message);
                    
                    page = getServletContext().getRequestDispatcher("/services.jsp");
                    page.forward(request, response);
                    break;
                    
                default:
                    page = getServletContext().getRequestDispatcher("/services.jsp");
                    page.forward(request, response);
            }
        } catch(IOException | NumberFormatException | ServletException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}