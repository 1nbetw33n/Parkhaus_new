<%@ page import="com.se1_team20.Parkhaus.MANAGEMENT.ManagementModel" %>
<%@ page import="com.se1_team20.Parkhaus.PARKHAUS.CarIF" %>
<%@ page import="java.util.ArrayList" %>
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
  Date: 06/07/2021
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Overview</title>
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
      "plotBackgroundColor": null,
      "plotBorderWidth": null,
      "plotShadow": false,
      "type": "pie"
    },
    "title": {
      "text": "<%=title%>"
    },
    "tooltip": {
      "pointFormat": "{series.name}: <b>{point.percentage:.1f}%</b>"
    },
    "plotOptions": {
      "pie": {
        "allowPointSelect": true,
        "cursor": "pointer",
        "dataLabels": {
          "enabled": true,
          "format": "<b>{point.name}</b>: {point.percentage:.1f} %",
          "style": {
            "color": "black"
          }
        }
      }
    },
    "series": [
      {
        "name": "Customer-Type",
        "colorByPoint": true,
        "data": [
          {
            "name": "<%=name1%>",
            "y": <%=dataDisplay1%>,
            "sliced": true,
            "selected": true
          },
          {
            "name": "<%=name2%>",
            "y": <%=dataDisplay2%>
          },
          {
            "name": "<%=name3%>",
            "y": <%=dataDisplay3%>
          },
          {
            "name": "<%=name4%>",
            "y": <%=dataDisplay4%>
          }
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
<body>

</body>
</html>
