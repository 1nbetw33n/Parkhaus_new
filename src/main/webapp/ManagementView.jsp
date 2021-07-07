<%@ page import="com.se1_team20.Parkhaus.PARKHAUS.CarIF" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.se1_team20.Parkhaus.MANAGEMENT.ManagementModel" %><%--
  ~ /* copyright (c) 2021 se1_team20.
  ~  Planet Earth, Milky Way, Virgo Supercluster.
  ~  All rights reserved.
  ~
  ~  part of team20:
  ~
  ~  1nbetw33n
  ~  Masternuss
  ~  Preet149
  ~  Rahgawi
  ~
  ~ This software is the confidential and proprietary information of
  ~ se1_team20. ("Confidential Information"). You shall not disclose
  ~ such Confidential Information and shall use it only in accordance
  ~ with the terms of the license agreement you entered into with
  ~ se1_team20.
  ~  */
  --%>

<%--
  Created by IntelliJ IDEA.
  User: rahgawirajakumaraswamy
  Date: 27.06.21
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Management</title>
    <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('userInput, #passInput').click(function () {
                $("#errMsg").hide();
            });
        });
    </script>
    <div style="text-align: center;">
        <h1>Management</h1>
    </div>
    <style>
        .paddingBtm {
            padding-bottom: 12px;
        }
    </style>
</head>
<body>
<script>alert("Welcome you are logged in!")</script>
</body>
<body>

<body>
<div style="text-align: center;">
    <form id="chartFormId" name="chartForm" method="get" action="ManagementServlet">
        <button name="cmd" type="submit" value="chart1"/>
        Customer Overview</button>
        <button name="cmd" type="submit" value="chart2"/>
        Income Overview</button>
    </form>
</div>
</body>

<% ServletContext sc = request.getServletContext(); %>
<% ArrayList<CarIF> cars = (ArrayList<CarIF>) sc.getAttribute("former-cars" + "Level1");
    if (cars == null) {
        PrintWriter OUT = response.getWriter();
        OUT.println("Oops, no Cars left the Building yet!");
        OUT.println();
    } else { %>
<div align=com.se1_team20.Parkhaus.MANAGEMENT.ManagementServlet"center"></div>
<table style="  width:300px" align="center" border="1">
    <tr bgcolor="gray">
        <td> Ticket-Nr.</td>
        <td>Customer-Type</td>
        <td> Duration</td>
        <td> Ticket price</td>
        <td> Car-Type</td>
        <td> Parkingspace-Nr.</td>
    </tr>
    <% for(CarIF car : cars) {%>
    <tr>
        <td><%= car.nr() %></td>
        <td><%= car.kunde() %></td>
        <td><%= car.duration()/100 %></td>
        <td><%= car.price() %></td>
        <td><%= car.typeCar() %></td>
        <td><%= car.space() %></td>
    </tr>
        <%}
    }%>

</table>
</body>
</html>
