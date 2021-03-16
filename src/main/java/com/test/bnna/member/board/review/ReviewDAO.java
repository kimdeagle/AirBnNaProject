package com.test.bnna.member.board.review;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAO implements IReviewDAO {
	
	@Autowired
	private SqlSessionTemplate template;

	/**
	 *  전체 리뷰를 가져오는 메서드입니다.
	 */
	@Override
	public List<ReviewDTO> list() {
		
		return template.selectList("review.alllist");
	}
	
	/**
	 * 하나의 숙소의 리뷰를 가져오는 메서드입니다.
	 * @param list
	 * @return 리뷰정보를 담고 있는 DTO의 리스트를 반환합니다.
	 */
	@Override
	public List<ReviewDTO> list(String seq) {
		
		return template.selectList("review.onelist", seq);
	}

	/**
	 * 조회수를 올리는 메서드입니다.
	 */
	@Override
	public void readCountUp(String seq) {
		
		template.update("review.readcntup", seq);
		
	}

	@Override
	public void recommendCountUp(String seq) {
		template.update("review.recommendcntup", seq);
		
	}

}
