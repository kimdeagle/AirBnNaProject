package com.test.bnna.member.board.blackboard;

import java.util.List;

public interface IMemberDAO {

	List<MemberDTO> list(String condition, String keyword);

}
