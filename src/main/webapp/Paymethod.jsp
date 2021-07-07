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
  Created by IntelliJ IDEA.
  User: multa
  Date: 01/07/2021
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Payment_Step1</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body style="background-color: bisque">
<div style="text-align:center">
    <h1>How would you like to pay?</h1>
</div>

<div style="text-align:center">


    <form action="PaymentServlet" method="post">

        <div style="margin-left:38%;">
            <div style="float:left;">

                <input type="radio" name="paymethod" value="paypal">
                <i class="fa fa-cc-paypal" style="font-size:48px;color:blue"></i><br>

                <input type="radio" name="paymethod" value="creditcard">
                <i class="fa fa-credit-card" style="font-size:48px;color:black"></i><br>

                <input type="submit" name="submit" value="Next">



            </div>
        </div>

    </form>

</div>
</div>



</body>
</html>
