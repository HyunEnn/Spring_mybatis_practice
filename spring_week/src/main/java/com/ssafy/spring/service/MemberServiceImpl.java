package com.ssafy.spring.service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.spring.dto.MemberDto;
import com.ssafy.spring.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	SqlSession session;
	
	@Autowired
	public MemberServiceImpl(SqlSession session) {
		super();
		this.session = session;
	}

	@Override
	public void memberInsert(MemberDto dto) throws SQLException {
		// TODO Auto-generated method stub
		session.getMapper(MemberRepository.class).memberInsert(dto);
	}

	@Override
	public MemberDto memberView(MemberDto dto) throws SQLException {
		// TODO Auto-generated method stub
		MemberDto memberView = session.getMapper(MemberRepository.class).memberView(dto);
		return memberView;
	}

	@Override
	public void MemberUpdate(MemberDto dto) throws SQLException {
		session.getMapper(MemberRepository.class).MemberUpdate(dto);
	}

	@Override
	public void MemberDelete(MemberDto dto) throws SQLException {
		// TODO Auto-generated method stub
		session.getMapper(MemberRepository.class).MemberDelete(dto);
	}

	@Override
	public boolean login(MemberDto dto) throws SQLException {
		MemberDto login = session.getMapper(MemberRepository.class).login(dto);
		if(login != null) {
			return true;
		} else {
			return false;
		}
	}
	
}
