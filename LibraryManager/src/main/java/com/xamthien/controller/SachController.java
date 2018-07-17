package com.xamthien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xamthien.model.Sach;
import com.xamthien.service.SachService;
import com.xamthien.service.TacgiaService;

@Controller
public class SachController {

	@Autowired
	private SachService sachService;
	@Autowired
	private TacgiaService tacgiaService;
	
	String msg="";
	
	@RequestMapping(value={"/", "/sach"})
	public String listSach(Model model) {
		model.addAttribute("sach", new Sach());// cho them moi
		model.addAttribute("listTacgia", tacgiaService.getAllTacGia());
		model.addAttribute("listSach", sachService.getAllSach());
		return "sach-list";
	}

//	@RequestMapping("/sach-save") // gọi trang thêm mới
//	public String insertSach(Model model) {
//		model.addAttribute("sach", new Sach());
//		model.addAttribute("listTacgia", tacgiaService.getAllTacGia());
//		return "sach-save";
//	}

//	@RequestMapping("/sach-view/id={id}")
//	public String viewCustomer(@PathVariable int id, Model model) {
//		Sach sach = sachService.getSachByID(id);
//		model.addAttribute("sach", sach);
//		return "sach-view";
//	}
	
//	@RequestMapping("/sach-update/id={id}")
//	public String updateCustomer(@PathVariable int id, Model model) {
//		Sach sach = sachService.getSachByID(id);
//		model.addAttribute("listTacgia", tacgiaService.getAllTacGia());
//		model.addAttribute("sach", sach);
//		return "sach-update";
//	}

	@RequestMapping("/saveSach")
	public String doSaveCustomer(@ModelAttribute("sach") Sach sach, Model model) {
		sachService.insertSacht(sach);
		model.addAttribute("msg", "Thêm sách thành công.");
		model.addAttribute("sach", new Sach());
		model.addAttribute("listSach", sachService.getAllSach());
		model.addAttribute("listTacgia", tacgiaService.getAllTacGia());
		return "sach-list";    
	}

	@RequestMapping("/updateSach")
	public String doUpdateCustomer(@ModelAttribute("sach") Sach sach, Model model) {
		sachService.updateSach(sach);
		model.addAttribute("msg", "Sửa thông tin sách thành công.");
		model.addAttribute("sach", new Sach());
		model.addAttribute("listSach", sachService.getAllSach());
		model.addAttribute("listTacgia", tacgiaService.getAllTacGia());
		return "sach-list";                                                     // redirect la return ve link mapping
	}
	
	@RequestMapping("/sach-delete/id={id}")
	public String doDeleteCustomer(@ModelAttribute("hid") int id, Model model) {
		Sach sach = sachService.getSachByID(id);
		sachService.deleteSach(sach);
		model.addAttribute("msg", "Xóa sách thành công.");
		model.addAttribute("sach", new Sach());
		model.addAttribute("listSach", sachService.getAllSach());
		model.addAttribute("listTacgia", tacgiaService.getAllTacGia());
		return "sach-list";    
	}
}
