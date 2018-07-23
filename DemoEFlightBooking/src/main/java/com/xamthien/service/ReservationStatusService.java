package com.xamthien.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xamthien.DAO.*;
import com.xamthien.model.*;
@Service
@Transactional


public class ReservationStatusService {
	@Autowired
	private PaymentStatusDAO statusDAO;

    public ReservationStatus geStatusByID(int id) {
         return statusDAO.getReservationStatusByID(id);
    }


}
