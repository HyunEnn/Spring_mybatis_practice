package com.ssafy.spring.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.spring.dto.MobileDto;

public interface MobileRepository {
	
	void MobileInsert(MobileDto dto) throws SQLException; // 유저 등록
	MobileDto MobileView(MobileDto dto) throws SQLException; // 마이페이지
	void MobileUpdate(MobileDto dto) throws SQLException; // 유저 수정
	void MobileDelete(MobileDto dto) throws SQLException; // 유저 삭제
	List<MobileDto> listMobile() throws SQLException;
	List<MobileDto> listMobilePage(Map<String, Integer> map) throws SQLException;
	MobileDto findMobile(String mobileCode) throws SQLException;
}
