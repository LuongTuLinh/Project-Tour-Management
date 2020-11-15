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
public class Handle_API_Tour_Attractions {

    public static JSONArray Fetch_API_Tour_Attraction(String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.fetchAPI(endpoint, token));

            JSONObject data = (JSONObject) myObject.get("data");
            if(Integer.parseInt(data.get("totalItems").toString()) >= 1){
                JSONArray tourAttraction = (JSONArray) data.get("data");

                return tourAttraction;
            }else {
                return null;
            }
        } catch (ParseException ex) {
            Logger.getLogger(Handle_API_Get_Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    public static Object sendPostTourDetail(String parameter, String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.sendPOST(parameter, endpoint, token));

            if(myObject.get("ApiErr") == null) {
                System.out.println("TourDetail Add Success");
            } else {
                JOptionPane.showMessageDialog(null,"Lỗi: "+ myObject.get("ApiErr").toString());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Object sendDeleteTourDetail(String parameter, String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.sendDelete(parameter, endpoint, token));

            if(myObject.get("ApiErr") == null) {
                System.out.println("TourDetail Delete Success");
            } else {
                JOptionPane.showMessageDialog(null,"Lỗi: "+ myObject.get("ApiErr").toString());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
