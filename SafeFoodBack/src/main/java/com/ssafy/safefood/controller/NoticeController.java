package com.ssafy.safefood.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.safefood.dto.Notice;
import com.ssafy.safefood.dto.User;
import com.ssafy.safefood.service.NoticeService;

@Controller
@CrossOrigin("{*}")
public class NoticeController {
	@Autowired
	NoticeService nService;
	
	@GetMapping("notice.do")
	public String getNoticePage(Model model) {
		model.addAttribute("noticeList", nService.selectAllNotice());
		return "notice";
	}
	@GetMapping("noticeDetail.do")
	public String getNoticeDetail(Integer noticeNum, Model model) {
		model.addAttribute("notice", nService.selectNotice(noticeNum));
		return "noticeDetail";
	}
	@GetMapping("getModifyNoticeForm.do")
	public String getNoticeModifyForm(Integer noticeNum, Model model) {
		model.addAttribute("notice", nService.selectNotice(noticeNum));
		return "modifyNotice";
	}
	
	@GetMapping("modifyNotice.do")
	public String doModifyNotice(Integer noticeNum, String title, String writer, String writtenDate, String contents, HttpSession session) {
		try {
			if(nService.modifyNotice(new Notice(noticeNum, title, writer, writtenDate, contents))) {
				session.setAttribute("message", "공지 사항을 수정하였습니다.");
				return "redirect:notice.do";
			} else {
				session.setAttribute("message", "공지 사항 수정 실패.");
				return "notice.do";
			}
		} catch(RuntimeException e) {
			session.setAttribute("message", "공지 사항 수정 실패.");
			return "notice.do";
		}
	}
	
	@GetMapping("deleteNotice.do")
	public String doDeleteNotice(Integer noticeNum, HttpSession session) {
		try {
			if(nService.deleteNotice(noticeNum)) {
				session.setAttribute("message", "공지 사항을 삭제하였습니다.");
				return "redirect:notice.do";
				
			} else {
				session.setAttribute("message", "공지 사항 삭제 실패.");
				return "notice.do";
			}
		} catch(RuntimeException e) {
			session.setAttribute("message", "공지 사항 삭제 실패.");
			return "notice.do";
		}
	}
	@GetMapping("getInsertNoticeForm.do")
	public String getInsertNoticeForm() {
		return "newNotice";
	}
	@GetMapping("insertNotice.do")
	public String doInsertNotice(String titleText, String contents, HttpSession session) {
		try {
			User loginUser = (User) session.getAttribute("loginUser");
			if(nService.insertNotice(new Notice(0, titleText, loginUser.getId(), "", contents))) {
				session.setAttribute("message", "공지 사항을 등록하였습니다.");
				return "redirect:notice.do";
			} else {
				session.setAttribute("message", "공지 사항 등록 실패.");
				return "notice.do";
			}
		} catch(RuntimeException e) {
			session.setAttribute("message", "공지 사항 등록 실패.");
			return "notice.do";
		}
	}
}