package com.xamthien.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xamthien.DAO.*;
import com.xamthien.model.*;
import com.xamthien.service.*;


 
@RestController
public class FlightController {
 
    @Autowired
    private FlightSchedulesService flightSchedulesService;
 
   // trả về danh sách các chuyến bay
    @RequestMapping(value = "/api/flights",method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE}) 
    @ResponseBody
    public List<FlightSchedules> getAll() {
        List<FlightSchedules> list = flightSchedulesService.getAllFlight();
        return list;
    }
    
    
    // trả về chuyến bay đc lấy theo id
    @RequestMapping(value = "/api/flight/{fid}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})     
    @ResponseBody
    public FlightSchedules getByID(@PathVariable("fid") String fid) {
    	FlightSchedules fl = flightSchedulesService.getFlightByID(Integer.parseInt(fid));
        return fl;
    }
    
    
    // thêm mới chuyến bay
    @RequestMapping(value = "/api/flight",method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE}) 
    @ResponseBody
    public void addFlight(@RequestBody FlightSchedules fli,HttpServletResponse response) throws IOException {
    	response.setCharacterEncoding("utf-8");
    	flightSchedulesService.insertFlightSchedules(fli);
        response.getWriter().println("Thêm chuyến bay thành công"); 
    }
    
    
    // sửa thông tin chuyến bay
    @RequestMapping(value = "/api/flight", method = RequestMethod.PUT,produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void  updateFlight(@RequestBody FlightSchedules fli,HttpServletResponse response) throws IOException {
 
    	response.setCharacterEncoding("utf-8");
    	flightSchedulesService.updateFlightSchedules(fli);
        response.getWriter().println("Sửa thông tin chuyến bay thành công"); 
    }
    
    
    // xóa chuyến bay theo id
    @RequestMapping(value = "/api/flight/{fid}",  method = RequestMethod.DELETE,produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteFlight(@PathVariable("fid") String fid,HttpServletResponse response) throws IOException {
 
    	response.setCharacterEncoding("utf-8");
    	FlightSchedules fl = flightSchedulesService.getFlightByID(Integer.parseInt(fid));
    	flightSchedulesService.deleteFlightSchedules(fl);
    	response.getWriter().println("Xóa chuyến bay thành công"); 
    }


    
}
