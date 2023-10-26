package com.ssafy.spring.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.spring.dto.MemberDto;
import com.ssafy.spring.service.MemberService;

@Controller
@RequestMapping("/mem")
public class UserController {
	
	private MemberService service;
	
	public UserController(MemberService service) {
		super();
		this.service = service;
	}

	@GetMapping("/login")
	public String login() {
		return "user/login";
	};
	
	@PostMapping("/login")
	public String loginMem(MemberDto dto, HttpServletRequest request) throws SQLException {
		boolean login = service.login(dto);
		if(login) {
			request.getSession().setAttribute("userInfo", dto);
			System.out.println(dto);
			return "index";
		} else {
			return "index";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		try {
			request.getSession().invalidate();
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			return "error/error";
		}
	}
	
	@GetMapping("/insert")
	public String MemberInsert() {
		return "user/regform";
	}
	
	@PostMapping("/insert")
	public String MemberInsertForm(MemberDto dto) throws SQLException {
		try {			
			service.memberInsert(dto);
			return "redirect:/";
		} catch (Exception e) {
			return "error/error";
		}
	}

	@GetMapping("/idcheck/{id}")
	public @ResponseBody Map<String, String> idCheck(@PathVariable("id") String id) throws Exception{
		MemberDto dto = new MemberDto();
		dto.setId(id);
		MemberDto mem = service.memberView(dto);
		Map<String, String> map = new HashMap<>();
		System.out.println(mem);
		map.put("result", mem==null?"사용하실 수 있는 아이디입니다":"사용하실 수 없는 아이디입니다");
		return map;
	}
	
	
}
