package com.mydu.letian.dataanalysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mydu.letian.entity.BoSo;
import com.mydu.letian.entity.de.De;

public class CommonStringDe {
	
	public String chuanHoaSpace(String str) {
		String out = xoaBoNgoaiKVaX(str);
		return out.replaceAll("\\s+", " ");
	}
	
	public String chuanHoaSpaceL(String str) {
		String out = xoaBoNgoaiKVaXL(str);
		out = out.replaceAll("×", "X");
		return out.replaceAll("\\s+", " ");
	}
	
	public String chuanHoaSpaceDT(String str) {
		String out = xoaBoNgoaiKVaXDT(str);
		return out.replaceAll("\\s+", " ");
	}
	
	public String chuanHoaSpaceCL(String str) {
		String out = xoaBoNgoaiKVaXCL(str);
		return out.replaceAll("\\s+", " ");
	}
	
	public String chuanHoaSpaceDD(String str) {
		String out = xoaBoNgoaiKVaXDD(str);
		out = out.replaceAll("Đ", "D");
		return out.replaceAll("\\s+", " ");
	}
	
	public String chuanHoaSpaceKB(String str) {
		String out = xoaBoNgoaiKVaXKB(str);
		return out.replaceAll("\\s+", " ");
	}
	
	public String xoaBoNgoaiKVaXDD(String str) {
		str = str.replaceAll("[^× K X B D Đ \\.\\, \\s 0-9]", "");
		return str;
	}
	
	public String formatChuanDD(String str) {
		String out = str.replaceAll("[^× a-zA-Z Đ 0-9]", " ");
		out = out.replaceAll("×", "X");
		return chuanHoa(out);
	}
	
	public String xoaBoNgoaiKVaX(String str) {
		str = str.replaceAll("[^X B \\.\\, \\s 0-9]", "");
		return str;
	}
	
	public String xoaBoNgoaiKVaXKB(String str) {
		str = str.replaceAll("[^X K \\.\\, \\s 0-9]", "");
		return str;
	}
	
	public String xoaBoNgoaiKVaXL(String str) {
		str = str.replaceAll("[^K X B × \\.\\, \\s 0-9]", "");
		return str;
	}
	
	public String xoaBoNgoaiKVaXCL(String str) {
		str = str.replaceAll("[^X B C L \\.\\, \\s 0-9]", "");
		return str;
	}
	
	public String xoaBoNgoaiKVaXDT(String str) {
		str = str.replaceAll("[^K X B T \\.\\, \\s 0-9]", "");
		return str;
	}
	
