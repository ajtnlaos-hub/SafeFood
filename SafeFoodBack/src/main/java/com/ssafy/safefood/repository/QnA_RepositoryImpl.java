package com.ssafy.safefood.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.QnA;

@Repository
public class QnA_RepositoryImpl implements QnA_Repository {
	@Autowired
	SqlSession session;
	
	private final String namespace = "sql.safefood.qna.";
	
	@Override
	public List<QnA> selectAllQnA() {
		return session.selectList(namespace.concat("selectAllQnA"));
	}
	@Override
	public QnA selectQnA(int qnaNum) {
		return session.selectOne(namespace.concat("selectQnA"), qnaNum);
	}
	@Override
	public boolean insert(QnA qna) {
		return session.insert(namespace.concat("insert"), qna)>0;
	}
	@Override
	public boolean delete(int qnaNum) {
		return session.delete(namespace.concat("delete"), qnaNum)>0;
	}
	@Override
	public boolean update(QnA qna) {
		return session.update(namespace.concat("update"), qna)>0;
	}
}
