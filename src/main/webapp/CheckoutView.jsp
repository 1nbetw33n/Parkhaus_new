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
  ~  copyright (c) 2021 se1_team20.
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
--%>


<%--
  Created by IntelliJ IDEA.
  User: multa
  Date: 18/06/2021
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<br>
<br>
<title>Checkout</title>
<body>
<script>alert("This Button Works!")</script>
</body>
<body>

<div align=com.se1_team20.Parkhaus.CHECKOUT.CheckoutServlet"center"></div>
<table border = "1">
    <tr bgcolor="gray">
        <td> Parkticketnr.</td>
        <td>Kunde</td>
        <td> Parkdauer</td>
        <td> Ticketpreis</td>
    </tr>
    <% ServletContext sc = request.getServletContext(); %>
    <% ArrayList<CarIF> cars = (ArrayList<CarIF>) sc.getAttribute("carNrenter"+ "Level1"); %>
    <%for(CarIF car: cars){%>
    <tr>
        <td><%=car.nr() %></td>
        <td><%=car.kunde() %></td>
        <td><%=car.duration() %></td>
        <td><%=car.kunde().equals("Company")?0.0+"€":car.price() %></td>
    </tr>
    <% }%>

</table>

</body>
</html>

<%--

 * TO DO:


--%>

<%--
<%@ page import="com.se1_team20.Parkhaus" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.ServletContext" %>
<%@ page import="com.se1_team20.Parkhaus.PARKHAUS.CarIF" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Checkout</title>
    </head>
  <body>

  <div align=com.se1_team20.Parkhaus.CheckoutServlet"center"></div>
     <table border="1">
           <tr bgcolor="gray">
                <td> Parkticketnr.</td>
                <td>Kunde</td>
                <td> Parkdauer</td>
                <td> Ticketpreis</td>
           </tr>

         &lt;%&ndash; Fetching the attributes of the request object
           which was previously set by the servlet
            "StudentServlet.java"
         &ndash;%&gt;
         <% ServletContext sc = request.getServletContext(); %>
         <% ArrayList<CarIF> cars = (ArrayList<CarIF>) sc.getAttribute("cars"+ "Level1"); %>
         <% ArrayList<String>std= (ArrayList<String>)request.getAttribute("data");

            for(CarIF car: cars){%>
         &lt;%&ndash; Arranging data in tabular form
        &ndash;%&gt;
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
--%>


