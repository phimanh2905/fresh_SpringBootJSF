package com.xamthien.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xamthien.model.Sach;

import com.xamthien.service.TacgiaService;

@Controller
public class TacgiaController {
	@Autowired
	private TacgiaService tacgiaService;
	@RequestMapping("/tacgia")
	public String listSach(Model model) {
		model.addAttribute("listTacgia", tacgiaService.getAllTacGia());
		return "tacgia-list";
	}
}
