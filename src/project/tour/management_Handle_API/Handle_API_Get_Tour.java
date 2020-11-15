/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.tour.management_Handle_API;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
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
public class Handle_API_Get_Tour {
    
    public static JSONArray Fetch_API_Tour(String endpoint, String token){
        JSONParser parser = new JSONParser();
            JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.fetchAPI(endpoint, token));

            JSONObject data = (JSONObject) myObject.get("data");
            if(Integer.parseInt(data.get("totalItems").toString()) >= 1){
                JSONArray userRepsonse = (JSONArray) data.get("data");
                return userRepsonse;
            }else {
                return null;
            }
        } catch (ParseException ex) {
            Logger.getLogger(Handle_API_Get_Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
            
    }
    public static String sendPost_Add_New_Tour(String parameter, String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.sendPOST(parameter, endpoint, token));

            if(myObject.get("ApiErr") == null) {
                JSONObject data = (JSONObject) myObject.get("data");
                return "success";
            } else {
                JOptionPane.showMessageDialog(null,"Lỗi: "+ myObject.get("ApiErr").toString());
                return null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String send_Delete_Tour(String parameter, String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.sendDelete(parameter,endpoint, token));

            if(myObject.get("ApiErr") == null) {
                JOptionPane.showMessageDialog(null, "Xoá thành công");
                return "success";
            } else {
                String apierror = myObject.get("ApiErr") == null ? "" : myObject.get("ApiErr").toString();

                String error = "Lỗi:"+ apierror+"\n";

                String[] arrayError = error.split("\\.");
                String messError = "";
                for(String s : arrayError){
                    messError+= s +"\n";
                }

                JOptionPane.showMessageDialog(null,messError, "My Message", JOptionPane.ERROR_MESSAGE);
                return "error";
            }
        } catch (ParseException ex) {
            Logger.getLogger(Handle_API_Get_Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
