package org.example;


import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws Exception {
        String url = "https://http.cat/"+code+".jpg";
        Connection.Response response;
        try {
            response= Jsoup.connect(url).method(Connection.Method.GET).ignoreContentType(true).execute();
        } catch (IOException e) {
            throw new Exception("There is no such code");
        }
        if(response.statusCode()==404){
            throw new Exception("There is no such code");
        }
        return url;
    }
}
