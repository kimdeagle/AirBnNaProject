package com.test.bnna.member.bnbsearch;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BnBDAO implements IBnBDAO {
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public BnBDTO getInfo(String seq) {
		
		return template.selectOne("search.info", seq);
	}

	@Override
	public List<BnBPicDTO> getPic(String seq) {
		
		return template.selectList("search.image", seq);
	}

	@Override
	public int getTotalCount(String seq) {
		
		return template.selectOne("review.getTotalCount", seq);
	}

}
