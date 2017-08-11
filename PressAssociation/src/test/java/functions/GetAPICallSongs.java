package functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by paul.hunter on 10/08/2017.
 */
// May be able to combine with APICalls. Need to check when API is working again.

public class GetAPICallSongs {
    public static String responseContent;
    public static int statusCode;

    public static void GetAPICallSongs(String stringUrl) throws IOException {
        URL url = new URL(stringUrl);
        HttpURLConnection conn =
                (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Content-Type", "application/json");

        //Extract the status code
        statusCode = conn.getResponseCode();

         // Buffer the response into a string
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();

        conn.disconnect();
        responseContent = sb.toString();
    }
    public int getStatusCode(){
        return statusCode;
    }

    public String getResponseContent() {
        return responseContent;
    }

}
