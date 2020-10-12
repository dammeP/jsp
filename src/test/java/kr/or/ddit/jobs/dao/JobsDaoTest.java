package kr.or.ddit.jobs.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.jobs.VO.JobsVO;
import kr.or.ddit.jobs.controller.getAllJobsServlet;

public class JobsDaoTest {
	
	@Test
	public void getAllJobs(){
		
		/***Given***/
		JobsDaoI jobsDao = new JobsDao();

		/***When***/
		List<JobsVO> jobsList = jobsDao.getAllJobs();
		/***Then***/
		assertEquals("AD_VP",jobsList.get(1).getJob_id());
		
	}

}
