package com.xamthien.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xamthien.DAO.SachDAO;
import com.xamthien.model.Sach;

@Service
@Transactional
public class SachService {
	@Autowired
	private SachDAO sachDAO;
	
	public List<Sach> getAllSach() {
        return sachDAO.getAllSach();
    }

    public Sach getSachByID(int id) {
         return sachDAO.getSachByID(id);
    }

    public void insertSacht(Sach sp) {
        this.sachDAO.insertSacht(sp);
    }

    
    public void updateSach(Sach sp) {
        this.sachDAO.updateSach(sp);
    }
    public void deleteSach(Sach sp) {
        this.sachDAO.deleteSach(sp);
    }
   

}
