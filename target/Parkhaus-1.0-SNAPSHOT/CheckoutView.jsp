<%@ page import="com.se1_team20.Parkhaus.PARKHAUS.CarIF" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.se1_team20.Parkhaus.PARKHAUS.Level1Servlet" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.se1_team20.Parkhaus.CHECKOUT.CheckoutModel" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="com.se1_team20.Parkhaus.PARKHAUS.ParkingServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.se1_team20.Parkhaus.PARKHAUS.Car" %><%--
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
<%-- Erstellt von Bella und Rahgawi--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <br>
    <br>
    <title>Checkout</title>
    <br>
    <br>
    <head>
        <title>Checkout</title>
    </head>
    <%ServletContext context = request.getServletContext();%>
    <%CarIF checkedOutCar = (CarIF) context.getAttribute("checked_out_car");%>
    <%PrintWriter OUT = response.getWriter();%>
    <%OUT.println("<h1><center>Checkout</center></h1>");%>
    <%if (checkedOutCar == null) {OUT.println("<center>There is no car to checkout</center>");
          } else { %>
    <div align=com.se1_team20.Parkhaus.CHECKOUT.CheckoutServlet"center"></div>
    <table style="  width:300px" align="center" border="1">
        <tr bgcolor="purple" >
            <td><span style="color: white; "><b>LicensePlate</b></span></td>
            <td><span style="color: white; "><b>TicketNr</b></span></td>
            <td><span style="color: white; "><b>ParkingSpaceNumber</b></span></td>
            <td><span style="color: white; "><b>CustomerType</b></span></td>
            <td><span style="color: white; "><b>VehicleType</b></span></td>
            <td><span style="color: white; "><b>Duration</b></span></td>
            <td><span style="color: white; "><b>Price</b></span></td>
        </tr>
        <tr>
            <td><%= checkedOutCar.licensePlate()%></td>
            <td><%= checkedOutCar.nr()%></td>
            <td><%= checkedOutCar.space()%></td>
            <td><%= checkedOutCar.typeCar()%></td>
            <td><%= checkedOutCar.kunde()%></td>
            <td><%= checkedOutCar.duration() / 10000. + "s"%></td>
            <td><%= checkedOutCar.price() / 100. + ",-"%></td>
        </tr>
    <%}%>
    <body>
        <div style="text-align: center;">
            <form id="PaymentRedirectionFormID" name="PaymentRedirectionForm" method="post" action="PaymethodServlet">
                <div id="PaymentRedirectionDiv">
                    <input id="PaymentRedirectionButton" type="submit" value="Payment Methods"/>
                </div>
            </form>
        </div>
    </body>
</html>






