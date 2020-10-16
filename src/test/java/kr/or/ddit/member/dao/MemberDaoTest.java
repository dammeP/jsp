package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;

public class MemberDaoTest {

	@Test
	public void getMemberTest() {
		/***Given***/
		MemberDao memberDao = new MemberDao();
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
		MemberDaoI memberDao = new MemberDao();

		/***When***/
		List<MemberVO> memberList = memberDao.selectAllMember();

		/***Then***/
		assertEquals(15, memberList.size());
		//assertEquals("brown", memberList.get(0).getUserid()); 
	}
	
	@Test
	public void selectAllMemberPageTest() {
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
		PageVO pageVO = new PageVO(1,5);
//		int page = 1;
//		MemberVO memberVO = new MemberVO();
//		memberVO

		/***When***/
		List<MemberVO> memberListPage = memberDao.selectAllMemberPage(pageVO);

		/***Then***/
		assertEquals(7, memberListPage.size());
		
	}
	
	@Test
		/***Given***/
	public void selectMemberTotalCountTest() {
		MemberDaoI memberDao = new MemberDao();

		/***When***/
		int totalCount = memberDao.selectMemberTotalCount();
		
		/***Then***/
		assertEquals(15, totalCount);
	}
}
