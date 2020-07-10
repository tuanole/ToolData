package com.mydu.letian.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mydu.letian.dataanalysis.CommonStringXien;
import com.mydu.letian.entity.Bet;
import com.mydu.letian.entity.xien.Xien;
import com.mydu.letian.repository.BaseRepository;
import com.mydu.letian.repository.BetRepository;
import com.mydu.letian.repository.BetTypeRepository;

@Controller
public class NhapXienController {
	
	@Autowired
	private BaseRepository baseRepository;

//	@Autowired
//	private UserRepository userRepository;

	@Autowired
	private BetRepository betRepository;

//	@Autowired
//	private LotResultRepository lotResultRepository;

	@Autowired
	private BetTypeRepository betTypeRepository;
	
	@RequestMapping(value = { "/calculationXien" } , method = RequestMethod.GET)
	@ResponseBody
	public String calculationXien(Model model, @RequestParam(name = "stringXien") String stringXien, 
			@RequestParam(name = "type") String type, 
			@RequestParam("baseIn") String baseIn, @RequestParam("baseOut") String baseOut) {
		
		CommonStringXien comm = new CommonStringXien();
		List<Xien> listXien = new ArrayList<Xien>();
		
		if (type.equals("XIEN2")) {
			String str = comm.convertNghinToK(stringXien);
			String format = comm.formatChuan(str);
			String formatChuan = comm.chuanHoaSpace(format);
			List<String> xiens = comm.splitByK(formatChuan);
			for (String string : xiens) {
				if (!string.equals("") && !string.equals(" ")) {
					listXien.add(comm.convertStringToXien(string, baseIn, baseOut));
				}	
			}
		} else if (type.equals("XIEN3")) {
			String str = comm.convertNghinToK(stringXien);
			String format = comm.formatChuan(str);
			String formatChuan = comm.chuanHoaSpace(format);
			List<String> xiens = comm.splitByK(formatChuan);
			for (String string : xiens) {
				if (!string.equals("") && !string.equals(" ")) {
					listXien.add(comm.convertStringToXien3(string, baseIn, baseOut));
				}	
			}
		} else if (type.equals("XIEN4")) {
			String str = comm.convertNghinToK(stringXien);
			String format = comm.formatChuan(str);
			String formatChuan = comm.chuanHoaSpace(format);
			List<String> xiens = comm.splitByK(formatChuan);
			for (String string : xiens) {
				if (!string.equals("") && !string.equals(" ")) {
					listXien.add(comm.convertStringToXien4(string, baseIn, baseOut));
				}	
			}
		} else if (type.equals("3CANG")) {
			String str = comm.convertNghinToK(stringXien);
			String format = comm.formatChuan(str);
			String formatChuan = comm.chuanHoaSpace(format);
			List<String> xiens = comm.splitByK(formatChuan);
			for (String string : xiens) {
				if (!string.equals("") && !string.equals(" ")) {
					listXien.add(comm.convertStringTo3Cang(string, baseIn, baseOut));
				}	
			}
		}
		
		model.addAttribute("list", listXien);
		Gson gson = new Gson();
		return gson.toJson(listXien);
	}
	
	@RequestMapping(value = { "/saveXien" }, method = RequestMethod.POST)
	public String saveDataXien(Model model, @RequestBody Xien [] listData,
			@RequestParam("baseIn") String baseIn,
			@RequestParam("baseOut") String baseOut, @RequestParam("type") String type) {
		
		if (listData.length == 0 || listData == null) {
			model.addAttribute("flg", "warn");
			return "nhap-xien";
		}
		
		for (Xien xien : listData) {
			System.out.println(xien);
			Bet bet  = new Bet();
			bet.setBetKey(xien.getSoDanh());
			bet.setAmount(Integer.parseInt(xien.getTien()));
			bet.setBetDate(getToday());
			bet.setBaseIn(baseRepository.findByBaseNameSpec(baseIn));
			bet.setBaseOut(baseRepository.findByBaseNameSpec(baseOut));
			//bet.setUser(userRepository.findByUserId(cus));
			bet.setBetType(betTypeRepository.findByTypeId(3));
			betRepository.save(bet);
		}
		
		return "nhap-xien";
	}
	
	public Date getToday() {
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);
		return date;
	}
}
