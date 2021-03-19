package com.test.bnna.admin.board.event;

import lombok.Data;

@Data
public class EventBoardDTO {
	
	private String seq;
	private String seqAdmin;
	private String content;
	private String title;
	private String regdate;
	private String id;
	private String pw;
	private String readcnt;
	private String image;
	private String orgImage;
	private int thread;
	private int depth;
}
