package com.xamthien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xamthien.DAO.SachDAO;
import com.xamthien.model.Sach;
import com.xamthien.service.SachService;

@Controller
public class CustomerController {

	@Autowired
	private SachService sachService;

	@RequestMapping(value={"/", "/sach"})
	public String listSach(Model model) {
		model.addAttribute("listSach", sachService.getAllSach());
		return "sach-list";
	}

	@RequestMapping("/sach-save")
	public String insertSach(Model model) {
		model.addAttribute("sach", new Sach());
		return "sach-save";
	}

	@RequestMapping("/sach-view/{id}")
	public String viewCustomer(@PathVariable int id, Model model) {
		Sach sach = sachService.getSachByID(id);
		model.addAttribute("sach", sach);
		return "sach-view";
	}
	
	@RequestMapping("/sach-update/{id}")
	public String updateCustomer(@PathVariable int id, Model model) {
		Sach sach = sachService.getSachByID(id);
		model.addAttribute("sach", sach);
		return "sach-update";
	}

	@RequestMapping("/saveSach")
	public String doSaveCustomer(@ModelAttribute("Customer") Sach sach, Model model) {
		sachService.insertSacht(sach);
		model.addAttribute("listCustomer", sachService.getAllSach());
		return "redirect:sach-list";
	}

	@RequestMapping("/updateSach")
	public String doUpdateCustomer(@ModelAttribute("Customer") Sach sach, Model model) {
		sachService.updateSach(sach);
		model.addAttribute("listCustomer", sachService.getAllSach());
		return "redirect:sach-list";
	}
	
	@RequestMapping("/sachDelete/{id}")
	public String doDeleteCustomer(@PathVariable int id, Model model) {
		Sach sach = sachService.getSachByID(id);
		sachService.deleteSach(sach);
		model.addAttribute("listCustomer", sachService.getAllSach());
		return "redirect:/customer-list";
	}
}
