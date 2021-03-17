package com.test.bnna.member.board.review;

import lombok.Data;

/**
 * 리뷰 추가시 사용하는 DTO입니다.
 * @author 조아라
 *
 */
@Data
public class AddReviewDTO {
	
	private String seqbook;
	private String title;
	private String content;
	private String star;

}