	public String formatChuan(String str) {
		String out = str.replaceAll("[^× a-zA-Z 0-9]", " ");
		return chuanHoa(out);
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
	
	public String convertNghinToKDD(String str) {
		String out = str.toUpperCase();
		String strConvert = "";
		if (out.contains("NGHIN")) {
			strConvert = out.replaceAll("NGHIN", "K");
		}else if (out.contains("NGHÌN")) {
			strConvert = out.replaceAll("NGHÌN", "K");
		}else if (out.contains("N")) {
			int index = out.indexOf('N');
			if ( Character.isDigit(out.charAt(index - 1))) {
				StringBuilder sb = new StringBuilder(out);
				sb.setCharAt(index, 'K');
				strConvert = sb.toString();
				return strConvert;
			}else {
				return out;
			}
		}else {
			return out;
		}
		return strConvert.replaceAll("Đ", "D");
	}
	
	public String convertNghinToK(String str) {
		String out = str.toUpperCase();
		String strConvert = "";
		if (out.contains("NGHIN")) {
			strConvert = out.replaceAll("NGHIN", "K");
		}else if (out.contains("NGHÌN")) {
			strConvert = out.replaceAll("NGHÌN", "K");
		}else if (out.contains("N")) {
			int index = out.indexOf('N');
			if ( Character.isDigit(out.charAt(index - 1))) {
				StringBuilder sb = new StringBuilder(out);
				sb.setCharAt(index, 'K');
				strConvert = sb.toString();
				strConvert = strConvert.replaceAll("N", "K");
				return strConvert.replaceAll("\\(", "X");
			}else {
				return out.replaceAll("\\(", "X");
			}
		}else {
			return out.replaceAll("\\(", "X");
		}
		return strConvert.replaceAll("\\(", "X");
	}
	
	public List<String> splitByK(String str) {
		String [] out = str.split("K");
		List<String> listOut = new ArrayList<String>();
		for (String string : out) {
			listOut.add(string);
		}
		return listOut;
	}
	
	public List<De> convertStringToDe(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		str = str.trim();
		String soDanh = str.substring(0, str.indexOf('X'));
		String [] out = soDanh.trim().split(" ");
		String tienDanh = str.substring(str.indexOf('X') + 1, str.length());
		for (String string : out) {
			if (string.length() == 3) {
				List<String> fix3 = fix3Digit(string);
				for (String string2 : fix3) {
					De de = new De();
					de.setSoDanh(string2);
					de.setTien(tienDanh);
					de.setBaseIn(baseIn);
					de.setBaseOut(baseOut);
					//de.setUser(user);
					listDe.add(de);
				}
				
			}else {
				De de = new De();
				if (string.length() == 1) {
					de.setSoDanh("0" + string);
				}else {
					de.setSoDanh(string);
				}
				de.setTien(tienDanh);
				de.setBaseIn(baseIn);
				de.setBaseOut(baseOut);
				//de.setUser(user);
				listDe.add(de);
			}
			
		}
		return listDe;
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
	
	public List<De> convertStringToDeDau(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		String soDe = str.substring(0, str.indexOf('X'));
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(str.indexOf('X') + 1, str.length()).trim();
		}
		
		int count = countDigit(soDe);
		if (count == 1) {
			if (str.contains("B")) {
				int index = str.indexOf("B");
				String sobo = str.substring(index + 1, str.length());
				String [] out = sobo.trim().split(" ");
				for (int i = 0; i < 10; i++) {
					De deDau = new De();
					deDau.setSoDanh(str.charAt(0) + String.valueOf(i));
					deDau.setTien(tienDanh);
					deDau.setBaseIn(baseIn);
					deDau.setBaseOut(baseOut);
					//deDau.setUser(user);
					listDe.add(deDau);
				}
				for (String string : out) {
					for (De deDau : listDe) {
						if (string.equalsIgnoreCase(deDau.getSoDanh())) {
							listDe.remove(deDau);
							break;
						}
					}
				}
			}else {
				for (int i = 0; i < 10; i++) {
					De deDau = new De();
					deDau.setSoDanh(str.charAt(0) + String.valueOf(i));
					deDau.setTien(tienDanh);
					deDau.setBaseIn(baseIn);
					deDau.setBaseOut(baseOut);
					//deDau.setUser(user);
					listDe.add(deDau);
				}
			}
			
		}else if (count > 1) {
			String [] sodanhOut = soDe.trim().split(" ");
			for (String string : sodanhOut) {
				if (str.contains("B")) {
					int index = str.indexOf("B");
					String sobo = str.substring(index + 1, str.length());
					String [] out = sobo.trim().split(" ");
					for (int i = 0; i < 10; i++) {
						De deDau = new De();
						deDau.setSoDanh(string.charAt(0) + String.valueOf(i));
						deDau.setTien(tienDanh);
						deDau.setBaseIn(baseIn);
						deDau.setBaseOut(baseOut);
						//deDau.setUser(user);
						listDe.add(deDau);
					}
					for (String string2 : out) {
						for (De deDau : listDe) {
							if (string2.equalsIgnoreCase(deDau.getSoDanh())) {
								listDe.remove(deDau);
								break;
							}
						}
					}
				}else {
					for (int i = 0; i < 10; i++) {
						De deDau = new De();
						deDau.setSoDanh(string.charAt(0) + String.valueOf(i));
						deDau.setTien(tienDanh);
						deDau.setBaseIn(baseIn);
						deDau.setBaseOut(baseOut);
						//deDau.setUser(user);
						listDe.add(deDau);
					}
				}
			}
			
		} 
		return listDe;
	}
	
	public List<De> convertStringToDeDit(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		String soDe = str.substring(0, str.indexOf('X'));
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(str.indexOf('X') + 1, str.length()).trim();
		}
		
		int count = countDigit(soDe);
		if (count == 1) {
			if (str.contains("B")) {
				int index = str.indexOf("B");
				String sobo = str.substring(index + 1, str.length());
				String [] out = sobo.trim().split(" ");
				for (int i = 0; i < 10; i++) {
					De deDau = new De();
					deDau.setSoDanh(String.valueOf(i) + str.charAt(0));
					deDau.setTien(tienDanh);
					deDau.setBaseIn(baseIn);
					deDau.setBaseOut(baseOut);
					//deDau.setUser(user);
					listDe.add(deDau);
				}
				for (String string : out) {
					for (De deDau : listDe) {
						if (string.equalsIgnoreCase(deDau.getSoDanh())) {
							listDe.remove(deDau);
							break;
						}
					}
				}
			}else {
				for (int i = 0; i < 10; i++) {
					De deDau = new De();
					deDau.setSoDanh(String.valueOf(i) + str.charAt(0));
					deDau.setTien(tienDanh);
					deDau.setBaseIn(baseIn);
					deDau.setBaseOut(baseOut);
					//deDau.setUser(user);
					listDe.add(deDau);
				}
			}
			
		}else if (count > 1) {
			String [] sodanhOut = soDe.trim().split(" ");
			for (String string : sodanhOut) {
				if (str.contains("B")) {
					int index = str.indexOf("B");
					String sobo = str.substring(index + 1, str.length());
					String [] out = sobo.trim().split(" ");
					for (int i = 0; i < 10; i++) {
						De deDau = new De();
						deDau.setSoDanh(String.valueOf(i) + string.charAt(0));
						deDau.setTien(tienDanh);
						deDau.setBaseIn(baseIn);
						deDau.setBaseOut(baseOut);
						//deDau.setUser(user);
						listDe.add(deDau);
					}
					for (String string2 : out) {
						for (De deDau : listDe) {
							if (string2.equalsIgnoreCase(deDau.getSoDanh())) {
								listDe.remove(deDau);
								break;
							}
						}
					}
				}else {
					for (int i = 0; i < 10; i++) {
						De deDau = new De();
						deDau.setSoDanh(String.valueOf(i) + str.charAt(0));
						deDau.setTien(tienDanh);
						deDau.setBaseIn(baseIn);
						deDau.setBaseOut(baseOut);
						//deDau.setUser(user);
						listDe.add(deDau);
					}
				}
			}
			
		} 
		return listDe;
	}
	
