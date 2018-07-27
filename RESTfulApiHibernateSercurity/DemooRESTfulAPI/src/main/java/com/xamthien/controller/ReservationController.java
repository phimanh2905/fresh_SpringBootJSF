package com.xamthien.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xamthien.model.*;
import com.xamthien.service.*;

@RestController
public class ReservationController {
	@Autowired
    private ReservationService reservationService;
 
  
    @RequestMapping(value = "/api/reservation_p/{phone}",method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE}) 
    @ResponseBody
    public List<Reservation> getReservationByPhone(@PathVariable("phone") String phone) {
        List<Reservation> list = reservationService.getReservationByPhone(phone);
        return list;
    }
    
    @RequestMapping(value = "/api/reservation",method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE}) 
    @ResponseBody
    public void saveReservation(@RequestBody Reservation res) {
         reservationService.insertReservation(res);
       
    }
}
