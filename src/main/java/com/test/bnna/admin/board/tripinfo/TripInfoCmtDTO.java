package com.test.bnna.admin.board.tripinfo;

import lombok.Data;

@Data
public class TripInfoCmtDTO {
	
	private String seq;			//댓글번호
	private String seqMember;	//회원번호
	private String seqTripInfo;	//글번호
	private String ccontent;	//댓글내용
	private String regdate;		//댓글 작성일
	
	//회원 정보 관련 추가
	private String pic;			//회원사진
	private String id;			//회원아이디
	
}
