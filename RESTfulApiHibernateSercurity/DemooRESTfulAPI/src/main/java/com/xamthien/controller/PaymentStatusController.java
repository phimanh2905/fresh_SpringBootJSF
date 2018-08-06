package com.xamthien.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xamthien.model.*;
import com.xamthien.service.*;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PaymentStatusController {
	@Autowired
    private ReservationStatusService reservationStatusService;
 
  
    @RequestMapping(value = "/api/reservation_status/{id}",method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE}) 
    @ResponseBody
    public ReservationStatus getReservationByPhone(@PathVariable("id") String id) {
        ReservationStatus stt = reservationStatusService.geStatusByID(Integer.parseInt(id));//
        return stt;
    }
}