	public List<De> convertStringToDeTong(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(str.indexOf('X') + 1, str.length()).trim();
		}
		String tong = str.substring(0, str.indexOf('X'));
		int count = countDigit(tong);
		if (count == 1) {
			if (str.contains("B")) {
				String soBo = str.substring(str.indexOf("B") + 1, str.length());
				String [] outBo = soBo.trim().split(" ");
				for (int i = 0; i < 10; i++) {
					De de = new De();
					for (int j = 9 ; j >= 0; j--) {
						if (i + j == Integer.parseInt(tong)) {
							de.setSoDanh(String.valueOf(i) + String.valueOf(j));
							de.setTien(tienDanh);
							de.setBaseIn(baseIn);
							de.setBaseOut(baseOut);
							//de.setUser(user);
							listDe.add(de);
							break;
						}
					}
				}
				
				for (String string : outBo) {
					for (De deChan : listDe) {
						if (deChan.getSoDanh().equals(string)) {
							listDe.remove(deChan);
							break;
						}
					}
				}
			}else {
				for (int i = 0; i < 10; i++) {
					De de = new De();
					for (int j = 9 ; j >= 0; j--) {
						if (i + j == Integer.parseInt(tong)) {
							de.setSoDanh(String.valueOf(i) + String.valueOf(j));
							de.setTien(tienDanh);
							de.setBaseIn(baseIn);
							de.setBaseOut(baseOut);
							//de.setUser(user);
							listDe.add(de);
							break;
						}
					}
				}
			}
		}else if (count > 1) {
			String [] sodanhOut = tong.trim().split(" ");
			for (String tong1 : sodanhOut) {
				if (str.contains("B")) {
					String soBo = str.substring(str.indexOf("B") + 1, str.length());
					String [] outBo = soBo.trim().split(" ");
					for (int i = 0; i < 10; i++) {
						De de = new De();
						for (int j = 9 ; j >= 0; j--) {
							if (i + j == Integer.parseInt(tong1)) {
								de.setSoDanh(String.valueOf(i) + String.valueOf(j));
								de.setTien(tienDanh);
								de.setBaseIn(baseIn);
								de.setBaseOut(baseOut);
								//de.setUser(user);
								listDe.add(de);
								break;
							}
						}
					}
					
					for (String string : outBo) {
						for (De deChan : listDe) {
							if (deChan.getSoDanh().equals(string)) {
								listDe.remove(deChan);
								break;
							}
						}
					}
				}else {
					for (int i = 0; i < 10; i++) {
						De de = new De();
						for (int j = 9 ; j >= 0; j--) {
							if (i + j == Integer.parseInt(tong1)) {
								de.setSoDanh(String.valueOf(i) + String.valueOf(j));
								de.setTien(tienDanh);
								de.setBaseIn(baseIn);
								de.setBaseOut(baseOut);
								//de.setUser(user);
								listDe.add(de);
								break;
							}
						}
					}
				}
			}
		}
		
