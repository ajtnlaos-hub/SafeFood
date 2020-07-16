package com.ssafy.safefood.service;

import java.util.List;

import com.ssafy.safefood.dto.Notice;

public interface NoticeService {
	List<Notice> selectAllNotice();
	Notice selectNotice(int noticeNum);
	boolean modifyNotice(Notice notice);
	boolean deleteNotice(int noticeNum);
	boolean insertNotice(Notice notice);
}
