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
import project.tour.management_DTO.Tour_DTO;

/**
 *
 * @author DELL
 */
public class Handle_API_Tour_Id {
    public static void Fetch_API_Tour_Id(String endpoint, String token){
        JSONParser parser = new JSONParser();
            JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.fetchAPI(endpoint, token));
            JSONObject data = (JSONObject) myObject.get("data");
            Tour_DTO tour = new Tour_DTO();
                tour.setTourId(data.get("id").toString());
                tour.setTourName(data.get("name").toString());
                tour.setSpecification(data.get("specification").toString());
                tour.setPrice(data.get("price").toString());
                tour.setStatus(data.get("status").toString());
        } catch (ParseException ex) {
            Logger.getLogger(Handle_API_Tour_Id.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static JSONArray Fetch_API_Tour_Id_Detail(String endpoint, String token){
        JSONParser parser = new JSONParser();
            JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.fetchAPI(endpoint, token));
            JSONObject data = (JSONObject) myObject.get("data");
            JSONArray tourDetails = (JSONArray) data.get("tourDetails");
            return tourDetails;
        } catch (ParseException ex) {
            Logger.getLogger(Handle_API_Tour_Id.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
