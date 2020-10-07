package project.tour.management_API;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//import org.json.JSONException;
//import org.json.JSONObject;
import project.tour.management_DTO.User_DTO;

public class APIRequester {

    private static String method = "GET";
    private static String url = "https://localhost:5001/api/v1";
    private static String endpoint = "";

    public APIRequester(String endpoint) {
        this.endpoint = endpoint;
    }

    public APIRequester(String endpoint, String method) {
        this.endpoint = endpoint;
        this.method = method;
    }

    public static String fetchAPI() {
        try {
            URL urlForGetRequest = new URL(url + "/" + endpoint);
            trustCertificateBeforeRequest();
            String readLine = null;

            HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
            connection.setAllowUserInteraction(true);
            connection.setRequestMethod(method);
//            User_DTO user = new User_DTO();
//            System.out.println("token: "+user.getToken());
//            connection.setRequestProperty("Authorization","Bearer "+user.getToken());

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                StringBuilder response;
                try ( BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
                    response = new StringBuilder();
                    while ((readLine = in.readLine()) != null) {
                        response.append(readLine);
                    }
                }
                // print result
                System.out.println("JSON String Result " + response.toString());
                return response.toString();
                //           GetAndPost.POSTRequest(response.toString());
            } else {
                System.out.println("GET NOT WORKED");
                return "GET NOT WORKED";
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return "GET NOT WORKED";
    }

    public static String sendPOST(String parameter, String endpoint) throws IOException, ParseException {
        URL obj = new URL(url + "/" + endpoint);
        trustCertificateBeforeRequest();

        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
        httpURLConnection.setAllowUserInteraction(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");

        

        // For POST only - START
        httpURLConnection.setDoOutput(true);
        OutputStream os = httpURLConnection.getOutputStream();
        os.write(parameter.getBytes());
        os.flush();
        os.close();


        int responseCode = httpURLConnection.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

//            JSONParser parser = new JSONParser();
//            JSONObject myObject = (JSONObject) parser.parse(response.toString());
//            // print result
//
//            
//            JSONObject data = (JSONObject) myObject.get("data");
//            
//            JSONObject userRepsonse = (JSONObject) data.get("userResponse");
//            User_DTO user = new User_DTO();
//                user.setToken(data.get("token").toString());
//                user.setEmail(userRepsonse.get("email").toString());
//                user.setLastName(userRepsonse.get("lastName").toString());
//                user.setFirstName(userRepsonse.get("firstName").toString());
//                user.setPhoneNumber(userRepsonse.get("phoneNumber").toString());
                
//                System.out.println("token:"+user.getToken());
            return response.toString();
        } else {
            System.out.println("POST request not worked");
            return null;
        }
        
    }

    public static void trustCertificateBeforeRequest() {
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                @Override
                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
        };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (GeneralSecurityException e) {
        }
    }

}
