/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.tour.management_Handle_API;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import project.tour.management_API.APIRequester;
import project.tour.management_DTO.User_DTO;

import javax.swing.*;

/**
 *
 * @author DELL
 */
public class Handle_API_Login {
    
    public static Object Login(String parameter, String endpoint, String token){
        JSONParser parser = new JSONParser();
            JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.sendPOST(parameter, endpoint, token));

            if(myObject.get("ApiErr") == null) {
                JSONObject data = (JSONObject) myObject.get("data");

                JSONObject userRepsonse = (JSONObject) data.get("userResponse");
                User_DTO user = new User_DTO();
                user.setToken(data.get("token").toString());
                user.setEmail(userRepsonse.get("email").toString());
                user.setLastName(userRepsonse.get("lastName").toString());
                user.setFirstName(userRepsonse.get("firstName").toString());
                user.setPhoneNumber(userRepsonse.get("phoneNumber").toString());
            } else {
                JOptionPane.showMessageDialog(null,"Error: "+ myObject.get("ApiErr").toString());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
