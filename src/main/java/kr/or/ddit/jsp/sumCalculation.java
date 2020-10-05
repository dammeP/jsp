package kr.or.ddit.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class sumCalculation
 */
@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(sumCalculation.class);
       
	// 입력화면 요청 처리(sumInput.jsp)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/sumInput.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int firstNum = Integer.parseInt(request.getParameter("firstNum"));	// parameter <- 요청을 보낼때 설정하는것
		int secondNum = Integer.parseInt(request.getParameter("secondNum"));
		
		
		int sum = 0;
		for(int i=firstNum; i<=secondNum; i++) {
			sum +=i;
		}
		
		
		logger.debug("sumResult: {}", sum);

		HttpSession session = request.getSession();
		session.setAttribute("sumResult", sum);	// attribute <- 속성을 설정하는것
		
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
		
	}

}
