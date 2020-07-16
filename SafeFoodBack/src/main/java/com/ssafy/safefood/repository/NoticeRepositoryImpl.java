package com.ssafy.safefood.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.Notice;

@Repository
public class NoticeRepositoryImpl implements NoticeRepository {
	@Autowired
	SqlSession session;
	private final String namespace = "sql.safefood.notice.";
	@Override
	public List<Notice> selectAllNotice() {		
		return session.selectList(namespace.concat("selectAllNotice"));
	}
	@Override
	public Notice selectNotice(int noticeNum) {
		return session.selectOne(namespace.concat("selectNotice"), noticeNum);
	}
	@Override
	public boolean update(Notice notice) {
		return session.update(namespace.concat("update"), notice)>0;
	}
	@Override
	public boolean delete(int noticeNum) {
		// TODO Auto-generated method stub
		return session.delete(namespace.concat("delete"), noticeNum)>0;
	}
	@Override
	public boolean insert(Notice notice) {
		return session.insert(namespace.concat("insert"), notice)>0;
	}
}
