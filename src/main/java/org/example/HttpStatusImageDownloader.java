package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.FileOutputStream;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws Exception{
        HttpStatusChecker checker = new HttpStatusChecker();
        String url=checker.getStatusImage(code);
        Connection.Response resultImageResponse = Jsoup.connect(url)
                .ignoreContentType(true).execute();

        FileOutputStream out = (new FileOutputStream(new java.io.File(code+".jpg")));
        out.write(resultImageResponse.bodyAsBytes());  // resultImageResponse.body() is where the image's contents are.
        out.close();
    }
}
