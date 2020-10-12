package kr.or.ddit.jobs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.jobs.VO.JobsVO;
import kr.or.ddit.jobs.service.JobsService;
import kr.or.ddit.jobs.service.JobsServiceI;

/**
 * Servlet implementation class getAllJobsServlet
 */
@WebServlet("/getAllJobsServlet")
public class getAllJobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static final Logger logger = LoggerFactory.getLogger(getAllJobsServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JobsServiceI jobsService = new JobsService();
		List<JobsVO> jobsList = jobsService.getAllJobs();
		request.setAttribute("jobsList", jobsList);
		logger.debug(jobsList + "");
		
		
		
		request.getRequestDispatcher("jsp/getAllJobs.jsp").forward(request, response);
		
	}


}
