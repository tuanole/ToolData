package com.mydu.letian.dataanalysis;

import java.util.ArrayList;
import java.util.List;

import com.mydu.letian.entity.xien.Xien;


public class CommonStringXien {
	
	public String chuanHoaSpace(String str) {
		String out = xoaBoNgoaiKVaX(str);
		return out.replaceAll("\\s+", " ");
	}
	
	public String xoaBoNgoaiKVaX(String str) {
		str = str.replaceAll("[^K X B N\\.\\, \\s 0-9]", "");
		return str;
	}
	
	public String formatChuan(String str) {
		String out = str.replaceAll("[^a-zA-Z 0-9]", " ");
		return chuanHoa(out);
	}
	
	public String findSoDanh(String str) {
		int index = 0;
		int count = 0;
		for ( int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == 'X') {
				index = i;
				for (int j = index; j >= 0; j--) {
					if (Character.isDigit(str.charAt(j))) {
						count++;
						if (count == 4) {
							return str.substring(j, index);
						}
					}
				}
			}
		}
		return str;
	}
	
	public String findSoDanhX3(String str) {
		int index = 0;
		int count = 0;
		for ( int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == 'X') {
				index = i;
				for (int j = index; j >= 0; j--) {
					if (Character.isDigit(str.charAt(j))) {
						count++;
						if (count == 6) {
							return str.substring(j, index);
						}
					}
				}
			}
		}
		return str;
	}
	
	public String findSoDanhX4(String str) {
		int index = 0;
		int count = 0;
		for ( int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == 'X') {
				index = i;
				for (int j = index; j >= 0; j--) {
					if (Character.isDigit(str.charAt(j))) {
						count++;
						if (count == 8) {
							return str.substring(j, index);
						}
					}
				}
			}
		}
		return str;
	}
	
	public String findSoDanh3C(String str) {
		int index = 0;
		int count = 0;
		String temp = "";
		for ( int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == 'X') {
				index = i;
				for (int j = index; j >= 0; j--) {
					if (Character.isDigit(str.charAt(j))) {
						temp += str.charAt(j);
						count++;
						if (count == 3) {
							StringBuilder sb = new StringBuilder(temp);
							return sb.reverse().toString();
						}
					}
				}
			}
		}
		return str;
	}
	
	public String chuanHoa(String str) {
		str = str.replaceAll("\\s+X\\s+", "X");
		str = str.replaceAll("\\s+X", "X");
		str = str.replaceAll("X\\s+", "X");
		str = str.replaceAll("\\s+K\\s+", "K ");
		str = str.replaceAll("\\s+K", "K ");
		str = str.replaceAll("K\\s+", "K ");
		return str;
	}
	
	public Xien convertStringToXien(String str, String baseIn, String baseOut) {
		Xien xien2 = new Xien();
		xien2.setSoDanh(findSoDanh(str));
		xien2.setTien(findTien(str));
		xien2.setBaseIn(baseIn);
		xien2.setBaseOut(baseOut);
		//xien2.setUser(cus);
		return xien2;
	}
	
	public Xien convertStringToXien3(String str, String baseIn, String baseOut) {
		Xien xien2 = new Xien();
		xien2.setSoDanh(findSoDanhX3(str));
		xien2.setTien(findTien(str));
		xien2.setBaseIn(baseIn);
		xien2.setBaseOut(baseOut);
		//xien2.setUser(cus);
		return xien2;
	}
	
	public Xien convertStringToXien4(String str, String baseIn, String baseOut) {
		Xien xien2 = new Xien();
		xien2.setSoDanh(findSoDanhX4(str));
		xien2.setTien(findTien(str));
		xien2.setBaseIn(baseIn);
		xien2.setBaseOut(baseOut);
		//xien2.setUser(cus);
		return xien2;
	}
	
	public Xien convertStringTo3Cang(String str, String baseIn, String baseOut) {
		Xien xien2 = new Xien();
		xien2.setSoDanh(findSoDanh3C(str));
		xien2.setTien(findTien(str));
		xien2.setBaseIn(baseIn);
		xien2.setBaseOut(baseOut);
		//xien2.setUser(cus);
		return xien2;
	}
	
	public String findTien(String str) {
		str = str.substring(str.lastIndexOf('X') + 1, str.length());
		return str;
	}
	
	public List<String> splitByK(String str) {
		String [] out = str.split("K");
		List<String> listOut = new ArrayList<String>();
		for (String string : out) {
			listOut.add(string.trim());
		}
		return listOut;
	}
	
	public String convertNghinToK(String str) {
		String strConvert = str.toUpperCase();
		strConvert = strConvert.replaceAll("NGHIN", "K");
		strConvert = strConvert.replaceAll("NGHÌN", "K");
		if (strConvert.contains("N")) {
			for (int i = 1; i < strConvert.length(); i++) {
				if (strConvert.charAt(i) == 'N' && Character.isDigit(strConvert.charAt(i - 1))) {
					StringBuilder sb = new StringBuilder(strConvert);
					sb.setCharAt(i, 'K');
					strConvert = sb.toString();
					return strConvert.replaceAll("\\(", "X");
				}
			}
		}
		return strConvert.replaceAll("\\(", "X");
	}

}
