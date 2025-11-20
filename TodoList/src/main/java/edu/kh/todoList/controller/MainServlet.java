package edu.kh.todoList.controller;

import java.io.IOException;
import java.util.Map;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// "/main" 요청을 매핑하여 처리하는 Servlet
@WebServlet("/main")
public class MainServlet extends HttpServlet{

	// why? index.jsp에서 메인페이지 코드를 작성하지 않고 /main 요청을 처리하는 서블릿을 만들었는가?
	// => Servlet(Java 코드 <-> DB)에서 추가한 (DB에서 조회한) 데이터를 얻어와 메인페이지에서부터 사용할 수 있게 하기 위해서
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// DB에서 데이터를 얻어와야함!
		// 요청 -> Controller -> Service -> DAO -> DB -> DAO -> Service -> Controller -> views(jsp) -> 응답
		// 서비스 호출
		
		try {
			
			TodoListService service = new TodoListServiceImpl();
			
			// 전체 할 일 목록 + 완료된 Todo 개수 얻어오기
			Map<String, Object> map = service.todoListFullView();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
}
