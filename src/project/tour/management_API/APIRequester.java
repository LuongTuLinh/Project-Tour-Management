package project.tour.management_API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
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
        HttpURLConnection connection ;
        BufferedReader in;
        try {
            URL urlForGetRequest = new URL(url + "/" + endpoint);
            System.out.println(urlForGetRequest);
            trustCertificateBeforeRequest();
            String readLine = null;

             connection = (HttpURLConnection) urlForGetRequest.openConnection();
            connection.setAllowUserInteraction(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("content-type", "application/json; charset=utf-8");
            connection.setRequestProperty("Authorization", "Bearer " + token);

            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                StringBuilder response;
                 in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                    response = new StringBuilder();
                    while ((readLine = in.readLine()) != null) {
                        response.append(readLine);
                    }

                // print result
                System.out.println("JSON String Result " + response.toString());
                return response.toString();
            }
            else {
                in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println(response.toString());
                return response.toString();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
        return "{\"ApiErr\": \"Error\"}";
    }

    public static String sendPOST(String parameter, String endpoint, String token) {
        URL obj = null;
        HttpURLConnection httpURLConnection = null;
        BufferedReader in;
        try {
            obj = new URL(url + "/" + endpoint);
            System.out.println(obj);
            System.out.println(parameter);
            trustCertificateBeforeRequest();

            httpURLConnection = (HttpURLConnection) obj.openConnection();
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
                in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return response.toString();
            } else {
                in = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println(response.toString());
                return response.toString();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
        return "{\"ApiErr\": \"Error\"}";

    }

    public static String sendPUT(String parameter, String endpoint, String token) {
        URL obj;
        HttpURLConnection httpURLConnection;
        BufferedReader in;
        try {
            obj = new URL(url + "/" + endpoint);
            System.out.println(obj);
            trustCertificateBeforeRequest();

            httpURLConnection = (HttpURLConnection) obj.openConnection();
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
                in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return "{\"ApiSuccess\": \"Success\"}";
            } else {
                in = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println(response.toString());
                return response.toString();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
        return "{\"ApiErr\": \"Error\"}";

    }
    
    public static String sendDelete(String parameter, String endpoint, String token) {
        URL obj;
        BufferedReader in;
        HttpURLConnection httpURLConnection;
        try {
            obj = new URL(url + "/" + endpoint);
            System.out.println(obj);
            trustCertificateBeforeRequest();

             httpURLConnection = (HttpURLConnection) obj.openConnection();
            httpURLConnection.setAllowUserInteraction(true);
            httpURLConnection.setRequestMethod("DELETE");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            httpURLConnection.setRequestProperty("Authorization", "Bearer " + token);

            // For POST only - START
            httpURLConnection.setDoOutput(true);
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(parameter.getBytes());
            os.flush();
            os.close();

            int responseCode = httpURLConnection.getResponseCode();
            System.out.println(" Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == 204) { // success
                in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return "{\"ApiSuccess\": \"Success\"}";
            } else {
                in = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println(response.toString());
                return response.toString();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
        return "{\"ApiErr\": \"Error\"}";

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
