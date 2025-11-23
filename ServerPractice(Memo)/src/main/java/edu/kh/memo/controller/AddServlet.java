package edu.kh.memo.controller;

import java.io.IOException;

import edu.kh.memo.model.service.MemoService;
import edu.kh.memo.model.service.MemoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/memo/add")
public class AddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			req.getRequestDispatcher("/WEB-INF/views/memoAdd.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			MemoService service = new MemoServiceImpl();
			
			int result = service.addMemo(title, content);
			
			HttpSession session = req.getSession();
			
			String message = null;
			
			if (result > 0) {
				
				message = "메모가 성공적으로 추가되었습니다.";
				
			} else {
				
				message = "메모 추가에 실패했습니다..";
				
			}
			
			session.setAttribute("message", message);
			resp.sendRedirect("/");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	 	
		
	}
	
}
