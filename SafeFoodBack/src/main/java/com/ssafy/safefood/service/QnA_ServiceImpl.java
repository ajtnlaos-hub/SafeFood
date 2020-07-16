package com.ssafy.safefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dto.QnA;
import com.ssafy.safefood.repository.QnA_Repository;

@Service
public class QnA_ServiceImpl implements QnA_Service {
	@Autowired
	QnA_Repository qRepo;
	
	@Override
	public List<QnA> selectAllQnA() {
		return qRepo.selectAllQnA();
	}
	@Override
	public QnA selectQnA(int qnaNum) {
		return qRepo.selectQnA(qnaNum);
	}
	@Override
	public boolean insert(QnA qna) {
		return qRepo.insert(qna);
	}
	@Override
	public boolean delete(int qnaNum) {
		return qRepo.delete(qnaNum);
	}
	@Override
	public boolean update(QnA qna) {
		return qRepo.update(qna);
	}
}
