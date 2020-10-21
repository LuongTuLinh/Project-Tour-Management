package project.tour.management_Handle_API;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import project.tour.management_API.APIRequester;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Handle_API_Tour_Group {
    public static JSONArray Fetch_API_Tour_Group(String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.fetchAPI(endpoint, token));

            JSONObject data = (JSONObject) myObject.get("data");

            JSONArray tourGroup = (JSONArray) data.get("data");

            return tourGroup;
        } catch (ParseException ex) {
            Logger.getLogger(Handle_API_Get_Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    public static String sendPut_Tour_Group(String parameter, String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.sendPUT(parameter, endpoint, token));

            if(myObject.get("ApiSuccess")!=null && myObject.get("ApiErr") == null && myObject.get("StartDate") == null && myObject.get("EndDate") == null) {
                JOptionPane.showMessageDialog(null, "Sửa thành công");
                return "success";
            } else {
                String startDate = myObject.get("StartDate") == null ? "" : myObject.get("StartDate").toString();

                String endDate = myObject.get("EndDate") == null ? "" : myObject.get("EndDate").toString();

                String apierror = myObject.get("ApiErr") == null ? "" : myObject.get("ApiErr").toString();

                JOptionPane.showMessageDialog(null,"Error: "+ apierror+
                        startDate+ endDate);
                return "error";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
