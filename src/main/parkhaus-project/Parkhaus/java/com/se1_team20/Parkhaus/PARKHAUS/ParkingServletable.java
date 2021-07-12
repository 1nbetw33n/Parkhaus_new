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
/*Architektur von Bella*/
package com.se1_team20.Parkhaus.PARKHAUS;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public interface ParkingServletable{
    /*
    * default implementation for getBody
     * since getBody is for all servlets the same, its enough to implement it here
     */
    static String getBody(HttpServletRequest request) throws IOException {
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
        return stringBuilder.toString();
    }
    //TODO: DELETE THIS METHOD HERE, BECAUSE INTELLIJ SAYS EVERYTHING WILL STILL WORK
    void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    //TODO: DELETE THIS METHOD HERE, BECAUSE INTELLIJ SAYS EVERYTHING WILL STILL WORK

    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    //TODO: DELETE THIS METHOD HERE, BECAUSE INTELLIJ SAYS EVERYTHING WILL STILL WORK
    ServletContext getContext();

    //TODO: DELETE THIS METHOD HERE, BECAUSE INTELLIJ SAYS EVERYTHING WILL STILL WORK
    void destroy();


}
