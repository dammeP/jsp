package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

public interface MemberDaoI {
	MemberVO getMember(String userId);
	
	List<MemberVO> selectAllMember();
	
	List<MemberVO> selectAllMemberPage(PageVO pageVO);
	
	int selectMemberTotalCount();
}
