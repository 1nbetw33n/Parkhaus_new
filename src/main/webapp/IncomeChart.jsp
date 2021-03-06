<%@ page import="com.se1_team20.Parkhaus.PARKHAUS.CarIF" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.se1_team20.Parkhaus.MANAGEMENT.ManagementModel" %>
<%@ page import="java.io.PrintWriter" %><%--
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
  ~
  ~  Erstellt von Lukas

  --%>

<%--
  Created by IntelliJ IDEA.
  User: busse
  Date: 07/07/2021
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Income Overview</title>
</head>
<body>
<script>
    function goBack() {
        window.history.back();
    }
</script>
<%


    ServletContext sc = request.getServletContext();
    @SuppressWarnings("unchecked")
    ArrayList<CarIF> cars = (ArrayList<CarIF>) sc.getAttribute("former-cars" + "Level1");
    ManagementModel mModel = new ManagementModel();

    if (cars == null) {
        PrintWriter writer = response.getWriter();
        writer.println("former_cars is null somehow!");
    } else {

        double limoDay = mModel.filterDurationCustomerCar(cars,"Day","Limousine")/10000.;
        double limoHandi = mModel.filterDurationCustomerCar(cars,"Handicapped","Limousine")/10000.;
        double limoFem = mModel.filterDurationCustomerCar(cars,"Female","Limousine")/10000.;
        double limoCom = mModel.filterDurationCustomerCar(cars,"Company","Limousine")/10000.;

        double suvDay = mModel.filterDurationCustomerCar(cars,"Day","SUV")/10000.;
        double suvHandi = mModel.filterDurationCustomerCar(cars,"Handicapped","SUV")/10000.;
        double suvFem = mModel.filterDurationCustomerCar(cars,"Female","SUV")/10000.;
        double suvCom = mModel.filterDurationCustomerCar(cars,"Company","SUV")/10000.;

        double motoDay = mModel.filterDurationCustomerCar(cars,"Day","Motorcycle")/10000.;
        double motoHandi = mModel.filterDurationCustomerCar(cars,"Handicapped","Motorcycle")/10000.;
        double motoFem = mModel.filterDurationCustomerCar(cars,"Female","Motorcycle")/10000.;
        double motoCom = mModel.filterDurationCustomerCar(cars,"Company","Motorcycle")/10000.;

        double vanDay = mModel.filterDurationCustomerCar(cars,"Day","Van")/10000.;
        double vanHandi = mModel.filterDurationCustomerCar(cars,"Handicapped","Van")/10000.;
        double vanFem = mModel.filterDurationCustomerCar(cars,"Female","Van")/10000.;
        double vanCom = mModel.filterDurationCustomerCar(cars,"Company","Van")/10000.;

        double completeDay = limoDay + suvDay + motoDay + vanDay;
        double completeHandi = limoHandi + suvHandi + motoHandi + vanHandi;
        double completeFem = limoFem + suvFem + motoFem + vanFem;
        double completeCom = limoCom + suvCom + motoCom + vanCom;


%>
<script src='https://ccmjs.github.io/akless-components/highchart/versions/ccm.highchart-3.0.1.js'></script>
<ccm-highchart-3-0-1
        key='{
          "settings": {
            "chart": {
              "type": "column"
            },
            "title": {
              "text": "Duration from Customers"
            },
            "subtitle": {
              "text": "Sorted by Customer-/Car-Type"
            },
            "xAxis": {
              "categories": [
                "Day",
                "Company",
                "Female",
                "Handicapped"
                ],
              "crosshair": true
            },
            "yAxis": {
              "min": 0,
              "title": {
                "text": "Duration (sec)"
              }
            },
            "tooltip": {
                "headerFormat": "<span style="font-size:10px">{point.key}</span><table>",
                "pointFormat": "<tr><td style="color:{series.color};padding:0">{series.name}: </td><td style="padding:0"><b>{point.y:.1f} sec</b></td></tr>",
                "footerFormat": "</table>",
                "shared": true,
                "useHTML": true
            },
            "plotOptions": {
              "column": {
                "pointPadding": 0.2,
                "borderWidth": 0
              }
            },
            "series": [
              {
                "name": "Limousine",
                "data": [
                  <%=limoDay%>,
                  <%=limoCom%>,
                  <%=limoFem%>,
                  <%=limoHandi%>
                ]
              },
              {
                "name": "Van",
                "data": [
                  <%=vanDay%>,
                  <%=vanCom%>,
                  <%=vanFem%>,
                  <%=vanHandi%>
                ]
              },
              {
                "name": "SUV",
                "data": [
                  <%=suvDay%>,
                  <%=suvCom%>,
                  <%=suvFem%>,
                  <%=suvHandi%>
                ]
              },
              {
                "name": "Motorcycle",
                "data": [
                  <%=motoDay%>,
                  <%=motoCom%>,
                  <%=motoFem%>,
                  <%=motoHandi%>
                ]
              },
              {
                "name": "Complete",
                "data": [
                  <%=completeDay%>,
                  <%=completeCom%>,
                  <%=completeFem%>,
                  <%=completeHandi%>
                  ]
                }
            ]
          },
          "data": {},
          "html": {
            "id": "chart",
            "style": "%%"
          },
          "style": "min-width: 400px; max-width: 800px; min-height: 400px; max-height: 800px; margin: 0 auto"
        }'
></ccm-highchart-3-0-1>
<%}%>
<br>
<div style="text-align: center;">
    <button onclick="goBack()">Go Back</button>
</div>

</body>
</html>
