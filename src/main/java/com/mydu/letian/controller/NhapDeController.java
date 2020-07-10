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
import com.mydu.letian.dataanalysis.CommonStringDe;
import com.mydu.letian.entity.Bet;
import com.mydu.letian.entity.BoSo;
import com.mydu.letian.entity.de.De;
import com.mydu.letian.repository.BaseRepository;
import com.mydu.letian.repository.BetRepository;
import com.mydu.letian.repository.BetTypeRepository;
import com.mydu.letian.repository.BoSoRepository;

@Controller
public class NhapDeController {

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
	
	@Autowired
	private BoSoRepository boSoRepository;
	
	@RequestMapping(value = { "/calculationDe" } , method = RequestMethod.GET)
	@ResponseBody
	public String calculationDe(Model model, @RequestParam(name = "stringDe") String stringDe, 
			@RequestParam(name = "type") String type, 
			@RequestParam("baseIn") String baseIn, @RequestParam("baseOut") String baseOut) {
		
		
		CommonStringDe comm = new CommonStringDe();
		List<De> listDe = new ArrayList<De>();
		if (type.equals("")) {
			String str = comm.convertNghinToK(stringDe);
			String format = comm.formatChuan(str);
			String formatChuan = comm.chuanHoaSpaceL(format);
			List<String> listString = new ArrayList<String>();
			listString = comm.splitByK(formatChuan);
			for (String string : listString) {
				if (!str.equals("") && !string.equals(" ")) {
					listDe.addAll(comm.convertStringToDe(string.trim(), baseIn, baseOut));
				}
			}
		}else if (type.equals("DEDAU")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			//System.out.println(convertStr);
			String out = comm.formatChuanDD(convertStr);
			String formatChuan = comm.chuanHoaSpaceDD(out);
			System.out.println(formatChuan);
			String [] spk = formatChuan.split("D");
			for (String string : spk) {
				if (!string.equals("") && !string.equals(" ")) {
					listDe.addAll(comm.convertStringToDeDau(string.trim(), baseIn, baseOut));
				}
			}//co gi hot?
		} else if (type.equals("DEDIT")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuanDD(convertStr);
			String formatChuan = comm.chuanHoaSpaceDD(out);
			System.out.println(formatChuan);
			String [] spk = formatChuan.split("D");
			for (String string : spk) {
				if (!string.equals("") && !string.equals(" ")) {
					listDe.addAll(comm.convertStringToDeDit(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DETONG")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpaceDT(out);
			System.out.println(formatChuan);
			String [] spk = formatChuan.split("T");
			for (String string : spk) {
				if (!string.equals("") && !string.equals(" ")) {
					listDe.addAll(comm.convertStringToDeTong(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DETONGTREN")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpaceDT(out);
			System.out.println(formatChuan);
			String [] spk = formatChuan.split("T");
			for (String string : spk) {
				if (!string.equals("") && !string.equals(" ")) {
					listDe.addAll(comm.convertStringToDeTongTren(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DETONGDUOI")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpaceDT(out);
			System.out.println(formatChuan);
			String [] spk = formatChuan.split("T");
			for (String string : spk) {
				if (!string.equals("") && !string.equals(" ")) {
					listDe.addAll(comm.convertStringToDeTongDuoi(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DECC")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpaceCL(out);
			String [] listKb = formatChuan.split("C");
			for (String string : listKb) {
				if (!string.trim().equals("") && string.trim().length() > 2) {
					listDe.addAll(comm.convertStringToDeChanChan(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DECL")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpaceCL(out);
			String [] listKb = formatChuan.split("C");
			for (String string : listKb) {
				if (!string.trim().equals("") && string.trim().length() > 2) {
					listDe.addAll(comm.convertStringToDeChanLe(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DELC")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpaceCL(out);
			String [] listKb = formatChuan.split("L");
			for (String string : listKb) {
				if (!string.trim().equals("") && string.trim().length() > 2) {
					listDe.addAll(comm.convertStringToDeLeChan(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DELL")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpaceCL(out);
			String [] listKb = formatChuan.split("L");
			for (String string : listKb) {
				if (!string.trim().equals("") && string.trim().length() > 2) {
					listDe.addAll(comm.convertStringToDeLeLe(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DEKB")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpaceKB(out);
			String [] listKb = formatChuan.split("X");
			for (String string : listKb) {
				if (!string.trim().equals("") && string.trim().length() > 2) {
					listDe.addAll(comm.convertStringToDeKepBang(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DEKL")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpaceKB(out);
			String [] listKb = formatChuan.split("X");
			for (String string : listKb) {
				if (!string.trim().equals("") && string.trim().length() > 2) {
					listDe.addAll(comm.convertStringToDeKepLech(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DEDAUC")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpace(out);
			String [] listKb = formatChuan.split("X");
			for (String string : listKb) {
				if (!string.trim().equals("") && string.trim().length() > 2) {
					listDe.addAll(comm.convertStringToDeDauCao(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DEDAUT")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpace(out);
			String [] listKb = formatChuan.split("X");
			for (String string : listKb) {
				if (!string.trim().equals("") && string.trim().length() > 2) {
					listDe.addAll(comm.convertStringToDeDauThap(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DEDITC")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpace(out);
			String [] listKb = formatChuan.split("X");
			for (String string : listKb) {
				if (!string.trim().equals("") && string.trim().length() > 2) {
					listDe.addAll(comm.convertStringToDeDitCao(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DEDITT")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpace(out);
			String [] listKb = formatChuan.split("X");
			for (String string : listKb) {
				if (!string.trim().equals("") && string.trim().length() > 2) {
					listDe.addAll(comm.convertStringToDeDitThap(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DEDAUCDITC")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpace(out);
			String [] listKb = formatChuan.split("X");
			for (String string : listKb) {
				if (!string.trim().equals("") && string.trim().length() > 2) {
					listDe.addAll(comm.convertStringToDeDauCaoDitCao(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DEDAUCDITT")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpace(out);
			String [] listKb = formatChuan.split("X");
			for (String string : listKb) {
				if (!string.trim().equals("") && string.trim().length() > 2) {
					listDe.addAll(comm.convertStringToDeDauCaoDitThap(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DEDAUTDITT")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpace(out);
			String [] listKb = formatChuan.split("X");
			for (String string : listKb) {
				if (!string.trim().equals("") && string.trim().length() > 2) {
					listDe.addAll(comm.convertStringToDeDauThapDitThap(string.trim(), baseIn, baseOut));
				}
			}
		} else if (type.equals("DEDAUTDITC")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpace(out);
			String [] listKb = formatChuan.split("X");
			for (String string : listKb) {
				if (!string.trim().equals("") && string.trim().length() > 2) {
					listDe.addAll(comm.convertStringToDeDauThapDitCao(string.trim(), baseIn, baseOut));
				}
			}
			
		} else if (type.equals("DEBO")) {
			String convertStr = comm.convertNghinToKDD(stringDe);
			String out = comm.formatChuan(convertStr);
			String formatChuan = comm.chuanHoaSpace(out);
			String [] listKb = formatChuan.split("B");
			for (String string : listKb) {
				if (!string.trim().equals("") && string.trim().length() > 2) {
					listDe.addAll(comm.convertStringToDeBo(string.trim(), baseIn, baseOut, addBoToMap()));
				}
			}
		}
		

		model.addAttribute("list", listDe);
		Gson gson = new Gson();
		return gson.toJson(listDe);
	}
	
	@RequestMapping(value = { "/saveDe" }, method = RequestMethod.POST)
	public String saveDataDe(Model model, @RequestBody De [] listData, 
			@RequestParam("baseIn") String baseIn,
			@RequestParam("baseOut") String baseOut, @RequestParam("type") String type) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = "2020-07-08";
		Date betDate = null;
		try {
			betDate = df.parse(strdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		for (De de : listData) {
			System.out.println(de);
			Bet bet  = new Bet();
			bet.setBetKey(de.getSoDanh());
			bet.setAmount(Integer.parseInt(de.getTien()));
			//bet.setBetDate(getToday());
			bet.setBetDate(betDate);
			bet.setBaseIn(baseRepository.findByBaseNameSpec(baseIn));
			bet.setBaseOut(baseRepository.findByBaseNameSpec(baseOut));
			//bet.setUser(userRepository.findByUserId(cus));
			bet.setBetType(betTypeRepository.findByTypeId(2));
			betRepository.save(bet);
		}
		
		return "nhap-de";
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
