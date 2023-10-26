package com.ssafy.spring.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.spring.dto.MobileDto;
import com.ssafy.spring.util.PageNavigation;

public interface MobileService {

	void MobileInsert(MobileDto dto) throws SQLException; // 유저 등록
	MobileDto MobileView(MobileDto dto) throws SQLException; // 마이페이지
	void MobileUpdate(MobileDto dto) throws SQLException; // 유저 수정
	void MobileDelete(MobileDto dto) throws SQLException; // 유저 삭제
	List<MobileDto> listMobile() throws SQLException;
	List<MobileDto> listMobilePage(Map<String, Integer> map) throws SQLException;
	
	boolean MobileDeletes(String[] mobileCode)  throws Exception;
	PageNavigation makePageNavigation(int currentPage, int sizePerPage)  throws Exception;
	MobileDto findMobile(String mobileCode) throws SQLException;
}
