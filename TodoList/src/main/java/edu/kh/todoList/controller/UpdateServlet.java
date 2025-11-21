package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/update")
public class UpdateServlet extends HttpServlet{

	// 수정 버튼 클릭 시 요청한 수정 화면 전환 GET 요청
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 수정 화면에는 기존 제목과 상세 내용이 input 태그와 textarea에 채워져 있어야함!
			// => 수정 전 제목/내용 조회!
			
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			TodoListService service = new TodoListServiceImpl();
			
			Todo todo = service.todoDetail(todoNo);
			
			if(todo == null) {
				
				// 메인페이지로 redirect
				resp.sendRedirect("/");
				return;
				
			}
		
			req.setAttribute("todo", todo);
			
			// 요청 발송자를 통해서 forward
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/* 요청해야하는 주소가 같으면서 요청 방식(GET/POST)이 다를 때
	 * => 하나의 서블릿 클래스에서 각각의 메서드(doGet()/doPost())를 만들어 처리할 수 있다!
	 * */
	
	// 할 일 제목과 내용을 수정 POST 요청
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 전달 받은 파라미터 얻어오기 (제목, 상세 내용, todoNo)
			String title = req.getParameter("title");
			String detail = req.getParameter("detail");
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			TodoListService service = new TodoListServiceImpl();
			
			int result = service.todoUpdate(title, detail, todoNo);
			
			// 수정 성공 시
			// 상세 조회 페이지로 redirect
			// "수정되었습니다" message를 출력
			
			// 수정 실패 시
			// 수정화면으로 redirect
			// "수정 실패" message를 출력
			String url = null;
			String message = null;
			
			if(result > 0) {
				
				url = "/todo/detail?todoNo=" + todoNo;
				message = "수정되었습니다";
				
			} else {
				
				url = "/todo/update?todoNo=" + todoNo;
				message = "수정 실패..";
				
			}
			
			req.getSession().setAttribute("message", message);
			
			resp.sendRedirect(url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
