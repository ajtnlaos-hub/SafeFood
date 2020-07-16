package com.ssafy.safefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dto.Notice;
import com.ssafy.safefood.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	NoticeRepository nRepo;
	
	@Override
	public List<Notice> selectAllNotice() {
		return nRepo.selectAllNotice();
	}
	@Override
	public Notice selectNotice(int noticeNum) {
		return nRepo.selectNotice(noticeNum);
	}
	@Override
	public boolean modifyNotice(Notice notice) {
		return nRepo.update(notice);
	}
	@Override
	public boolean deleteNotice(int noticeNum) {
		return nRepo.delete(noticeNum);
	}
	@Override
	public boolean insertNotice(Notice notice) {
		return nRepo.insert(notice);
	}
}
