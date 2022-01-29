<%-- 
    Document   : login
    Created on : 29/01/2022, 11:55:35
    Author     : Gabriel Inácio <gabrielinacio@id.uff.br>
--%>

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
                        <a class="nav-link" href="User?a=login">Login<span class="sr-only">(Página atual)</span></a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="album py-5">
            <%                       
                if (request.getAttribute("message") != null) {
            %>
                <div class="d-flex justify-content-center">
                    <div class="alert alert-danger w-25 p-3 d-flex justify-content-center" role="alert">
                        <%= (String) request.getAttribute("message") %>
                    </div>
                </div>
            <%
                }
            %>
            <div class="container">
                <form method="POST" action="User?a=login">

                    <div class="form-group">
                        <label for="username"><b> Username </b></label>
                        <input type="text" class="form-control" name="username" id="username" autocomplete="off" required>
                    </div>

                    <div class="form-group">
                        <label for="password"><b> Senha </b></label>
                        <input type="password" class="form-control" name="password" id="password" autocomplete="off" required>
                    </div>
                    
                    <button type="submit" class="btn btn-outline-primary"><i class="fas fa-sign-in-alt"></i> Login </button>
                </form>
            </div>
        </div>
        <%@include file="components/commonscript.html" %>
    </body>
</html>