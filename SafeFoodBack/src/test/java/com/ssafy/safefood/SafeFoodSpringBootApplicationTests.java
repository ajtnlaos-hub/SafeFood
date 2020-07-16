package com.ssafy.safefood;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.safefood.dto.QnA;
import com.ssafy.safefood.service.QnA_Service;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Transactional
@Slf4j
class SafeFoodSpringBootApplicationTests {
	@Autowired
	QnA_Service service;
	
	@Test
	void testSelectAllQnA() {
		log.error("test1 : {}", service.selectAllQnA());
		assertNotNull(service);
		assertEquals(service.selectAllQnA().size(), 3);
	}
	@Test
	void testSelectQnA() {
		log.error("testSelectQnA() : {}", service.selectQnA(1));
		assertEquals(service.selectQnA(1).getWriter(), "admin");
	}
	@Test
	void testInsert() {
		log.error("testInsert() : {}");
		QnA qna = new QnA(0, "InsertTest", "admin", null, "contentExample");
		assertEquals(service.insert(qna), true);
		assertEquals(qna.getQnaNum(), 4);
	}
}
