package com.mydu.letian.business;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mydu.letian.entity.LotResult;
import com.mydu.letian.repository.LotResultRepository;

@Service
public class GetLotResultService {
	
	@Autowired
	LotResultRepository lotResultRepository;
	
	@Scheduled(cron = "0/5 10-35 9-19 * * *")
	public void getLotResults(){
		Document doc = null;
		SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat dfo = new SimpleDateFormat("yyyy-MM-dd");
		String lotDate = dfo.format(this.getToday());
		Date newDate = null;
		try {
			doc = Jsoup.connect("https://xosodaiphat.com/xsmb-xo-so-mien-bac.html").get();
			newDate = dfo.parse(lotDate);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//https://xosodaiphat.com/xsmb-xo-so-mien-bac.html
		//https://www.minhngoc.net.vn/getkqxs/mien-bac.js
		
		String today = "kqngay_" + df.format(this.getToday());
		Element dayDP = doc.getElementById(today);
		String checkDay = dayDP.text().toString();
		System.out.println(checkDay);
		
		if (!checkDay.trim().equals("")) {
			Element GDB = doc.getElementById("mb_prize_DB_item_0");
			if (!GDB.text().equals("") && !GDB.text().contains(".")) {
				System.out.println(GDB.text());
				getLotResult(0, GDB, newDate, 0);
			}
			
			Element G1 = doc.getElementById("mb_prize_1_item_0");
			if (!G1.text().equals("") && !G1.text().contains(".")) {
				System.out.println(G1.text());
				getLotResult(1, G1, newDate, 1);
			}
			
			Element G2_1 = doc.getElementById("mb_prize_2_item_0");
			if (!G2_1.text().equals("") && !G2_1.text().contains(".")) {
				System.out.println(G2_1.text());
				getLotResult(2, G2_1, newDate, 20);
			}
			
			Element G2_2 = doc.getElementById("mb_prize_2_item_1");
			if (!G2_2.text().equals("") && !G2_2.text().contains(".")) {
				System.out.println(G2_2.text());
				getLotResult(2, G2_2, newDate, 21);
			}
			
			Element G3_1 = doc.getElementById("mb_prize_3_item_0");
			if (!G3_1.text().equals("") && !G3_1.text().contains(".")) {
				getLotResult(3, G3_1, newDate, 30);
			}
			
			Element G3_2 = doc.getElementById("mb_prize_3_item_1");
			if (!G3_2.text().equals("") && !G3_2.text().contains(".")) {
				getLotResult(3, G3_2, newDate, 31);
			}
			
			Element G3_3 = doc.getElementById("mb_prize_3_item_2");
			if (!G3_3.text().equals("") && !G3_3.text().contains(".")) {
				getLotResult(3, G3_3, newDate, 32);
			}

			Element G3_4 = doc.getElementById("mb_prize_3_item_3");
			if (!G3_4.text().equals("") && !G3_4.text().contains(".")) {
				getLotResult(3, G3_4, newDate, 33);
			}
			
			Element G3_5 = doc.getElementById("mb_prize_3_item_4");
			if (!G3_5.text().equals("") && !G3_5.text().contains(".")) {
				getLotResult(3, G3_5, newDate, 34);
			}

			Element G3_6 = doc.getElementById("mb_prize_3_item_5");
			if (!G3_6.text().equals("") && !G3_6.text().contains(".")) {
				getLotResult(3, G3_6, newDate, 35);
			}

			Element G4_1 = doc.getElementById("mb_prize_4_item_0");
			if (!G4_1.text().equals("") && !G4_1.text().contains(".")) {
				getLotResult(4, G4_1, newDate, 40);
			}

			Element G4_2 = doc.getElementById("mb_prize_4_item_1");
			if (!G4_2.text().equals("") && !G4_2.text().contains(".")) {
				getLotResult(4, G4_2, newDate, 41);
			}

			Element G4_3 = doc.getElementById("mb_prize_4_item_2");
			if (!G4_3.text().equals("") && !G4_3.text().contains(".")) {
				getLotResult(4, G4_3, newDate, 42);
			}

			Element G4_4 = doc.getElementById("mb_prize_4_item_3");
			if (!G4_4.text().equals("") && !G4_4.text().contains(".")) {
				getLotResult(4, G4_4, newDate, 43);
			}

			Element G5_1 = doc.getElementById("mb_prize_5_item_0");
			if (!G5_1.text().equals("") && !G5_1.text().contains(".")) {
				getLotResult(5, G5_1, newDate, 50);
			}

			Element G5_2 = doc.getElementById("mb_prize_5_item_1");
			if (!G5_2.text().equals("") && !G5_2.text().contains(".")) {
				getLotResult(5, G5_2, newDate, 51);
			}

			Element G5_3 = doc.getElementById("mb_prize_5_item_2");
			if (!G5_3.text().equals("") && !G5_3.text().contains(".")) {
				getLotResult(5, G5_3, newDate, 52);
			}

			Element G5_4 = doc.getElementById("mb_prize_5_item_3");
			if (!G5_4.text().equals("") && !G5_4.text().contains(".")) {
				getLotResult(5, G5_4, newDate, 53);
			}

			Element G5_5 = doc.getElementById("mb_prize_5_item_4");
			if (!G5_5.text().equals("") && !G5_5.text().contains(".")) {
				getLotResult(5, G5_5, newDate, 54);
			}

			Element G5_6 = doc.getElementById("mb_prize_5_item_5");
			if (!G5_6.text().equals("") && !G5_6.text().contains(".")) {
				getLotResult(5, G5_6, newDate, 55);
			}

			Element G6_1 = doc.getElementById("mb_prize_6_item_0");
			if (!G6_1.text().equals("") && !G6_1.text().contains(".")) {
				getLotResult(6, G6_1, newDate, 60);
			}

			Element G6_2 = doc.getElementById("mb_prize_6_item_1");
			if (!G6_2.text().equals("") && !G6_2.text().contains(".")) {
				getLotResult(6, G6_2, newDate, 61);
			}

			Element G6_3 = doc.getElementById("mb_prize_6_item_2");
			if (!G6_3.text().equals("") && !G6_3.text().contains(".")) {
				getLotResult(6, G6_3, newDate, 62);
			}
			Element G7_1 = doc.getElementById("mb_prize_7_item_0");
			if (!G7_1.text().equals("") && !G7_1.text().contains(".")) {
				getLotResult(7, G7_1, newDate, 70);
			}

			Element G7_2 = doc.getElementById("mb_prize_7_item_1");
			if (!G7_2.text().equals("") && !G7_2.text().contains(".")) {
				getLotResult(7, G7_2, newDate, 71);
			}

			Element G7_3 = doc.getElementById("mb_prize_7_item_2");
			if (!G7_3.text().equals("") && !G7_3.text().contains(".")) {
				getLotResult(7, G7_3, newDate, 72);
			}

			Element G7_4 = doc.getElementById("mb_prize_7_item_3");
			if (!G7_4.text().equals("") && !G7_4.text().contains(".")) {
				getLotResult(7, G7_4, newDate, 73);
			}
			
		}
	}
	public Date getToday() {
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);
		return date;
	}
	
