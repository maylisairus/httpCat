package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus(){
        Scanner sc = new Scanner(System.in);
        String scode;
        do{
        System.out.println("Enter http code:");
         scode=sc.next();
        if(scode.matches("\\d+")){
            break;
        }
        else{
            System.out.println("Please enter valid number");
        }
        }while(true);

        int code = Integer.parseInt(scode);
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        try{
            downloader.downloadStatusImage(code);
        }catch (Exception ex){
            System.out.println("There is not image for HTTP status "+scode);
        }
    }
}
