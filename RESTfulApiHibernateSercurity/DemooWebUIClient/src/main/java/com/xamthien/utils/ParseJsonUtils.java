package com.xamthien.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ParseJsonUtils {
	 public static JSONObject toJsonString(Object ob) throws IOException {
		 ObjectMapper o = new ObjectMapper();
		 String JsonString = o.writeValueAsString(ob);
		 //JSONObject xx = new JSONObject(JsonString);
		 Map<String, Object> mp = o.readValue(JsonString, Map.class);
		 return  new JSONObject(mp);
	 }
	 
	 public static Object get(String JsonSource, Object xxx) throws IOException
	    {
			
			URL website = new URL(JsonSource);
	        InputStream inputStream = null;
	        BufferedReader bufferedReader = null;
	        
	        try
	        {
	        	inputStream = website.openStream();
	        	bufferedReader = new BufferedReader(new  InputStreamReader(inputStream, Charset.forName("UTF-8")));
	        	
	        	StringBuilder stringBuilder = new StringBuilder();
	        	int cp;
	        	while ((cp = bufferedReader.read())!=-1)
	        	{
	        		stringBuilder.append((char)cp);
	        	}
	        	ObjectMapper mapper = new ObjectMapper();
	        	xxx = mapper.readValue(stringBuilder.toString(), xxx.getClass());
	    		
	        }
	        catch(Exception e)
	        {
	        	inputStream.close();
	        	bufferedReader.close();
	        	
	        }
	        return xxx;
	    }
	 public  List<Object> getLst(String JsonSoure,Object xxx) throws IOException
	    {
			
			URL website = new URL(JsonSoure);
	        InputStream inputStream = null;
	        BufferedReader bufferedReader = null;
	        List<Object> lst = null;
	        try
	        {
	        	inputStream = website.openStream();
	        	bufferedReader = new BufferedReader(new  InputStreamReader(inputStream, Charset.forName("UTF-8")));
	        	
	        	StringBuilder stringBuilder = new StringBuilder();
	        	int cp;
	        	while ((cp = bufferedReader.read())!=-1)
	        	{
	        		stringBuilder.append((char)cp);
	        	}
	        	ObjectMapper mapper = new ObjectMapper();
	        	JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, xxx.getClass());
	        	lst = mapper.readValue(stringBuilder.toString(), type);
	        }
	        catch(Exception e)
	        {
	        	inputStream.close();
	        	bufferedReader.close();
	        	
	        }
			
	        return lst;
	    }
	 
//     List<FlightSchedules> lst = (List<FlightSchedules>) (Object) new ParseJsonUtils().getLst(Jsonpath, new FlightSchedules());
 	
// 	List<FlightSchedules> lst = list.stream()
//             .map(element->(FlightSchedules) element)
//             .collect(Collectors.toList());
	 
}
