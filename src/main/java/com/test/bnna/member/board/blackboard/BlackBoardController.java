package com.test.bnna.member.board.blackboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlackBoardController {

	@RequestMapping(value="/member/board/blackboard/add.action", method={RequestMethod.GET})
	public String add() {
		
		return "member.board.blackboard.add";
	}
	
}
