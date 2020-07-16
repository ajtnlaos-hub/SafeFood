package com.ssafy.safefood.repository;

import java.util.List;

import com.ssafy.safefood.dto.Food;

public interface FoodRepository {
	public List<Food> selectFoodList();
	public Food selectFoodDetail(int code);
}