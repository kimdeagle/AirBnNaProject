package com.test.bnna.admin.board.review;

import java.util.List;

public interface IReviewForAdminDAO {

	List<ReviewForAdminDTO> list();

	ReviewForAdminDTO info(String seq);

	int del(String path, String seq);

}
