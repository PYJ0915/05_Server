package edu.kh.memo.controller;

import java.io.IOException;

import edu.kh.memo.model.dto.Memo;
import edu.kh.memo.model.service.MemoService;
import edu.kh.memo.model.service.MemoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/memo/update")
public class UpdateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int memoNo = Integer.parseInt(req.getParameter("memoNo"));
			
			MemoService service = new MemoServiceImpl();
			
			Memo memo = service.memoDetail(memoNo);
			
			if (memo == null) {
			    HttpSession session = req.getSession();
			    session.setAttribute("message", "일치하는 메모가 없습니다!");
			    resp.sendRedirect("/");
			    return;
			}
			
			req.setAttribute("memo", memo);
			
			req.getRequestDispatcher("/WEB-INF/views/memoUpdate.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			int memoNo = Integer.parseInt(req.getParameter("memoNo"));
			
			MemoService service = new MemoServiceImpl();
			
			int result = service.updateMemo(memoNo, title, content);
			
			HttpSession session = req.getSession();
			
			String message = null;
			String url = null;
			
			if(result > 0) {
				
				message = "수정 완료되었습니다.";
				url = "/memo/detail?memoNo=" + memoNo;
				
			} else {
				
				message = "수정에 실패했습니다.";
				url = "/memo/update?memoNo=" + memoNo;
				
			}
			
			session.setAttribute("message", message);
			resp.sendRedirect(url);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
