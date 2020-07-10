package com.mydu.letian.controller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mydu.letian.entity.Base;
import com.mydu.letian.entity.BaseReport;
import com.mydu.letian.entity.Bet;
import com.mydu.letian.entity.LotResult;
import com.mydu.letian.repository.BaseRepository;
import com.mydu.letian.repository.BetRepository;
import com.mydu.letian.repository.BetTypeRepository;
import com.mydu.letian.repository.LotResultRepository;

@Controller
public class BaseReportController {

	@Autowired
	private BaseRepository baseRepository;
	
	@Autowired
	private BetRepository betRepository;

	@Autowired
	private LotResultRepository lotResultRepository;

	@Autowired
	private BetTypeRepository betTypeRepository;
	
	final DecimalFormat df = new DecimalFormat("#.###");
	
	@RequestMapping(value = { "/base-report" }, method = RequestMethod.GET)
	public String getBaseReport(Model model) throws ParseException {
		
		List<BaseReport> listBaseIn = new ArrayList<BaseReport>();
		List<BaseReport> listBaseOutt = new ArrayList<BaseReport>();
		
		BaseReport totalIn = new BaseReport();
		BaseReport totalOut = new BaseReport();
		listBaseIn = getListByBaseIn();
		listBaseOutt = getListByBaseOut();
		
		for (BaseReport baseReport : listBaseIn) {
			if (baseReport.getId().equals("TOTAL")) {
				totalIn = baseReport;
			}
		}
		
		for (BaseReport baseReport : listBaseOutt) {
			if (baseReport.getId().equals("TOTAL")) {
				totalOut = baseReport;
			}
		}
		
		BaseReport baseTotal = new BaseReport();
		baseTotal.setId("TỔNG BẢNG");
		baseTotal.setSumDiemLo(totalIn.getSumDiemLo());
		baseTotal.setSumTienDe(totalIn.getSumTienDe());
		baseTotal.setHh(String.valueOf(Double.valueOf(df.format(Double.parseDouble(totalOut.getChotLo()) + Double.parseDouble(totalIn.getChotLo()) + 
				Double.parseDouble(totalOut.getChotDe()) + Double.parseDouble(totalIn.getChotDe())))));
		
		model.addAttribute("listBaseIn", listBaseIn);
		model.addAttribute("listBaseOut", listBaseOutt);
		model.addAttribute("baseTotal", baseTotal);
		return "base-report";
	}
	
	public List<BaseReport> getListByBaseOut() throws ParseException{
		List<BaseReport> listBr = new ArrayList<BaseReport>();
		List<Base> listBase = new ArrayList<Base>();
		listBase = baseRepository.findAllBase();
		for (Base base : listBase) {
			BaseReport baseRp = this.getBaseReportByBaseOut(base);
			if (baseRp != null) {
				listBr.add(baseRp);
			}
		}
		System.out.println(listBr.size());
		
		List<BaseReport> listOut = new ArrayList<BaseReport>();
		listOut.addAll(listBr);
		double tt1 = 0;double tt2 = 0;double tt3 = 0;double tt4 = 0;double tt5 = 0;
		double tt6 = 0;double tt7 = 0;double tt8 = 0;double tt9 = 0;//double tt10 = 0;
		//double chotlo = 0; 
		//double chotDe = 0;
		for (BaseReport baseReport : listBr) {
			tt1 += Double.valueOf(df.format(Double.parseDouble(baseReport.getSumDiemLo())));
			tt2 += Double.valueOf(df.format(Double.parseDouble(baseReport.getSumDiemWinLo())));
			tt3 += Double.valueOf(df.format(Double.parseDouble(baseReport.getSumTienLo())));
			tt4 += Double.valueOf(df.format(Double.parseDouble(baseReport.getSunTienWinLo())));
			tt6 += Double.valueOf(df.format(Double.parseDouble(baseReport.getSumTienDe())));
			tt7 += Double.valueOf(df.format(Double.parseDouble(baseReport.getSumTienWinDe())));
			//chotlo += Double.valueOf(df.format(Double.parseDouble(baseReport.getChotLo())));
			
			//chotDe += Double.parseDouble(baseReport.getChotDe());
		}
		
		tt5 = Double.valueOf(df.format(tt4 - tt3));
		tt8 = Double.valueOf(df.format(tt7 - tt6));
		tt9 = Double.valueOf(df.format(tt5 + tt8));
		//tt10 = Double.valueOf(df.format(tt5 - chotlo + tt8 * 0.015));
		BaseReport baseTotal = new BaseReport();
		baseTotal.setId("TOTAL");
		baseTotal.setSumDiemLo(String.valueOf((int)tt1));
		baseTotal.setSumDiemWinLo(String.valueOf((int)tt2));
		baseTotal.setSumTienLo(String.valueOf(tt3));
		baseTotal.setSunTienWinLo(String.valueOf(tt4));
		baseTotal.setChotLo(String.valueOf(tt5));
		baseTotal.setSumTienDe(String.valueOf(tt6));
		baseTotal.setSumTienWinDe(String.valueOf(tt7));
		baseTotal.setChotDe(String.valueOf(tt8));
		baseTotal.setTotal(String.valueOf(tt9));
		//baseTotal.setHh(String.valueOf(tt10));
		
		listOut.add(baseTotal);
		
		return listOut;
	}
	
