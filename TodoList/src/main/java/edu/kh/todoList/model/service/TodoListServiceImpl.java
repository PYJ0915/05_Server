package edu.kh.todoList.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dao.TodoListDAO;
import edu.kh.todoList.model.dao.TodoListDAOImpl;
import edu.kh.todoList.model.dto.Todo;

import static edu.kh.todoList.common.JDBCTemplate.*;

public class TodoListServiceImpl implements TodoListService{

	private TodoListDAO dao = new TodoListDAOImpl();
	
	@Override
	public Map<String, Object> todoListFullView() throws Exception {
		
		// 커넥션 생성
		Connection conn = getConnection();
		
		// 데이터 가공 => 없어서 패스
		
		// dao 호출 및 반환 받기
		// 1) 할 일 목록 얻어오기
		List<Todo> todoList = dao.todoListFullView(conn);
		
		// 2) 완료된 할 일 개수 카운트
		
		
		
		return null;
	}


}
