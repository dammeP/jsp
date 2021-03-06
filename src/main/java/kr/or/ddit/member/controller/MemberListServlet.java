package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MemberServiceI memberService;
	
	@Override
		public void init() throws ServletException {
		memberService = new MemberService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. page 파라미터를 받는다
		//2. page 파라미터가 없을 경우 1이라고 가정한다
		//3. memberService.selectAllMember메서드를 수정 / 새로운 메서드 만들기
		
		// page
		String page_str = request.getParameter("page");
		int page = page_str == null ? 1 : Integer.parseInt(page_str); 
		request.setAttribute("page", page);
		
		// pageSize
		String pageSize_str = request.getParameter("pageSize");
		int pageSize = pageSize_str == null ? 8 : Integer.parseInt(page_str); 
		request.setAttribute("pageSize", pageSize);
		
		// pageVO : page, pageSize
		PageVO pageVO = new PageVO(page, pageSize);
		
//		request.setAttribute("memList", memberService.selectAllMember());
		
//		memberService.selectAllMemberPage(page) => List<MemberVO> => Map<String, Object>
		
		 Map<String, Object> map = memberService.selectAllMemberPage(pageVO);
	      request.setAttribute("memList", map.get("memberList"));
	      request.setAttribute("pages", map.get("pages"));

//		request.setAttribute("memList", memberService.selectAllMemberPage(page));
		request.getRequestDispatcher("/member/memberList.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
