package com.test.bnna.member.tripplan;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Daeun
 *
 */
@Repository
public class TripPlanDAO implements ITripPlanDAO {
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public int getTotalCount(HashMap<String, String> map) {
		
		String where = "";
		
		if (map.get("search") != null) {
			//검색 중..
			where = String.format("where title like '%%%s%%' or descript like '%%%s%%'", map.get("search"), map.get("search"));
		}
		
		map.put("where", where); //검색어 포함한 where 구문 담기
	
		return template.selectOne("tripplan.gettotalcount", map);
	}
	
	
	@Override
	public List<TripPlanDTO> list(HashMap<String, String> map) {
		
		String where = "";
		
		if (map.get("search") != null) {
			//검색 중..
			where = String.format("where title like '%%%s%%' or descript like '%%%s%%'", map.get("search"), map.get("search"));
		}
		
		map.put("where", where); //검색어 포함한 where 구문 담기
		
		return template.selectList("tripplan.list", map);
	}

}
