package com.ssafy.safefood.repository;

import java.util.List;

import com.ssafy.safefood.dto.History;
import com.ssafy.safefood.dto.HistoryDetail;

public interface HistoryRepository {
	public boolean insertHistory(History history);
	public List<HistoryDetail> selectMyHistory(String id);

}
