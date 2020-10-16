package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest {

	@Test
	public void getMemberTest() {
		/***Given***/
		MemberServiceI memberService = new MemberService();
		String userId = "brown";
		
		MemberVO answerMemberVO = new MemberVO();
		answerMemberVO.setUserid("brown");
		answerMemberVO.setPass("brownPass");
		
		/***When***/
		MemberVO memberVO = memberService.getMember(userId);

		/***Then***/
//		assertEquals("brown", memberVO.getUserId());
//		assertEquals("passBrown", memberVO.getPassword());

		assertEquals(answerMemberVO, memberVO);
	}

	
	@Test
	public void selectAllMemberPageTest() {
		/***Given***/
		MemberServiceI memberService = new MemberService();
		PageVO pageVO = new PageVO(1,7);
//		int page = 1;
//		MemberVO memberVO = new MemberVO();
//		memberVO

		/***When***/
		Map<String, Object> map = memberService.selectAllMemberPage(pageVO);
		List<MemberVO> memberListPage = (List<MemberVO>)map.get("memList");

		/***Then***/
		assertEquals(7, memberListPage.size());
		
	}
	
	@Test
	public void selectMemberTotalCountTest() {
		/***Given***/
		MemberServiceI memberService = new MemberService();

		/***When***/
		int totalCount = memberService.selectMemberTotalCount();
		
		/***Then***/
		assertEquals(15, totalCount);
	}

}
