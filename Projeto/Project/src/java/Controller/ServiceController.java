package Controller;

import Model.ServiceModel;
import Repository.ServiceRepository;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
@MultipartConfig 
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
        List<ServiceModel> services;
        
        if (action == null)
            action = "";
        
        switch(action) {
            case "show":
                serviceId = Integer.parseInt(request.getParameter("id"));
                serviceModel = serviceRepository.getModel(serviceId);
                
                services = serviceRepository.allModel();
                request.setAttribute("services", services);
                
                request.setAttribute("service", serviceModel);
                page = getServletContext().getRequestDispatcher("/service.jsp");
                page.forward(request, response);
                break;
                
            case "create":
                serviceModel.setId(0);
                serviceModel.setName("");
                serviceModel.setQuery("");
                serviceModel.setImageFileName("");
                serviceModel.setHistoryList(new ArrayList<>());
                
                services = serviceRepository.allModel();
                request.setAttribute("services", services);
                
                request.setAttribute("service", serviceModel);
                page = getServletContext().getRequestDispatcher("/createservice.jsp");
                page.forward(request, response);
                break;
                
            case "update":
                serviceId = Integer.parseInt(request.getParameter("id"));
                serviceModel = serviceRepository.getModel(serviceId);
                
                services = serviceRepository.allModel();
                request.setAttribute("services", services);
                
                request.setAttribute("service", serviceModel);
                page = getServletContext().getRequestDispatcher("/updateservice.jsp");
                page.forward(request, response);
                break;
            
            case "image":
                serviceId = Integer.parseInt(request.getParameter("id"));
                serviceModel = serviceRepository.getModel(serviceId);
                
                services = serviceRepository.allModel();
                request.setAttribute("services", services);
                
                request.setAttribute("service", serviceModel);
                page = getServletContext().getRequestDispatcher("/imageservice.jsp");
                page.forward(request, response);
                break;
                
            case "delete":
                serviceId = Integer.parseInt(request.getParameter("id"));
                serviceRepository.deleteModel(serviceId);
                
                services = serviceRepository.allModel();
                request.setAttribute("services", services);
                
                page = getServletContext().getRequestDispatcher("/services.jsp");
                page.forward(request, response);
                break;
                
            case "load":
                services = serviceRepository.allModel();
                request.setAttribute("services", services);
                
                page = getServletContext().getRequestDispatcher("/index.jsp");
                page.forward(request, response);
                break;
                
            default:
                services = serviceRepository.allModel();
                request.setAttribute("services", services);
                
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
            List<ServiceModel> services;
            
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
                    
                    services = serviceRepository.allModel();
                    request.setAttribute("services", services);
                    
                    page = getServletContext().getRequestDispatcher("/services.jsp");
                    page.forward(request, response);
                    break;
                    
                case "image":
                    if (request.getParameter("id") == null) {
                        message = "O campo 'Id' não existe";
                    } else {
                        if (request.getParameter("id").equals(""))
                            message = "O campo 'Id' não existe";
                    }
                    
                    if (request.getPart("file") == null) {
                        message = "O campo 'Arquivo' não foi preenchido";
                    }
                    
                    if (request.getParameter("image") == null) {
                        message = "O campo 'Id' não existe";
                    } else {
                        if (request.getParameter("image").equals(""))
                            message = "O campo 'Id' não existe";
                    }
                    
                    if (message.equals("")) {
                        serviceModel.setId(Integer.parseInt(request.getParameter("id")));
                        serviceModel.setImageFileName(request.getParameter("image"));

                        Part filePart = request.getPart("file");
                        InputStream fileContent = filePart.getInputStream();

                        File targetFile = new File(getServletContext().getRealPath("/") + "images/" + serviceModel.getImageFileName());
                        OutputStream outStream = new FileOutputStream(targetFile);

                        byte[] buffer = new byte[8 * 1024];
                        int bytesRead;
                        while ((bytesRead = fileContent.read(buffer)) != -1) {
                            outStream.write(buffer, 0, bytesRead);
                        }
                        IOUtils.closeQuietly(fileContent);
                        IOUtils.closeQuietly(outStream);
                    }
                    
                    request.setAttribute("message", message);
                    
                    services = serviceRepository.allModel();
                    request.setAttribute("services", services);
    
                    page = getServletContext().getRequestDispatcher("/services.jsp");
                    page.forward(request, response);
                    break;
                    
                default:
                    services = serviceRepository.allModel();
                    request.setAttribute("services", services);
                    
                    page = getServletContext().getRequestDispatcher("/services.jsp");
                    page.forward(request, response);
            }
        } catch(IOException | NumberFormatException | ServletException e) {
            System.out.println("Error: " + Arrays.toString(e.getStackTrace()).replace(",", ",\n"));
        }
    }
}