package com.ssafy.safefood.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ssafy.safefood.dto.History;
import com.ssafy.safefood.dto.HistoryDetail;
import com.ssafy.safefood.dto.User;
import com.ssafy.safefood.service.HistoryService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@CrossOrigin("{*}")
public class HistoryController {
	@Autowired
	HistoryService hservice;
	@PostMapping("insertHistory.do")
	public String doAdd(History history, HttpSession session) {
		User user = (User)session.getAttribute("loginUser");
		history.setId(user.getId());
		try {
			if( hservice.insertHistory(history)) {
				return "redirect:detail.do?code="+history.getCode();
			}else {
				log.error("history insert 실패1");
				return "redirect:detail.do?code="+history.getCode();
			}
		}catch (RuntimeException e) {
			log.error("history insert 실패");
			return "redirect:detail.do?code="+history.getCode();
		}
	}
	@GetMapping("myList.do")
	public String getMyList(HttpSession session, Model model) {
		try {
			User user = (User)session.getAttribute("loginUser");
			String id = user.getId();
			List<HistoryDetail> historyList = hservice.selectMyHistory(id);
			model.addAttribute("myFood", historyList);
			return "myFood";
		}catch(RuntimeException e) {
			log.error("history select 실패");
			return "main";			
		}
	}

}
