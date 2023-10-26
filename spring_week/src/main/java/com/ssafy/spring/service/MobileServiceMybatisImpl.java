package com.ssafy.spring.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.spring.dto.MobileDto;
import com.ssafy.spring.repository.MobileRepository;
import com.ssafy.spring.util.PageNavigation;
import com.ssafy.spring.util.PaggingUtil;

@Service
public class MobileServiceMybatisImpl implements MobileService {

	SqlSession session;

	public MobileServiceMybatisImpl(SqlSession session) {
		super();
		this.session = session;
	}

	@Override
	public void MobileInsert(MobileDto dto) throws SQLException {
		// TODO Auto-generated method stub
		session.getMapper(MobileRepository.class).MobileInsert(dto);
	}

	@Override
	public MobileDto MobileView(MobileDto dto) throws SQLException {
		// TODO Auto-generated method stub
		MobileDto mobileView = session.getMapper(MobileRepository.class).MobileView(dto);
		return mobileView;
	}

	@Override
	public void MobileUpdate(MobileDto dto) throws SQLException {
		// TODO Auto-generated method stub
		session.getMapper(MobileRepository.class).MobileUpdate(dto);
	}

	@Override
	public void MobileDelete(MobileDto dto) throws SQLException {
		// TODO Auto-generated method stub
		session.getMapper(MobileRepository.class).MobileDelete(dto);
	}

	@Override
	public List<MobileDto> listMobile() throws SQLException {
		// TODO Auto-generated method stub
		List<MobileDto> listMobile = session.getMapper(MobileRepository.class).listMobile();
		return listMobile;
	}

	@Override
	public List<MobileDto> listMobilePage(Map<String, Integer> map) throws SQLException {
		// TODO Auto-generated method stub
		List<MobileDto> listMobile = session.getMapper(MobileRepository.class).listMobilePage(map);
		return listMobile;
	}

	@Override
	public boolean MobileDeletes(String[] mobileCodes) throws Exception {
		MobileDto dto = new MobileDto();
		for(String mobileCode : mobileCodes) {
			dto.setMobileCode(mobileCode);
			session.getMapper(MobileRepository.class).MobileDelete(dto);
		}
		return true;
	}
	
	@Override
	public MobileDto findMobile(String mobileCode) throws SQLException {
		MobileDto findMobile = session.getMapper(MobileRepository.class).findMobile(mobileCode);
		return findMobile;
	}

	@Override
	public PageNavigation makePageNavigation(int currentPage, int sizePerPage) throws Exception {
		int naviSize = PaggingUtil.naviSize;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalSize = getTotalMobileCnt();
		//pageNavigation.setTotalCount(totalSize);
		int totalPageSize = (totalSize - 1)/sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageSize);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	
	public int getTotalMobileCnt() throws Exception {
		String ns = "com.ssafy.spring.repository.MobileRepository.";
		int cnt = session.selectOne(ns +"getTotalMobileCnt");
		return cnt;
	}
}
