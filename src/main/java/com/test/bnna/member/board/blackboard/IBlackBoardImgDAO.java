package com.test.bnna.member.board.blackboard;

import java.util.List;

public interface IBlackBoardImgDAO {

	int add(List<BlackBoardImgDTO> ilist);

	void del(String seq);

	boolean hasImage(String seq);

}
