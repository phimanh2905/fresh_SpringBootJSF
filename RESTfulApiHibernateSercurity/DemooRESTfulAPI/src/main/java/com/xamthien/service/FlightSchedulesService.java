package com.xamthien.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xamthien.DAO.*;
import com.xamthien.model.*;

@Service
@Transactional
public class FlightSchedulesService {
	@Autowired
	private FlightSchedulesDAO FlightSchedulesDAO;
	
	public List<FlightSchedules> getAllFlight() {
        return FlightSchedulesDAO.getAllFlightSchedules();
    }

    public FlightSchedules getFlightByID(long id) {
         return FlightSchedulesDAO.getFlightSchedulesByID(id);
    }

    public void insertFlightSchedules(FlightSchedules sp) {
        this.FlightSchedulesDAO.insertFlightSchedules(sp);
    }

    
    public void updateFlightSchedules(FlightSchedules sp) {
        this.FlightSchedulesDAO.updateFlightSchedules(sp);
    }
    public void deleteFlightSchedules(FlightSchedules sp) {
        this.FlightSchedulesDAO.deleteFlightSchedules(sp);
    }
   

}
