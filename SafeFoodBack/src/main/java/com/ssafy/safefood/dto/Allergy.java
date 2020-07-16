package com.ssafy.safefood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Allergy {
	private String id;
	private String ingredient;
}
