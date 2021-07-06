<%@ page import="java.security.SecureRandom" %><%--
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
  Date: 02/07/2021
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

      <body>
                <% String[]values=(String[])request.getAttribute("parameter"); %>

                <% boolean isempty=true; %>

                <% for(int i=0;i<10;i++){ %>

                     <% if(values[i]!=null){ %>

                           <% isempty=false; %>
                     <% } %>
                <% } %>

          <div style="text-align: center;">

              <table>

                <tr>
                     <% for(int i=0;i<10;i++){ %>

                         <% if(isempty){ %>

                             <td style="width: 50px" bgcolor="green"><%=i+1%></td>
                         <% }else{ %>

                                   <% if(values[i]!=null){ %>

                                           <% if(values[i].split(",")[0].equals("enter")){ %>

                                                  <% if(Integer.parseInt(values[i].split(",")[2])==i+1){ %>

                                                         <td style="width: 50px" bgcolor="red"><%=i+1%></td>

                                                  <% } %>

                                           <% }else{ %>

                                                 <% if(Integer.parseInt(values[i].split(",")[2])==i+1){ %>

                                                         <td style="width: 50px" bgcolor="green"><%=i+1%></td>

                                                  <% } %>

                                           <% } %>
                                   <% }else{ %>

                                              <td style="width: 50px" bgcolor="green"><%=i+1%></td>
                                  <% } %>
                         <% } %>
                     <% } %>

                </tr>

                <tr>

                      <% for(int i=0;i<10;i++){ %>

                          <% if(isempty){ %>

                              <td style="width: 50px"><%="id"%></td>

                          <% }else{ %>

                                <% if(values[i]!=null){ %>

                                    <% if(values[i].split(",")[0].equals("enter")){ %>

                                           <% if(Integer.parseInt(values[i].split(",")[2])==i+1){ %>

                                                        <td style="width: 50px"><%=Integer.parseInt(values[i].split(",")[1])%></td>

                                           <% } %>

                                     <% }else{ %>

                                             <% if(Integer.parseInt(values[i].split(",")[2])==i+1){ %>

                                                   <td style="width: 50px" ><%= "id" %></td>

                                              <% } %>

                                   <% } %>
                          <% }else{ %>

                                <td style="width: 50px"><%="id"%></td>
                             <% } %>
                        <% } %>
                    <% } %>

                </tr>

              </table>


        </div>
    </body>
</html>
