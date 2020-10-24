package project.tour.management_Handle_API;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import project.tour.management_API.APIRequester;
import project.tour.management_DTO.User_DTO;

import javax.swing.*;

public class Handle_API_Tour_Detail {
    public static String sendPUT_Attraction_Tour(String parameter, String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.sendPUT(parameter, endpoint, token));

            if(myObject.get("ApiErr") == null) {
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
