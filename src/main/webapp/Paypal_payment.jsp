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
   Erstellt von Preet
  --%>

<%--
  Created by IntelliJ IDEA.
  User: multa
  Date: 30/06/2021
  Time: 15:42
  To change this template use File | Settings | File Templates.
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

    <img src="https://www.paypalobjects.com/webstatic/en_US/i/buttons/PP_logo_h_200x51.png" alt="PayPal" />


    <form action="LastpageServlet" method="post">

        <div style="text-indent:50px">
            <label for="mail">E-Mail:</label>
            <input type="text" id="mail" name="mail" size="40" maxlength="40" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Invalid mail" placeholder="Enter your email address" required><br><br>

        </div>

        <div style="text-indent:-30px">
            <label for="pword">Password:</label>
            <input type="password" id="pword" name="pword" size="30" maxlength="30" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Invalid password" placeholder="Enter password" required><br><br>

        </div>



        <input type="submit" value="Pay">
    </form>

</div>

</body>
</html>

