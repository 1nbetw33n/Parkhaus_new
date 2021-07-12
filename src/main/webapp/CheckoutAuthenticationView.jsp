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

<%-- Erstellt von Bella und Rahgawi --%>

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
	<form id="CheckoutForm" name="loginForm" method="post" action="CheckoutServlet">
		<div id="enterLicensePlateDiv" class="paddingBtm">
			<span id="enteredTicketNrSpan">Enter Ticket Nr:</span>
			<label for="userInput"></label>
			<input id="userInput"
			       type="text"
			       name="entered_ticket_nr"
			       oninvalid="alert('Invalid Input')"
			       pattern="^([1-9]|[1-9][0-9]|100)$"
			       title="^([1-9][0-9]|100)$. For example: 99 or 7 or 43 or ..."
			       required
			/>
		</div>
		<div id="CheckoutBtnDiv">
			<input id="CheckoutBtnInput" type="submit" value="Checkout" />
		</div>
	</form>
</div>
</body>