package com.ssafy.safefood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.safefood.dto.QnA;
import com.ssafy.safefood.responseType.BoolResult;
import com.ssafy.safefood.service.QnA_Service;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rest")
@Slf4j
@CrossOrigin({"*"})
public class QnA_RestController {
	@Autowired
	QnA_Service service;
	
	@GetMapping("/QnAMain")
	@ApiOperation(value="모든 QnA의 정보를 반환한다.", response=List.class)
	public Object selectAllQnA() {
		log.error("selectAllQnA()");
		try {
//			log.trace("QnA List : {}", service.selectAllQnA());
			return new ResponseEntity<Object>(service.selectAllQnA(), HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("ERROR OCCUR : selectAllQnA()");
			e.printStackTrace();
			throw e;
		}
	}
	
	@GetMapping("/QnADetail/{qnaNum}")
	@ApiOperation(value="QnA Num을 통한 상세 조회 페이지", response=QnA.class)
	public Object selectQnA(@PathVariable int qnaNum) {
//		log.trace("selectQnA() WITH PARAM QNANUM : {}", qnaNum);
		try {
			return new ResponseEntity<Object>(service.selectQnA(qnaNum), HttpStatus.OK);
		} catch(RuntimeException e) {
			e.printStackTrace();
			log.error("ERROR OCCUR : selectQnA()");
			throw e;
		}
	}
	
	@PostMapping("/addQnA")
	@ApiOperation(value="새로운 QnA insert", response=BoolResult.class)
	public Object insert(@RequestBody QnA qna) {
		try {
			if(service.insert(qna)) {
				return new ResponseEntity<Object>(new BoolResult("insert", true, "SUCCESS"), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(new BoolResult("insert", false, "FAIL"), HttpStatus.CONFLICT);				
			}
		} catch(RuntimeException e) {
			e.printStackTrace();
			log.error("ERROR OCCUR : insert()");
			throw e;
		}
	}
	
	@DeleteMapping("/deleteQnA/{qnaNum}")
	@ApiOperation(value="QnA Delete", response=BoolResult.class)
	public Object delete(@PathVariable int qnaNum) {
		try {
			if(service.delete(qnaNum)) {
				return new ResponseEntity<Object>(new BoolResult("delete", true, "SUCCESS"), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(new BoolResult("delete", false, "FAIL"), HttpStatus.CONFLICT);
			}
		} catch(RuntimeException e) {
			e.printStackTrace();
			log.error("ERROR OCCUR : delete()");
			throw e;
		}
	}
	
	@PutMapping("/updateQnA")
	@ApiOperation(value="QnA Update", response=BoolResult.class)
	public Object update(@RequestBody QnA qna) {
		try {
			if(service.update(qna)) {
				return new ResponseEntity<Object>(new BoolResult("update", true, "SUCCESS"), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(new BoolResult("update", false, "FAIL"), HttpStatus.CONFLICT);
			}
		} catch(RuntimeException e) {
			e.printStackTrace();
			log.error("ERROR OCCUR : update()");
			throw e;
		}
	}
	
	@GetMapping("/searchQnA/{type}/{searchText}")
	@ApiOperation(value="QnA Search 1 : title, 2 : writer", response=List.class)
	public Object searchQnA(@PathVariable int type, @PathVariable String searchText) {
		try {
			List<QnA> list = service.selectAllQnA();
			switch(type) {
			case 1:
				for (int i = list.size()-1; i >=0 ; i--) {
					if(!list.get(i).getTitle().contains(searchText)) list.remove(i);
				}
				break;
			case 2:
				for (int i = list.size()-1; i >=0 ; i--) {
					if(list.get(i).getWriter()!=null && !list.get(i).getWriter().contains(searchText)) list.remove(i);
				}
				break;
			}
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		} catch(RuntimeException e) {
			e.printStackTrace();
			log.error("ERROR OCCUR : searchQnA()");
			throw e;
		}
	}
}

















