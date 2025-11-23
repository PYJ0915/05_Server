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

@WebServlet("/memo/delete")
public class DeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int memoNo = Integer.parseInt(req.getParameter("memoNo"));
			
			MemoService service = new MemoServiceImpl();
			
			int result = service.deleteMemo(memoNo);
			
			HttpSession session = req.getSession();
			
			if(result > 0) {
				
				session.setAttribute("message", "메모가 삭제되었습니다.");
				resp.sendRedirect("/");
				return;
				
			}
			
			session.setAttribute("message", "메모 삭제에 실패했습니다. 다시 시도해주세요..");
			resp.sendRedirect("/memo/detail=memo" + memoNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
