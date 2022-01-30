<%-- 
    Document   : session
    Created on : 29/01/2022, 12:05:24
    Author     : Gabriel Inácio <gabrielinacio@id.uff.br>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Model.UserModel"%>
<%
    UserModel user = (UserModel) session.getAttribute("user");
    
    if (user == null)
        response.sendRedirect("User?a=login");
%>