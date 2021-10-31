package de.codingbaker;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException 
    {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.openweathermap.org/data/2.5/weather?q=bingen&appid=0a9c8ad4011df9d68906632d3d421943&units=metric")).build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject myObject = new JSONObject(response.body());
        
        // Full Objekt
        //System.out.println(myObject); // Your json object
        

        
        System.out.println(myObject.get("name"));
        System.out.println("Aktuelle Temperatur = " + myObject.getJSONObject("main").get("temp") + " Grad");
        System.out.println("Minimale Temperatur = " + myObject.getJSONObject("main").get("temp_min") + " Grad");
        System.out.println("Maximale Temperatur = " + myObject.getJSONObject("main").get("temp_max") + " Grad");
    }
}
