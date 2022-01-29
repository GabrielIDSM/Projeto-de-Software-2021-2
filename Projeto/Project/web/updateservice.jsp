<%-- 
    Document   : updateservice
    Created on : 29/01/2022, 16:28:59
    Author     : Gabriel Inácio <gabrielinacio@id.uff.br>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
            <div class="container">
                <h3> Editar serviço </h3>
                <br/>
                <br/>
                <jsp:include page="components/serviceform.jsp" />
            </div>
        </div>
        <%@include file="components/commonscript.html" %>
    </body>
</html>
