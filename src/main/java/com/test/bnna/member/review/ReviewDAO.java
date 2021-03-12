package com.test.bnna.member.review;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAO implements IReviewDAO {
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<ReviewDTO> list() {
		
		return template.selectList("review.list");
	}

}
