package com.test.bnna.member.board.qna;

import java.util.List;

public interface IQnaDAO {

	List<QnaDTO> list();

	int add(QnaDTO dto);

	QnaDTO get(String seq);

	int del(String seq);

	int edit(QnaDTO dto);
	
	/*
	 * public int countBoard();
	 * 
	 * public List<QnaDTO> selectBoard(PagingVO vo);
	 */
	
	

}
