package com.ssafy.safefood.repository;

import java.util.List;

import com.ssafy.safefood.dto.Notice;

public interface NoticeRepository {
	List<Notice> selectAllNotice();
	Notice selectNotice(int noticeNum);
	boolean update(Notice notice);
	boolean delete(int noticeNum);
	boolean insert(Notice notice);
}