		return listDe;
	}
	
	public List<De> convertStringToDeTongTren(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(str.indexOf('X') + 1, str.length()).trim();
		}
		String tong = str.substring(0, str.indexOf('X'));
		int count = countDigit(tong);
		if (count == 1) {
			if (str.contains("B")) {
				String soBo = str.substring(str.indexOf("B") + 1, str.length());
				String [] outBo = soBo.trim().split(" ");
				for (int i = 0; i < 10; i++) {
					
					for (int j = 9 ; j >= 0; j--) {
						if (i + j > Integer.parseInt(tong)) {
							De de = new De();
							de.setSoDanh(String.valueOf(i) + String.valueOf(j));
							de.setTien(tienDanh);
							de.setBaseIn(baseIn);
							de.setBaseOut(baseOut);
							//de.setUser(user);
							listDe.add(de);
						}
					}
				}
				
				for (String string : outBo) {
					for (De deChan : listDe) {
						if (deChan.getSoDanh().equals(string)) {
							listDe.remove(deChan);
							break;
						}
					}
				}
			}else {
				for (int i = 0; i < 10; i++) {
					
					for (int j = 9 ; j >= 0; j--) {
						if (i + j > Integer.parseInt(tong)) {
							De de = new De();
							de.setSoDanh(String.valueOf(i) + String.valueOf(j));
							de.setTien(tienDanh);
							de.setBaseIn(baseIn);
							de.setBaseOut(baseOut);
							//de.setUser(user);
							listDe.add(de);
						}
					}
				}
			}
		}else if (count > 1) {
			String [] sodanhOut = tong.trim().split(" ");
			for (String tong1 : sodanhOut) {
				if (str.contains("B")) {
					String soBo = str.substring(str.indexOf("B") + 1, str.length());
					String [] outBo = soBo.trim().split(" ");
					for (int i = 0; i < 10; i++) {
						
						for (int j = 9 ; j >= 0; j--) {
							if (i + j > Integer.parseInt(tong1)) {
								De de = new De();
								de.setSoDanh(String.valueOf(i) + String.valueOf(j));
								de.setTien(tienDanh);
								de.setBaseIn(baseIn);
								de.setBaseOut(baseOut);
								//de.setUser(user);
								listDe.add(de);
							}
						}
					}
					
					for (String string : outBo) {
						for (De deChan : listDe) {
							if (deChan.getSoDanh().equals(string)) {
								listDe.remove(deChan);
								break;
							}
						}
					}
				}else {
					for (int i = 0; i < 10; i++) {
						
						for (int j = 9 ; j >= 0; j--) {
							if (i + j > Integer.parseInt(tong1)) {
								De de = new De();
								de.setSoDanh(String.valueOf(i) + String.valueOf(j));
								de.setTien(tienDanh);
								de.setBaseIn(baseIn);
								de.setBaseOut(baseOut);
								//de.setUser(user);
								listDe.add(de);
							}
						}
					}
				}
			}
		}
		return listDe;
	}
	
	public List<De> convertStringToDeTongDuoi(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(str.indexOf('X') + 1, str.length()).trim();
		}
		String tong = str.substring(0, str.indexOf('X'));
		int count = countDigit(tong);
		if (count == 1) {
			if (str.contains("B")) {
				String soBo = str.substring(str.indexOf("B") + 1, str.length());
				String [] outBo = soBo.trim().split(" ");
				for (int i = 0; i < 10; i++) {
					
					for (int j = 9 ; j >= 0; j--) {
						if (i + j < Integer.parseInt(tong)) {
							De de = new De();
							de.setSoDanh(String.valueOf(i) + String.valueOf(j));
							de.setTien(tienDanh);
							de.setBaseIn(baseIn);
							de.setBaseOut(baseOut);
							//de.setUser(user);
							listDe.add(de);
						}
					}
				}
				
				for (String string : outBo) {
					for (De deChan : listDe) {
						if (deChan.getSoDanh().equals(string)) {
							listDe.remove(deChan);
							break;
						}
					}
				}
			}else {
				for (int i = 0; i < 10; i++) {
					
					for (int j = 9 ; j >= 0; j--) {
						if (i + j < Integer.parseInt(tong)) {
							De de = new De();
							de.setSoDanh(String.valueOf(i) + String.valueOf(j));
							de.setTien(tienDanh);
							de.setBaseIn(baseIn);
							de.setBaseOut(baseOut);
							//de.setUser(user);
							listDe.add(de);
						}
					}
				}
			}
		}else if (count > 1) {
			String [] sodanhOut = tong.trim().split(" ");
			for (String tong1 : sodanhOut) {
				if (str.contains("B")) {
					String soBo = str.substring(str.indexOf("B") + 1, str.length());
					String [] outBo = soBo.trim().split(" ");
					for (int i = 0; i < 10; i++) {
						
						for (int j = 9 ; j >= 0; j--) {
							if (i + j < Integer.parseInt(tong1)) {
								De de = new De();
								de.setSoDanh(String.valueOf(i) + String.valueOf(j));
								de.setTien(tienDanh);
								de.setBaseIn(baseIn);
								de.setBaseOut(baseOut);
								//de.setUser(user);
								listDe.add(de);
							}
						}
					}
					
					for (String string : outBo) {
						for (De deChan : listDe) {
							if (deChan.getSoDanh().equals(string)) {
								listDe.remove(deChan);
								break;
							}
						}
					}
				}else {
					for (int i = 0; i < 10; i++) {
						
						for (int j = 9 ; j >= 0; j--) {
							if (i + j < Integer.parseInt(tong1)) {
								De de = new De();
								de.setSoDanh(String.valueOf(i) + String.valueOf(j));
								de.setTien(tienDanh);
								de.setBaseIn(baseIn);
								de.setBaseOut(baseOut);
								//de.setUser(user);
								listDe.add(de);
							}
						}
					}
				}
			}
		}
		return listDe;
	}
	
	public List<De> convertStringToDeChanChan(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(str.indexOf('X') + 1, str.length()).trim();
		}
		if (str.contains("B")) {
			String soBo = str.substring(str.indexOf("B") + 1, str.length());
			String [] outBo = soBo.trim().split(" ");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (i % 2 == 0 && j % 2 == 0) {
						De deChan = new De();
						deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
						deChan.setTien(tienDanh);
						deChan.setBaseIn(baseIn);
						deChan.setBaseOut(baseOut);
						//deChan.setUser(user);
						listDe.add(deChan);
					}
				}
				
			}
			
			for (String string : outBo) {
				for (De deChan : listDe) {
					if (deChan.getSoDanh().equals(string)) {
						listDe.remove(deChan);
						break;
					}
				}
			}
		}else {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (i % 2 == 0 && j % 2 == 0) {
						De deChan = new De();
						deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
						deChan.setTien(tienDanh);
						deChan.setBaseIn(baseIn);
						deChan.setBaseOut(baseOut);
						//deChan.setUser(user);
						listDe.add(deChan);
					}
				}
				
			}
		}
		return listDe;
	}
	
	public List<De> convertStringToDeChanLe(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(str.indexOf('X') + 1, str.length()).trim();
		}
		if (str.contains("B")) {
			String soBo = str.substring(str.indexOf("B") + 1, str.length());
			String [] outBo = soBo.trim().split(" ");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (i % 2 == 0 && j % 2 != 0) {
						De deChan = new De();
						deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
						deChan.setTien(tienDanh);
						deChan.setBaseIn(baseIn);
						deChan.setBaseOut(baseOut);
						//deChan.setUser(user);
						listDe.add(deChan);
					}
				}
				
			}
			
			for (String string : outBo) {
				for (De deChan : listDe) {
					if (deChan.getSoDanh().equals(string)) {
						listDe.remove(deChan);
						break;
					}
				}
			}
		}else {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (i % 2 == 0 && j % 2 != 0) {
						De deChan = new De();
						deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
						deChan.setTien(tienDanh);
						deChan.setBaseIn(baseIn);
						deChan.setBaseOut(baseOut);
						//deChan.setUser(user);
						listDe.add(deChan);
					}
				}
				
			}
		}
		return listDe;
	}
	
	public List<De> convertStringToDeLeChan(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(str.indexOf('X') + 1, str.length()).trim();
		}
		if (str.contains("B")) {
			String soBo = str.substring(str.indexOf("B") + 1, str.length());
			String [] outBo = soBo.trim().split(" ");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (i % 2 != 0 && j % 2 == 0) {
						De deChan = new De();
						deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
						deChan.setTien(tienDanh);
						deChan.setBaseIn(baseIn);
						deChan.setBaseOut(baseOut);
						//deChan.setUser(user);
						listDe.add(deChan);
					}
				}
				
			}
			
			for (String string : outBo) {
				for (De deChan : listDe) {
					if (deChan.getSoDanh().equals(string)) {
						listDe.remove(deChan);
						break;
					}
				}
			}
		}else {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (i % 2 != 0 && j % 2 == 0) {
						De deChan = new De();
						deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
						deChan.setTien(tienDanh);
						deChan.setBaseIn(baseIn);
						deChan.setBaseOut(baseOut);
						//deChan.setUser(user);
						listDe.add(deChan);
					}
				}
				
			}
		}
		return listDe;
	}
	
	public List<De> convertStringToDeLeLe(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(str.indexOf('X') + 1, str.length()).trim();
		}
		if (str.contains("B")) {
			String soBo = str.substring(str.indexOf("B") + 1, str.length());
			String [] outBo = soBo.trim().split(" ");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (i % 2 != 0 && j % 2 != 0) {
						De deChan = new De();
						deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
						deChan.setTien(tienDanh);
						deChan.setBaseIn(baseIn);
						deChan.setBaseOut(baseOut);
						//deChan.setUser(user);
						listDe.add(deChan);
					}
				}
				
			}
			
			for (String string : outBo) {
				for (De deChan : listDe) {
					if (deChan.getSoDanh().equals(string)) {
						listDe.remove(deChan);
						break;
					}
				}
			}
		}else {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (i % 2 != 0 && j % 2 != 0) {
						De deChan = new De();
						deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
						deChan.setTien(tienDanh);
						deChan.setBaseIn(baseIn);
						deChan.setBaseOut(baseOut);
						//deChan.setUser(user);
						listDe.add(deChan);
					}
				}
				
			}
		}
		return listDe;
	}
	
	public List<De> convertStringToDeKepBang(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				index = i;
				break;
			}
		}
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(index, str.length()).trim();
		}
		 
		if (str.contains("B")) {
			String soBo = str.substring(str.indexOf("B") + 1, str.length());
			String [] outBo = soBo.trim().split(" ");
			for (int i = 0; i < 10; i++) {
				De deChan = new De();
				deChan.setSoDanh(String.valueOf(i) + String.valueOf(i));
				deChan.setTien(tienDanh);
				deChan.setBaseIn(baseIn);
				deChan.setBaseOut(baseOut);
				//deChan.setUser(user);
				listDe.add(deChan);
			}
			
			for (String string : outBo) {
				for (De deChan : listDe) {
					if (deChan.getSoDanh().equals(string)) {
						listDe.remove(deChan);
						break;
					}
				}
			}
		}else {
			for (int i = 0; i < 10; i++) {
				De deChan = new De();
				deChan.setSoDanh(String.valueOf(i) + String.valueOf(i));
				deChan.setTien(tienDanh);
				deChan.setBaseIn(baseIn);
				deChan.setBaseOut(baseOut);
				//deChan.setUser(user);
				listDe.add(deChan);
			}
		}
		return listDe;
	}
	
	public List<De> convertStringToDeKepLech(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				index = i;
				break;
			}
		}
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(index, str.length()).trim();
		}
		 
		if (str.contains("B")) {
			String soBo = str.substring(str.indexOf("B") + 1, str.length());
			String [] outBo = soBo.trim().split(" ");
			for (int i = 0; i < 10; i++) {
				De deChan = new De();
				if (i < 5) {
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(i + 5));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}else {
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(i - 5));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
				
			}
			
			for (String string : outBo) {
				for (De deChan : listDe) {
					if (deChan.getSoDanh().equals(string)) {
						listDe.remove(deChan);
						break;
					}
				}
			}
		}else {
			for (int i = 0; i < 10; i++) {
				De deChan = new De();
				if (i < 5) {
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(i + 5));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}else {
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(i - 5));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
		}
		return listDe;
	}
	
	public List<De> convertStringToDeDauCao(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				index = i;
				break;
			}
		}
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(index, str.length()).trim();
		}
		if (str.contains("B")) {
			String soBo = str.substring(str.indexOf("B") + 1, str.length());
			String [] outBo = soBo.trim().split(" ");
			for (int i = 5; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					De deChan = new De();
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
			
			for (String string : outBo) {
				for (De deChan : listDe) {
					if (deChan.getSoDanh().equals(string)) {
						listDe.remove(deChan);
						break;
					}
				}
			}
		}else {
			for (int i = 5; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					De deChan = new De();
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
		}
		return listDe;
	}
	
	public List<De> convertStringToDeDauThap(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				index = i;
				break;
			}
		}
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(index, str.length()).trim();
		}
		if (str.contains("B")) {
			String soBo = str.substring(str.indexOf("B") + 1, str.length());
			String [] outBo = soBo.trim().split(" ");
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 10; j++) {
					De deChan = new De();
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
			
			for (String string : outBo) {
				for (De deChan : listDe) {
					if (deChan.getSoDanh().equals(string)) {
						listDe.remove(deChan);
						break;
					}
				}
			}
		}else {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 10; j++) {
					De deChan = new De();
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
		}
		return listDe;
	}
	
	public List<De> convertStringToDeDitCao(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				index = i;
				break;
			}
		}
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(index, str.length()).trim();
		}
		if (str.contains("B")) {
			String soBo = str.substring(str.indexOf("B") + 1, str.length());
			String [] outBo = soBo.trim().split(" ");
			for (int i = 0; i < 10; i++) {
				for (int j = 5; j < 10; j++) {
					De deChan = new De();
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
			
			for (String string : outBo) {
				for (De deChan : listDe) {
					if (deChan.getSoDanh().equals(string)) {
						listDe.remove(deChan);
						break;
					}
				}
			}
		}else {
			for (int i = 0; i < 10; i++) {
				for (int j = 5; j < 10; j++) {
					De deChan = new De();
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
		}
		return listDe;
	}
	
	public List<De> convertStringToDeDitThap(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				index = i;
				break;
			}
		}
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(index, str.length()).trim();
		}
		if (str.contains("B")) {
			String soBo = str.substring(str.indexOf("B") + 1, str.length());
			String [] outBo = soBo.trim().split(" ");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 5; j++) {
					De deChan = new De();
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
			
			for (String string : outBo) {
				for (De deChan : listDe) {
					if (deChan.getSoDanh().equals(string)) {
						listDe.remove(deChan);
						break;
					}
				}
			}
		}else {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 5; j++) {
					De deChan = new De();
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
		}
		return listDe;
	}
	
	public List<De> convertStringToDeDauCaoDitCao(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				index = i;
				break;
			}
		}
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(index, str.length()).trim();
		}
		if (str.contains("B")) {
			String soBo = str.substring(str.indexOf("B") + 1, str.length());
			String [] outBo = soBo.trim().split(" ");
			for (int i = 5; i < 10; i++) {
				for (int j = 5; j < 10; j++) {
					De deChan = new De();
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
			
			for (String string : outBo) {
				for (De deChan : listDe) {
					if (deChan.getSoDanh().equals(string)) {
						listDe.remove(deChan);
						break;
					}
				}
			}
		}else {
			for (int i = 5; i < 10; i++) {
				for (int j = 5; j < 10; j++) {
					De deChan = new De();
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
		}
		return listDe;
	}
	
	public List<De> convertStringToDeDauCaoDitThap(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				index = i;
				break;
			}
		}
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(index, str.length()).trim();
		}
		if (str.contains("B")) {
			String soBo = str.substring(str.indexOf("B") + 1, str.length());
			String [] outBo = soBo.trim().split(" ");
			for (int i = 5; i < 10; i++) {
				for (int j = 0; j < 5; j++) {
					De deChan = new De();
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
			
			for (String string : outBo) {
				for (De deChan : listDe) {
					if (deChan.getSoDanh().equals(string)) {
						listDe.remove(deChan);
						break;
					}
				}
			}
		}else {
			for (int i = 5; i < 10; i++) {
				for (int j = 0; j < 5; j++) {
					De deChan = new De();
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
		}
		return listDe;
	}
	
	public List<De> convertStringToDeDauThapDitCao(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				index = i;
				break;
			}
		}
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(index, str.length()).trim();
		}
		if (str.contains("B")) {
			String soBo = str.substring(str.indexOf("B") + 1, str.length());
			String [] outBo = soBo.trim().split(" ");
			for (int i = 0; i < 5; i++) {
				for (int j = 5; j < 10; j++) {
					De deChan = new De();
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
			
			for (String string : outBo) {
				for (De deChan : listDe) {
					if (deChan.getSoDanh().equals(string)) {
						listDe.remove(deChan);
						break;
					}
				}
			}
		}else {
			for (int i = 0; i < 5; i++) {
				for (int j = 5; j < 10; j++) {
					De deChan = new De();
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
		}
		return listDe;
	}
	
	public List<De> convertStringToDeDauThapDitThap(String str, String baseIn, String baseOut) {
		List<De> listDe = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				index = i;
				break;
			}
		}
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(index, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(index, str.length()).trim();
		}
		if (str.contains("B")) {
			String soBo = str.substring(str.indexOf("B") + 1, str.length());
			String [] outBo = soBo.trim().split(" ");
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					De deChan = new De();
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
			
			for (String string : outBo) {
				for (De deChan : listDe) {
					if (deChan.getSoDanh().equals(string)) {
						listDe.remove(deChan);
						break;
					}
				}
			}
		}else {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					De deChan = new De();
					deChan.setSoDanh(String.valueOf(i) + String.valueOf(j));
					deChan.setTien(tienDanh);
					deChan.setBaseIn(baseIn);
					deChan.setBaseOut(baseOut);
					//deChan.setUser(user);
					listDe.add(deChan);
				}
			}
		}
		return listDe;
	}
	
	public List<De> convertStringToDeBo(String str, String baseIn, String baseOut, Map<String, List<BoSo>> map) {
		List<De> listDe = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				index = i;
				break;
			}
		}
		str = str.substring(index, str.length());
		String tienDanh = "";
		if (str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('K')).trim();
		}else if (str.contains("B") && !str.contains("K")) {
			tienDanh = str.substring(str.indexOf('X') + 1, str.indexOf('B')).trim();
		}else {
			tienDanh = str.substring(str.indexOf('X') + 1, str.length()).trim();
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
					De de = new De();
					de.setSoDanh(bo.getBoKey());
					de.setTien(tienDanh);
					de.setBaseIn(baseIn);
					de.setBaseOut(baseOut);
					//de.setUser(user);
					listDe.add(de);
				}
			}
			
			for (String string : outBo) {
				for (De deChan : listDe) {
					if (deChan.getSoDanh().equals(string)) {
						listDe.remove(deChan);
						break;
					}
				}
			}
		}else {
			for (String str1 : bodanh) {
				List<BoSo> out = new ArrayList<BoSo>();
				out = map.get("BO" + str1);
				for (BoSo bo : out) {
					De de = new De();
					de.setSoDanh(bo.getBoKey());
					de.setTien(tienDanh);
					de.setBaseIn(baseIn);
					de.setBaseOut(baseOut);
					//de.setUser(user);
					listDe.add(de);
				}
			}
		}
		return listDe;
	}
}