	public List<BaseReport> getListByBaseIn() throws ParseException{
		List<BaseReport> listBr = new ArrayList<BaseReport>();
		List<Base> listBase = new ArrayList<Base>();
		listBase = baseRepository.findAllBase();
		for (Base base : listBase) {
			BaseReport baseRp = this.getBaseReportByBaseIn(base);
			if (baseRp != null) {
				listBr.add(baseRp);
			}
		}
		System.out.println(listBr.size());
		
		List<BaseReport> listOut = new ArrayList<BaseReport>();
		listOut.addAll(listBr);
		double tt1 = 0;double tt2 = 0;double tt3 = 0;double tt4 = 0;double tt5 = 0;
		double tt6 = 0;double tt7 = 0;double tt8 = 0;double tt9 = 0;//double tt10 = 0;
		//double chotlo = 0; 
		//double chotDe = 0;
		for (BaseReport baseReport : listBr) {
			tt1 += Double.valueOf(df.format(Double.parseDouble(baseReport.getSumDiemLo())));
			tt2 += Double.valueOf(df.format(Double.parseDouble(baseReport.getSumDiemWinLo())));
			tt3 += Double.valueOf(df.format(Double.parseDouble(baseReport.getSumTienLo())));
			tt4 += Double.valueOf(df.format(Double.parseDouble(baseReport.getSunTienWinLo())));
			tt6 += Double.valueOf(df.format(Double.parseDouble(baseReport.getSumTienDe())));
			tt7 += Double.valueOf(df.format(Double.parseDouble(baseReport.getSumTienWinDe())));
			//chotlo += Double.valueOf(df.format(Double.parseDouble(baseReport.getChotLo())));
			//chotDe += Double.valueOf(df.format(Double.parseDouble(baseReport.getChotDe())));
		}
		
		tt5 = Double.valueOf(df.format(tt3 - tt4));
		tt8 = Double.valueOf(df.format(tt6 - tt7));
		tt9 = Double.valueOf(df.format(tt5 + tt8));
		//tt10 = Double.valueOf(df.format(tt5 - chotlo + tt8 * 0.015));
		BaseReport baseTotal = new BaseReport();
		baseTotal.setId("TOTAL");
		baseTotal.setSumDiemLo(String.valueOf((int)tt1));
		baseTotal.setSumDiemWinLo(String.valueOf((int)tt2));
		baseTotal.setSumTienLo(String.valueOf(tt3));
		baseTotal.setSunTienWinLo(String.valueOf(tt4));
		baseTotal.setChotLo(String.valueOf(tt5));
		baseTotal.setSumTienDe(String.valueOf(tt6));
		baseTotal.setSumTienWinDe(String.valueOf(tt7));
		baseTotal.setChotDe(String.valueOf(tt8));
		baseTotal.setTotal(String.valueOf(tt9));
		//baseTotal.setHh(String.valueOf(tt10));
		
		listOut.add(baseTotal);
		
		return listOut;
	}
	
