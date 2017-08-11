package functions;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by paul.hunter on 11/08/2017.
 */
public class APICalls {
    public static String responseContent;
    public static int statusCode;

    public static void APICalls(String callType, String stringUrl, JSONObject jsonData) throws IOException {
        URL url = new URL(stringUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod(callType);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.connect();

        if (jsonData != null) {
            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write(jsonData.toString());
            osw.flush();
            osw.close();
        }

        //Extract the status code
        statusCode = connection.getResponseCode();
        System.out.println("status code returned is: " + statusCode);

        // Buffer the result into a string
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();

        connection.disconnect();
        responseContent = sb.toString();
        System.out.println("Response Content JSON returned is: " + responseContent);
    }
    public int getStatusCode(){
        return statusCode;
    }

    public String getResponseContent() {
        return responseContent;
    }
}
