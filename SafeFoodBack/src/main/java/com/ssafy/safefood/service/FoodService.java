package com.ssafy.safefood.service;

import java.util.List;

import com.ssafy.safefood.dto.Food;

public interface FoodService {
	public List<Food> selectFoodList();
	public Food selectFoodDetail(int code);
}
