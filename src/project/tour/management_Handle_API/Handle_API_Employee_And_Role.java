package project.tour.management_Handle_API;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import project.tour.management_API.APIRequester;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Handle_API_Employee_And_Role {

    public static JSONArray Fetch_API_All_Employee(String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.fetchAPI(endpoint, token));

            JSONObject data = (JSONObject) myObject.get("data");
            if(Integer.parseInt(data.get("totalItems").toString()) >= 1){
                JSONArray allEmployee = (JSONArray) data.get("data");

                return allEmployee;
            }else {
                return null;
            }


        } catch (ParseException ex) {
            Logger.getLogger(Handle_API_Get_Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static JSONArray Fetch_API_All_Role(String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.fetchAPI(endpoint, token));

            JSONObject data = (JSONObject) myObject.get("data");
            if(Integer.parseInt(data.get("totalItems").toString()) >= 1){
                JSONArray allRoleGroup = (JSONArray) data.get("data");

                return allRoleGroup;
            }else {
                return null;
            }


        } catch (ParseException ex) {
            Logger.getLogger(Handle_API_Get_Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    public static String sendPost_Add_Role_Group(String parameter, String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.sendPOST(parameter, endpoint, token));

            if(myObject.get("ApiErr") == null) {
                System.out.println("TourDetail Add Success");
                return "success";
            } else {
                JOptionPane.showMessageDialog(null,"Error: "+ myObject.get("ApiErr").toString());
                return "error";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String sendDeleteRole(String parameter, String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.sendDelete(parameter, endpoint, token));

            if(myObject.get("ApiErr") == null) {
                System.out.println("TourDetail Delete Success");
                return "success";
            } else {
                JOptionPane.showMessageDialog(null,"Error: "+ myObject.get("ApiErr").toString());
                return "error";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String send_PUT_Edit_Role(String parameter, String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.sendPUT(parameter, endpoint, token));

            if(myObject.get("ApiErr") == null) {
                System.out.println("TourDetail Add Success");
                return "success";
            } else {
                JOptionPane.showMessageDialog(null,"Error: "+ myObject.get("ApiErr").toString());
                return "error";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
