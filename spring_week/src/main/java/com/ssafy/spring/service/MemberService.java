package com.ssafy.spring.service;

import java.sql.SQLException;

import com.ssafy.spring.dto.MemberDto;

public interface MemberService {
	
	void memberInsert(MemberDto dto) throws SQLException; // 유저 등록
	MemberDto memberView(MemberDto dto) throws SQLException; // 마이페이지
	void MemberUpdate(MemberDto dto) throws SQLException; // 유저 수정
	void MemberDelete(MemberDto dto) throws SQLException; // 유저 삭제
	boolean login(MemberDto dto) throws SQLException; // 로그인
}
