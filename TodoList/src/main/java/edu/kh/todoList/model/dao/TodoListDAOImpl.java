package edu.kh.todoList.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.todoList.model.dto.Todo;

public class TodoListDAOImpl implements TodoListDAO{
	
	// JDBC 객체 참조 변수 선언
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	// TodoListDAOImpl 생성자 /xml/sql.xml 경로 읽어오기
	public TodoListDAOImpl() {
	// TodoListDAOImpl 객체가 생성 될 때( Service 단에서 new 연산자를 통해 객체화 될 때)
	// sql.xml 파일의 내용을 읽어와 Properties prop 객체에 K:V 세팅
		
		try {
			String filePath = TodoListDAOImpl.class.getResource("/xml/sql.xml").getPath();
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			System.out.println("sql.xml 로드 중 예외발생");
			e.printStackTrace();
		}
		
	}


	@Override
	public List<Todo> todoListFullView(Connection conn) throws Exception {
		
		// 결과 저장용 변수 선언
		List<Todo> todoList = new ArrayList<Todo>();
		
		try {
			// SQL 작성
			String sql = prop.getProperty("todoListFullView");
			// ==
			/*
			String sql = SELECT TODO_NO, TODO_TITLE, TODO_COMPLETE, TO_CHAR(REG_DATE, 'YYYY-MM-DD HH24:MI:SS') REG_DATE 
			FROM TB_TODO ORDER BY TODO_NO 
			 */
			
			// stmt 객체 생성 후 결과값 받아오기
			stmt = conn.createStatement();
			
			// executeQuery() - SELECT 구문 수행 후 ResultSet반환
			// executeUpdate() - DML(INSERT/DELETE/UPDATE) 구문 수행 후 결과 행의 개수 반환
			rs = stmt.executeQuery(sql);
			
			
			
		} finally {
			
			
		}
		
		
		return todoList;
	}

}
