<%-- 
    Document   : index
    Created on : 09/01/2022, 13:52:48
    Author     : gabriel
--%>

<%@page import="Model.UserModel"%>
<%@page import="Model.ServiceHistoryModel"%>
<%@page import="Model.ServiceModel"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Repository.ServiceRepository"%>
<%@page import="Model.ServiceModel"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="FontAwesome/css/all.css">
        <link rel="stylesheet" href="styles/isdown.css">

        <title>Is Down ?</title>
    </head>
    <body>
        <%@include file="components/services.jsp" %>
        <%
            UserModel user = (UserModel) session.getAttribute("user");
            List<ServiceModel> serviceList = (List<ServiceModel>) request.getAttribute("services");
            
            if (serviceList == null)
                serviceList = new ArrayList<>();
        %>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="index.jsp">Is Down ?</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Alterna navegação">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">Página Inicial<span class="sr-only">(Página atual)</span></a>
                    </li>
                    <%
                        if (user != null) {
                            if (user.getRole().getName().compareTo("Administrator") == 0) {
                    %>
                                <li class="nav-item">
                                    <a class="nav-link" href="User">Usuários</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="Service">Serviços</a>
                                </li>
                    <%
                                                    
                            }
                    %>
                        <li class="nav-item">
                            <a class="nav-link" href="User?a=logout">Logout</a>
                        </li>
                    <%
                        } else {
                    %>
                        <li class="nav-item">
                            <a class="nav-link" href="User?a=login">Login</a>
                        </li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </nav>
        <div class="album py-5">
            <div class="container">
                <div class="row row-cols-1 row-cols-sm-1 row-cols-md-1 row-cols-lg-2 row-cols-xl-3 g-3">
                    <%
                        for(ServiceModel serviceModel : serviceList) {
                            Integer lastComplaintCount;
                            String dropDivClass;
                            String message;
                            
                            if (!serviceModel.getHistoryList().isEmpty()) {
                                ServiceHistoryModel serviceHistoryModel = serviceModel.getHistoryList().get(serviceModel.getHistoryList().size() - 1);
                                lastComplaintCount = serviceHistoryModel.getComplaints();
                            } else {
                                lastComplaintCount = 0;
                            }
                            
                            if (lastComplaintCount <= ServiceModel.NORMAL_THRESHOLD)       dropDivClass = "isdown-normal-div";
                            else if (lastComplaintCount <= ServiceModel.WARNING_THRESHOLD) dropDivClass = "isdown-warning-div";
                            else if (lastComplaintCount <= ServiceModel.DANGER_THRESHOLD)  dropDivClass = "isdown-danger-div";
                            else if (lastComplaintCount > ServiceModel.DANGER_THRESHOLD)   dropDivClass = "isdown-down-div";
                            else dropDivClass = "isdown-none-div";
                            
                            if (lastComplaintCount.intValue() == 1) message = "reclamação na última hora";
                            else message = "reclamações na última hora";
                    %>
                    <div class="col">
                        <div class="card shadow-sm isdown-round isdown-card" onclick="location.href='Service?a=show&id=<%= serviceModel.getId() %>';">
                            <div class="<%= dropDivClass %> isdown-default-div">
                                <div class="isdown-down-content-div">
                                    <p><%= lastComplaintCount %> <%= message %></p>
                                </div>
                            </div>
                            <div class="isdown-image-div">
                                <div class="isdown-frame-div">
                                    <img alt=<%= serviceModel.getImageFileName() %> src="images/<%= serviceModel.getImageFileName() %>">
                                </div>
                            </div>
                            <div style="text-align: center;" class="card-body">
                                <h5 class="card-title"><%= serviceModel.getName() %></h5>
                            </div>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
        <%@include file="components/commonscript.html" %>
    </body>
</html>