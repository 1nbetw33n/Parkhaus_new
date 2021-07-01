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
  --%>

<%--
1nbetw33n
29.Jun.2021
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<br>
<br>
<head>
	<title>Checkout Authentication</title>
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
	<h1>Checkout Authentication</h1>
	<form id="loginFormId" name="loginForm" method="post" action="CheckoutServlet">
		<div id="ticketNrDiv" class="paddingBtm">
			<span id="user">TicketNummer: </span><label for="userInput"></label><input id="userInput" type="text" name="username" />
		</div>
		<div id="loginBtn">
			<input id="Btn" type="submit" value="Login" />
		</div>
	</form>
</div>
</body>