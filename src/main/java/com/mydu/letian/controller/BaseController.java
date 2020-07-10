package com.mydu.letian.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mydu.letian.entity.Base;
import com.mydu.letian.repository.BaseRepository;

@Controller
public class BaseController {

	@Autowired
	private BaseRepository baseRepository;

	@RequestMapping(value = { "/base-infor" }, method = RequestMethod.GET)
	public String home(Model model, @RequestParam(name= "baseId" )String baseId) {
		Base base = new Base();
		base = baseRepository.findBaseSpec(Long.parseLong(baseId));
		model.addAttribute("base", base);
		return "base-infor";
	}
	
	@RequestMapping(value = { "/add-base" }, method = RequestMethod.GET)
	public String addBase(Model model) {
		return "base-infor";
	}
	
	@RequestMapping(value = { "/delete-base" }, method = RequestMethod.GET)
	public String deleteBase(Model model,  @RequestParam(name= "baseId" )String baseId) {
		
		baseRepository.deleteById(Long.parseLong(baseId));
		
		List<Base> list = new ArrayList<Base>();
		list = baseRepository.findAllBase();
		model.addAttribute("bases", list);
		return "base";
	}
	
	@RequestMapping(value = { "/save-base" }, method = RequestMethod.POST)
	public String saveBase(Model model, 
			@RequestParam(name= "baseId" )String baseId, @RequestParam(name= "baseName" )String baseName, 
			@RequestParam(name= "baseDes" )String baseDes, @RequestParam(name= "rateLIn" )String rateLIn,
			@RequestParam(name= "rateLOut" )String rateLOut, @RequestParam(name= "rateD" )String rateD,
			@RequestParam(name= "rateX2" )String rateX2, @RequestParam(name= "rateX3" )String rateX3, 
			@RequestParam(name= "rateX4" )String rateX4, @RequestParam(name= "rate3c" )String rate3c) {
		
		Base base = new Base();
		base.setBaseName(baseName);
		base.setBaseDes(baseDes);
		base.setRateLIn(Double.parseDouble(rateLIn));
		base.setRateLOut(Double.parseDouble(rateLOut));
		base.setRateD(Double.parseDouble(rateD));
		base.setRateX2(Double.parseDouble(rateX2));
		base.setRateX3(Double.parseDouble(rateX3));
		base.setRateX4(Double.parseDouble(rateX4));
		base.setRate3c(Double.parseDouble(rate3c));
		if (baseId.equals("") || baseId == null) {
			base.setBaseId(null);
			baseRepository.save(base);
		}else{
//				baseRepository.saveBase(base.getBaseName(), base.getBaseDes(), base.getRateLIn(), 
//						base.getRateLOut(), base.getRateD(), base.getRateX2(), base.getRateX3(), base.getRateX4(), base.getRate3c(), Long.parseLong(baseId));
			base.setBaseId(Long.parseLong(baseId));
			baseRepository.save(base);
			
		}
		
		
		System.out.println(base);
		List<Base> listBase = new ArrayList<Base>();
		listBase = baseRepository.findAllBase();
		model.addAttribute("bases", listBase);
		return "base";
	}
}
