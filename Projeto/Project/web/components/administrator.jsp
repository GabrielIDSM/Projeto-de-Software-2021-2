<%-- 
    Document   : administrator
    Created on : 30/01/2022, 11:47:55
    Author     : Gabriel Inácio <gabrielinacio@id.uff.br>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Model.UserModel"%>
<%
    UserModel administrator = (UserModel) session.getAttribute("user");
    
    if (administrator == null)
        response.sendRedirect("User?a=login");
    else
        if (administrator.getRole().getName().compareTo("Administrator") != 0)
            response.sendRedirect("index.jsp");
%>