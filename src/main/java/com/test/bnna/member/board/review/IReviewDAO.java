package com.test.bnna.member.board.review;

import java.util.ArrayList;
import java.util.List;



public interface IReviewDAO {

	List<ReviewDTO> list(String seq); // 이건 숙소번호를 파라미터로 해서 그 숙소의 리뷰를 찾아오는 메서드

	void readCountUp(String seq);

	void recommendCountUp(String seq);

	List<ReviewForMemberDTO> listForMember(String seqMember); // 이건 회원번호를 파라미터로 해서 그 회원이 작성한 리뷰를 찾아오는 메서드

	ReviewForMemberDTO info(String seq);

	int del(String path, String seq);

	int add(AddReviewDTO dto);

	int addReviewPic(ArrayList<ReviewPicDTO> plist);

	int getCurrentReviewSeq();

	int edit(EditReviewDTO dto);

	String getOwner(String seq);

}
