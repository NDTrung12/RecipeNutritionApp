package vn.edu.usth.nutritionrecipe.networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkChecker {
    public static String getResponseFromHttpurl(String urlString) throws Exception{
        URL url = new URL(urlString);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        }finally {
            urlConnection.disconnect();
        }
    }
}
