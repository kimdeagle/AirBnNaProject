package com.test.bnna.admin.board.event;

import java.util.HashMap;
import java.util.List;


public interface IEventBoardDAO {

//	List<EventBoardDTO> list();
	List<EventBoardDTO> list(HashMap<String, String> map);

	EventBoardDTO get(String seq);

	List<EventCmtDTO> clist(String seq);

	int add(EventBoardDTO dto);

	int edit(EventBoardDTO dto);

	int del(String seq);

	int delcomment(String seq);

}
