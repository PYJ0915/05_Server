package edu.kh.memo.model.service;

import static edu.kh.memo.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.memo.model.dao.MemoDAO;
import edu.kh.memo.model.dao.MemoDAOImpl;
import edu.kh.memo.model.dto.Memo;

public class MemoServiceImpl implements MemoService{
	
	private MemoDAO dao = new MemoDAOImpl();

	@Override
	public List<Memo> getMemoFull() throws Exception {
		
		Connection conn = getConnection();
		
		List<Memo> memoList = dao.getMemoFull(conn);
		
		close(conn);
		
		return memoList;
	}

	@Override
	public Memo memoDetail(int memoNo) throws Exception {
		
		Connection conn = getConnection();
		
		Memo memo = dao.memoDetail(conn, memoNo);
		
		close(conn);
		
		return memo;
	}

	@Override
	public int addMemo(String title, String content) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.addMemo(conn, title, content);
		
		if(result > 0) {
			
			commit(conn);
			
		} else {
			
			rollback(conn);
			
		}
		
		close(conn);
		
		return result;
	}

	@Override
	public int deleteMemo(int memoNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteMemo(conn, memoNo);
		
		if(result > 0) {
			
			commit(conn);
			
		} else {
			
			rollback(conn);
			
		}
		
		close(conn);
		
		return result;
	}

	@Override
	public int updateMemo(int memoNo, String title, String content) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.updateMemo(conn, memoNo, title, content);
		
		if(result > 0) {
			
			commit(conn);
			
		} else {
			
			rollback(conn);
			
		}
		
		close(conn);
		
		return result;
	}

}
