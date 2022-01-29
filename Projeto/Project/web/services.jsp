<%-- 
    Document   : index
    Created on : 09/01/2022, 13:52:48
    Author     : ricardo
--%>

<%@page import="Model.ServiceHistoryModel"%>
<%@page import="Model.ServiceModel"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Repository.ServiceRepository"%>
<%@page import="Model.ServiceModel"%>

<%
    ServiceRepository serviceRepository = new ServiceRepository();
    List<ServiceModel> serviceModelList = serviceRepository.allModel();
%>

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
        <%@include file="components/session.jsp" %>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="index.jsp">Is Down ?</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Alterna navegação">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Página Inicial</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="User">Usuários</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="Service">Serviços <span class="sr-only">(Página atual)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="User?a=logout">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="album py-5">
            <%                       
                if (request.getAttribute("message") != null) {
                    if (!request.getAttribute("message").equals("")) {
            %>
                        <div class="d-flex justify-content-center">
                            <div class="alert w-25 p-3 d-flex justify-content-center" role="alert">
                                <%= (String) request.getAttribute("message") %>
                            </div>
                        </div>
            <%
                    }
                }
            %>
            <div class="container">
                <a class="btn btn-success" href="Service?a=create"><i class="fa fa-plus"></i> Novo </a>
                <br/>
                <br/>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (ServiceModel serviceModel : serviceModelList) {%>
                        <tr>
                            <td><%= serviceModel.getId()%></td>
                            <td><%= serviceModel.getName()%></td>
                            <td>
                                <a class="btn btn-outline-success"><i class="fa fa-eye"></i> Visualizar </a>
                                <a class="btn btn-outline-primary" href="Service?a=update&id=<%= serviceModel.getId() %>"><i class="fa fa-edit"></i> Editar </a>
                                <a class="btn btn-outline-danger" href="Service?a=delete&id=<%= serviceModel.getId() %>"><i class="fa fa-trash"></i> Excluir </a>
                            </td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="components/commonscript.html" %>
    </body>
</html>