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
  ~  */
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
<%


    ServletContext sc = request.getServletContext();
    ArrayList<CarIF> cars = (ArrayList<CarIF>) sc.getAttribute("former-cars" + "Level1");
    ManagementModel mModel = new ManagementModel();

    if (cars == null) {
        PrintWriter writer = response.getWriter();
        writer.println("No Data could be found yet!");
    } else {

        String name1 = "Company";
        long data1 = 0;

        String name2 = "Day";
        long data2 = 0;

        String name3 = "Female";
        long data3 = 0;

        String name4 = "Handicapped";
        long data4 = 0;

        String title = "Share of customers who visited the garage.";

        data1 = mModel.filterAmountOfType(cars, "Company");
        String dataDisplay1 = Long.toString(data1);
        data2 = mModel.filterAmountOfType(cars, "Day");
        String dataDisplay2 = Long.toString(data2);
        data3 = mModel.filterAmountOfType(cars, "Female");
        String dataDisplay3 = Long.toString(data3);
        data4 = mModel.filterAmountOfType(cars, "Company");
        String dataDisplay4 = Long.toString(data4);

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
                "Handicapped",
                "May",
                "jun",
                "jul",
                "aug",
                "sep",
                "oct",
                "nov",
                "dec"
              ],
              "crosshair": true
            },
            "yAxis": {
              "min": 0,
              "title": {
                "text": "Duration (min)"
              }
            },
            "tooltip": {
                "headerFormat": "<span style="font-size:10px">{point.key}</span><table>",
                "pointFormat": "<tr><td style="color:{series.color};padding:0">{series.name}: </td><td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>",
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
                  49.9,
                  71.5,
                  106.4,
                  129.2,
                  144,
                  176,
                  135.6,
                  148.5,
                  216.4,
                  194.1,
                  95.6,
                  54.4
                ]
              },
              {
                "name": "Van",
                "data": [
                  83.6,
                  78.8,
                  98.5,
                  93.4,
                  106,
                  84.5,
                  105,
                  104.3,
                  91.2,
                  83.5,
                  106.6,
                  92.3
                ]
              },
              {
                "name": "SUV",
                "data": [
                  48.9,
                  38.8,
                  39.3,
                  41.4,
                  47,
                  48.3,
                  59,
                  59.6,
                  52.4,
                  65.2,
                  59.3,
                  51.2
                ]
              },
              {
                "name": "Motorcycle",
                "data": [
                  42.4,
                  33.2,
                  34.5,
                  39.7,
                  52.6,
                  75.5,
                  57.4,
                  60.4,
                  47.6,
                  39.1,
                  46.8,
                  51.1
                ]
              },
              {
                "name": "Complete",
                "data": [
                  1.0,
                  2.0,
                  3.0,
                  4.0,
                  5.0,
                  6.0,
                  7.0,
                  8.0,
                  9.0,
                  10.0,
                  11.0,
                  12.0
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
</body>
</html>
