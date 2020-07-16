package com.ssafy.safefood.service;

import java.util.List;

import com.ssafy.safefood.dto.QnA;

public interface QnA_Service {
	List<QnA> selectAllQnA();
	QnA selectQnA(int qnaNum);
	boolean insert(QnA qna);
	boolean delete(int qnaNum);
	boolean update(QnA qna);
}
