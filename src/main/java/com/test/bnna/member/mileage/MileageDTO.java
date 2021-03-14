package com.test.bnna.member.mileage;

import lombok.Data;

@Data
public class MileageDTO {
	
	private String seq;
	private String seqMember;
	private String seqPay;
	private int totalM;
	private int useM;
	private int saveM;
	private String regdate;
	
	
	//Member 정보 관련 추가
	private String id;
	private String name;
	private String memdate;
	private String pic;

}
