package project.tour.management_Handle_API;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import project.tour.management_API.APIRequester;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Handle_API_Statistical {
    public static JSONArray API_Statistical_Tour(String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.fetchAPI(endpoint, token));

            JSONArray tourGroup = (JSONArray) myObject.get("data");

            return tourGroup;
        } catch (ParseException ex) {
            Logger.getLogger(Handle_API_Get_Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
