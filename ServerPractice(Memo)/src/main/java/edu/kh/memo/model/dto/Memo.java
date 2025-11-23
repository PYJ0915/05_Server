package edu.kh.memo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Memo {
	
	private int memoNo;
	private String memoTitle;
	private String memoContent;
	private String regDate;
	
}
