package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);
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
		assertEquals("brown", memberVO.getUserid());
		assertEquals("brownPass", memberVO.getPass());

//		assertEquals(answerMemberVO, memberVO);
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
		List<MemberVO> memberListPage = (List<MemberVO>)map.get("memberList");
		int pages = (int)map.get("pages");

		/***Then***/
		assertEquals(7, memberListPage.size());
		assertEquals(3, pages);
		
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

	@Test
	public void localeListTest() {
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		for(Locale locale : locales) {
			logger.debug(locale.toString());
		}
	}
}
