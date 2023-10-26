package com.ssafy.spring.repository;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.spring.dto.MemberDto;

@Repository("MemberRepositoryMybatis")
public class MemberRepositoryMybatisImpl implements MemberRepository {

	SqlSession session;
	
	@Autowired
	public MemberRepositoryMybatisImpl(SqlSession session) {
		super();
		this.session = session;
	}

	String ns = "com.ssafy.spring.repository.MemberRepository.";
	@Override
	public void memberInsert(MemberDto dto) throws SQLException {
		session.insert(ns + "memberInsert", dto);
	}

	@Override
	public MemberDto memberView(MemberDto dto) throws SQLException {
		MemberDto member = session.selectOne(ns + "memberView", dto);
		return member;
	}

	@Override
	public void MemberUpdate(MemberDto dto) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void MemberDelete(MemberDto dto) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public MemberDto login(MemberDto dto) throws SQLException {
		MemberDto login = session.selectOne(ns + "login", dto);
		return login;
	}

}