	public BaseReport getBaseReportByBaseOut(Base base) throws ParseException {
		
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = fomat.parse("2020-07-08");
		List<Bet> listbetLo = new ArrayList<Bet>();
		listbetLo = betRepository.findByBaseOutAndBetDateAndBetType(base, date, betTypeRepository.findByTypeId(1));
		List<Bet> listbetDe = new ArrayList<Bet>();
		listbetDe = betRepository.findByBaseOutAndBetDateAndBetType(base, date, betTypeRepository.findByTypeId(2));
		
		if (listbetLo.isEmpty() && listbetDe.isEmpty()) {
			return null;
		}
		
		List<LotResult> results = new ArrayList<LotResult>();
		results = lotResultRepository.findByLotDate(date);
		int amountLo = 0;
		int diemTrung = 0;
		for (Bet bet : listbetLo) {
			amountLo += bet.getAmount();
			for (LotResult lotResult : results) {
				if (bet.getBetKey().equals(lotResult.getLotKey())) {
					diemTrung += bet.getAmount();
				}
			}
		}
		
		int amountDe = 0;
		int tienWinDe = 0;
		for (Bet bet : listbetDe) {
			amountDe += bet.getAmount();
			for (LotResult lotResult : results) {
				if (lotResult.getLotRank() == 0 && bet.getBetKey().equals(lotResult.getLotKey())) {
					tienWinDe += bet.getAmount();
				}
			}
			
		}
		
		BaseReport br = new BaseReport();
		br.setSumDiemLo(String.valueOf(amountLo));
		br.setSumDiemWinLo(String.valueOf(diemTrung));
		br.setId(base.getBaseName());
		br.setSumTienLo(String.valueOf(Double.valueOf(df.format(amountLo * base.getRateLIn()))));
		br.setSunTienWinLo(String.valueOf(Double.valueOf(df.format(diemTrung * base.getRateLOut()))));
		br.setChotLo(String.valueOf(Double.valueOf(df.format(diemTrung * base.getRateLOut() - amountLo * base.getRateLIn()))));
		br.setSumTienDe(String.valueOf(Double.valueOf(df.format(amountDe))));
		br.setSumTienWinDe(String.valueOf(Double.valueOf(df.format(tienWinDe * base.getRateD()))));
		br.setChotDe(String.valueOf(Double.valueOf(df.format(tienWinDe * base.getRateD() - amountDe))));
		br.setTotal(String.valueOf(Double.valueOf(df.format((diemTrung * base.getRateLOut() - amountLo * base.getRateLIn()) + 
											(tienWinDe * base.getRateD() - amountDe)))));
		br.setHh("");
		
		return br;
	}
	
public BaseReport getBaseReportByBaseIn(Base base) throws ParseException {
		
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = fomat.parse("2020-07-08");
		List<Bet> listbetLo = new ArrayList<Bet>();
		listbetLo = betRepository.getByBaseInAndBetDateAndBetType(base, date, betTypeRepository.findByTypeId(1));
		List<Bet> listbetDe = new ArrayList<Bet>();
		listbetDe = betRepository.getByBaseInAndBetDateAndBetType(base, date, betTypeRepository.findByTypeId(2));
		
		if (listbetLo.isEmpty() && listbetDe.isEmpty()) {
			return null;
		}
		
		List<LotResult> results = new ArrayList<LotResult>();
		results = lotResultRepository.findByLotDate(date);
		int amountLo = 0;
		int diemTrung = 0;
		for (Bet bet : listbetLo) {
			amountLo += bet.getAmount();
			for (LotResult lotResult : results) {
				if (bet.getBetKey().equals(lotResult.getLotKey())) {
					diemTrung += bet.getAmount();
				}
			}
		}
		
		int amountDe = 0;
		int tienWinDe = 0;
		for (Bet bet : listbetDe) {
			amountDe += bet.getAmount();
			for (LotResult lotResult : results) {
				if (lotResult.getLotRank() == 0 && bet.getBetKey().equals(lotResult.getLotKey())) {
					tienWinDe += bet.getAmount();
				}
			}
			
		}
		
		BaseReport br = new BaseReport();
		br.setSumDiemLo(String.valueOf(amountLo));
		br.setSumDiemWinLo(String.valueOf(diemTrung));
		br.setId(base.getBaseName());
		br.setSumTienLo(String.valueOf(Double.valueOf(df.format(amountLo * base.getRateLIn()))));
		br.setSunTienWinLo(String.valueOf(Double.valueOf(df.format(diemTrung * base.getRateLOut()))));
		br.setChotLo(String.valueOf(Double.valueOf(df.format(amountLo * base.getRateLIn() - diemTrung * base.getRateLOut()))));
		br.setSumTienDe(String.valueOf(Double.valueOf(df.format(amountDe))));
		br.setSumTienWinDe(String.valueOf(Double.valueOf(df.format(tienWinDe * base.getRateD()))));
		br.setChotDe(String.valueOf(Double.valueOf(df.format(amountDe - tienWinDe * base.getRateD()))));
		br.setTotal(String.valueOf(Double.valueOf(df.format((amountLo * base.getRateLIn() - diemTrung * base.getRateLOut()) + 
											(amountDe - tienWinDe * base.getRateD())))));
		br.setHh("");
		
		return br;
	}
	
	public Date getToday() {
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);
		return date;
	}
}
