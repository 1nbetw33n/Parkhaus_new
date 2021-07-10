<%@ page import="com.se1_team20.Parkhaus.PARKHAUS.CarIF" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.se1_team20.Parkhaus.MANAGEMENT.ManagementModel" %>
<%--
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

  Erstellt von Rahgawi und bearbeitet Lukas
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title> Management</title>
    <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>

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
<script>
    alert("Welcome you are logged in!")

    function showTotalCars(elem) {
        if (document.getElementById(elem).style.display == "block") {
            document.getElementById(elem).style.display = "none";
        } else {
            document.getElementById(elem).style.display = "block";
        }
    }
</script>

<% ServletContext sc = request.getServletContext();


    int total_cars = (sc.getAttribute("total_cars") == null) ? 0 : (int) sc.getAttribute("total_cars");
    ArrayList<CarIF> former_cars = (ArrayList<CarIF>) sc.getAttribute("former-cars" + "Level1");
    int former_cars_size = 0;
    if (former_cars != null) former_cars_size = former_cars.size();
    double total_revenue = sc.getAttribute("total_revenue") == null ?  0.0 : (double) sc.getAttribute("total_revenue");
    double average_revenue = sc.getAttribute("average_revenue") == null ?  0.0 : (double) sc.getAttribute("average_revenue");


%>

<%--<div id="tot_revenue_div" style="margin-left: 20%">--%>
<%--    <div id="div1" style="float:left">--%>
<%--        <button margin: auto auto 0 float: left  type="button" value="total_revenue"--%>
<%--        onclick="showTotalCars()"/>--%>
<%--        Total Revenue</button>--%>
<%--    </div>--%>
<%--    <div id="total_cars_div" style="float:left">--%>
<%--        <p> <%=total_cars%> </p>--%>
<%--    </div>--%>
<%--</div>--%>


<div style="text-align: center;">
    <form id="buttonFormId" name="buttonForm" method="get" action="ManagementServlet">
        <button type="button" value="total_revenue" onclick="showTotalCars('total_revenue_div')"/>
        <div id="total_revenue_div" style="display: none;">
            <p><%=total_revenue + ",-"%>
            </p>
        </div>
        Total Revenue</button>

        <button type="button" value="total_revenue" onclick="showTotalCars('average_revenue_div')"/>
        <div id="average_revenue_div" style="display: none;">
            <p><%=average_revenue + ",-"%>
            </p>
        </div>
        Average Revenue</button>

        <button type="button" value="total_revenue" onclick="showTotalCars('total_cars_div')"/>
        <div id="total_cars_div" style="display: none;">
            <p><%=total_cars%>
            </p>
        </div>
        Current Cars</button>

        <button type="button" value="total_revenue" onclick="showTotalCars('former_cars_div')"/>
        <div id="former_cars_div" style="display: none;">
            <p><%=former_cars_size%>
            </p>
        </div>
        Former Cars</button>
    </form>
</div>

<div style="text-align: center;">
    <form id="chartFormId" name="chartForm" method="get" action="ManagementServlet">
        <button name="cmd" type="submit" value="customer_chart"/>
        Customer Overview</button>
        <button name="cmd" type="submit" value="income_chart"/>
        Income Overview (Duration Overview?)</button>
        <button name="cmd" type="submit" value="revenue_chart_customer"/>
        Revenue Overview by Customer</button>
        <button name="cmd" type="submit" value="revenue_chart_vehicle"/>
        Revenue Overview by Vehicle</button>
    </form>
</div>


<% if (former_cars == null) {
    PrintWriter OUT = response.getWriter();
    OUT.println("Oops, no Cars left the Building yet!");
    OUT.println();
} else { %>
<div align=com.se1_team20.Parkhaus.MANAGEMENT.ManagementServlet"center"></div>
<table style="  width:300px" align="center" border="1">
    <tr bgcolor="gray">
        <th> Ticket Nr.</th>
        <th>Customer Type</th>
        <th> Duration</th>
        <th> Ticket price</th>
        <th> Car Type</th>
        <th> Parkingspace Nr.</th>
    </tr>
    <% for (CarIF car : former_cars) {%>
    <tr>
        <td><%= car.nr() %>
        </td>
        <td><%= car.kunde() %>
        </td>
        <td><%= car.duration() / 10000. + "s" %>
        </td>
        <td><%= (car.price() / 100.) + ",-"%>
        </td>
        <td><%= car.typeCar() %>
        </td>
        <td><%= car.space() %>
        </td>
    </tr>
    <%
            }
        }
    %>

</table>
</body>
</html>
