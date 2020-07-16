package com.ssafy.safefood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.safefood.dto.Food;
import com.ssafy.safefood.service.FoodService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@CrossOrigin("{*}")
public class FoodController {
	@Autowired
	FoodService fService;
	
	@GetMapping("foodList.do")
	public String getfoodList(Model model) {
		try {
			List<Food> foodList = fService.selectFoodList();
			model.addAttribute("foodList", foodList);
			return "foodList";
		} catch (RuntimeException e) {
			log.error("불러오기 실패");
			return "main";
		}
	}

	@GetMapping("detail.do")
	public String getDetail(@RequestParam int code, Model model) {
		try {
			System.out.println(code);
			Food food = fService.selectFoodDetail(code);
			model.addAttribute("food", food);
			// return "main";
			return "detail";
		} catch (RuntimeException e) {
			log.error("불러오기 실패2");
			return "main";
		}
	}
	@GetMapping("search.do")
	public String doSearch(String condition, String searchText, Model model) {
		try {
			List<Food> foodList = fService.selectFoodList();
			switch(condition) {
			case "상품명":
				for (int i = foodList.size()-1; i >= 0; i--) {
					if(!foodList.get(i).getName().contains(searchText)) foodList.remove(i);
				}
				break;
			case "재료":
				for (int i = foodList.size()-1; i >= 0; i--) {
					if(!foodList.get(i).getMaterial().contains(searchText)) foodList.remove(i);
				}
				break;
			case "제조사":
				for (int i = foodList.size()-1; i >= 0; i--) {
					if(!foodList.get(i).getMaker().contains(searchText)) foodList.remove(i);
				}
				break;
			}
			if(foodList.size()!=0) model.addAttribute("foodList", foodList);
			else model.addAttribute("message", "검색 조건에 맞는 식품이 없습니다.");
		} catch(RuntimeException e) {
			model.addAttribute("message", "조회에 실패 했습니다.");
			log.trace("searchText : {}", searchText);
			e.printStackTrace();
		}
		return "foodList";
	}
}
