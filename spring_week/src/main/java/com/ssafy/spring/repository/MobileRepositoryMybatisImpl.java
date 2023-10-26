package com.ssafy.spring.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.spring.dto.MobileDto;

@Repository
public class MobileRepositoryMybatisImpl implements MobileRepository {

	SqlSession session;
	
	public MobileRepositoryMybatisImpl(SqlSession session) {
		super();
		this.session = session;
	}

	String ns = "com.ssafy.spring.repository.MobileRepository.";
	@Override
	public void MobileInsert(MobileDto dto) throws SQLException {
		session.insert(ns+ "MobileInsert", dto);
		//		session.getMapper(MobileRepository.class).MobileInsert(dto);
	}

	@Override
	public MobileDto MobileView(MobileDto dto) throws SQLException {
		MobileDto mobileView = session.selectOne(ns + "MobileView", dto);
		//		MobileDto mobileView = session.getMapper(MobileRepository.class).MobileView(dto);
		return mobileView;
	}

	@Override
	public void MobileUpdate(MobileDto dto) throws SQLException {
		session.update(ns + "MobileUpdate", dto);
		//		session.getMapper(MobileRepository.class).MobileUpdate(dto);
	}

	@Override
	public void MobileDelete(MobileDto dto) throws SQLException {
		session.delete(ns +"MobileDelete", dto);
		//		session.getMapper(MobileRepository.class).MobileDelete(dto);
	}

	@Override
	public List<MobileDto> listMobile() throws SQLException {
		List<MobileDto> list = session.selectList(ns+ "listMobile");
		//		List<MobileDto> listMobile = session.getMapper(MobileRepository.class).listMobile();
		return list;
	}

	@Override
	public List<MobileDto> listMobilePage(Map<String, Integer> map) throws SQLException {
		List<MobileDto> list = session.selectList(ns + "listMobilePage", map);
		//		List<MobileDto> listMobile = session.getMapper(MobileRepository.class).listMobile(map);
		return list;
	}
	
	@Override
	public MobileDto findMobile(String mobileCode) throws SQLException {
		MobileDto dto = session.selectOne(ns + "findMobile", mobileCode);
		return dto;
	}


}
