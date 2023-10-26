package com.ssafy.spring.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.spring.dto.MobileDto;
import com.ssafy.spring.service.MobileService;
import com.ssafy.spring.util.PageNavigation;
import com.ssafy.spring.util.PaggingUtil;


@Controller
@RequestMapping("/mobile")
public class PhoneController {

	private MobileService service;
	
	public PhoneController(MobileService service) {
		super();
		this.service = service;
	}

	@GetMapping("/insert")
	public String PhoneInsert() {
		return "mobile/registMobile";
	}

	@PostMapping("/insert")
	public String PhoneInsertList(MobileDto mobileDto) throws SQLException {
		service.MobileInsert(mobileDto);
		return "redirect:/mobile/list";
	}
	
	@GetMapping("/list")
	public ModelAndView PhoneList(String pg, String spp, ModelAndView mav) {
		int currentPage = pg == null ? 1 : Integer.parseInt(pg);
		currentPage = currentPage == 0 ? 1 : currentPage;
		int sizePerPage = spp == null ? PaggingUtil.sizePerPage : Integer.parseInt(spp);
		try {
			Map<String,Integer>map = new HashMap<>();
			map.put("currentPage", (currentPage-1)*sizePerPage);
			map.put("sizePerPage", sizePerPage);
			List<MobileDto> list = service.listMobilePage(map);
			PageNavigation pageNavigation = service.makePageNavigation(currentPage, sizePerPage);
			mav.addObject("navigation", pageNavigation);
			mav.addObject("mobileList",list);
			mav.setViewName("mobile/listMobile");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		return mav;
	};
	
	@GetMapping("/view")
	public String MemberView(MobileDto dto, Model model) {
		try {
			MobileDto mobileView = service.MobileView(dto);
			model.addAttribute("mobile", mobileView);
			return "mobile/detailMobile";
		} catch (Exception e) {
			e.printStackTrace();
			return "error/error";
		}
	}
	
	@GetMapping("/delete")
	public String DeletePhone(@RequestParam("mobileCode") String mobileCode) throws SQLException {
		try {
		MobileDto findMobile = service.findMobile(mobileCode);
		service.MobileDelete(findMobile);
		return "redirect:/mobile/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "error/error";
		}
	}
}
