<%-- Erstellt vom ganzen Team%--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>Tomcat Parkhaus 10.5.0</title>
</head>
<body>
<br>
<h1>Tomcat Parkhaus 10.5.0</h1>
<br>
<script src='https://ccmjs.github.io/mkaul-components/parkhaus/versions/ccm.parkhaus-10.5.0.js'></script>
	<ccm-parkhaus-10-5-0
		key='{
					    "name":"CarHome",
					    "server_url":"http://localhost:8080/Parkhaus_war_exploded/level1-servlet",
					    "client_categories":["Handicapped",
					                         "Female",
					                         "Day",
					                         "Company"
					                         ],
					    "vehicle_types":["SUV",
					    				 "Limousine",
					    				 "Motorcycle",
					    				 "Van"
					    				 ],

                        "price_factor":1, <%--Festlegung des Parkgebührs--%>

                        "max":10,  <%--Maximale Anzahl von Parkplätze.--%>

                       "open_from": 6,

                        "open_to": 24,

                        "delay": 100,

                        "simulation_speed": 10,

					    "extra_buttons":
					    [
					        {
					            "extra_class":"checkout",
					            "extra_inner":"CHECKOUT",
					            "extra_popup_title":"GO TO CHECKOUT"
					        },
					        {
					            "extra_class":"management",
					            "extra_inner":"MANAGEMENT",
					            "extra_popup_title":"GO TO MANAGEMENT VIEW"
					        },
					        {
					            "extra_class":"spaces",
					            "extra_inner":"Display free parking spaces",
					            "extra_popup_title":"GO TO PARKING SPACES VIEW"

					        }
					    ]
					   }'
		>
	</ccm-parkhaus-10-5-0>
</body>
</html>
