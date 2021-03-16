package com.test.bnna.member.board.blackboard;

import lombok.Data;

@Data
public class BlackBoardDTO {

	private String seq;
	private String seqMember;
	private String seqIssueMember;
	private String title;
	private String content;
	private int readcnt;
	private String regdate;
	private int thread;
	private int depth;
	
	private String id;
	private String name;
	
	private String issueMemberId;
	private String issueMemberName;
	
}
