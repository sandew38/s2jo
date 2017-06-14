package com.s2jo.khx.hjs;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;

//===== Api Explorer 클래스 생성하기 =====

@Repository
public class ApiExplorer {
	
	
    public void tourInfo(String SIDO) throws Exception{
    	
    	System.out.println("==> ApiExplorer 파라미터 확인 : " + SIDO);   // 서울특별시
    	
        StringBuilder urlBuilder = new StringBuilder("http://openapi.tour.go.kr/openapi/service/TourismResourceService/getTourResourceList"); /*URL*/
        
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=eFlzqtWy00byos9tnPd%2FjvF1fg5k6AyKlUUBABdHaLMt3QVJWkNBg6le1g8THhaQxMfZ%2BQb6pDSyfxM7ixeqZg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("SIDO","UTF-8") + "=" + URLEncoder.encode("서울특별시", "UTF-8")); /*시도*/
        urlBuilder.append("&" + URLEncoder.encode("GUNGU","UTF-8") + "=" + URLEncoder.encode("종로구", "UTF-8")); /*시군구*/
        urlBuilder.append("&" + URLEncoder.encode("RES_NM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*관광지*/ 
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();		// url 연결
        
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        
        System.out.println("Response code: " + conn.getResponseCode());	// 200
        
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
        
        
        System.out.println("=====>" + line);  // null 
        
        rd.close();
        conn.disconnect();
        
        System.out.println(sb.toString());
        
        
       /* 
        
        //== 추가 == // 
        
        try {

           	JsonFactory jfactory = new JsonFactory();

           	*//*** read from url ***//*
           	JsonParser jParser = jfactory.createJsonParser(new URL(readUrl()));

           	// loop until token equal to "}"
           	while (jParser.nextToken() != JsonToken.END_OBJECT) {

           		String fieldname = jParser.getCurrentName();
           		if ("CSido".equals(fieldname)) {

           		  // current token is "name",
                             // move to next, which is "name"'s value
           		  jParser.nextToken();
           		  System.out.println(jParser.getText()); // display mkyong

           		}

           		if ("DGungu".equals(fieldname)) {

           		  // current token is "age",
                             // move to next, which is "name"'s value
           		  jParser.nextToken();
           		  System.out.println(jParser.getIntValue()); // display 29

           		}

           		if ("EPreSimpleDesc".equals(fieldname)) {

           		  jParser.nextToken(); // current token is "[", move next

           		  // messages is array, loop until token equal to "]"
           		  while (jParser.nextToken() != JsonToken.END_ARRAY) {

                                // display msg1, msg2, msg3
           		     System.out.println(jParser.getText());

           		  }

           		}

           	  }
           	  jParser.close();

                } catch (JsonGenerationException e) {

           	  e.printStackTrace();

                } catch (JsonMappingException e) {

           	  e.printStackTrace();

                } catch (IOException e) {

           	  e.printStackTrace();

                }
*/
        
        
        
        
    }
    
   // ========== JSON 망했으면 
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            new ApiExplorer();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    private static String readUrl() throws Exception {
        BufferedInputStream reader = null;
        try {
        	
            StringBuilder urlBuilder = new StringBuilder("http://openapi.tour.go.kr/openapi/service/TourismResourceService/getTourResourceList"); /*URL*/
            
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=eFlzqtWy00byos9tnPd%2FjvF1fg5k6AyKlUUBABdHaLMt3QVJWkNBg6le1g8THhaQxMfZ%2BQb6pDSyfxM7ixeqZg%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("SIDO","UTF-8") + "=" + URLEncoder.encode("서울특별시", "UTF-8")); /*시도*/
            urlBuilder.append("&" + URLEncoder.encode("GUNGU","UTF-8") + "=" + URLEncoder.encode("종로구", "UTF-8")); /*시군구*/
            urlBuilder.append("&" + URLEncoder.encode("RES_NM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*관광지*/ 
            urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*json 타입*/ 
            
            URL url = new URL(urlBuilder.toString());
            
            reader = new BufferedInputStream(url.openStream());
            StringBuffer buffer = new StringBuffer();
            int i;
            byte[] b = new byte[4096];
            while( (i = reader.read(b)) != -1){
              buffer.append(new String(b, 0, i));
            }
            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
    
    
    public ApiExplorer() throws Exception{
/*
        JSONObject jsonobject = (JSONObject)jsonparser.parse(readUrl());
        JSONObject json =  (JSONObject) jsonobject.get("boxOfficeResult");
        JSONArray array = (JSONArray)json.get("dailyBoxOfficeList");
        for(int i = 0 ; i < array.size(); i++){
            
            JSONObject entity = (JSONObject)array.get(i);
            String movieNm = (String) entity.get("movieNm");
            System.out.println(movieNm);
        }
        
        
        
*/
        try {

   	JsonFactory jfactory = new JsonFactory();

   	/*** read from url ***/
   	JsonParser jParser = jfactory.createJsonParser(new URL(readUrl()));

   	// loop until token equal to "}"
   	while (jParser.nextToken() != JsonToken.END_OBJECT) {

   		String fieldname = jParser.getCurrentName();
   		if ("CSido".equals(fieldname)) {

   		  // current token is "name",
                     // move to next, which is "name"'s value
   		  jParser.nextToken();
   		  System.out.println(jParser.getText()); // display mkyong

   		}

   		if ("DGungu".equals(fieldname)) {

   		  // current token is "age",
                     // move to next, which is "name"'s value
   		  jParser.nextToken();
   		  System.out.println(jParser.getIntValue()); // display 29

   		}

   		if ("EPreSimpleDesc".equals(fieldname)) {

   		  jParser.nextToken(); // current token is "[", move next

   		  // messages is array, loop until token equal to "]"
   		  while (jParser.nextToken() != JsonToken.END_ARRAY) {

                        // display msg1, msg2, msg3
   		     System.out.println(jParser.getText());

   		  }

   		}

   	  }
   	  jParser.close();

        } catch (JsonGenerationException e) {

   	  e.printStackTrace();

        } catch (JsonMappingException e) {

   	  e.printStackTrace();

        } catch (IOException e) {

   	  e.printStackTrace();

        }

     }
        
        
        
        
        
        
     
    
}// end of class ------