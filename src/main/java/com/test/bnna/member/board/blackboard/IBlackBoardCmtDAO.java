package com.test.bnna.member.board.blackboard;

public interface IBlackBoardCmtDAO {

	int add(BlackBoardCmtDTO dto);

	BlackBoardCmtDTO getAddCmt();

	int del(String seqBlackBoardCmt);

	BlackBoardCmtDTO get(String seq);

}
