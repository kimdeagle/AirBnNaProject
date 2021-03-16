package com.test.bnna.member.board.blackboard;

import java.util.List;

public interface IBlackBoardDAO {

	BlackBoardDTO get(String seq);

	List<BlackBoardImgDTO> getImages(String seq);

	List<BlackBoardCmtDTO> getComments(String seq);

}
