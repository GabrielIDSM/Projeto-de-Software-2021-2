<%-- 
    Document   : serviceform
    Created on : 29/01/2022, 14:47:33
    Author     : Gabriel Inácio <gabrielinacio@id.uff.br>
--%>

<%@page import="Model.ServiceModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ServiceModel serviceModel = (ServiceModel) request.getAttribute("service");
%>

<!DOCTYPE html>
<div class="container">
    <form method="POST" action="Service?a=submit">
        <input type="hidden" name="id" id="id" value="<%= serviceModel.getId() %>">
        
        <div class="form-group">
            <label for="name"><b> Nome </b></label>
            <input type="text" class="form-control" name="name" id="name" value="<%= serviceModel.getName() %>" autocomplete="off" required>
        </div>

        <div class="form-group">
            <label for="query"><b> Query </b></label>
            <input type="text" class="form-control" name="query" id="query" value='<%= serviceModel.getQuery() %>' autocomplete="off" required>
        </div>

        <div class="form-group">
            <label for="image"><b> Imagem </b></label>
            <input type="text" class="form-control" name="image" id="image" value="<%= serviceModel.getImageFileName() %>" autocomplete="off" required>
        </div>
        
        <button type="submit" class="btn btn-outline-primary"> Salvar </button>
        <a class="btn btn-outline-danger" href="Service"> Cancelar </a>
    </form>
</div>