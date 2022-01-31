<%-- 
    Document   : service
    Created on : 30/01/2022, 01:50:11
    Author     : Gabriel Inácio <gabrielinacio@id.uff.br>
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="Model.ServiceHistoryModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Model.ServiceModel"%>
<%@page import="Model.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    ServiceModel service = (ServiceModel) request.getAttribute("service");
    UserModel user = (UserModel) session.getAttribute("user");
    
    Integer historyArrayCount = 0;
    Integer lastComplaintCount = 0;
    ServiceHistoryModel serviceHistoryLast = null;
    List<String> labelArray = new ArrayList<>();
    List<Integer> dataArray = new ArrayList<>();
    String serviceDivClass;
    String serviceChartColor;
    String serviceTextColor;
    String serviceMessage;
    
    if (!service.getHistoryList().isEmpty()) 
        historyArrayCount = service.getHistoryList().size();
    
    if (historyArrayCount > 0) {
        serviceHistoryLast = service.getHistoryList().get(service.getHistoryList().size() - 1);
        lastComplaintCount = serviceHistoryLast.getComplaints();
    }

    if (serviceHistoryLast != null) {
        if (historyArrayCount < 15) {
            for (int i = 0; i < (15 - historyArrayCount); i++) {
                labelArray.add("''");
                dataArray.add(0);
            }
            for (int i = (service.getHistoryList().size() - historyArrayCount); i < (service.getHistoryList().size()); i++) {
                labelArray.add("'" + dateFormat.format(service.getHistoryList().get(i).getCollectionTimestamp()) + "'");
                dataArray.add(service.getHistoryList().get(i).getComplaints());
            }
        } else {
            for (int i = (service.getHistoryList().size() - 15); i < (service.getHistoryList().size()); i++) {
                labelArray.add("'" + dateFormat.format(service.getHistoryList().get(i).getCollectionTimestamp()) + "'");
                dataArray.add(service.getHistoryList().get(i).getComplaints());
            }
        }
    }

    if (lastComplaintCount <= ServiceModel.NORMAL_THRESHOLD) { 
        serviceDivClass = "isdown-service-normal-div";
        serviceChartColor = "#008000";
        serviceTextColor = "#FFFFFF";
        serviceMessage = "O serviço está estável";
    } else if (lastComplaintCount <= ServiceModel.WARNING_THRESHOLD) {
        serviceDivClass = "isdown-service-warning-div";
        serviceChartColor = "#FFFF00";
        serviceTextColor = "#000000";
        serviceMessage = "O serviço pode apresentar problemas";
    } else if (lastComplaintCount <= ServiceModel.DANGER_THRESHOLD) {
        serviceDivClass = "isdown-service-danger-div";
        serviceChartColor = "#FFA500";
        serviceTextColor = "#000000";
        serviceMessage = "Algo está errado com o serviço";
    } else if (lastComplaintCount > ServiceModel.DANGER_THRESHOLD) {
        serviceDivClass = "isdown-service-down-div";
        serviceChartColor = "#FF0000";
        serviceTextColor = "#FFFFFF";
        serviceMessage = "O serviço está impactado";
    } else {
        serviceDivClass = "isdown-service-none-div";
        serviceChartColor = "#FFFFFF";
        serviceTextColor = "#000000";
        serviceMessage = "";
    }
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="FontAwesome/css/all.css">
        <link rel="stylesheet" href="styles/isdown.css">
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.js"></script>
        
        <script type="text/javascript">
            function drawChart() {
                var dataArray = <%= dataArray.toString() %>;
                var labelArray = <%= labelArray.toString() %>;
                
                new Chart('isdown-chart', {
                    type: 'bar',
                    data: {
                        labels: labelArray,
                        datasets: [{
                            label: 'Reclamações',
                            data: dataArray,
                            borderColor: '<%= serviceChartColor %>',
                            backgroundColor: '<%= serviceChartColor %>'
                        }]
                    },
                    options: {
                        interaction: {
                            intersect: false,
                            mode: 'index'
                        },
                        plugins: {
                            legend: {
                                labels: {
                                    usePointStyle: true
                                },
                                position: 'right',
                                align: 'start',
                                display: false
                            }
                        },
                        scales: {
                            x: {
                                ticks: {
                                    source: 'auto',
                                    maxRotation: 0,
                                    autoSkip: true
                                }
                            },
                            y: {
                                beginAtZero: true,
                                stacked: false
                            }
                        },
                        responsive: true,
                        fill: true,
                        radius: 0,
                        maintainAspectRatio: false
                    }
                });
            }
        </script>

        <title>Is Down ?</title>
    </head>
    <body onload="drawChart()">
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
                <h3><%= service.getName() %></h3>
                <br/>
                <br/>
                <div style="width: 100%; border-radius: 5px 5px 0 0; height: 50px; text-align: center; vertical-align: middle; color: <%= serviceTextColor %>; background-color: <%= serviceChartColor %>;">
                    <p style="font-size: 16pt; line-height: 50px;"><%= serviceMessage %></p>
                </div>
                <div class="isdown-chart-div <%= serviceDivClass %>">
                    <canvas class="isdown-chart-canvas" id="isdown-chart" ></canvas>
                </div>
            </div>
        </div>
        <%@include file="components/commonscript.html" %>
    </body>
</html>
