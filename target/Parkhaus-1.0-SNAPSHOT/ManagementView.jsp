<%@ page import="com.se1_team20.Parkhaus.PARKHAUS.CarIF" %>
<%@ page import="java.util.ArrayList" %><%--
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
        <title>Management</title>
    </head>
    <body>
        <script>alert("Welcome you are logged in!")</script>
    </body>
    <body>
        <div align=com.se1_team20.Parkhaus.MANAGEMENT.ManagementServlet"center"></div>

        <table border = "1">
            <tr bgcolor="gray">
                <td> Parkticketnr.</td>
                <td>Kunde</td>
                <td> Parkdauer</td>
                <td> Ticketpreis</td>
            </tr>

            <% ServletContext sc = request.getServletContext(); %>
            <% ArrayList<CarIF> cars = (ArrayList<CarIF>) sc.getAttribute("cars"+ "Level1"); %>
            <%for(CarIF car: cars){%>
            <tr>
                <td><%=car.nr() %></td>
                <td><%=car.kunde() %></td>
                <td><%=car.duration() %></td>
                <td><%=car.kunde().equals("Firmenkunde")?0.0+"€":car.price() %></td>
            </tr>
            <% }%>

        </table>
    </body>

</html>
