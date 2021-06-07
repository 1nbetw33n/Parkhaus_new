/*
 *  copyright (c) 2021 se1_team20.
 *  Planet Earth, Milky Way, Virgo Supercluster.
 *  All rights reserved.
 *
 *  part of team20:
 *
 *  1nbetw33n
 *  Masternuss
 *  Preet149
 *  Rahgawi
 *
 * This software is the confidential and proprietary information of
 * se1_team20. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with
 * se1_team20.
 *
 */

package com.se1_team20.Parkhaus;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {

    /*
     *  Checkout Servlet soll:
     *  Checkout Klasse verwenden um eine Oberfläche anzuzeigen (im Browser -> index.jsp ruft dieses dann auf)
     *  Die Berechnungen finden in Checkout statt -> keine Berechnungen im Servlet - Lukas
     *
     *  Über ein Textfeld soll man die Nr. des Autos angeben, welches dann verlässt
     *  Danach soll man wieder beim ParkhausServlet ankommen - Lukas
     *
     *  TODO: Checkout Klasse implementieren
     *  TODO: doPost() und doGet()
     *  TODO: Texteingabe?
     *  TODO: Zurück zum ParkhausServlet?
     */

    final protected static String getBody(HttpServletRequest request) throws IOException {
        StringBuilder  stringBuilder  = new StringBuilder();
        BufferedReader bufferedReader = null;

        try{
            InputStream inStream = request.getInputStream();

            if (inStream != null){
                bufferedReader    = new BufferedReader(new InputStreamReader(inStream));
                char[] charBuffer = new char[128];
                int bytesRead        = -1;

                while ((bytesRead = bufferedReader.read(charBuffer)) > 0){
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }

            } else {
                stringBuilder.append("");
            }

        } catch (final IOException E) {
            E.printStackTrace();

        } finally {
            if (bufferedReader != null){
                bufferedReader.close();
            }
        }





}
