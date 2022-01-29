<%-- 
    Document   : index
    Created on : 09/01/2022, 13:52:48
    Author     : ricardo
--%>

<%@page import="Repository.UserRepository"%>
<%@page import="DTO.UserDTO"%>
<%@page import="Model.ServiceHistoryModel"%>
<%@page import="Model.ServiceModel"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    UserRepository userRepository = new UserRepository();
    List<UserModel> userModelList = userRepository.allModel();
%>

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
                    <li class="nav-item active">
                        <a class="nav-link" href="User">Usuários <span class="sr-only">(Página atual)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Service">Serviços</a>
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
            %>
                <div class="d-flex justify-content-center">
                    <div class="alert alert-primary w-25 p-3 d-flex justify-content-center" role="alert">
                        <%= (String) request.getAttribute("message") %>
                    </div>
                </div>
            <%
                }
            %>
            <div class="container">
                <a class="btn btn-success"><i class="fa fa-plus"></i> Novo </a>
                <br/>
                <br/>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Função</th>
                            <th scope="col">Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (UserModel userModel : userModelList) {%>
                        <tr>
                            <td>
                                <%= userModel.getId()%>
                            </td>
                            <td>
                                <%= userModel.getUsername() %>
                            </td>
                            <td>
                                <%= userModel.getRole().getName() %>
                            </td>
                            <td>
                                <a class="btn btn-outline-primary"><i class="fa fa-edit"></i> Editar </a>
                                <a class="btn btn-outline-danger"><i class="fa fa-trash"></i> Excluir </a>
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