package com.test.bnna.member.board.review;

import java.util.List;

public interface IReviewDAO {

	List<ReviewDTO> list();
	
	List<ReviewDTO> list(String seq);

	void readCountUp(String seq);

	void recommendCountUp(String seq);


}
