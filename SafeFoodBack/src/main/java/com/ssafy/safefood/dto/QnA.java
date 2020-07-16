package com.ssafy.safefood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QnA {
	private int qnaNum;
	private String title;
	private String writer;
	private String writtenDate;
	private String contents;
}