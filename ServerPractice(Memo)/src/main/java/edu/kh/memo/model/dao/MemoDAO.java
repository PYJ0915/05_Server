package edu.kh.memo.model.dao;

import java.sql.Connection;
import java.util.List;

import edu.kh.memo.model.dto.Memo;

public interface MemoDAO {

	List<Memo> getMemoFull(Connection conn) throws Exception;

	Memo memoDetail(Connection conn, int memoNo) throws Exception;

	int addMemo(Connection conn, String title, String content) throws Exception;

	int deleteMemo(Connection conn, int memoNo) throws Exception;

	int updateMemo(Connection conn, int memoNo, String title, String content) throws Exception;

}
