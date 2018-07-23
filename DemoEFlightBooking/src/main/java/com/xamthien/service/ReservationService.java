package com.xamthien.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xamthien.DAO.*;
import com.xamthien.model.*;

@Service
@Transactional
public class ReservationService {
	@Autowired
	private ReservationDAO ReservationDAO;
	
	public List<Reservation> getReservationByPhone(String phone) {
        return ReservationDAO.getReservationByPhone(phone);
    }

    public void insertReservation(Reservation sp) {
        this.ReservationDAO.insertReservation(sp);
    }

    
    public void updateReservation(Reservation sp) {
        this.ReservationDAO.updateReservation(sp);
    }
    public void deleteReservation(Reservation sp) {
        this.ReservationDAO.deleteReservation(sp);
    }
}
