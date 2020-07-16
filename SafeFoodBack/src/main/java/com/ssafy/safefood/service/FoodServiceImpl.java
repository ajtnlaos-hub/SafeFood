package com.ssafy.safefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dto.Food;
import com.ssafy.safefood.repository.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
	FoodRepository frepo;
	private String[] allergies = {"대두", "땅콩", "우유", "게", "새우", "참치", "연어", "쑥", "소고기", "닭고기", "돼지고기", "복숭아", "민들레", "계란흰자"};

	@Override
	public List<Food> selectFoodList() {
		return frepo.selectFoodList();
	}

	@Override
	public Food selectFoodDetail(int code) {
		System.out.println("service: " + code);
		Food f =frepo.selectFoodDetail(code);
		String allergy = "";
		String matrial =f.getMaterial();
		
		for (int i = 0; i < allergies.length; i++) {
			if(matrial.contains(allergies[i])) {
				allergy+= allergies[i]+", ";
			}
		}
		
		if(allergy.length() != 0)
			f.setAllergy(allergy.substring(0, allergy.length()-2));
		
		return f;
	}

}
