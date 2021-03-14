package com.test.bnna.admin.board.tripinfo;

import java.util.List;

public interface ITripInfoDAO {

	List<TripInfoDTO> list();

	TripInfoDTO view(String seq);

	List<TripInfoCmtDTO> cmtlist(String seq);

}
