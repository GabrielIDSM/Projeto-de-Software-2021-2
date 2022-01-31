<%-- 
    Document   : services
    Created on : 31/01/2022, 10:34:22
    Author     : Gabriel Inácio <gabrielinacio@id.uff.br>
--%>

<%@page import="Model.ServiceModel"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Model.UserModel"%>
<%
    List<ServiceModel> services = (List<ServiceModel>) request.getAttribute("services");

    if (services == null)
        response.sendRedirect("Service?a=load");
%>