package com.mydu.letian.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mydu.letian.entity.BoSo;
import com.mydu.letian.repository.BoSoRepository;

@Controller
public class SetController {

	@Autowired
	BoSoRepository boSoRepository;
	
	@RequestMapping(value = { "/manager-set" }, method = RequestMethod.GET)
	public String home(Model model) {
		
		List<BoSo> list = new ArrayList<BoSo>();
		list = boSoRepository.findAll();
		model.addAttribute("list", list);
		
		return "manager-set";
	}
	
	@RequestMapping(value = { "/add-set" }, method = RequestMethod.GET)
	public String addSet(Model model) {
		
		return "add-set";
	}
	
	@RequestMapping(value = { "/save-set" }, method = RequestMethod.POST)
	public String saveSet(Model model, @RequestParam("boName")String boName, 
									   @RequestParam("boKey")String boKey, @RequestParam("boDes")String boDes) {
		
		String [] key = boKey.split(" ");
		for (String string : key) {
			BoSo so = new BoSo();
			so.setBoName(boName);
			so.setBoKey(string);
			so.setBoDes(boDes);
			boSoRepository.save(so);
		}
		List<BoSo> list = new ArrayList<BoSo>();
		list = boSoRepository.findAll();
		model.addAttribute("list", list);
		return "manager-set";
	}
	
	@RequestMapping(value = { "/edit-set" }, method = RequestMethod.POST)
	public String editSet(Model model, @RequestParam("boName")String boName, @RequestParam("id") String id,
									   @RequestParam("boKey")String boKey, @RequestParam("boDes")String boDes) {
		
		BoSo so = new BoSo();
		so.setId(Long.parseLong(id));
		so.setBoName(boName);
		so.setBoKey(boKey);
		so.setBoDes(boDes);
		boSoRepository.save(so);
		List<BoSo> list = new ArrayList<BoSo>();
		list = boSoRepository.findAll();
		model.addAttribute("list", list);
		return "manager-set";
	}
	
	
	@RequestMapping(value = { "/show-set" }, method = RequestMethod.GET)
	public String viewSet(Model model, @RequestParam("id") String id) {
		
		BoSo boso = new BoSo();
		boso = boSoRepository.getById(Long.parseLong(id));
		model.addAttribute("so", boso);
		return "show-set";
	}
	
	@RequestMapping(value = { "/delete-set" }, method = RequestMethod.GET)
	public String deleteSet(Model model, @RequestParam("id") String id) {
		
		BoSo boso = new BoSo();
		boso = boSoRepository.getById(Long.parseLong(id));
		if (boso != null) {
			boSoRepository.delete(boso);
		}
		List<BoSo> list = new ArrayList<BoSo>();
		list = boSoRepository.findAll();
		model.addAttribute("list", list);
		return "manager-set";
	}
}
