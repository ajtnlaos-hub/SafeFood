package com.ssafy.safefood.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.Food;

@Repository
public class FoodRepositoryImpl implements FoodRepository{
	private final String ns = "sql.safefood.food.";
	
	@Autowired
	SqlSession session;

	@Override
	public List<Food> selectFoodList() {
		return session.selectList(ns+"selectFoodList");
	}

	@Override
	public Food selectFoodDetail(int code) {
		System.out.println("repo: " + code);
		return session.selectOne(ns+"selectFoodDetail",code);
	}
	
	

}
