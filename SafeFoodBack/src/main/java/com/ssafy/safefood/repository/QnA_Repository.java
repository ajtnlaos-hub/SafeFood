package com.ssafy.safefood.repository;

import java.util.List;

import com.ssafy.safefood.dto.QnA;

public interface QnA_Repository {
	List<QnA> selectAllQnA();
	QnA selectQnA(int qnaNum);
	boolean insert(QnA qna);
	boolean delete(int qnaNum);
	boolean update(QnA qna);
}