	public void getLotResult(int rank, Element key, Date date, int prize) {
		String keyDb = key.text().substring(key.text().length() - 2);
		LotResult lot = new LotResult();
		lot.setLotDate(date);
		lot.setLotKey(keyDb);
		lot.setLotRank(rank);
		lot.setLotPrize(prize);
		LotResult lotnew = lotResultRepository.getByLotDateAndLotPrize(date, prize);
		if (lotnew == null) {
			lotResultRepository.save(lot);
			System.out.println("Save record: " + lot.getLotPrize());
		}

	}
	
	public void getLotResultSt(int rank, String key, Date date, int prize) {
		LotResult lot = new LotResult();
		lot.setLotDate(date);
		lot.setLotKey(key);
		lot.setLotRank(rank);
		lot.setLotPrize(prize);
		LotResult lotnew = lotResultRepository.getByLotDateAndLotPrize(date, prize);
		if (lotnew == null) {
			lotResultRepository.save(lot);
			System.out.println("Save record: " + lot.getLotPrize());
		}

	}
	
	public void getLotResult7(Element key, Date date, int prize) {
		String keyDb = key.text();
		LotResult lot = new LotResult();
		lot.setLotDate(date);
		lot.setLotKey(keyDb);
		lot.setLotRank(7);
		lot.setLotPrize(prize);
		LotResult lotnew = new LotResult();
		lotnew = lotResultRepository.getByLotDateAndLotPrize(date, prize);
		if (lotnew == null) {
			lotResultRepository.save(lot);
			System.out.println("Save record: " + lot.getLotPrize());
		}
	}
}
