package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVO;

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
//		assertEquals("brown", memberVO.getUserId());
//		assertEquals("passBrown", memberVO.getPassword());

		assertEquals(answerMemberVO, memberVO);
	}
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		MemberDaoI memberDao = new MemberDao();

		/***When***/
		List<MemberVO> memberList = memberDao.selectAllMember();

		/***Then***/
		assertEquals(5, memberList.size());
		//assertEquals("brown", memberList.get(0).getUserid()); 
	}

}
