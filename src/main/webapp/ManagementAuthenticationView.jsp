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
   Erstellt von Bella und Rahgawi
  --%>

<%--
  Created by IntelliJ IDEA.
  User: 1nbetw33n
  Date: 28/06/2021
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
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
	<div style="text-align: center;">
		<h1>Management Authentication</h1>
		<form id="loginFormId" name="loginForm" method="post" action="ManagementServlet">
			<div id="usernameDiv" class="paddingBtm">
				<span id="user">Username: </span>
				<label for="userInput"></label>
				<input id="userInput"
				       type="text"
				       name="username"
				       oninvalid="alert('Invalid Input')"
				       pattern="^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$"
				       title="^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$"
				       required
				/>
			</div>
			<div id="passwordDiv" class="paddingBtm">
				<span id="pass">Password: </span>
				<label for="passInput"></label>
				<input id="passInput"
				       type="password"
				       name="password"
				       oninvalid="alert('Invalid Input')"
				       pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"
				       title="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"
				       required
				/>
			</div>
			<div id="loginBtn">
				<input id="Btn" type="submit" value="Login" />
			</div>
		</form>
	</div>
</body>
