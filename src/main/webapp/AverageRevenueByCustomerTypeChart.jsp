<%@ page import="java.util.List" %>
<%@ page import="com.se1_team20.Parkhaus.PARKHAUS.CarIF" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.se1_team20.Parkhaus.MANAGEMENT.ManagementModel" %><%--
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
09.Jul.2021
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<html>
	<head>
		<title>Total Daily Revenue</title>
	</head>
	<body>
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
			    final String TITLE = " Share of customers who visited the garage.";
			    final String HANDICAPPED = "Handicapped";
			    final String FEMALE = "Female";
			    final String COMPANY = "Company";
			    final String DAY = "Day";
			   String displayHandicappedData = "" + MODEL.filterRevenueByCustomer(vehiclesThatLeft, HANDICAPPED);
			   String displayFemaleData = "" + MODEL.filterRevenueByCustomer(vehiclesThatLeft, FEMALE);
			   String displayCompanyData = "" + MODEL.filterRevenueByCustomer(vehiclesThatLeft, COMPANY);
			   String displayDayData = "" + MODEL.filterRevenueByCustomer(vehiclesThatLeft, DAY);
		%>
		<script src='https://ccmjs.github.io/akless-components/highchart/versions/ccm.highchart-3.0.1.js'></script>
		<ccm-highchart-3-0-1
				key='{
							"settings":
								{
									"chart":
										{
											"plotBackgroundColor": null,
                                             "plotBorderWidth": null,
                                             "plotShadow": false,
                                             "type":"pie"
                                       }
                                   "title":
                                       {
                                           "text":"<%=TITLE%>"
                                       },
                                   "tooltip":
                                       {
                                           "pointFormat":"{series.name}: <b>{point.percentage:.1f}%</b>"
                                       },
                                   "plotOptions":
                                       {
                                           "pie":
                                               {
                                                   "allowPointSelect": true,
                                                   "cursor":"pointer",
                                                   "dataLabels":
                                                       {
                                                           "enabled": true,
                                                           "format":"<b>{point.name}</b>: {point.percentage:.1f} %",
                                                           "style":
                                                               {
                                                                   "color":"black"
                                                               }
                                                       }
                                               }
                                       },
                                   "series":
                                       [
                                           {
                                               "name":"Customer-Type",
                                               "colorByPoint": true,
                                               "data":
                                                   [
                                                       {
                                                           "name":"<%=HANDICAPPED%>",
                                                           "y":<%=displayHandicappedData%>,
                                                           "sliced": true,
                                                           "selected": true
                                                       },
                                                       {
                                                           "name":"<%=FEMALE%>",
                                                           "y":<%=displayFemaleData%>,
                                                       },
                                                       {
                                                           "name":"<%=COMPANY%>",
                                                           "y":<%=displayCompanyData%>,
                                                       }
                                                       {
                                                           "name":"<%=DAY%>",
                                                           "y":<%=displayDayData%>,
                                                       }
                                                   ]
                                           }
                                       ]
                                   }.
                               "data":{},
                               "html":
                                   {
                                       "id":"chart",
                                       "style":"%%"
                                   },
                               "style":"min-width: 400px; max-width: 800px; min-height: 400px; max-height: 800px; margin: 0 auto"
                       } '
		></ccm-highchart-3-0-1>
		<%}%>
	</body>
</html>

