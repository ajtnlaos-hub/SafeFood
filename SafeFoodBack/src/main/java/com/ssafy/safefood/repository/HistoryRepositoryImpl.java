package com.ssafy.safefood.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.History;
import com.ssafy.safefood.dto.HistoryDetail;

@Repository
public class HistoryRepositoryImpl implements HistoryRepository {
	
	private final String ns = "sql.safefood.history.";
	
	@Autowired
	SqlSession session;

	@Override
	public boolean insertHistory(History history) {
		System.out.println("repo: " + history);
		return session.insert(ns+"insertHistory", history)>0;
	}

	@Override
	public List<HistoryDetail> selectMyHistory(String id) {
		return session.selectList(ns+"selectMyHistory", id);
	}
}
