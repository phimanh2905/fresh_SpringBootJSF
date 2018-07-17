package com.xamthien.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.xamthien.DAO.TacgiaDAO;
import com.xamthien.model.TacGia;

@Service
@Transactional

public class TacgiaService {
	@Autowired
	private TacgiaDAO tacgiaDAO;
	
	public List<TacGia> getAllTacGia() {
        return tacgiaDAO.getAllTacGia();
    }

    public TacGia getTacGiaByID(int id) {
         return tacgiaDAO.getTacGiaByID(id);
    }

    public void insertSacht(TacGia sp) {
        this.tacgiaDAO.insertTacGiat(sp);
    }

    
    public void updateSach(TacGia sp) {
        this.tacgiaDAO.updateTacGia(sp);
    }
    public void deleteSach(TacGia sp) {
        this.tacgiaDAO.deleteTacGia(sp);
    }
}
