package com.mydu.letian.dataanalysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mydu.letian.entity.BoSo;
import com.mydu.letian.entity.lo.Lo;

public class CommonStringLo {
	
	public String chuanHoaSpace(String str) {
		String out = xoaBoNgoaiKVaX(str);
		return out.replaceAll("\\s+", " ");
	}
	
	public String chuanHoaSpaceLD(String str) {
		String out = xoaBoNgoaiDVaX(str);
		return out.replaceAll("\\s+", " ");
	}
	
	public String xoaBoNgoaiKVaX(String str) {
		str = str.replaceAll("[^K X B D Đ ₫ đ\\.\\, \\s 0-9]", "");
		return str;
	}
	
	public String xoaBoNgoaiDVaX(String str) {
		str = str.replaceAll("[^X B D đ L\\.\\, \\s 0-9]", "");
		return str;
	}
	
	public String formatChuan(String str) {
		String out = str.replaceAll("[^a-zA-Z 0-9 Đ ₫]", " ");
		return chuanHoa(out);
	}
	
	public String chuanHoa(String str) {
		str = str.replaceAll("\\s+X\\s+", "X");
		str = str.replaceAll("\\s+X", "X");
		str = str.replaceAll("X\\s+", "X");
		str = str.replaceAll("\\s+D\\s+", "D ");
		str = str.replaceAll("\\s+D", "D ");
		str = str.replaceAll("D\\s+", "D ");
		return str;
	}
	
	public String convertNghinToK(String str) {
		String out = str.toUpperCase();
		String strConvert = "";
		strConvert = out.replaceAll("Đ", "D");
		strConvert = strConvert.replaceAll("₫", "D");
		strConvert = strConvert.replaceAll("\\(", "X");
		strConvert = strConvert.replaceAll("×", "X");
		strConvert = strConvert.replaceAll("-", "X");
		return strConvert;
	}
	
	public List<String> splitByD(String str) {
		String [] out = str.split("D");
		List<String> listOut = new ArrayList<String>();
		for (String string : out) {
			listOut.add(string.trim());
		}
		return listOut;
	}
	
