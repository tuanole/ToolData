package com.mydu.letian.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.mydu.letian.dataanalysis.CommonStringLo;
import com.mydu.letian.entity.Bet;
import com.mydu.letian.entity.BoSo;
import com.mydu.letian.entity.lo.Lo;
import com.mydu.letian.repository.BaseRepository;
import com.mydu.letian.repository.BetRepository;
import com.mydu.letian.repository.BetTypeRepository;
import com.mydu.letian.repository.BoSoRepository;

@Controller
public class AjaxController {
	@Autowired
	private BaseRepository baseRepository;

	@Autowired
	private BetRepository betRepository;

//	@Autowired
//	private LotResultRepository lotResultRepository;

	@Autowired
	private BetTypeRepository betTypeRepository;
	
	@Autowired
	private BoSoRepository boSoRepository;
	
	@RequestMapping(value = { "/calculation" }, method = RequestMethod.GET, produces = {"application/json"}, headers = "Accept=*/*")
	@ResponseBody
	public String getListLo(Model model, @RequestParam(name = "stringLo") String stringLo, 
			@RequestParam(name = "kind") String kind,
			@RequestParam(name = "type") String type, @RequestParam(name = "diem") String diem,
			@RequestParam("baseIn") String baseIn, @RequestParam("baseOut") String baseOut) {
		CommonStringLo comm = new CommonStringLo();
		List<Lo> listLo = new ArrayList<Lo>();
		if (type.equals("") || type == null) {
			String str = comm.convertNghinToK(stringLo);
			String format = comm.formatChuan(str);
			String formatChuan = comm.chuanHoaSpace(format);
			System.out.println(formatChuan);
			List<String> listSplit = new ArrayList<String>();
			listSplit = comm.splitByD(formatChuan);
			for (String string : listSplit) {
				if (!string.equals("") && !string.equals(" ") && string.length() > 2) {
					listLo.addAll(comm.convertStringToLo(string, baseIn, baseOut));
				}
			}
		} else if (type.equals("LODAU")) {
			String convertStr = comm.convertToD(stringLo);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpaceLD(out);
			String [] spk = formatChuan.split("L");
			for (String string : spk) {
				if (!string.equals("") && !string.equals(" ")) {
					listLo.addAll(comm.convertStringToLoDau(string, baseIn, baseOut));
				}
			}
		}else if (type.equals("LODIT")) {
			String convertStr = comm.convertToD(stringLo);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpaceLD(out);
			String [] spk = formatChuan.split("L");
			for (String string : spk) {
				if (!string.equals("") && !string.equals(" ")) {
					listLo.addAll(comm.convertStringToLoDit(string , baseIn, baseOut));
				}
			}
		}else if (type.equals("LOBO")) {
			String convertStr = comm.convertNghinToK(stringLo);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpaceLD(out);
			listLo.addAll(comm.convertStringToLoBo(formatChuan.trim(), baseIn, baseOut, addBoToMap()));
			System.out.println(listLo.size());
			for (Lo lo : listLo) {
				System.out.println(lo);
			}
		}else if (type.equals("LOTONG")) {
			String convertStr = comm.convertNghinToK(stringLo);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpaceLD(out);
			String [] loTong = formatChuan.split("L");
			for (String string : loTong) {
				if (!string.equals("") && !string.equals("\\s+")) {
					listLo.addAll(comm.convertStringToLoTong(string.trim(), baseIn, baseOut));
				}
			}
		}
		Gson gson = new Gson();
		return gson.toJson(listLo);
	}
	
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String saveDataLo(Model model, @RequestBody Lo [] listData, @RequestParam("baseIn") String baseIn,
			@RequestParam("baseOut") String baseOut, @RequestParam("kind") String kind, @RequestParam("type") String type) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = "2020-07-08";
		Date betDate = null;
		try {
			betDate = df.parse(strdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		for (Lo lo : listData) {
			System.out.println(lo);
			Bet bet  = new Bet();
			bet.setBetKey(lo.getSoDanh());
			bet.setAmount(Integer.parseInt(lo.getDiem()));
			//bet.setBetDate(getToday());
			bet.setBetDate(betDate);
			bet.setBaseIn(baseRepository.findByBaseNameSpec(baseIn));
			bet.setBaseOut(baseRepository.findByBaseNameSpec(baseOut));
			bet.setBetType(betTypeRepository.findByTypeId(Integer.parseInt(kind)));
			betRepository.save(bet);
			System.out.println("success");
		}
		
		return "nhap-lo";
	}
	
	public Date getToday() {
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);
		return date;
	}
	
	public HashMap<String, List<BoSo>> addBoToMap() {
		final HashMap<String, List<BoSo>> map = new HashMap<String, List<BoSo>>();
		List<String> boName = new ArrayList<String>();
		boName = boSoRepository.findAllBoName();
		for (String string : boName) {
			map.put(string, boSoRepository.findByBoName(string));
		}
		return map;
	}
}
