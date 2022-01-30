<%-- 
    Document   : newimage
    Created on : 29/01/2022, 22:48:29
    Author     : Gabriel Inácio <gabrielinacio@id.uff.br>
--%>

<%@page import="Model.ServiceModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ServiceModel serviceModel = (ServiceModel) request.getAttribute("service");
%>

<!DOCTYPE html>
<html>
    <form method="POST" action="Service?a=image&id=<%= serviceModel.getId() %>&image=<%= serviceModel.getImageFileName() %>" enctype="multipart/form-data">

        <div class="mb-3">
            <label for="file"><b> Arquivo </b></label>
            <input type="file" class="form-control" name="file" id="file" required>
        </div>
        
        <button type="submit" class="btn btn-outline-primary"> Salvar </button>
        <a class="btn btn-outline-danger" href="Service"> Cancelar </a>
    </form>
</html>
