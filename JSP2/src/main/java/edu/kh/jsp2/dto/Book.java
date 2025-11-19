package edu.kh.jsp2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
// @Getter
// @Setter
// @ToString
// ==
@Data
public class Book {

	private String title; // 제목
	private String writer; // 저자
	private int price; // 가격
	
}
