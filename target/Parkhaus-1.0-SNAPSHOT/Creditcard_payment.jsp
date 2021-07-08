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
  Date: 30/06/2021
  Time: 12:53
  To change this template use File | Settings | File Templates.

   Erstellt von Preet

--%>
<!DOCTYPE html>
<html>
<body style="background-color: bisque">
<head>
    <title>Payment Step2</title>
</head>

<div style="text-align:center">
    <h1>Geben Sie bitte ihren Bankdaten ein</h1>
</div>

<div style="text-align:center">

    <a href="http://www.credit-card-logos.com/"><img alt="Credit Card Logos" title="Credit Card Logos" src="http://www.credit-card-logos.com/images/multiple_credit-card-logos-1/credit_card_logos_8.gif" width="251" height="50" border="0" /></a>


    <form action="LastpageServlet" method="post">
        <label for="cname">Kreditkarteninhalter:</label>
        <input type="text" id="cname" name="cname" size="30" maxlength="30" pattern="[A-Za-zäöü\s]{3,}" title="Invalid input" placeholder="Kreditkarteninhalter/-in" required><br><br>

        <div style="text-indent:-4px">
            <label for="cnumber">Kreditkartennummer:</label>
            <input type="password" id="cnumber" name="cnumber" size="30" maxlength="30" oninvalid="alert('The credit card number must have 16 digits'); "pattern="[0-9]{16}" title="Invalid account number" placeholder="Kreditkartennummer" required><br><br>

        </div>

        <div style="text-indent:-102px">
            <label for="cvc">CVC_Code:</label>
            <input type="password" id="cvc" name="cvc" size="5" max="5" oninvalid="alert('The CVC_Code must have 3 digits'); "pattern="[0-9]{3}" title="Invalid cvc_code" placeholder="CVC" required ><br><br>

        </div>

        <div style="text-indent:-102px">
            <label for="date">Expiry date:</label>
            <input type="text" id="date" name="date" size="5" maxlength="5" pattern="^(0[1-9]|1[0-2])\/?([0-9]{2})$" title="Invalid date" placeholder="MM/YY" required ><br><br>

        </div>

        <div style="text-indent:150px">
            <label for="email">E-Mail:</label>
            <input type="text" id="email" name="email" size="40" maxlength="40" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Not a valid mail adress" placeholder="mail" required><br><br>

        </div>

        <input type="submit" value="Pay">
    </form>

</div>

</body>
</html>