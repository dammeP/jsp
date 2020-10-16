package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.jobs.VO.JobsVO;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

public class MemberService implements MemberServiceI {

	private MemberDaoI memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}

	@Override
	public MemberVO getMember(String userId) {
		return memberDao.getMember(userId);
	}

	@Override
	public List<MemberVO> selectAllMember() {
		return memberDao.selectAllMember();
	}
	
	public Map<String, Object> selectAllMemberPage(PageVO pageVO) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("memberList", memberDao.selectAllMemberPage(pageVO));
		
		// 15건, 페이지 사이즈를 7로 가정했을때 3개의 페이지가 나와야한다
		// 15/7 = 2.14... 올림을 하여 3개의 페이지가 필요
		int totalCount = memberDao.selectMemberTotalCount();
		int pages = (int)Math.ceil((double)totalCount/7);
		map.put("pages", pages);
		
		return map;
	}

	@Override
	public int selectMemberTotalCount() {
		 return memberDao.selectMemberTotalCount();
	}

}
