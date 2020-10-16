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

/**
 *
 * @author DELL
 */
public class Handle_API_Tour {
    
    public static JSONArray Fetch_API_Tour(String endpoint, String token){
        JSONParser parser = new JSONParser();
            JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.fetchAPI(endpoint, token));

            JSONObject data = (JSONObject) myObject.get("data");

            JSONArray userRepsonse = (JSONArray) data.get("data");
            
            return userRepsonse;
        } catch (ParseException ex) {
            Logger.getLogger(Handle_API_Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
            
    }
}
