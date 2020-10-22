package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;

public class MemberDaoTest {
	
	// 테스트 메소드 실행 사이클: 
	// @BeforeClass (static)
	// 		@Before => @Test => @After	
	// 		@Before => @Test => @After	(테스트 메서드마다 실행)
	// @AfterClass (static)
	
	MemberDaoI memberDao;
	
	@Before
	public void setup() {
		memberDao = new MemberDao();
		String userid = "pdm";
		memberDao.deleteMember(userid);
	}

	@Test
	public void getMemberTest() {
		/***Given***/
		String userId = "brown";
		
		MemberVO answerMemberVO = new MemberVO();
		answerMemberVO.setUserid("brown");
		answerMemberVO.setPass("brownPass");
		
		/***When***/
		MemberVO memberVO = memberDao.getMember(userId);

		/***Then***/
		assertEquals("brown", memberVO.getUserid());
		assertEquals("brownPass", memberVO.getPass());

//		assertEquals(answerMemberVO, memberVO);
	}
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		
		/***When***/
		List<MemberVO> memberList = memberDao.selectAllMember();

		/***Then***/
		assertEquals(15, memberList.size());
		//assertEquals("brown", memberList.get(0).getUserid()); 
	}
	
	@Test
	public void selectAllMemberPageTest() {
		/***Given***/
		PageVO pageVO = new PageVO(1,5);
//		int page = 1;
//		MemberVO memberVO = new MemberVO();
//		memberVO

		/***When***/
		List<MemberVO> memberListPage = memberDao.selectAllMemberPage(pageVO);

		/***Then***/
		assertEquals(7, memberListPage.size());
		
	}
	
//	@Test
//	public void selectMemberTotalCountTest() {
//		/***Given***/
//		MemberDaoI memberDao = new MemberDao();
//		SqlSession sqlSession;
//
//		/***When***/
//		int totalCount = memberDao.selectMemberTotalCount(sqlSession);
//		
//		/***Then***/
//		assertEquals(15, totalCount);
//	}
//	
	@Test
	public void insertMemberDaoTest() {
		/***Given***/
		MemberVO memberVO = new MemberVO("pdm", "pass1234", "박다미", "dam", "대전 중구 중앙로 76", "영민빌딩 404호", "34940", "d:\\profile\\dam.png", "dam.png");

		/***When***/
		int insertCnt = memberDao.insertMember(memberVO);

		/***Then***/
		assertEquals(1,  insertCnt);
	}
}
