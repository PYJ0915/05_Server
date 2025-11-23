package edu.kh.memo.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static edu.kh.memo.common.JDBCTemplate.*;
import edu.kh.memo.model.dto.Memo;

public class MemoDAOImpl implements MemoDAO{
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public MemoDAOImpl() {
		
		try {
			String filePath = MemoDAOImpl.class.getResource("/xml/sql.xml").getPath();
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			System.out.println("sql.xml 로드 중 예외 발생");
			e.printStackTrace();
		}
		
	}
	

	@Override
	public List<Memo> getMemoFull(Connection conn) throws Exception {
		
		List<Memo> memoList = new ArrayList<Memo>();
		
		try {
			
			String sql = prop.getProperty("getMemoFull");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Memo memo = Memo.builder()
		   			  .memoNo(rs.getInt("MEMO_NO"))
					  .memoTitle(rs.getString("MEMO_TITLE"))
					  .memoContent(rs.getString("MEMO_CONTENT"))
					  .regDate(rs.getString("REG_DATE"))
					  .build();
				
				memoList.add(memo);
			}
			
		} finally {
			
			close(rs);
			close(stmt);
			
		}
		
		return memoList;
	}


	@Override
	public Memo memoDetail(Connection conn, int memoNo) throws Exception {
		
		Memo memo = null;
		
		try {
			
			String sql = prop.getProperty("memoDetail");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memoNo);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				memo = Memo.builder()
						.memoNo(memoNo)
						.memoTitle(rs.getString("MEMO_TITLE"))
						.memoContent(rs.getString("MEMO_CONTENT"))
						.regDate(rs.getString("REG_DATE"))
						.build();
				
			}
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return memo;
	}


	@Override
	public int addMemo(Connection conn, String title, String content) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("addMemo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			
			close(pstmt);
			
		}
		
		return result;
	}


	@Override
	public int deleteMemo(Connection conn, int memoNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteMemo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memoNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			
			close(pstmt);
			
		}
		
		return result;
	}


	@Override
	public int updateMemo(Connection conn, int memoNo, String title, String content) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateMemo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, memoNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			
			close(pstmt);
			
		}
		
		return result;
	}

}
