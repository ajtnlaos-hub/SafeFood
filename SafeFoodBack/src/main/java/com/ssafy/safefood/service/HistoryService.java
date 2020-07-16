package com.ssafy.safefood.service;

import java.util.List;

import com.ssafy.safefood.dto.History;
import com.ssafy.safefood.dto.HistoryDetail;

public interface HistoryService {
	public boolean insertHistory(History history);
	public List<HistoryDetail> selectMyHistory(String id);
}
