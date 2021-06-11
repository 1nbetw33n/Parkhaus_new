<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<br>
	<br>
	<head>
		<title> Management Authentication</title>
		<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function () {
			    $('userInput, #passInput').click(function (){
			        $("#errMsg").hide();
			    });
			});
		</script>
		<style>
			.paddingBtm{
				padding-bottom: 12px;
			}
		</style>
	</head>
	<body>
		<center>
			<h1>Management Authentication</h1>
			<form id="loginFormId" name="loginForm" method="post" action="ManagementServlet">
				<div id="usernameDiv" class="paddingBtm">
					<span id="user">Username: </span><label for="userInput"></label><input id="userInput" type="text" name="username" />
				</div>
				<div id="passwordDiv" class="paddingBtm">
					<span id="pass">Password: </span><label for="passInput"></label><input id="passInput" type="password" name="password" />
				</div>
				<div id="loginBtn">
					<input id="Btn" type="submit" value="Login" />
				</div>
			</form>
		</center>
	</body>

	<head>
		<title>Tomcat Parkhaus 9.1.9</title>
	</head>
	<body>
	<br>
		<h1>Tomcat Parkhaus 9.1.9</h1>
	<br>
		<script src='https://ccmjs.github.io/mkaul-components/parkhaus/versions/ccm.parkhaus-9.1.9.js'></script>
			<ccm-parkhaus-9-1-9
                key='{
					    "name":"CarHome",
					    "server_url":"http://localhost:8080/Parkhaus_war_exploded/level1-servlet",
					    "extra_buttons":[
					        {
					            "extra_class":"checkout",
					            "extra_inner":"CHECKOUT",
					            "extra_popup_title":"GO TO CHECKOUT"
					        },
						    {
							    "extra_class":"total_revenue",
							    "extra_inner":"Total Revenue",
							    "extra_popup_title":"Total revenue"
						    },
						    {
							    "extra_class":"average_revenue",
							    "extra_inner":"Average Revenue",
							    "extra_popup_title":"Average revenue per car"
						    },
						    {
						        "extra_class":"total_cars",
							    "extra_inner":"Total Cars",
							    "extra_popup_title":"How many cars visited the Parkhaus"
							},
							{
							    "extra_class":"get_bill",
							    "extra_inner":"Your Bill",
							    "extra_popup_title":"Show hwo much you have to pay"
							}
					    ],
					    "extra_charts":[
					        {
					            "extra_class":"my_chart",
					            "extra_inner":"My Chart",
					            "extra_popup_title":"Show my Chart"
					        }
					    ]
	                }
				'>
		</ccm-parkhaus-9-1-9>
	</body>
</html>

