<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
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
  User: multa
  Date: 02/07/2021
  Time: 15:22
  To change this template use File | Settings |
  Erstellt von Preet
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

      <body>
                <% List<String> values= (ArrayList) request.getAttribute("parameter"); %>

                <% boolean isempty=true; %>

                <% for(int i=0;i<values.size();i++){ %>

                     <% if(values.get(i)!=null){ %>

                           <% isempty=false; %>
                     <% } %>
                <% } %>

          <div style="text-align: center;">

          <p>Hinweis: Klicken Sie bitte erneut auf den Button für die Aktualisieren der Parkplätze. </p>

              <table>

                <tr>
                     <% for(int i=0;i<values.size();i++){ %>

                         <% if(isempty){ %>

                             <td style="width: 50px" bgcolor="green"><%=i+1%></td>
                         <% }else{ %>

                                   <% if(values.get(i)!=null){ %>

                                           <% if(values.get(i).split(",")[0].equals("enter")){ %>

                                                  <% if(Integer.parseInt(values.get(i).split(",")[2])==i+1){ %>

                                                         <td style="width: 50px" bgcolor="red"><%=i+1%></td>

                                                  <% } %>

                                           <% }else{ %>

                                                 <% if(Integer.parseInt(values.get(i).split(",")[2])==i+1){ %>

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

                      <% for(int i=0;i< values.size();i++){ %>

                             <% if(isempty){ %>

                                   <td style="width: 50px"><%="id"%></td>

                            <% }else{ %>

                                <% if(values.get(i)!=null){ %>

                                    <% if(values.get(i).split(",")[0].equals("enter")){ %>

                                           <% if(Integer.parseInt(values.get(i).split(",")[2])==i+1){ %>

                                                 <td style="width: 50px"><%=Integer.parseInt(values.get(i).split(",")[1])%></td>

                                           <% } %>

                                     <% }else{ %>

                                             <% if(Integer.parseInt(values.get(i).split(",")[2])==i+1){ %>

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
