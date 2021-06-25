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
  User: multa
  Date: 18/06/2021
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>

/*
 * TO DO:

*/
<%@ page import="com.se1_team20.Parkhaus" %>
<%@ page import="java.util.ArrayList" %>
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
                <td> Parkdauer</td>
                <td> Ticketpreis</td>
           </tr>

         <%-- Fetching the attributes of the request object
           which was previously set by the servlet
            "StudentServlet.java"
         --%>

         <% ArrayList<String>std= (ArrayList<String>)request.getAttribute("data");

            for(String s: std){%>
         <%-- Arranging data in tabular form
        --%>
         <tr>
                 <td><%=s.getTicketNr. %></td>
                 <td><%=s.getDuration %></td>
                 <td><%=s.getPrice %>%></td>
            </tr>
     </table>

  </body>
</html>
