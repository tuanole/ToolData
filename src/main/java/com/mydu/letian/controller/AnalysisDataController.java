package com.mydu.letian.controller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mydu.letian.entity.Bet;
import com.mydu.letian.entity.DataDe;
import com.mydu.letian.entity.DataLo;
import com.mydu.letian.entity.LotResult;
import com.mydu.letian.repository.BetRepository;
import com.mydu.letian.repository.BetTypeRepository;
import com.mydu.letian.repository.LotResultRepository;

@Controller
public class AnalysisDataController {
	
	@Autowired
	private BetRepository betRepository;

	@Autowired
	private LotResultRepository lotResultRepository;

	@Autowired
	private BetTypeRepository betTypeRepository;
	
	@RequestMapping(value = { "/analysis-data" }, method = RequestMethod.GET)
	public String getData(Model model) throws ParseException{
		
		List<DataDe> listDataDe = new ArrayList<DataDe>();
		List<DataLo> listData = new ArrayList<DataLo>();
		List<DataLo> listData2 = new ArrayList<DataLo>();
		listData = getListDataLo();
		listDataDe = getListDataDe();
		listData2.addAll(listData);
		int diem = 0;
		int trung = 0;
		int luot = 0;
		for (DataLo dataLo : listData) {
			diem += Integer.parseInt(dataLo.getDiem());
			trung += Integer.parseInt(dataLo.getTong());
			luot += Integer.parseInt(dataLo.getSoLuot());
		}
		DataLo data = new DataLo();
		data.setSo("");
		data.setDiem(String.valueOf(diem));
		data.setTong(String.valueOf(trung));
		data.setSoLuot(String.valueOf(luot));
		data.setHang(0);
		
		int tienD = 0;
		int tienT = 0;
		for (DataDe dataD : listDataDe) {
			tienD += dataD.getTienD();
			tienT += dataD.getTienT();
		}
		DataDe dataD = new DataDe();
		dataD.setSo("");
		dataD.setTienD(tienD);
		dataD.setTienT(tienT);
		dataD.setHang(0);
		
		Collections.sort(listData, new DataLo());
		int index = 1;
		listData.get(0).setHang(index);
		for (int i = 1; i < 100; i++) {
			if (!listData.get(i).getDiem().equals(listData.get(i - 1).getDiem())) {
				index++;
				listData.get(i).setHang(index);
			}else {
				listData.get(i).setHang(index);
			}
		}
		List<String> listTotal = new ArrayList<String>();
		int diemTotal = 0;
		int count = 0;
		for (int i = 0; i < listData2.size(); i++) {
			diemTotal += Integer.parseInt(listData2.get(i).getDiem());
			count++;
			if (count == 10) {
				listTotal.add(String.valueOf(diemTotal));
				diemTotal = 0;
				count = 0;
			}
		}
		
		double hhLbl = 0;
		double luotVePer = 0;
		double lai = 0;
		DecimalFormat df = new DecimalFormat("#.###");
		hhLbl = Double.parseDouble(data.getDiem())*21.3 - Double.parseDouble(data.getTong())*80;
		hhLbl = Double.valueOf(df.format(hhLbl));
		luotVePer = Double.parseDouble(data.getSoLuot())/27*100;
		luotVePer = Double.valueOf(df.format(luotVePer));
		lai = ((Double.parseDouble(data.getTong())*80)/(Double.parseDouble(data.getDiem())*21.3))*100;
		lai = Double.valueOf(df.format(lai));
		//listData.add(0, data);
		for (DataLo dataLo : listData2) {
			if (dataLo.getDiem().equals("0")) {
				dataLo.setDiem("");
			}
		}
		model.addAttribute("data", data);
		model.addAttribute("listData", listData);
		model.addAttribute("listData2", listData2);
		model.addAttribute("listTotal", listTotal);
		model.addAttribute("listDe", listDataDe);
		model.addAttribute("dataD", dataD);
		model.addAttribute("results", getListResult());
		model.addAttribute("hhLbl", hhLbl);
		model.addAttribute("luotVePer", luotVePer);
		model.addAttribute("lai", lai);
		
		return "analysis-data";
	}
	
	public List<DataLo> getListDataLo() throws ParseException{
		
		List<DataLo> listData = new ArrayList<DataLo>();
		List<LotResult> results = new ArrayList<LotResult>();
		results = lotResultRepository.findAll();
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = fomat.parse("2020-07-08");
		List<Bet> listBetLo = new ArrayList<Bet>();
		listBetLo = betRepository.findByBetDateAndBetType(date, betTypeRepository.findByTypeId(1));
		
		
		for (int i = 0; i < 100; i++) {
			DataLo data = new DataLo();
			if (i < 10) {
				data.setSo("0" + String.valueOf(i));
			}else {
				data.setSo(String.valueOf(i));
			}
			listData.add(data);
		}
		
		for (DataLo dtl : listData) {
			int diem = 0;
			int trung = 0;
			int luot = 0;
			for (Bet bet : listBetLo) {
				if (bet.getBetKey().equals(dtl.getSo())) {
					diem += bet.getAmount();
				}
			}
			for (LotResult lot : results) {
				if (lot.getLotKey().equals(dtl.getSo())) {
					trung += diem;
					luot++;
				}
			}
			dtl.setDiem(String.valueOf(diem));
			dtl.setTong(String.valueOf(trung));
			dtl.setSoLuot(String.valueOf(luot));
		}
		
		
		return listData;
	}

	public List<DataDe> getListDataDe() throws ParseException{
		List<DataDe> listData = new ArrayList<DataDe>();
		List<LotResult> results = new ArrayList<LotResult>();
		results = lotResultRepository.findAll();
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = fomat.parse("2020-07-08");
		List<Bet> listBetDe = new ArrayList<Bet>();
		listBetDe = betRepository.findByBetDateAndBetType(date, betTypeRepository.findByTypeId(2));
		
		for (int i = 0; i < 100; i++) {
			DataDe data = new DataDe();
			if (i < 10) {
				data.setSo("0" + String.valueOf(i));
			}else {
				data.setSo(String.valueOf(i));
			}
			listData.add(data);
		}
		
		for (DataDe dtd : listData) {
			int diem = 0;
			int trung = 0;
			for (Bet bet : listBetDe) {
				if (bet.getBetKey().equals(dtd.getSo())) {
					diem += bet.getAmount();
				}
			}
			for (LotResult lotResult : results) {
				if (lotResult.getLotRank() == 0 && dtd.getSo().equals(lotResult.getLotKey())) {
					trung += diem;
				}
			}
			
			dtd.setTienD(diem);
			dtd.setTienT(trung);
		}
		
		Collections.sort(listData, new DataDe());
		int index = 1;
		listData.get(0).setHang(index);
		for (int i = 1; i < 100; i++) {
			if (listData.get(i).getTienD() != listData.get(i - 1).getTienD()) {
				index++;
				listData.get(i).setHang(index);
			}else {
				listData.get(i).setHang(index);
			}
		}
		
		return listData;
	}
	
	public List<LotResult> getListResult() throws ParseException{
		List<LotResult> results = new ArrayList<LotResult>();
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = fomat.parse("2020-07-08");
		results = lotResultRepository.findByLotDateOrderByLotRankAsc(date);
		if (results.isEmpty() || results == null) {
			for (int i = 0; i < 27; i++) {
				LotResult lot  = new LotResult();
				results.add(lot);
			}
		}else if (results.size() < 27) {
			for (int i = results.size(); i < 27; i++) {
				LotResult lot = new LotResult();
				results.add(lot);
			}
		}
		
		return results;
	}
}
