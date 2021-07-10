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
<head>
    <title>Payment_Step2</title>
</head>
<body style="background-color:yellow">
<div style="text-align:center">
    <h1>Geben Sie bitte die Email Adresse und das Passwort ein </h1>
</div>

<div style="text-align:center">

    <img src="https://www.paypalobjects.com/webstatic/en_US/i/buttons/PP_logo_h_200x51.png" alt="PayPal" />
    <form>

        <div style="margin-left:38%;">
            <div style="float:left;">
                <label style="display:block; line-height:24px;">Email Adresse</label>
                <label style="display:block; line-height:24px;">Passwort</label>

            </div>
            <input style="display:block;" type="text" size="30" maxlength="30" name="mail" oninvalid="alert('Not a valid mail adress');" name="fname" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" />
            <input style="display:block;" type="password" size="30" maxlength="30" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" />
            <input style="display:block;" type="submit" name="formaction" value="Pay" />
        </div>

    </form>

</div>
</div>



</body>
</html>
