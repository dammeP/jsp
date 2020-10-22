package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileUpload.FileUploadUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/memberRegist")
@MultipartConfig
public class MemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(MemberRegisterServlet.class);
	
	private MemberServiceI memberService;
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/memberRegister.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String pass = request.getParameter("pass");
		String alias = request.getParameter("alias");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		logger.debug("parameter : {}, {}, {}, {}, {}, {}, {}", userid, usernm, pass, alias, addr1, addr2, zipcode);
		
		Part profile = request.getPart("realFilename");
		logger.debug("file : {}",profile.getHeader("Content-Disposition"));
		
		String realFilename = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
		String fileName = UUID.randomUUID().toString();
		String filePath = "";
		
		if(profile.getSize() > 0) {
			String extension = FileUploadUtil.getExtenstion(realFilename);
			filePath = "D:\\profile\\" + fileName + "." +extension;
			profile.write(filePath);
		}
		 
		// 사용자 정보 등록
		MemberVO memberVO = new MemberVO(userid, pass, usernm, alias, addr1, addr2, zipcode, filePath, realFilename);
		int insertCnt = memberService.insertMember(memberVO);
		
		// 1건이 입력되었을 때 : 정상 - memberList 페이지로 이동
		if(insertCnt == 1) {
			response.sendRedirect(request.getContextPath() + "/memberList");
		}
		else {
			doGet(request, response);
		}
		// 1건이 아닐때 : 비정상
	}

}
