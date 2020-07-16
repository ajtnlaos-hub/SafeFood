package com.ssafy.safefood.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.safefood.dto.Allergy;
import com.ssafy.safefood.dto.Food;
import com.ssafy.safefood.dto.User;
import com.ssafy.safefood.service.FoodService;
import com.ssafy.safefood.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@CrossOrigin("{*}")
public class UserController {
	@Autowired
	UserService uService;
	
	private String[] allergies = {"대두", "땅콩", "우유", "게", "새우", "참치", "연어", "쑥", "소고기", "닭고기", "돼지고기", "복숭아", "민들레", "계란흰자"};
	@GetMapping("main.do")
	public String getMain() {
		return "main";
	}
	
	@PostMapping("login.do")
	public String doLogin(String id, String pw, HttpSession session) {
		try {
			User loginUser = uService.login(id);
			if(loginUser.getPassword().equals(pw)) {
				session.setAttribute("loginUser", loginUser);
				session.setAttribute("message", "로그인 되었습니다.");
				return "redirect:main.do";
			} else {
				session.setAttribute("message", "아이디 혹은 비밀번호를 확인하세요.");
				return "main";
			}
		} catch(RuntimeException e) {
			e.printStackTrace();
			session.setAttribute("message", "아이디 혹은 비밀번호를 확인하세요.");
			return "main";
		}
	}
	
	@GetMapping("logout.do")
	public String doLogout(HttpSession session, Model model) {
		session.invalidate();
		System.out.println("Logout.do");
		return "redirect:main.do";
	}
	@GetMapping("modify.do")
	public String getModifyForm() {
		return "modify";
	}
	@PostMapping("modify.do")
	public String doModify(String id, String password, String name, String address, String phone, int[] ingredient, HttpSession session) {
		List<Allergy> allergyList = new ArrayList<Allergy>();
		for (int i = 0; i < ingredient.length; i++) {
			allergyList.add(new Allergy(id, allergies[ingredient[i]]));
		}
		User user = new User(id, password, name, address, phone, allergyList, null);
		try {
			log.error("user :{}", user);
			if(uService.modify(user)) {
				session.setAttribute("message", "수정되었습니다.");
				session.setAttribute("loginUser", user);
				return "redirect:main.do";
			} else {
				session.setAttribute("message", "수정 실패");
				return "modify";
			}
		} catch(RuntimeException e) {
			e.printStackTrace();
			session.setAttribute("message", "수정 실패");
			return "main";
		}
	}
	
	@GetMapping("signup.do")
	public String getRegistForm() {
		return "signup";
	}
	@PostMapping("signup.do")
	public String doSignUp(String id, String password, String name, String address, String phone, int[] ingredient, HttpSession session) {
		List<Allergy> allergyList = new ArrayList<Allergy>();
		for (int i = 0; i < ingredient.length; i++) allergyList.add(new Allergy(id, allergies[ingredient[i]]));
		User signUpUser = new User(id, password, name, address, phone, allergyList, null);
		try {
			if(uService.signUp(signUpUser)) {
				session.setAttribute("message", "회원 가입 되었습니다.");
				return "redirect:main.do";		
			} else {
				session.setAttribute("message", "회원 가입에 실패하였습니다.");
				return "main.do";
			}
		} catch(RuntimeException e) {
			e.printStackTrace();
			session.setAttribute("message", "회원 가입에 실패하였습니다.");
			return "main.do";
		}
	}
	
	@GetMapping("delete.do")
	public String doDelete(String id, HttpSession session) {
		try {
			if(uService.delete(id)) {
				session.setAttribute("message", "회원 탈퇴 되었습니다.");
				return "redirect:logout.do";				
			} else {
				session.setAttribute("message", "회원 탈퇴에 실패하였습니다.");
				return "main";
			}
		} catch(RuntimeException e) {
			e.printStackTrace();
			session.setAttribute("message", "회원 탈퇴에 실패하였습니다.");
			return "main";
		}
	}
	
	@GetMapping("findPassword.do")
	public String getFindPasswordForm() {
		return "findPassword";
	}
	
	@PostMapping("findPassword.do")
	public String doFindPassword(User user, HttpSession session) {
		User find = uService.findPassword(user);
		if(find!=null) {
			session.setAttribute("message", "비밀번호는 " + find.getPassword() + "입니다.");
		} else {
			session.setAttribute("message", "사용자 정보를 찾을 수 없습니다.");
		}
		return "main";
	}
	
}