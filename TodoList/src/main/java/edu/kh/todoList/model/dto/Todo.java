package edu.kh.todoList.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data // Getter + Setter + ToString
@Builder
public class Todo {

	private int todoNo; // todo 번호
	private String todoTitle; // todo 제목
	private String todoDetail; // todo 상세 내용
	private boolean todoComplete; // todo 완료 여부
	private String regDate; // todo 등록일
	
}
