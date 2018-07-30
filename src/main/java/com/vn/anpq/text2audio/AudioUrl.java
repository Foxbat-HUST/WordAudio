package com.vn.anpq.text2audio;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by anpq on 2018/07/30.
 */
public class AudioUrl {

    private final String URL_PATTERN="https://neospeech.com/service/demo?voiceId=%d&content=%s";
    private final String USER_AGENT = "Mozilla/5.0";
    public String getAudioUrl(String word,int voidId) throws IOException {
        String url=String.format(URL_PATTERN,voidId,word);
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONObject responseJson=new JSONObject(response.toString());
        String audioUrl= responseJson.get("audioUrl").toString();
        int index=audioUrl.indexOf("http:");
        return audioUrl.substring(index);
    }

    public static void main(String[] args){
        try {
            System.out.println(new AudioUrl().getAudioUrl("こんばんは",9));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
