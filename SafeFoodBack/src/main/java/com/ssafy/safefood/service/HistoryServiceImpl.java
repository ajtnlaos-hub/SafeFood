package com.ssafy.safefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.safefood.dto.History;
import com.ssafy.safefood.dto.HistoryDetail;
import com.ssafy.safefood.repository.HistoryRepository;

@Service
public class HistoryServiceImpl implements HistoryService{
	
	@Autowired
	HistoryRepository hrepo;

	@Override
	@Transactional
	public boolean insertHistory(History history) {
		return hrepo.insertHistory(history);
	}

	@Override
	public List<HistoryDetail> selectMyHistory(String id) {
		return hrepo.selectMyHistory(id);
	}

}
