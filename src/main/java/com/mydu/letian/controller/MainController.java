package com.mydu.letian.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mydu.letian.entity.Base;
import com.mydu.letian.entity.Bet;
import com.mydu.letian.entity.BetType;
import com.mydu.letian.entity.LotResult;
import com.mydu.letian.entity.ThongKeCai;
import com.mydu.letian.entity.TypeUse;
import com.mydu.letian.entity.User;
import com.mydu.letian.repository.BaseRepository;
import com.mydu.letian.repository.BetRepository;
import com.mydu.letian.repository.BetTypeRepository;
import com.mydu.letian.repository.LotResultRepository;
import com.mydu.letian.repository.TypeUseRepository;
import com.mydu.letian.repository.UserRepository;

@Controller
public class MainController {

	@Autowired
	private BaseRepository baseRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BetRepository betRepository;

	@Autowired
	private LotResultRepository lotResultRepository;

	@Autowired
	private BetTypeRepository betTypeRepository;
	
	@Autowired
	private TypeUseRepository typeUseRepository;

	@RequestMapping(value = { "/home", "/" }, method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping(value = { "/nhap-lo" }, method = RequestMethod.GET)
	public String nhapLo(Model model) {
		List<Base> bases = new ArrayList<Base>();
		List<TypeUse> types = new ArrayList<TypeUse>();
		types = typeUseRepository.findByBetType(this.betTypeRepository.findByTypeId(1));
		bases = baseRepository.findAllBase();
		model.addAttribute("bases", bases);
		model.addAttribute("types", types);
		return "nhap-lo";
	}
	
	@RequestMapping(value = { "/nhap-de" }, method = RequestMethod.GET)
	public String nhapDe(Model model) {
		List<Base> bases = new ArrayList<Base>();
		List<TypeUse> types = new ArrayList<TypeUse>();
		types = typeUseRepository.findByBetType(this.betTypeRepository.findByTypeId(2));
		bases = baseRepository.findAllBase();
		model.addAttribute("bases", bases);
		model.addAttribute("types", types);
		return "nhap-de";
	}
	
	@RequestMapping(value = { "/nhap-xien" }, method = RequestMethod.GET)
	public String nhapXien(Model model) {
		List<Base> bases = new ArrayList<Base>();
		List<TypeUse> types = new ArrayList<TypeUse>();
		types = typeUseRepository.findByBetType(this.betTypeRepository.findByTypeId(3));
		bases = baseRepository.findAllBase();
		model.addAttribute("bases", bases);
		model.addAttribute("types", types);
		
		return "nhap-xien";
	}

	@RequestMapping(value = { "/base" }, method = RequestMethod.GET)
	public String showBase(Model model) {

		List<Base> bases = this.baseRepository.findAllBase();
		model.addAttribute("bases", bases);

		return "base";
	}

	@RequestMapping(value = { "/result" }, method = RequestMethod.GET)
	public String showResult(Model model) {

		// Iterable<Base> bases = this.baseRepository.findAll();
		// model.addAttribute("bases", bases);

		return "result";
	}

	@RequestMapping(value = { "/about" }, method = RequestMethod.GET)
	public String showAbout(Model model) {

		// Iterable<Base> bases = this.baseRepository.findAll();
		// model.addAttribute("bases", bases);

		return "about";
	}

	@RequestMapping(value = { "/userdata" }, method = RequestMethod.GET)
	public String showInputData(Model model) {

		return "userdata";
	}

	@RequestMapping(value = { "/user-infor" }, method = RequestMethod.GET)
	public String showUserInfor(Model model) {

		Iterable<User> users = this.userRepository.findAll();
		model.addAttribute("users", users);

		return "user-infor";
	}

	@RequestMapping(value = { "/thongke-ngay" }, method = RequestMethod.GET)
	public String showThongKeNgay(Model model) {
		Map<String, List<ThongKeCai>> map = this.getThongKeByBase();

		model.addAttribute("A1", map.get("A1"));
		model.addAttribute("B1", map.get("B1"));
		model.addAttribute("C1", map.get("C1"));

		return "thongke-ngay";
	}

	@RequestMapping(value = { "/infor" }, method = RequestMethod.GET)
	public String showInforUser(Model model, @RequestParam("userId") String userId) {

		User user = new User();
		user = this.userRepository.findByUserId(userId);
		model.addAttribute("user", user);
		return "infor";
	}

	@RequestMapping(value = { "/thongke" }, method = RequestMethod.GET)
	public String showThongKe(Model model) {

		// Iterable<Base> bases = this.baseRepository.findAll();
		// model.addAttribute("bases", bases);

		return "thongke";
	}

	public Map<String, List<ThongKeCai>> getThongKeByBase() {

		List<ThongKeCai> listTkA1 = new ArrayList<ThongKeCai>();
		Base base1 = new Base();
		base1 = this.baseRepository.findBaseSpec(1L);
		BetType betT1 = betTypeRepository.findByTypeId(1);
		if (base1 != null) {
			if (betT1 != null) {
				listTkA1.add(this.getThongKeLoByBaseAndBetType(base1, betT1));
			}

			if (this.betTypeRepository.findByTypeId(2) != null) {
				listTkA1.add(this.getThongKeDeByBaseAndBetType(this.baseRepository.findBaseSpec(1L),
						this.betTypeRepository.findByTypeId(2)));
			}

			if (this.betTypeRepository.findByTypeId(2) != null) {
				listTkA1.add(this.getThongKeXienByBaseAndBetType(this.baseRepository.findBaseSpec(1L),
						this.betTypeRepository.findByTypeId(3)));
			}

		} else {
			listTkA1.add(new ThongKeCai());
		}

		List<ThongKeCai> listTkB1 = new ArrayList<ThongKeCai>();
		if (this.baseRepository.findBaseSpec(2L) != null && this.betTypeRepository.findByTypeId(1) != null) {
			listTkB1.add(this.getThongKeLoByBaseAndBetType(this.baseRepository.findBaseSpec(2L),
					this.betTypeRepository.findByTypeId(1)));
		} else {
			listTkB1.add(new ThongKeCai());
		}
		if (this.baseRepository.findBaseSpec(2L) != null && this.betTypeRepository.findByTypeId(2) != null) {
			listTkB1.add(this.getThongKeDeByBaseAndBetType(this.baseRepository.findBaseSpec(2L),
					this.betTypeRepository.findByTypeId(2)));
		} else {
			listTkB1.add(new ThongKeCai());
		}
		if (this.baseRepository.findBaseSpec(2L) != null && this.betTypeRepository.findByTypeId(3) != null) {
			listTkB1.add(this.getThongKeXienByBaseAndBetType(this.baseRepository.findBaseSpec(2L),
					this.betTypeRepository.findByTypeId(3)));
		} else {
			listTkB1.add(new ThongKeCai());
		}

		List<ThongKeCai> listTkC1 = new ArrayList<ThongKeCai>();
		if (this.baseRepository.findBaseSpec(3L) != null && this.betTypeRepository.findByTypeId(1) != null) {
			listTkC1.add(this.getThongKeLoByBaseAndBetType(this.baseRepository.findBaseSpec(3L),
					this.betTypeRepository.findByTypeId(1)));
		} else {
			listTkC1.add(new ThongKeCai());
		}
		if (this.baseRepository.findBaseSpec(3L) != null && this.betTypeRepository.findByTypeId(2) != null) {
			listTkC1.add(this.getThongKeDeByBaseAndBetType(this.baseRepository.findBaseSpec(3L),
					this.betTypeRepository.findByTypeId(2)));
		} else {
			listTkC1.add(new ThongKeCai());
		}
		if (this.baseRepository.findBaseSpec(3L) != null && this.betTypeRepository.findByTypeId(3) != null) {
			listTkC1.add(this.getThongKeXienByBaseAndBetType(this.baseRepository.findBaseSpec(3L),
					this.betTypeRepository.findByTypeId(3)));
		} else {
			listTkC1.add(new ThongKeCai());
		}

		Map<String, List<ThongKeCai>> map = new HashMap<String, List<ThongKeCai>>();
		map.put("A1", listTkA1);
		map.put("B1", listTkB1);
		map.put("C1", listTkC1);

		return map;
	}

	public ThongKeCai getThongKeLoByBaseAndBetType(Base base, BetType betType) {
		List<Bet> listA1 = this.betRepository.getByBaseInAndBetType(base, betType);
		int amount = 0;
		String loai = "";
		int sumTrung = 0;
		List<LotResult> results = new ArrayList<LotResult>();
		results = this.lotResultRepository.findAll();
		for (Bet bet : listA1) {
			amount += bet.getAmount();
			loai = bet.getBetType().getTypeName();
			for (LotResult lotResult : results) {
				if (bet.getBetKey().equals(lotResult.getLotKey())) {
					sumTrung += bet.getAmount();
				}
			}

		}
		ThongKeCai tkl = new ThongKeCai();
		Base base1 = this.baseRepository.findBaseSpec(1L);
		tkl.setLoai(loai);
		tkl.setSumDiem(String.valueOf(amount));
		tkl.setSumDiemTrung(String.valueOf(sumTrung));
		tkl.setSumTien(String.valueOf(amount * base1.getRateLIn()));
		tkl.setSumTienTrung(String.valueOf(sumTrung * base1.getRateLOut()));
		tkl.setSumLai(String.valueOf(sumTrung * base1.getRateLOut() - amount * base1.getRateLIn()));
		return tkl;
	}

	public ThongKeCai getThongKeDeByBaseAndBetType(Base base, BetType betType) {
		List<Bet> listA1 = this.betRepository.getByBaseInAndBetType(base, betType);
		int amount = 0;
		String loai = "";
		int sumTrung = 0;
		List<LotResult> results = new ArrayList<LotResult>();
		results = this.lotResultRepository.findAll();
		for (Bet bet : listA1) {
			amount += bet.getAmount();
			loai = bet.getBetType().getTypeName();
			for (LotResult lotResult : results) {
				if (lotResult.getLotRank() == 0 && bet.getBetKey().equals(lotResult.getLotKey())) {
					sumTrung += bet.getAmount();
				}
			}

		}
		ThongKeCai tkl = new ThongKeCai();
		Base base1 = this.baseRepository.findBaseSpec(1L);
		tkl.setLoai(loai);
		tkl.setSumTien(String.valueOf(amount));
		tkl.setSumTienTrung(String.valueOf(sumTrung * base1.getRateD()));
		tkl.setSumLai(String.valueOf(sumTrung * base1.getRateD() - amount));
		return tkl;
	}

	public ThongKeCai getThongKeXienByBaseAndBetType(Base base, BetType betType) {
		List<Bet> listA1 = this.betRepository.getByBaseInAndBetType(base, betType);
		int amount = 0;
		String loai = "";
		int sumTrung = 0;
		List<LotResult> results = new ArrayList<LotResult>();
		results = this.lotResultRepository.findAll();
		for (Bet bet : listA1) {
			amount += bet.getAmount();
			loai = bet.getBetType().getTypeName();
			for (LotResult lotResult : results) {
				if (lotResult.getLotRank() == 0 && bet.getBetKey().equals(lotResult.getLotKey())) {
					sumTrung += bet.getAmount();
				}
			}

		}
		ThongKeCai tkl = new ThongKeCai();
		Base base1 = this.baseRepository.findBaseSpec(1L);
		tkl.setLoai(loai);
		tkl.setSumTien(String.valueOf(amount));
		tkl.setSumTienTrung(String.valueOf(sumTrung * base1.getRateX2()));
		tkl.setSumLai(String.valueOf(sumTrung * base1.getRateX2() - amount));
		return tkl;
	}

}
