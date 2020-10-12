package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

public class MemberDao implements MemberDaoI{

	@Override
	public MemberVO getMember(String userId) {
		// 원래는 db에서 데이터를 조회하는 로직이 있어야 하나
		// 우리는 controller기능에 집중 => 하드코딩을 통해 dao, service는 간략하게 넘어간다
		//	Mock (가짜)
		
//		MemberVO memberVO = new MemberVO();
//		memberVO.setUserId("brown");
//		memberVO.setPassword("passBrown");
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		//select
		// 한건 : selectOne
		// 여러건 : selectList
		
		MemberVO memberVO = sqlSession.selectOne("member.getMember", userId);
		
		
		
		return memberVO;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<MemberVO> memberList = sqlSession.selectList("member.selectAllMember");
		
		return memberList;
	}
	
	

	
}