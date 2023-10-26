package com.ssafy.spring.repository;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.spring.dto.MemberDto;

public interface MemberRepository {

	void memberInsert(MemberDto dto) throws SQLException; // 유저 등록
	MemberDto memberView(MemberDto dto) throws SQLException; // 마이페이지
	void MemberUpdate(MemberDto dto) throws SQLException; // 유저 수정
	void MemberDelete(MemberDto dto) throws SQLException; // 유저 삭제
	public MemberDto login(MemberDto dto) throws SQLException; // 로그인
}
