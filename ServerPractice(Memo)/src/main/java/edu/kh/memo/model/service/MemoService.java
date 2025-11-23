package edu.kh.memo.model.service;

import java.util.List;

import edu.kh.memo.model.dto.Memo;

public interface MemoService {

	List<Memo> getMemoFull() throws Exception;

	Memo memoDetail(int memoNo) throws Exception;

	int addMemo(String title, String content) throws Exception;

	int deleteMemo(int memoNo) throws Exception;

	int updateMemo(int memoNo, String title, String content) throws Exception;

}
