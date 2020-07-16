package com.ssafy.safefood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryDetail {
	private int code;
	private String name;
	private String img;
	private int count;
	private String eatingDate;	
}
