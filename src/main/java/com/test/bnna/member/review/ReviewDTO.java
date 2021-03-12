package com.test.bnna.member.review;

import lombok.Data;

@Data
public class ReviewDTO {
	
	private int seq;
	private int seqbook;
	private String title;
	private String content;
	private int star;
	private int readcnt;
	private int recommendcnt;
	private int thread;
	private int depth;
	private int secret;
	
	private String bookdate;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getSeqbook() {
		return seqbook;
	}

	public void setSeqbook(int seqbook) {
		this.seqbook = seqbook;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public int getRecommendcnt() {
		return recommendcnt;
	}

	public void setRecommendcnt(int recommendcnt) {
		this.recommendcnt = recommendcnt;
	}

	public int getThread() {
		return thread;
	}

	public void setThread(int thread) {
		this.thread = thread;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getSecret() {
		return secret;
	}

	public void setSecret(int secret) {
		this.secret = secret;
	}

	public String getBookdate() {
		return bookdate;
	}

	public void setBookdate(String bookdate) {
		this.bookdate = bookdate;
	}

	
}
