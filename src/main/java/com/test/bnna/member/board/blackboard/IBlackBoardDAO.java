package com.test.bnna.member.board.blackboard;

import java.util.HashMap;
import java.util.List;

public interface IBlackBoardDAO {

	BlackBoardDTO get(String seq);

	List<BlackBoardImgDTO> getImages(String seq);

	List<BlackBoardCmtDTO> getComments(String seq);

	int getThread();

	void updateThread(HashMap<String, Integer> map);
	
	int addok(BlackBoardDTO dto);

	String getAddSeq();

	int del(String addSeqBlackBoard);

	List<BlackBoardDTO> list(HashMap<String, String> map);

	int getCount();

	List<String> getSeqHasImage();

	void updateReadCnt(String seq);

	boolean hasReply(String seq);

	boolean hasComment(String seq);

}