	public String fixXoaBoX(String str) {
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == 'X' && !Character.isDigit(str.charAt(i - 1))) {
				str = str.substring(i + 1, str.length());
				return str;
			}
		}
		return str;
	}
	
	public List<Lo> convertStringToLo(String str, String baseIn, String baseOut) {
		List<Lo> listLo = new ArrayList<>();
		str = fixXoaBoX(str);
		String soDanh = str.substring(0, str.indexOf('X'));
		String [] out = soDanh.split(" ");
		String diem = str.substring(str.indexOf('X') + 1, str.length());
		for (String string : out) {
			if (string.length() == 3) {
				List<String> fix3 = fix3Digit(string);
				for (String string2 : fix3) {
					Lo lo = new Lo();
					lo.setSoDanh(string2);
					lo.setDiem(diem);
					lo.setBaseIn(baseIn);
					lo.setBaseOut(baseOut);
					listLo.add(lo);
				}
				
			}else {
				Lo lo = new Lo();
				if (string.length() == 1) {
					lo.setSoDanh("0" + string);
				}else {
					lo.setSoDanh(string);
				}
				lo.setDiem(diem);
				lo.setBaseIn(baseIn);
				lo.setBaseOut(baseOut);
				listLo.add(lo);
			}
		}
		return listLo;
	}
	
	public String convertToD(String str) {
		String out = str.toUpperCase();
		String strConvert = out.replaceAll("Đ", "D");
		return strConvert;
	}
	
	public List<String> fix3Digit(String str) {
		List<String> listOut = new ArrayList<String>();
		for (int i = 0; i < str.length() - 1; i++) {
			listOut.add(str.substring(i, i + 2));
		}
		return listOut;
	}
	
	public int countDigit(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				count++;
			}
		}
		return count;
	}
	
	
	public List<Lo> convertStringToLoDau(String str, String baseIn, String baseOut) {
		List<Lo> listLo = new ArrayList<>();
		int idex = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				idex = i;
				break;
			}
		}
		String StringLo = str.substring(idex, str.length());
		String soLo = StringLo.substring(0, StringLo.indexOf('X'));
		String diemDanh = "";
		if (StringLo.contains("D")) {
			diemDanh = StringLo.substring(StringLo.indexOf('X') + 1, StringLo.trim().indexOf('D')).trim();
		}else if (StringLo.contains("B") && !StringLo.contains("D")) {
			diemDanh = StringLo.substring(StringLo.indexOf('X') + 1, StringLo.indexOf("B")).trim();
		}else{
			diemDanh = StringLo.substring(StringLo.indexOf('X') + 1, StringLo.trim().length()).trim();
		}
	   
		int count = countDigit(soLo);
		if (count == 1) {
			if (StringLo.contains("B")) {
				int index = StringLo.indexOf("B");
				String sobo = StringLo.substring(index + 1, StringLo.length());
				String [] out = sobo.trim().split(" ");
				for (int i = 0; i < 10; i++) {
					Lo lodau = new Lo();
					lodau.setSoDanh(StringLo.charAt(0) + String.valueOf(i));
					lodau.setDiem(diemDanh);
					lodau.setBaseIn(baseIn);
					lodau.setBaseOut(baseOut);
					listLo.add(lodau);
				}
				for (String string : out) {
					for (Lo deDau : listLo) {
						if (string.equalsIgnoreCase(deDau.getSoDanh())) {
							listLo.remove(deDau);
							break;
						}
					}
				}
			}else {
				for (int i = 0; i < 10; i++) {
					Lo loDau = new Lo();
					loDau.setSoDanh(StringLo.charAt(0) + String.valueOf(i));
					loDau.setDiem(diemDanh);
					loDau.setBaseIn(baseIn);
					loDau.setBaseOut(baseOut);
					listLo.add(loDau);
				}
			}
			
		}else if (count > 1) {
			String [] sodanhOut = soLo.trim().split(" ");
			for (String string : sodanhOut) {
				if (StringLo.contains("B")) {
					int index = StringLo.indexOf("B");
					String sobo = StringLo.substring(index + 1, StringLo.length());
					String [] out = sobo.trim().split(" ");
					for (int i = 0; i < 10; i++) {
						Lo loDau = new Lo();
						loDau.setSoDanh(string.charAt(0) + String.valueOf(i));
						loDau.setDiem(diemDanh);
						loDau.setBaseIn(baseIn);
						loDau.setBaseOut(baseOut);
						listLo.add(loDau);
					}
					for (String string2 : out) {
						for (Lo loDau : listLo) {
							if (string2.equalsIgnoreCase(loDau.getSoDanh())) {
								listLo.remove(loDau);
								break;
							}
						}
					}
				}else {
					for (int i = 0; i < 10; i++) {
						Lo loDau = new Lo();
						loDau.setSoDanh(string.charAt(0) + String.valueOf(i));
						loDau.setDiem(diemDanh);
						loDau.setBaseIn(baseIn);
						loDau.setBaseOut(baseOut);
						listLo.add(loDau);
					}
				}
			}
			
		} 
		return listLo;
	}
	
	public List<Lo> convertStringToLoDit(String str, String baseIn, String baseOut) {
		List<Lo> listLo = new ArrayList<>();
		int idex = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				idex = i;
				break;
			}
		}
		String StringLo = str.substring(idex, str.length());
		String soLo = StringLo.substring(0, StringLo.indexOf('X'));
		String diemDanh = "";
		if (StringLo.contains("D")) {
			diemDanh = StringLo.substring(StringLo.indexOf('X') + 1, StringLo.trim().indexOf('D')).trim();
		}else if (StringLo.contains("B") && !StringLo.contains("D")) {
			diemDanh = StringLo.substring(StringLo.indexOf('X') + 1, StringLo.indexOf("B")).trim();
		}else{
			diemDanh = StringLo.substring(StringLo.indexOf('X') + 1, StringLo.trim().length()).trim();
		}
		int count = countDigit(soLo);
		if (count == 1) {
			if (StringLo.contains("B")) {
				int index = StringLo.indexOf("B");
				String sobo = StringLo.substring(index + 1, StringLo.length());
				String [] out = sobo.trim().split(" ");
				for (int i = 0; i < 10; i++) {
					Lo lodau = new Lo();
					lodau.setSoDanh(String.valueOf(i) + StringLo.charAt(0));
					lodau.setDiem(diemDanh);
					lodau.setBaseIn(baseIn);
					lodau.setBaseOut(baseOut);
					listLo.add(lodau);
				}
				for (String string : out) {
					for (Lo deDau : listLo) {
						if (string.equalsIgnoreCase(deDau.getSoDanh())) {
							listLo.remove(deDau);
							break;
						}
					}
				}
			}else {
				for (int i = 0; i < 10; i++) {
					Lo loDau = new Lo();
					loDau.setSoDanh(String.valueOf(i) + StringLo.charAt(0));
					loDau.setDiem(diemDanh);
					loDau.setBaseIn(baseIn);
					loDau.setBaseOut(baseOut);
					listLo.add(loDau);
				}
			}
			
		}else if (count > 1) {
			String [] sodanhOut = soLo.trim().split(" ");
			for (String string : sodanhOut) {
				if (StringLo.contains("B")) {
					int index = StringLo.indexOf("B");
					String sobo = StringLo.substring(index + 1, StringLo.length());
					String [] out = sobo.trim().split(" ");
					for (int i = 0; i < 10; i++) {
						Lo loDau = new Lo();
						loDau.setSoDanh(String.valueOf(i) + string.charAt(0));
						loDau.setDiem(diemDanh);
						loDau.setBaseIn(baseIn);
						loDau.setBaseOut(baseOut);
						listLo.add(loDau);
					}
					for (String string2 : out) {
						for (Lo loDau : listLo) {
							if (string2.equalsIgnoreCase(loDau.getSoDanh())) {
								listLo.remove(loDau);
								break;
							}
						}
					}
				}else {
					for (int i = 0; i < 10; i++) {
						Lo loDau = new Lo();
						loDau.setSoDanh(String.valueOf(i) + string.charAt(0));
						loDau.setDiem(diemDanh);
						loDau.setBaseIn(baseIn);
						loDau.setBaseOut(baseOut);
						listLo.add(loDau);
					}
				}
			}
			
		} 
		return listLo;
	}
	
	public List<Lo> convertStringToLoBo(String str, String baseIn, String baseOut, Map<String, List<BoSo>> map) {
		List<Lo> listLo = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				index = i;
				break;
			}
		}
		str = str.substring(index, str.length());
		String tienDanh = "";
		if (str.contains("D")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.trim().indexOf('D')).trim();
		}else if (str.contains("B") && !str.contains("D")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf("B")).trim();
		}else{
			tienDanh = str.substring(str.indexOf('X') + 1, str.trim().length()).trim();
		}
		String boDanh = str.substring(0, str.indexOf("X"));
		String [] bodanh = boDanh.split(" ");
		if (str.contains("B")) {
			String soBo = str.substring(str.indexOf("B") + 1, str.length());
			String [] outBo = soBo.trim().split(" ");
			for (String str1 : bodanh) {
				List<BoSo> out = new ArrayList<BoSo>();
				out = map.get("BO" + str1);
				for (BoSo bo : out) {
					Lo de = new Lo();
					de.setSoDanh(bo.getBoKey());
					de.setDiem(tienDanh);
					de.setBaseIn(baseIn);
					de.setBaseOut(baseOut);
					listLo.add(de);
				}
			}
			
			for (String string : outBo) {
				for (Lo deChan : listLo) {
					if (deChan.getSoDanh().equals(string)) {
						listLo.remove(deChan);
						break;
					}
				}
			}
		}else {
			for (String str1 : bodanh) {
				List<BoSo> out = new ArrayList<BoSo>();
				out = map.get("BO" + str1);
				for (BoSo bo : out) {
					Lo de = new Lo();
					de.setSoDanh(bo.getBoKey());
					de.setDiem(tienDanh);
					de.setBaseIn(baseIn);
					de.setBaseOut(baseOut);
					listLo.add(de);
				}
			}
		}
		return listLo;
	}
	
	public List<Lo> convertStringToLoTong(String str, String baseIn, String baseOut) {
		List<Lo> listLo = new ArrayList<>();
		String tienDanh = "";
		if (str.contains("D")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.trim().indexOf('D')).trim();
		}else if (str.contains("B") && !str.contains("D")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf("B")).trim();
		}else{
			tienDanh = str.substring(str.indexOf('X') + 1, str.trim().length()).trim();
		}
		String tong = str.substring(0, str.indexOf('X'));
		if (str.contains("B")) {
			String soBo = str.substring(str.indexOf("B") + 1, str.length());
			String [] outBo = soBo.trim().split(" ");
			for (int i = 0; i < 10; i++) {
				Lo lo = new Lo();
				for (int j = 9 ; j >= 0; j--) {
					if (i + j == Integer.parseInt(tong)) {
						lo.setSoDanh(String.valueOf(i) + String.valueOf(j));
						lo.setDiem(tienDanh);
						lo.setBaseIn(baseIn);
						lo.setBaseOut(baseOut);
						listLo.add(lo);
						break;
					}
				}
			}
			
			for (String string : outBo) {
				for (Lo lo : listLo) {
					if (lo.getSoDanh().equals(string)) {
						listLo.remove(lo);
						break;
					}
				}
			}
		}else {
			for (int i = 0; i < 10; i++) {
				Lo lo = new Lo();
				for (int j = 9 ; j >= 0; j--) {
					if (i + j == Integer.parseInt(tong)) {
						lo.setSoDanh(String.valueOf(i) + String.valueOf(j));
						lo.setDiem(tienDanh);
						listLo.add(lo);
						lo.setBaseIn(baseIn);
						lo.setBaseOut(baseOut);
						break;
					}
				}
			}
		}
		return listLo;
	}
}
