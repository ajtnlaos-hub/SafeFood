package com.ssafy.safefood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
	private Integer noticeNum;
	private String title;
	private String writer;
	private String writtenDate;
	private String contents;
}