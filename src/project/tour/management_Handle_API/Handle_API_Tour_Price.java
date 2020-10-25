package project.tour.management_Handle_API;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import project.tour.management_API.APIRequester;
import project.tour.management_DTO.User_DTO;

import javax.swing.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Handle_API_Tour_Price {
    public static JSONArray Fetch_API_Tour_Price(String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.fetchAPI(endpoint, token));

            JSONObject data = (JSONObject) myObject.get("data");

            JSONArray tourPrice = (JSONArray) data.get("data");

            return tourPrice;
        } catch (ParseException ex) {
            Logger.getLogger(Handle_API_Get_Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static String send_POST_Tour_Price(String parameter, String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.sendPOST(parameter, endpoint, token));
            System.out.println(myObject);

            if((myObject.get("ApiErr") == null && myObject.get("StartDate") == null && myObject.get("EndDate") == null)) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                return "success";
            } else {
                String startDate = myObject.get("StartDate") == null ? "" : myObject.get("StartDate").toString();

                String endDate = myObject.get("EndDate") == null ? "" : myObject.get("EndDate").toString();

                String apierror = myObject.get("ApiErr") == null ? "" : myObject.get("ApiErr").toString();
                String error = "Error:"+ apierror+"\n"+ startDate+ "\n "+ endDate;

                String[] arrayError = error.split("\\.");
                String messError = "";
                for(String s : arrayError){
                    messError+= s +"\n";
                }

                JOptionPane.showMessageDialog(null,messError, "My Message", JOptionPane.ERROR_MESSAGE);
                return "error";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String sendPut_Tour_Price(String parameter, String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.sendPUT(parameter, endpoint, token));
            System.out.println(myObject);

            if(myObject.get("ApiSuccess")!=null && (myObject.get("ApiErr") == null && myObject.get("StartDate") == null && myObject.get("EndDate") == null)) {
                JOptionPane.showMessageDialog(null, "Sửa thành công");
                return "success";
            } else {
                String startDate = myObject.get("StartDate") == null ? "" : myObject.get("StartDate").toString();

                String endDate = myObject.get("EndDate") == null ? "" : myObject.get("EndDate").toString();

                String apierror = myObject.get("ApiErr") == null ? "" : myObject.get("ApiErr").toString();

                String error = "Error:"+ apierror+"\n"+ startDate+ "\n "+ endDate;

                String[] arrayError = error.split("\\.");
                String messError = "";
                for(String s : arrayError){
                    messError+= s +"\n";
                }

                JOptionPane.showMessageDialog(null,messError, "My Message", JOptionPane.ERROR_MESSAGE);
                return "error";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
