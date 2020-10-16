package project.tour.management_API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.simple.parser.ParseException;

public class APIRequester {

    private static final String url = "https://localhost:5001/api/v1";

    public static String fetchAPI(String endpoint, String token) {
        try {
            URL urlForGetRequest = new URL(url + "/" + endpoint);
            trustCertificateBeforeRequest();
            String readLine = null;

            HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
            connection.setAllowUserInteraction(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + token);

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
                //GetAndPost.POSTRequest(response.toString());
            } else {
                System.out.println("GET NOT WORKED");
                return "GET NOT WORKED";
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return "GET NOT WORKED";
    }

    public static String sendPOST(String parameter, String endpoint, String token) throws IOException, ParseException {
        URL obj = new URL(url + "/" + endpoint);
        System.out.println(obj);
        trustCertificateBeforeRequest();

        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
        httpURLConnection.setAllowUserInteraction(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
        httpURLConnection.setRequestProperty("Authorization", "Bearer " + token);

        // For POST only - START
        httpURLConnection.setDoOutput(true);
        OutputStream os = httpURLConnection.getOutputStream();
        os.write(parameter.getBytes());
        os.flush();
        os.close();

        int responseCode = httpURLConnection.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK || responseCode == 201) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            System.out.println("POST request not worked");
            return "POST request not worked";
        }

    }

    public static String sendPUT(String parameter, String endpoint, String token) {
        URL obj;
        try {
            obj = new URL(url + "/" + endpoint);
            trustCertificateBeforeRequest();

            HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
            httpURLConnection.setAllowUserInteraction(true);
            httpURLConnection.setRequestMethod("PUT");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            httpURLConnection.setRequestProperty("Authorization", "Bearer " + token);

            // For POST only - START
            httpURLConnection.setDoOutput(true);
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(parameter.getBytes());
            os.flush();
            os.close();

            int responseCode = httpURLConnection.getResponseCode();
            System.out.println("PUT Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == 204) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return response.toString();
            } else {
                System.out.println("PUT request not worked");
                return "PUT request not worked";
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(APIRequester.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(APIRequester.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "PUT request not worked";

    }
    
    public static String sendDelete(String endpoint, String token) {
        URL obj;
        try {
            obj = new URL(url + "/" + endpoint);
            trustCertificateBeforeRequest();

            HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
            httpURLConnection.setAllowUserInteraction(true);
            httpURLConnection.setRequestMethod("DELETE");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            httpURLConnection.setRequestProperty("Authorization", "Bearer " + token);

            // For POST only - START
            httpURLConnection.setDoOutput(true);

            int responseCode = httpURLConnection.getResponseCode();
            System.out.println("PUT Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == 204) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return response.toString();
            } else {
                System.out.println("DELETE request not worked");
                return "DELETE request not worked";
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(APIRequester.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(APIRequester.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "DELETE request not worked";

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
