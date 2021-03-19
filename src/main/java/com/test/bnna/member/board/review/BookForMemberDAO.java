package com.test.bnna.member.board.review;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookForMemberDAO implements IBookForMemberDAO {

	@Autowired
	private SqlSessionTemplate template;

	
	@Override
	public List<BookForMemberDTO> list(String seqMember) {
		
		return template.selectList("review.blist", seqMember);
	}

}
