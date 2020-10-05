package kr.or.ddit.jsp;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ScopeServlet")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request, session, application 객체에 각각 속성을 저장
		request.setAttribute("requestAttr", "requestValue");

		HttpSession session = request.getSession();		// 사용자마다 할당
		session.setAttribute("sessionAttr", "sessionValue");
		
		ServletContext sc = getServletContext();		// 서버마다 할당
		sc.setAttribute("applicationAttr", "applicationValue");
		
		request.getRequestDispatcher("/jsp/scopeView.jsp").forward(request, response);
	}


}
