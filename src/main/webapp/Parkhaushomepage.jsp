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
  Time: 17:44
  To change this template use File | Settings | File Templates.

  Erstellt von Preet
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Parkhaus</title>
</head>
<body style="background-color: bisque">
<div style="text-align:center">
    <h1>Parkhaus Simulation</h1>

    <p>Bitte loggen Sie sich mit ihrem Hochschulaccount</p>
</div>

<div style="text-align:center">

    <img src="https://upload.wikimedia.org/wikipedia/commons/0/04/Zeichen_314-50_-_Parkhaus%2C_Parkgarage%2C_StVO_2017.svg" alt="Parkhaus_Logo" width="200" height="200">

    <form action="FirstpageServlet" method="post">

        <div style="text-indent:-100px">

            <label for="name">Benutzername:</label>
            <input type="text" size="20" maxlength="20" id="name" name="name" onvalid="alert('Fachbereichskürzel');" pattern="[a-z]{3,}2s" required/><br><br>

        </div>

        <div style="text-indent:-68px">

            <label for="pword">Password:</label>
            <input type="text" size="20" maxlength="20" id="pword" name="pword" onvalid="alert('Geben Sie bitte ein beantragtes Passwort');" pattern="[a-zA-Z0-9]{7}" required/><br><br>

        </div>

        <input type="submit" value="Login">

    </form>

</div>
</div>



</body>
</html>
