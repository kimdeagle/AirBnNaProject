package com.test.bnna.admin.board.review;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewPicForAdminDAO implements IReviewPicForAdminDAO {

	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public List<ReviewPicForAdminDTO> list(String seq) {
		return template.selectList("review.plistForAdmin", seq);
	}

}
