<%@ page import="com.se1_team20.Parkhaus.PARKHAUS.CarIF" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.se1_team20.Parkhaus.MANAGEMENT.ManagementModel" %>
<%@ page import="java.util.List" %><%--
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
1nbetw33n
10.Jul.2021
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<html>
	<head>
		<title>Total Daily Revenue</title>
	</head>
	<body>
		<div style="text-align: center;">
			<button onclick="window.history.back()">Go Back</button>
		</div>
		<%
			ServletContext context = request.getServletContext();
			@SuppressWarnings("unchecked")
			List<CarIF> vehiclesThatLeft = (List<CarIF>)  context.getAttribute("former-cars" + "Level1");
			final ManagementModel MODEL = new ManagementModel();
			if (vehiclesThatLeft == null)
			{
				final PrintWriter OUT = response.getWriter();
				OUT.println("<center>There's no data to display. </center>");
			}
			else
			{
				final String TITLE = "Daily Total Revenue per Vehicle";
				final String SUV = "SUV";
				final String LIMOUSINE = "Limousine";
				final String MOTORCYCLE = "Motorcycle";
				final String VAN = "Van";
				final double SUVData = (MODEL.filterRevenueByVehicle(vehiclesThatLeft, SUV) / 100.); //QUICK FIX, TO DISPLAY THE DATA UNIFORMLY
				final double limousineData = MODEL.filterRevenueByVehicle(vehiclesThatLeft, LIMOUSINE) / 100.;
				final double motorcycleData = MODEL.filterRevenueByVehicle(vehiclesThatLeft, MOTORCYCLE) / 100.;
				final double vanData = MODEL.filterRevenueByVehicle(vehiclesThatLeft, VAN) / 100.;
				String displaySUVData = "" + SUVData;
				String displayLimousineData = "" + limousineData ;
				String displayMotorcycleData = "" + motorcycleData;
				String displayVanData = "" + vanData;
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
      "text": "<%=TITLE%>"
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
        "name": "Vehicle-Type",
        "colorByPoint": true,
        "data": [
          {
            "name": "<%=SUV%>",
            "y": <%=displaySUVData%>,
            "sliced": true,
            "selected": true
          },
          {
            "name": "<%=LIMOUSINE%>",
            "y": <%=displayLimousineData%>
          },
          {
            "name": "<%=MOTORCYCLE%>",
            "y": <%=displayMotorcycleData%>
          },
          {
            "name": "<%=VAN%>",
            "y": <%=displayVanData%>
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
		<%-- LOWER BAR CHART --%>
		<ccm-highchart-3-0-1
				key='{
          "settings": {
            "chart": {
              "type": "column"
            },
            "title": {
              "text": ""
            },
            "subtitle": {
              "text": ""
            },
            "xAxis": {
              "categories": [
                ""
                ],
              "crosshair": true
            },
            "yAxis": {
              "min": 0,
              "title": {
                "text": ""
              }
            },
            "tooltip": {
                "headerFormat": "<span style="font-size:10px">{point.key}</span><table>",
                "pointFormat": "<tr><td style="color:{series.color};padding:0">{series.name}: </td><td style="padding:0"><b>{point.y:.1f} ,- </b></td></tr>",
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
                "name":"<%=SUV%>",
                "data":[
					<%=displaySUVData%>
				]
              },
              {
                "name": "<%=LIMOUSINE%>",
                "data":  [
					<%=displayLimousineData%>
				]
              },
              {
                "name": "<%=MOTORCYCLE%>",
                "data": [
					<%=displayMotorcycleData%>
				]
              },
              {
                "name": "<%=VAN%>",
                "data": [
					<%=displayVanData%>
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