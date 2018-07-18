package com.xamthien.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xamthien.model.Sach;
import com.xamthien.model.TacGia;

import com.xamthien.service.TacgiaService;

@Controller
public class TacgiaController {
	@Autowired
	private TacgiaService tacgiaService;
	@RequestMapping("/tacgia")
	public String listSach(Model model) {
		model.addAttribute("tacgia", new TacGia());		
		model.addAttribute("listTacgia", tacgiaService.getAllTacGia());
		return "tacgia-list";
	}
	@RequestMapping("/saveTacgia")
	public String doSaveCustomer(@ModelAttribute("tacgia") TacGia tg, Model model) {
		tacgiaService.insertTacGia(tg);
		model.addAttribute("msg", "Thêm tác giả thành công.");
		model.addAttribute("tacgia", new TacGia());	
		model.addAttribute("listTacgia", tacgiaService.getAllTacGia());
		return "tacgia-list";    
	}

	@RequestMapping("/updateTacgia")
	public String doUpdateCustomer(@ModelAttribute("sach") TacGia sach, Model model) {
		tacgiaService.updateTacGia(sach);
		model.addAttribute("msg", "Sửa thông tin tác giả thành công.");
		model.addAttribute("tacgia", new TacGia());		
		model.addAttribute("listTacgia", tacgiaService.getAllTacGia());
		return "tacgia-list";                                                   // redirect la return ve link mapping
	}
	
	@RequestMapping("/deleteTacgia/id={id}")
	public String doDeleteCustomer(@PathVariable int id, Model model) {
		TacGia sach = tacgiaService.getTacGiaByID(id);
		boolean ck = true;
		try
		{
			tacgiaService.deleteTacGia(sach);
			model.addAttribute("msg", "Xóa tác giả thành công.");
		}
		catch(Exception e)
		{
			model.addAttribute("msg", "Xóa tác giả không thành công.");
		}
		
		model.addAttribute("tacgia", new TacGia());		
		model.addAttribute("listTacgia", tacgiaService.getAllTacGia());
		return "tacgia-list";
	}
}
