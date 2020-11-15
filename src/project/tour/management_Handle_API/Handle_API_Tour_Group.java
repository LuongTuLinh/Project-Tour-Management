package project.tour.management_Handle_API;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import project.tour.management_API.APIRequester;
import project.tour.management_DTO.Tour_DTO;
import project.tour.management_DTO.Tour_Group_DTO;
import project.tour.management_DTO.User_DTO;

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

    public static JSONArray API_Get_Tour_Group_Id(String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.fetchAPI(endpoint, token));
            JSONObject data = (JSONObject) myObject.get("data");
            Tour_Group_DTO tour = new Tour_Group_DTO();
            tour.setGroupId(data.get("id").toString());
            tour.setGroupName(data.get("name").toString());
            tour.setStartDate(data.get("startDate").toString());
            tour.setStatus(data.get("status").toString());
            tour.setEndDate(data.get("endDate").toString());
        } catch (ParseException ex) {
            Logger.getLogger(Handle_API_Get_Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static String send_POST_Tour_Group(String parameter, String endpoint, String token) {
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

                String error = "Lỗi: "+ apierror+"\n"+ startDate+ "\n "+ endDate;

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

                String error = "Lỗi: "+ apierror+"\n"+ startDate+ "\n "+ endDate;

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
    public static JSONArray Fetch_API_Customer_In_Group(String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.fetchAPI(endpoint, token));

            JSONObject data = (JSONObject) myObject.get("data");

            JSONArray customerInGroup = (JSONArray) data.get("data");

            return customerInGroup;
        } catch (ParseException ex) {
            Logger.getLogger(Handle_API_Get_Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    public static JSONArray Fetch_API_List_All_Customers(String endpoint, String token) {
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
    public static String send_POST_Add_Customer_To_Group(String parameter, String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.sendPOST(parameter, endpoint, token));
            System.out.println(myObject);

            if(myObject.get("ApiErr") == null) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
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
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String send_Delete_Customer_In_Group(String parameter, String endpoint, String token) {
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
    public static String send_Delete_Group_In_Tour(String parameter, String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(APIRequester.sendDelete(parameter,endpoint, token));

            if(myObject.get("ApiErr") == null) {
                //JOptionPane.showMessageDialog(null, "Xoá thành công");
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
