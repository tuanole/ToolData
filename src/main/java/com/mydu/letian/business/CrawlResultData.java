package com.mydu.letian.business;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import com.mydu.letian.entity.LotResult;
import com.mydu.letian.repository.LotResultRepository;

public class CrawlResultData {
	
	@Autowired
	LotResultRepository lotRepository;

	public static void main(String[] args) throws IOException, ParseException {
		Document doc = Jsoup.connect("https://xosodaiphat.com/xsmb-xo-so-mien-bac.html").get();
		
		//https://xosodaiphat.com/xsmb-xo-so-mien-bac.html
		//https://www.minhngoc.net.vn/getkqxs/mien-bac.js

		CrawlResultData cr = new CrawlResultData();
		
		
		SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
		Date newDate = cr.getToday();
		String today = "kqngay_" + df.format(newDate);
		List<LotResult> listData = new ArrayList<LotResult>();
		//System.out.println(dayDP.text());
		Element dayDP = doc.getElementById(today);
		String checkDay = dayDP.text().toString();
		
		if (!checkDay.trim().equals("")) {
			Element GDB = doc.getElementById("mb_prize_DB_item_0");
			if (!GDB.text().equals("")) {
				listData.add(cr.getLotResult(0, GDB, newDate));
			}
			
			Element G1 = doc.getElementById("mb_prize_1_item_0");
			if (!G1.text().equals("")) {
				listData.add(cr.getLotResult(1, G1, newDate));
			}
			
			Element G2_1 = doc.getElementById("mb_prize_2_item_0");
			if (!G2_1.text().equals("")) {
				listData.add(cr.getLotResult(2, G2_1, newDate));
			}
			
			Element G2_2 = doc.getElementById("mb_prize_2_item_1");
			if (!G2_2.text().equals("")) {
				listData.add(cr.getLotResult(2, G2_2, newDate));
			}
			
			Element G3_1 = doc.getElementById("mb_prize_3_item_0");
			if (!G3_1.text().equals("")) {
				listData.add(cr.getLotResult(3, G3_1, newDate));
			}
			
			Element G3_2 = doc.getElementById("mb_prize_3_item_1");
			if (!G3_2.text().equals("")) {
				listData.add(cr.getLotResult(3, G3_2, newDate));
			}
			
			Element G3_3 = doc.getElementById("mb_prize_3_item_2");
			if (!G3_3.text().equals("")) {
				listData.add(cr.getLotResult(3, G3_3, newDate));
			}

			Element G3_4 = doc.getElementById("mb_prize_3_item_3");
			if (!G3_4.text().equals("")) {
				listData.add(cr.getLotResult(3, G3_4, newDate));
			}
			
			Element G3_5 = doc.getElementById("mb_prize_3_item_4");
			if (!G3_5.text().equals("")) {
				listData.add(cr.getLotResult(3, G3_5, newDate));
			}

			Element G3_6 = doc.getElementById("mb_prize_3_item_5");
			if (!G3_6.text().equals("")) {
				listData.add(cr.getLotResult(3, G3_6, newDate));
			}

			Element G4_1 = doc.getElementById("mb_prize_4_item_0");
			if (!G4_1.text().equals("")) {
				listData.add(cr.getLotResult(4, G4_1, newDate));
			}

			Element G4_2 = doc.getElementById("mb_prize_4_item_1");
			if (!G4_2.text().equals("")) {
				listData.add(cr.getLotResult(4, G4_2, newDate));
			}

			Element G4_3 = doc.getElementById("mb_prize_4_item_2");
			if (!G4_3.text().equals("")) {
				listData.add(cr.getLotResult(4, G4_3, newDate));
			}

			Element G4_4 = doc.getElementById("mb_prize_4_item_3");
			if (!G4_4.text().equals("")) {
				listData.add(cr.getLotResult(4, G4_4, newDate));
			}

			Element G5_1 = doc.getElementById("mb_prize_5_item_0");
			if (!G5_1.text().equals("")) {
				listData.add(cr.getLotResult(5, G5_1, newDate));
			}

			Element G5_2 = doc.getElementById("mb_prize_5_item_1");
			if (!G5_2.text().equals("")) {
				listData.add(cr.getLotResult(5, G5_2, newDate));
			}

			Element G5_3 = doc.getElementById("mb_prize_5_item_2");
			if (!G5_3.text().equals("")) {
				listData.add(cr.getLotResult(5, G5_3, newDate));
			}

			Element G5_4 = doc.getElementById("mb_prize_5_item_3");
			if (!G5_4.text().equals("")) {
				listData.add(cr.getLotResult(5, G5_4, newDate));
			}

			Element G5_5 = doc.getElementById("mb_prize_5_item_4");
			if (!G5_5.text().equals("")) {
				listData.add(cr.getLotResult(5, G5_5, newDate));
			}

			Element G5_6 = doc.getElementById("mb_prize_5_item_5");
			if (!G5_6.text().equals("")) {
				listData.add(cr.getLotResult(5, G5_6, newDate));
			}

			Element G6_1 = doc.getElementById("mb_prize_6_item_0");
			if (!G6_1.text().equals("")) {
				listData.add(cr.getLotResult(6, G6_1, newDate));
			}

			Element G6_2 = doc.getElementById("mb_prize_6_item_1");
			if (!G6_2.text().equals("")) {
				listData.add(cr.getLotResult(0, G6_2, newDate));
			}

			Element G6_3 = doc.getElementById("mb_prize_6_item_2");
			if (!G6_3.text().equals("")) {
				listData.add(cr.getLotResult(6, G6_3, newDate));
			}
			Element G7_1 = doc.getElementById("mb_prize_7_item_0");
			if (!G7_1.text().equals("")) {
				listData.add(cr.getLotResult7(G7_1, newDate));
			}

			Element G7_2 = doc.getElementById("mb_prize_7_item_1");
			if (!G7_2.text().equals("")) {
				listData.add(cr.getLotResult7(G7_2, newDate));
			}

			Element G7_3 = doc.getElementById("mb_prize_7_item_2");
			if (!G7_3.text().equals("")) {
				listData.add(cr.getLotResult7(G7_3, newDate));
			}

			Element G7_4 = doc.getElementById("mb_prize_7_item_3");
			if (!G7_4.text().equals("")) {
				listData.add(cr.getLotResult7(G7_4, newDate));
			}
			System.out.println(listData.size());
		}
		
		
		
		
		
		
		
		
//		Elements dates = doc.getElementsByClass("ngay");
//		Elements elsdb = doc.getElementsByClass("giaidb");
//		Elements els1 = doc.getElementsByClass("giai1");
//		Elements els2 = doc.getElementsByClass("giai2");
//		Elements els3 = doc.getElementsByClass("giai3");
//		Elements els4 = doc.getElementsByClass("giai4");
//		Elements els5 = doc.getElementsByClass("giai5");
//		Elements els6 = doc.getElementsByClass("giai6");
//		Elements els7 = doc.getElementsByClass("giai7");
//
//		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
//		List<LotResult> listLot = new ArrayList<LotResult>();
//		String strDate = dates.text();
//		String lotDate = strDate.substring(strDate.indexOf(" ") + 1, strDate.length());
//		String [] out = lotDate.split("/");
//		String temp = out[2] + "-" + out[1] + "-" + out[0];
//		
//		
//		
//		
//		String strDb = elsdb.text();
//		Date date = fomat.parse(temp);
//		LotResult lot = new LotResult();
//		lot.setLotDate(date);
//		lot.setLotRank(0);
//		lot.setLotKey(strDb.substring(strDb.length() - 2));
//		listLot.add(lot);
//		
//		String str1 = els1.text();
//		LotResult lot1 = new LotResult();
//		lot1.setLotDate(date);
//		lot1.setLotRank(1);
//		lot1.setLotKey(str1.substring(str1.length() - 2));
//		listLot.add(lot1);
//		
//		listLot.addAll(cr.getListByRank(els2, 2, date));
//		listLot.addAll(cr.getListByRank(els3, 3, date));
//		listLot.addAll(cr.getListByRank(els4, 4, date));
//		listLot.addAll(cr.getListByRank(els5, 5, date));
//		listLot.addAll(cr.getListByRank(els6, 6, date));
//		listLot.addAll(cr.getListByRank(els7, 7, date));
//		
//		System.out.println(listLot.size());
//		for (LotResult lotSave : listLot) {
//			cr.lotRepository.save(lotSave);
//		}
		

	}
	
	public List<LotResult> getListByRank(Elements e, int rank, Date date){
		List<LotResult> listLot = new ArrayList<LotResult>();
		String str = e.text();
		String [] strLot = str.split("-");
		for (String string : strLot) {
			LotResult lotrs = new LotResult();
			lotrs.setLotDate(date);
			lotrs.setLotRank(rank);
			lotrs.setLotKey(string.substring(string.length() - 2));
			listLot.add(lotrs);
		}
		return listLot;
	}
	
	public Date getToday() {
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);
		return date;
	}
	
	public LotResult getLotResult(int rank, Element key, Date date) {
		String keyDb = key.text().substring(key.text().length() - 2);
		LotResult lot = new LotResult();
		lot.setLotDate(date);
		lot.setLotKey(keyDb);
		lot.setLotRank(rank);
		
		return lot;
	}
	
	public LotResult getLotResult7(Element key, Date date) {
		String keyDb = key.text();
		LotResult lot = new LotResult();
		lot.setLotDate(date);
		lot.setLotKey(keyDb);
		lot.setLotRank(7);
		return lot;
	}

}
