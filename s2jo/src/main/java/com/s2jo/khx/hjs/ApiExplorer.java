package com.s2jo.khx.hjs;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;

//===== Api Explorer 클래스 생성하기 =====

@Repository
public class ApiExplorer {
	
	
    public void tourInfo() throws IOException{
    	
    	System.out.println("==================api 테스트 ::::: 동작");
    	
        StringBuilder urlBuilder = new StringBuilder("http://openapi.tour.go.kr/openapi/service/TourismResourceService/getTourResourceList"); /*URL*/
        
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=eFlzqtWy00byos9tnPd%2FjvF1fg5k6AyKlUUBABdHaLMt3QVJWkNBg6le1g8THhaQxMfZ%2BQb6pDSyfxM7ixeqZg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("SIDO","UTF-8") + "=" + URLEncoder.encode("서울특별시", "UTF-8")); /*시도*/
        urlBuilder.append("&" + URLEncoder.encode("GUNGU","UTF-8") + "=" + URLEncoder.encode("종로구", "UTF-8")); /*시군구*/
        urlBuilder.append("&" + URLEncoder.encode("RES_NM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*관광지*/     /* 아래 꼭 필요한지? */
        urlBuilder.append("&" + URLEncoder.encode("SIDO","UTF-8") + "=" + URLEncoder.encode("서울특별시", "UTF-8")); /*시도*/
        urlBuilder.append("&" + URLEncoder.encode("GUNGU","UTF-8") + "=" + URLEncoder.encode("종로구", "UTF-8")); /*시군구*/
        urlBuilder.append("&" + URLEncoder.encode("RES_NM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*관광지*/
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        
        System.out.println("Response code: " + conn.getResponseCode());
        
        BufferedReader rd;
        
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
       } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        
        StringBuilder sb = new StringBuilder();
        String line;
       
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        
        rd.close();
        conn.disconnect();
        
        System.out.println(sb.toString());
    }
    
    
    
    
}// end of class ------