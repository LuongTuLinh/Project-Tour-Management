package project.tour.management_Handle_API;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import project.tour.management_API.APIRequester;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Handle_API_Tour_Price {
    public static JSONArray Fetch_API_Tour_Price(String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.fetchAPI(endpoint, token));

            JSONObject data = (JSONObject) myObject.get("data");

            JSONArray tourCategory = (JSONArray) data.get("data");

            return tourCategory;
        } catch (ParseException ex) {
            Logger.getLogger(Handle_API_Get_Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
